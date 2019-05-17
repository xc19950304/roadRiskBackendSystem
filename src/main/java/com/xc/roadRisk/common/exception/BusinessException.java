package com.xc.roadRisk.common.exception;

import com.xc.roadRisk.common.vo.Response;
import com.xc.roadRisk.common.vo.ResponseConstant;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 2981289776602314427L;

    private Response response;

    public BusinessException(String msg) {
        super(msg);
        this.response = new Response(false, ResponseConstant.BUSINESS_EXCEPTION.getCode(), msg, msg);
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.response = new Response(false, code, msg, msg);
    }

    public BusinessException(String code, String msg, String errorMsg, Object data) {
        super(errorMsg);
        this.response = new Response<>(false, code, msg, errorMsg, data);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
