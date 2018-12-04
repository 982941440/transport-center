package com.tota.transport.rpc.api.domain.response;

import java.io.Serializable;

public class OrderDeliveryResp implements Serializable {
    private static final long serialVersionUID = -701407788480686831L;

    private  long  deliveryId;
    private  int  statusCode;
    private  String statusMsg ;
    private  String  transporterName;
    private  String  transporterPhone;
    private  String  transporterLng;
    private  String  transporterLat;
    private  long  deliveryFee;
    private  double  distance;
    private  String  createTime;
    private  String  acceptTime;
    private  String  fetchTime;
    private  String  finishTime;
    private  String  cancelTime;


    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public String getTransporterPhone() {
        return transporterPhone;
    }

    public void setTransporterPhone(String transporterPhone) {
        this.transporterPhone = transporterPhone;
    }

    public String getTransporterLng() {
        return transporterLng;
    }

    public void setTransporterLng(String transporterLng) {
        this.transporterLng = transporterLng;
    }

    public String getTransporterLat() {
        return transporterLat;
    }

    public void setTransporterLat(String transporterLat) {
        this.transporterLat = transporterLat;
    }

    public long getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(long deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(String fetchTime) {
        this.fetchTime = fetchTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }



}
