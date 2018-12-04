package com.tota.transport.dataaccess.domain;

import java.io.Serializable;

public class OrderDeliverDO implements Serializable{
    private static final long serialVersionUID = 2961862120430615781L;

    private long  deliveryId;
    private String deliveryNo;
    private  long  shopId;
    private  long  storeId;

    private long  deliveryFee;
    private long   serviceFee;
    //运费和服务费
    private long allFee;

    public OrderDeliverDO(){

    }

    public OrderDeliverDO(long deliveryId, String deliveryNo, long shopId, long storeId, long deliveryFee, long serviceFee, long allFee) {
        this.deliveryId = deliveryId;
        this.deliveryNo = deliveryNo;
        this.shopId = shopId;
        this.storeId = storeId;
        this.deliveryFee = deliveryFee;
        this.serviceFee = serviceFee;
        this.allFee = allFee;
    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
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

    public long getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(long deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public long getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(long serviceFee) {
        this.serviceFee = serviceFee;
    }

    public long getAllFee() {
        return allFee;
    }

    public void setAllFee(long allFee) {
        this.allFee = allFee;
    }
}
