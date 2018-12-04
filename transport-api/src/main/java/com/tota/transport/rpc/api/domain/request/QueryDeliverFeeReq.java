package com.tota.transport.rpc.api.domain.request;


import java.io.Serializable;

/**
 * Auto-generated: 2018-11-06 9:2:34
 *
 * @author jcduan
 */
public class QueryDeliverFeeReq implements Serializable {


    private static final long serialVersionUID = -8499837577816451574L;

    private long shopId;
    private long storeId;
    private long deliveryId;
    private String city;
    private long actualPayAmount;
    private String name;
    private String address;
    private String phone;
    private String remark;

    public  QueryDeliverFeeReq(){

    }

    public QueryDeliverFeeReq(long shopId, long storeId, long deliveryId, String city, long actualPayAmount, String name, String address, String phone, String remark) {
        this.shopId = shopId;
        this.storeId = storeId;
        this.deliveryId = deliveryId;
        this.city = city;
        this.actualPayAmount = actualPayAmount;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getActualPayAmount() {
        return actualPayAmount;
    }

    public void setActualPayAmount(long actualPayAmount) {
        this.actualPayAmount = actualPayAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}