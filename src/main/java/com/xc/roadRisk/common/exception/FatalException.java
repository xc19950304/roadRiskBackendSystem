package com.xc.roadRisk.common.exception;

import java.util.Map;

/**
 * 致命异常，系统会发邮件短信告警
 */
public class FatalException extends RuntimeException {
    private static final long serialVersionUID = 6199234446283250282L;
    private String tag;
    private Map<Object, Object> context;
    private Object[] args;

    public FatalException(String tag, Object... args) {
        this.tag = tag;
        this.args = args;
    }

    public FatalException(String tag, Map<Object, Object> context, Object[] args) {
        this.tag = tag;
        this.context = context;
        this.args = args;
    }

    public String getTag() {
        return tag;
    }

    public Map<Object, Object> getContext() {
        return context;
    }

    public Object[] getArgs() {
        return args;
    }
}
