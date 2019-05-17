package com.xc.roadRisk.common.vo;

import java.io.Serializable;

public class Response<T> implements Serializable {

    private static final long serialVersionUID = -748199784727733615L;

    protected Boolean status = Boolean.TRUE;

    protected String code = ResponseConstant.SUCCESS.getCode();

    protected String msg = ResponseConstant.SUCCESS.getMsg();

    protected String errorMsg = ResponseConstant.SUCCESS.getErrorMsg();

    protected T data;

    //服务器系统当前时间
    private Long currentTime = System.currentTimeMillis();

    /**
     * @param status
     * @param code
     * @param msg
     * @param errorMsg
     * @throws
     */
    public Response(Boolean status, String code, String msg, String errorMsg) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.errorMsg = errorMsg;
    }

    /**
     * @param data
     * @throws
     */
    public Response(T data) {
        super();
        this.data = data;
    }

    /**
     * @param status
     * @param code
     * @param msg
     * @param errorMsg
     * @param data
     * @throws
     */
    public Response(Boolean status, String code, String msg, String errorMsg, T data) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    /**
     * @throws
     */
    public Response() {
        super();
    }

    /**
     * 调用结果
     *
     * @return boolean
     */
    public Boolean success() {
        return status;
    }

    public Boolean getStatus() {
        return status;
    }

    /**
     * 错误编码
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 业务提示信息
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 错误信息
     *
     * @return
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 实体数据
     *
     * @return
     */
    public T getData() {
        return data;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    /**
     * toString
     *
     * @return
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Response [status=" + status + ", code=" + code + ", msg=" + msg + ", errorMsg=" + errorMsg + ", data="
                + data + ", currentTime=" + currentTime + "]";
    }

    /**
     * hashCode
     *
     * @return
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((errorMsg == null) ? 0 : errorMsg.hashCode());
        result = prime * result + ((msg == null) ? 0 : msg.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    /**
     * equals
     *
     * @param obj
     * @return
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Response<?> other = (Response<?>) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }

        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)) {
            return false;
        }
        if (errorMsg == null) {
            if (other.errorMsg != null) {
                return false;
            }
        } else if (!errorMsg.equals(other.errorMsg)) {
            return false;
        }
        if (msg == null) {
            if (other.msg != null) {
                return false;
            }
        } else if (!msg.equals(other.msg)) {
            return false;
        }
        if (status == null) {
            if (other.status != null) {
                return false;
            }
        } else if (!status.equals(other.status)) {
            return false;
        }
        return true;
    }

}
