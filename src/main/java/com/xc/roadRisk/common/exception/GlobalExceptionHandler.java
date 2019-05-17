package com.xc.roadRisk.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xc.roadRisk.common.vo.Response;
import com.xc.roadRisk.common.vo.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.Collectors;

/**
 * 全局统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Value("${example.isPrintStackTrace:true}")
    private boolean isPrintStackTrace;
    @Autowired
    private ObjectMapper objectMapper;

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> exceptionHandler(Exception e) {
        logger.error("GlobalExceptionHandler ", e);

        Response<Object> resp = null;
        if (e instanceof FatalException) {
            // TODO 发送邮件短信提醒人工干预
            resp = new Response<>(false, ResponseConstant.SYS_EXCEPTION.getCode(), ResponseConstant.SYS_EXCEPTION.getMsg(), getStackTrace(e));
        } else if (e instanceof BusinessException) {
            BusinessException biz = (BusinessException) e;
            resp = biz.getResponse();
        } else if (e instanceof HttpStatusCodeException) {
            HttpStatusCodeException ex = (HttpStatusCodeException) e;
            resp = new Response();
            String body = ex.getResponseBodyAsString();
            // RestTemplate调用错误, 尽可能将上级错误信息返回
            if (StringUtils.hasText(body)) {
                try {
                    resp = objectMapper.readValue(body, Response.class);
                } catch (Exception exception) {
                    resp = new Response<>(false, Integer.toString(ex.getRawStatusCode()), body, getStackTrace(ex));
                }
            }
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            resp = new Response<>(false, Integer.toString(HttpStatus.BAD_REQUEST.value()),
                    ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "))
                    , getStackTrace(ex));
        } else {
            resp = new Response<>(false, ResponseConstant.SYS_EXCEPTION.getCode(), ResponseConstant.SYS_EXCEPTION.getMsg(), getStackTrace(e));
        }

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    private String getStackTrace(Exception e) {
        if (isPrintStackTrace) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return sw.toString();
        } else {
            String errorMsg = e.getMessage();
            if (StringUtils.isEmpty(errorMsg)) {
                errorMsg = ResponseConstant.SYS_EXCEPTION.getErrorMsg();
            }
            return errorMsg;
        }
    }

}
