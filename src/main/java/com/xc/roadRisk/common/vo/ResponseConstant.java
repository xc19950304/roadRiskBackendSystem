package com.xc.roadRisk.common.vo;

public enum ResponseConstant {

    SUCCESS("200", "success", "success"),

    SYS_EXCEPTION("100", "网络开小差了，请稍候再试！", "系统异常"),
    NOT_LOGIN("101", "您未登录或者登录已过期，请重新登录后再操作", "您未登录或者登录已过期，请重新登录后再操作"),

    BUSINESS_EXCEPTION("1000", "网络开小差了，请稍后再试", "业务逻辑异常"),

    VALIDATE_EXCEPTION("2000", "网络开小差了，请稍候再试！", "数据验证失败！"),
    PARAM_MISSING("2001", "参数缺失", "%s不存在"),
    PARAM_INVALID("2002", "参数缺失", "%s错误"),

    LOCK_EXCEPTION("3000", "网络开小差了，请稍候再试！", "分布式锁异常");

    private String code;
    private String msg;
    private String errorMsg;

    /**
     * @throws
     */
    ResponseConstant(String code, String msg, String errorMsg) {
        this.code = code;
        this.msg = msg;
        this.errorMsg = errorMsg;
    }

    /**
     * @return code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @return errorMsg
     */
    public String getErrorMsg() {
        return this.errorMsg;
    }

    /**
     * @return the showmsg
     */
    public String getMsg() {
        return this.msg;
    }


}
