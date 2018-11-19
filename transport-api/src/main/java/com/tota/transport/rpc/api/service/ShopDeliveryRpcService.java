package com.tota.transport.rpc.api.service;


import com.tota.transport.rpc.api.domain.ResponseResult;
import com.tota.transport.rpc.api.domain.ShopDelivery;

public interface ShopDeliveryRpcService {



    /**
     *新增门店
     * @param shopDelivery  注册门店参数列表
     * @return  ResponseResult   返回数据结果集
     */
    ResponseResult addShop(ShopDelivery  shopDelivery);



    /**
     *编辑门店
     * @param shopDelivery  编辑门店参数列表
     * @return  ResponseResult   返回数据结果集
     */
    ResponseResult    updateShop(ShopDelivery shopDelivery );



    /**
     *门店详情
     * @param storeId    门店id
     * @return  ResponseResult<ShopDelivery>   返回数据结果集
     */
    ResponseResult<ShopDelivery>   detail(long  storeId);








}
