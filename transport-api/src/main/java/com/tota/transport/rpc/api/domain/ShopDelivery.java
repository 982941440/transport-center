package com.tota.transport.rpc.api.domain;

import java.io.Serializable;

public class ShopDelivery implements Serializable {


    private static final long serialVersionUID = 861879637768591501L;


    private  long  storeId;
    private  String   name;
    private  long   classifyId;
    private  String  city ;
    private  String  area ;
    private  String  address ;
    private  double   longitude;
    private  double   latitude;
    private  String   shopkeeperName;
    private  String   shopkeeperMob;
    private  byte  freezeStatus;


    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(long classifyId) {
        this.classifyId = classifyId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getShopkeeperName() {
        return shopkeeperName;
    }

    public void setShopkeeperName(String shopkeeperName) {
        this.shopkeeperName = shopkeeperName;
    }

    public String getShopkeeperMob() {
        return shopkeeperMob;
    }

    public void setShopkeeperMob(String shopkeeperMob) {
        this.shopkeeperMob = shopkeeperMob;
    }

    public byte getFreezeStatus() {
        return freezeStatus;
    }

    public void setFreezeStatus(byte freezeStatus) {
        this.freezeStatus = freezeStatus;
    }
}
