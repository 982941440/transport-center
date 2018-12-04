package com.tota.transport.rpc.api.domain.response;

import java.io.Serializable;

public class QueryDeliverFeeResp implements Serializable{

    private static final long serialVersionUID = 2326142303056434462L;


    private  long  deliverFee;
    private  double distance;
    private  String deliveryNo;



    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public long getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(long deliverFee) {
        this.deliverFee = deliverFee;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
