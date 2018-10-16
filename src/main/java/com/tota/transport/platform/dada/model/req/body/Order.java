package com.tota.transport.platform.dada.model.req.body;

/**
 * 新增订单、重发订单、订单预发布 三个接口参数相同
 */
public class Order {

    private String shop_no;
    private String origin_id;
    private String city_code;
    private Double cargo_price;
    private Integer is_prepay;
    private String receiver_name;
    private String receiver_address;
    private Double receiver_lat;
    private Double receiver_lng;
    private String callback;
    private String receiver_phone;//手机号和座机号必填一项

    public String getShop_no() {
        return shop_no;
    }

    public void setShop_no(String shop_no) {
        this.shop_no = shop_no;
    }

    public String getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(String origin_id) {
        this.origin_id = origin_id;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public Double getCargo_price() {
        return cargo_price;
    }

    public void setCargo_price(Double cargo_price) {
        this.cargo_price = cargo_price;
    }

    public Integer getIs_prepay() {
        return is_prepay;
    }

    public void setIs_prepay(Integer is_prepay) {
        this.is_prepay = is_prepay;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public Double getReceiver_lat() {
        return receiver_lat;
    }

    public void setReceiver_lat(Double receiver_lat) {
        this.receiver_lat = receiver_lat;
    }

    public Double getReceiver_lng() {
        return receiver_lng;
    }

    public void setReceiver_lng(Double receiver_lng) {
        this.receiver_lng = receiver_lng;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }
}
