package com.tota.transport.rpc.api.service;

import com.tota.transport.rpc.api.domain.ResponseResult;
import com.tota.transport.rpc.api.domain.request.QueryDeliverFeeReq;
import com.tota.transport.rpc.api.domain.response.OrderCancelResp;
import com.tota.transport.rpc.api.domain.response.OrderDeliveryResp;
import com.tota.transport.rpc.api.domain.response.QueryDeliverFeeResp;

public interface OrderDeliveryRpcService {

    /**
     * 预下单
     * @param queryDeliverFeeReq 新增订单参数
     * @return ResponseResult<QueryDeliverFeeReq>   返回数据结果集
     */
    ResponseResult<QueryDeliverFeeResp> queryDeliverFee(QueryDeliverFeeReq queryDeliverFeeReq );


    /**
     * 确认下单
     * @param deliveryId  平台订单id
     * @return  ResponseResult   返回数据结果集
     */
    ResponseResult  ConfirmOrder(long deliveryId);



    /**
     * 订单详情查询
     * @param deliveryId   第三方订单编号
     * @return   ResponseResult<OrderDeliveryResp>   返回数据结果集
     */
    ResponseResult<OrderDeliveryResp>  queryOrder(long deliveryId );



    /**
     * 取消订单
     * @param deliveryId   第三方订单id
     * @return   ResponseResult<OrderCancelResp>   返回数据结果集
     */
    ResponseResult<OrderCancelResp>  orderCancel(long deliveryId);









}
