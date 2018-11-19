package com.tota.transport.rpc.api.domain;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable{

    private static final long serialVersionUID = 6590360189310471717L;

    private  String status;
    private  long code;
    private  String msg;

    private  T   result;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
