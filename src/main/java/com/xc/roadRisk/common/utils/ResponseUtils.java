package com.xc.roadRisk.common.utils;

import com.xc.roadRisk.common.exception.BusinessException;
import com.xc.roadRisk.common.vo.Response;
import com.xc.roadRisk.common.vo.ResponseBack;
import com.xc.roadRisk.common.vo.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;

public class ResponseUtils {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtils.class);

    /**
     * 返回成功
     *
     * @return
     */
    public static <T> Response<T> returnSuccess() {
        return new Response<>(true, ResponseConstant.SUCCESS.getCode(), ResponseConstant.SUCCESS.getMsg(), "", null);
    }

    /**
     * 返回对象结果
     *
     * @param t
     * @return
     */
    public static <T> Response<T> returnObjectSuccess(T t) {
        if (t == null) {
            return new Response<>(true, ResponseConstant.SUCCESS.getCode(), ResponseConstant.SUCCESS.getMsg(), "", null);
        } else {
            return new Response<>(true, ResponseConstant.SUCCESS.getCode(), ResponseConstant.SUCCESS.getMsg(), "", t);
        }
    }


    public static <T> ResponseBack<T> returnObjectSuccessBack(T t, Integer count) {
        if (t == null) {
            return new ResponseBack<>(ResponseConstant.SUCCESS.getCode(), ResponseConstant.SUCCESS.getMsg(), count);
        } else {
            return new ResponseBack<>( ResponseConstant.SUCCESS.getCode(), ResponseConstant.SUCCESS.getMsg(), count, t);
        }
    }


    /**
     * 返回异常信息
     *
     * @param e
     * @return
     */
    public static <T> Response<T> returnException(Exception e) {

        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return be.getResponse();
        } else if (e instanceof IllegalArgumentException) {
            IllegalArgumentException ll = (IllegalArgumentException) e;
            return new Response<T>(false, ResponseConstant.VALIDATE_EXCEPTION.getCode(), ResponseConstant.VALIDATE_EXCEPTION.getMsg(), ll.getMessage() + " [Exception]:" + e, null);
        } else if (e instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException msrp = (MissingServletRequestParameterException) e;
            return new Response<T>(false, ResponseConstant.VALIDATE_EXCEPTION.getCode(), ResponseConstant.VALIDATE_EXCEPTION.getMsg(), msrp.getMessage() + " [Exception]:" + e, null);
        } else {
            logger.error(e.getMessage(), e);
            return new Response<T>(false, ResponseConstant.SYS_EXCEPTION.getCode(), ResponseConstant.SYS_EXCEPTION.getMsg(), ResponseConstant.SYS_EXCEPTION.getErrorMsg() + " [Exception]:" + e, null);
        }
    }

    /**
     * 简化消息提示，客户端得到该错误只会直接显示消息内容
     *
     * @param msg
     * @return
     */
    public static <T> Response<T> returnCommonException(String msg) {
        return new Response<T>(false, ResponseConstant.SYS_EXCEPTION.getCode(), msg, msg, null);
    }

    /**
     * 获取返回对象中对象
     *
     * @param res
     * @return T
     */
    public static <T> T getResponseData(Response<T> res) {
        if (null == res) {
            throw new BusinessException(ResponseConstant.SYS_EXCEPTION.getCode(), "response object must not null", "response object must not null", null);
        }

        if (!res.success() || !ResponseConstant.SUCCESS.getCode().equals(res.getCode())) {
            throw new BusinessException(res.getCode(), res.getMsg(), res.getErrorMsg(), res.getData());
        }

        return res.getData();
    }
}
