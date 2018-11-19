package com.tota.transport.rpc.api.domain.response;

import java.io.Serializable;

public class BalanceQueryResp implements Serializable{


    private static final long serialVersionUID = -2210848440454996632L;


    private  long amount;


    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
