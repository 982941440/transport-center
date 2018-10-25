package com.tota.transport.platform.dada.model.resp;

public class BaseDadaResp {

    public String status;

    public Integer code;

    public String msg;

    public Object result;

    public Integer errorCode;

    public BaseDadaResp(String status, Integer code, String msg, Object result, Integer errorCode) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.result = result;
        this.errorCode = errorCode;
    }
}
