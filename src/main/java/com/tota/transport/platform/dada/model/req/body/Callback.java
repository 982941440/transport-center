package com.tota.transport.platform.dada.model.req.body;

public class Callback {


    private String client_id;
    private String order_id;
    private int order_status;
    private String cancel_reason;
    private int cancel_from;
    private int update_time;
    private String signature;
    //非必填
    private int dm_id;
    private String dm_name;
    private String dm_mobile;

    public Callback(String client_id, String order_id, int order_status, String cancel_reason, int cancel_from, int update_time, String signature, int dm_id, String dm_name, String dm_mobile) {
        this.client_id = client_id;
        this.order_id = order_id;
        this.order_status = order_status;
        this.cancel_reason = cancel_reason;
        this.cancel_from = cancel_from;
        this.update_time = update_time;
        this.signature = signature;
        this.dm_id = dm_id;
        this.dm_name = dm_name;
        this.dm_mobile = dm_mobile;
    }

    public Callback(){

    }


    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

    public int getCancel_from() {
        return cancel_from;
    }

    public void setCancel_from(int cancel_from) {
        this.cancel_from = cancel_from;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getDm_id() {
        return dm_id;
    }

    public void setDm_id(int dm_id) {
        this.dm_id = dm_id;
    }

    public String getDm_name() {
        return dm_name;
    }

    public void setDm_name(String dm_name) {
        this.dm_name = dm_name;
    }

    public String getDm_mobile() {
        return dm_mobile;
    }

    public void setDm_mobile(String dm_mobile) {
        this.dm_mobile = dm_mobile;
    }

}
