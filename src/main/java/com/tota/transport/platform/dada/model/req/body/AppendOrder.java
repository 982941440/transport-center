package com.tota.transport.platform.dada.model.req.body;

public class AppendOrder {

    private String order_id;

    private Integer transporter_id;

    private String shop_no;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getTransporter_id() {
        return transporter_id;
    }

    public void setTransporter_id(Integer transporter_id) {
        this.transporter_id = transporter_id;
    }

    public String getShop_no() {
        return shop_no;
    }

    public void setShop_no(String shop_no) {
        this.shop_no = shop_no;
    }
}
