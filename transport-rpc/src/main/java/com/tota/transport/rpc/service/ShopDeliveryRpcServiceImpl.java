package com.tota.transport.rpc.service;

import com.alibaba.fastjson.JSONObject;
import com.tota.se.common.exception.BusinessException;
import com.tota.transport.common.tools.DadaTransport;
import com.tota.transport.common.util.CastingUtil;
import com.tota.transport.dataaccess.dao.mysql.DeliverBalanceMysqlDAO;
import com.tota.transport.dataaccess.domain.DeliverBalanceDO;
import com.tota.transport.rpc.api.domain.ResponseResult;
import com.tota.transport.rpc.api.domain.ShopDelivery;
import com.tota.transport.rpc.api.domain.response.OrderCancelResp;
import com.tota.transport.rpc.api.service.ShopDeliveryRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: duanjc 2018/11/21 17:30
 * */
@Service
public class ShopDeliveryRpcServiceImpl implements ShopDeliveryRpcService{

    @Autowired
    private DeliverBalanceMysqlDAO deliverBalanceMysqlDAO;

    @Override
    public ResponseResult addShop(ShopDelivery shopDelivery) {
        Map reqMap=new HashMap();
        reqMap.put("origin_shop_id",shopDelivery.getStoreId()+"");
        reqMap.put("station_name",shopDelivery.getName());
        reqMap.put("business",shopDelivery.getClassifyId());
        reqMap.put("city_name",shopDelivery.getCity());
        reqMap.put("area_name",shopDelivery.getArea());
        reqMap.put("station_address",shopDelivery.getAddress());
        reqMap.put("lng",shopDelivery.getLongitude());
        reqMap.put("lat",shopDelivery.getLatitude());
        reqMap.put("contact_name",shopDelivery.getShopkeeperName());
        reqMap.put("phone",shopDelivery.getShopkeeperMob());


        String jsonStr=new JSONObject(reqMap).toJSONString();

        jsonStr="["+jsonStr+"]";

        Object resultObj = null;
        try {
            resultObj = DadaTransport.invoke("/api/shop/add",jsonStr );
        } catch (Exception e) {
            throw  new BusinessException("调用达达接口失败");
        }

        JSONObject json = JSONObject.parseObject(resultObj.toString());

        ResponseResult rr=new ResponseResult();

        rr.setCode(Integer.parseInt(json.getString("code")));
        rr.setMsg(json.getString("msg"));
        rr.setStatus(json.getString("status"));


        if("success".equals(rr.getStatus())){
            deliverBalanceMysqlDAO.createBalance(shopDelivery.getStoreId());
        }

        return rr;

    }

    @Override
    public ResponseResult updateShop(ShopDelivery shopDelivery) {
        Map reqMap=new HashMap();
        reqMap.put("origin_shop_id",shopDelivery.getStoreId()+"");
        if(shopDelivery.getName()!=null){
            reqMap.put("station_name",shopDelivery.getName());
        }
        if( shopDelivery.getClassifyId()>0){
            reqMap.put("business",shopDelivery.getClassifyId());
        }
        if( shopDelivery.getCity()!=null){
            reqMap.put("city_name",shopDelivery.getCity());
        }
        if( shopDelivery.getArea()!=null){
            reqMap.put("area_name",shopDelivery.getArea());
        }
        if( shopDelivery.getAddress()!=null){
            reqMap.put("station_address",shopDelivery.getAddress());
        }
        if( shopDelivery.getLongitude()>0){
            reqMap.put("lng",shopDelivery.getLongitude());
        }
        if( shopDelivery.getLatitude()>0){
            reqMap.put("lat",shopDelivery.getLatitude());
        }
        if( shopDelivery.getShopkeeperName()!=null){
            reqMap.put("contact_name",shopDelivery.getShopkeeperName());
        }
        if( shopDelivery.getShopkeeperMob()!=null){
            reqMap.put("phone",shopDelivery.getShopkeeperMob());
        }


        String jsonStr=new JSONObject(reqMap).toJSONString();
        Object resultObj = null;
        try {
            resultObj = DadaTransport.invoke("/api/shop/update",jsonStr );
        } catch (Exception e) {
            throw  new BusinessException("调用达达接口失败");
        }

        JSONObject json = JSONObject.parseObject(resultObj.toString());

        ResponseResult rr=new ResponseResult();

        rr.setCode(Integer.parseInt(json.getString("code")));
        rr.setMsg(json.getString("msg"));
        rr.setStatus(json.getString("status"));

        return rr;

    }

    @Override
    public ResponseResult<ShopDelivery> detail(long storeId) {
        Map  reqMap=new HashMap();
        reqMap.put("origin_shop_id",storeId+"");

        String jsonStr=new JSONObject(reqMap).toJSONString();
        Object resultObj = null;
        try {
            resultObj = DadaTransport.invoke("/api/shop/detail",jsonStr );
        } catch (Exception e) {
            throw  new BusinessException("调用达达接口失败");
        }

        JSONObject json = JSONObject.parseObject(resultObj.toString());

        ResponseResult<ShopDelivery> rr=new ResponseResult<ShopDelivery>();

        rr.setCode(Integer.parseInt(json.getString("code")));
        rr.setMsg(json.getString("msg"));
        rr.setStatus(json.getString("status"));

        if("success".equals(rr.getStatus())){
            //对result的解析
            JSONObject result= json.getJSONObject("result");

            ShopDelivery rs=new ShopDelivery();

            rs.setStoreId(Long.parseLong(result.getString("origin_shop_id")));
            rs.setName(result.getString("station_name"));
            rs.setClassifyId(Long.parseLong(result.getString("business")));
            rs.setCity(result.getString("city_name"));
            rs.setArea(result.getString("area_name"));
            rs.setAddress(result.getString("station_address"));
            rs.setLongitude(Double.parseDouble(result.getString("lng")));
            rs.setLatitude(Double.parseDouble(result.getString("lat")));
            rs.setShopkeeperName(result.getString("contact_name"));
            rs.setShopkeeperMob(result.getString("phone"));
            rs.setFreezeStatus(Byte.parseByte(result.getString("status")));

            rr.setResult(rs);
        }



        return rr;

    }
}
