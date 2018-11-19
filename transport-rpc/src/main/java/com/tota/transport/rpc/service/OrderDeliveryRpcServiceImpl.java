package com.tota.transport.rpc.service;



import com.tota.transport.common.tools.DadaTransport;
import com.tota.transport.rpc.api.domain.ResponseResult;
import com.tota.transport.rpc.api.domain.request.QueryDeliverFeeReq;
import com.tota.transport.rpc.api.domain.response.OrderCancelResp;
import com.tota.transport.rpc.api.domain.response.OrderDelivery;
import com.tota.transport.rpc.api.domain.response.QueryDeliverFeeResp;
import com.tota.transport.rpc.api.service.OrderDeliveryRpcService;


/**
 * @author: duanjc 2018/9/18 10:26
 * */
public class OrderDeliveryRpcServiceImpl implements OrderDeliveryRpcService{


    @Override
    public ResponseResult<QueryDeliverFeeResp> queryDeliverFee(QueryDeliverFeeReq queryDeliverFeeReq) {
        return null;
    }

    @Override
    public ResponseResult ConfirmOrder(long deliveryId) {
        return null;
    }

    @Override
    public ResponseResult<OrderDelivery> queryOrder(long deliveryId) {
        return null;
    }

    @Override
    public ResponseResult<OrderCancelResp> orderCancel(long deliveryId) {
        return null;
    }




    public static void main(String[] args) throws Exception {

        Object resultObj = DadaTransport.invoke("/api/order/formalCancel", "{\"order_id\":\"65415151\",\"cancel_reason_id\":\"1\",\"cancel_reason\":\"没有配送员接单\"}");

        System.out.println(resultObj);
    }









}
