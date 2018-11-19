package com.tota.transport.rpc.api.service;

import com.tota.transport.rpc.api.domain.ResponseResult;
import com.tota.transport.rpc.api.domain.response.BalanceQueryResp;

public interface DeliveryBalanceRpcService {

    /**
     *配送余额充值
     * @param shopId   门店id
     * @return  ResponseResult   数据结果集
     */
    ResponseResult balanceRecharge(long shopId);




    /**
     *配送余额查询
     * @param shopId   商铺id
     * @return  ResponseResult<BalanceQueryResp>   数据结果集
     */
    ResponseResult<BalanceQueryResp>   balanceQuery(long shopId);

}
