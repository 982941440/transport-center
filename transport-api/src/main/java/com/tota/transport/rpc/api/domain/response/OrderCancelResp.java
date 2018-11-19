package com.tota.transport.rpc.api.domain.response;

import java.io.Serializable;

public class OrderCancelResp implements Serializable{


    private static final long serialVersionUID = -7049342320184401958L;

    private long deductFee;


    public long getDeductFee() {
        return deductFee;
    }

    public void setDeductFee(long deductFee) {
        this.deductFee = deductFee;
    }
}
