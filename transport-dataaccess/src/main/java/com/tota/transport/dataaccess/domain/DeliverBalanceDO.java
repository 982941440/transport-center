package com.tota.transport.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by duanjc on 2018/9/18.
 */
public class DeliverBalanceDO implements Serializable {



    private static final long serialVersionUID = 4264944032058930547L;


    private long shopId;

    private long  balance;

    private Date createTime;

    private Date updateTime;

    public DeliverBalanceDO() {

    }

    public DeliverBalanceDO(long shopId, long balance, Date createTime, Date updateTime) {
        this.shopId = shopId;
        this.balance = balance;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
