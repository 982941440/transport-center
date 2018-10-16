package com.tota.transport.platform.dada.model.req.body;

public class CancelOrder {

    private String order_id;

    private String  cancel_reason_id;

    private String cancel_reason;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCancel_reason_id() {
        return cancel_reason_id;
    }

    public void setCancel_reason_id(String cancel_reason_id) {
        this.cancel_reason_id = cancel_reason_id;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }
}
