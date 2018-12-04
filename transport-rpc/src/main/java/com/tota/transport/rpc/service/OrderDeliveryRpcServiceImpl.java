package com.tota.transport.rpc.service;



import com.alibaba.fastjson.JSONObject;
import com.tota.se.common.exception.BusinessException;
import com.tota.transport.common.Constant;
import com.tota.transport.common.tools.DadaTransport;
import com.tota.transport.common.util.CastingUtil;
import com.tota.transport.dataaccess.dao.mysql.DeliverBalanceMysqlDAO;
import com.tota.transport.dataaccess.dao.mysql.OrderDeliverMysqlDAO;
import com.tota.transport.dataaccess.domain.OrderDeliverDO;
import com.tota.transport.rpc.api.domain.ResponseResult;
import com.tota.transport.rpc.api.domain.request.QueryDeliverFeeReq;
import com.tota.transport.rpc.api.domain.response.OrderCancelResp;
import com.tota.transport.rpc.api.domain.response.OrderDeliveryResp;
import com.tota.transport.rpc.api.domain.response.QueryDeliverFeeResp;
import com.tota.transport.rpc.api.service.OrderDeliveryRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: duanjc 2018/9/18 10:26
 * */
@Service
public class OrderDeliveryRpcServiceImpl implements OrderDeliveryRpcService{

    @Autowired
    private DeliverBalanceMysqlDAO deliverBalanceMysqlDAO;

    @Autowired
    private OrderDeliverMysqlDAO orderDeliverMysqlDAO;

    @Override
    public ResponseResult<QueryDeliverFeeResp> queryDeliverFee(QueryDeliverFeeReq queryDeliverFeeReq) {

        Map  reqMap=new HashMap();
        reqMap.put("shop_no",queryDeliverFeeReq.getStoreId()+"");
        reqMap.put("origin_id",queryDeliverFeeReq.getDeliveryId()+"");
        reqMap.put("city_code",DadaTransport.getCityCode(queryDeliverFeeReq.getCity()));
        reqMap.put("cargo_price", CastingUtil.longToDouble(queryDeliverFeeReq.getActualPayAmount()));
        reqMap.put("is_prepay",0);
        reqMap.put("receiver_name",queryDeliverFeeReq.getName());
        reqMap.put("receiver_address",queryDeliverFeeReq.getAddress());
        reqMap.put("receiver_phone",queryDeliverFeeReq.getPhone());
        reqMap.put("callback", Constant.CALLBACK_URL);
        reqMap.put("info",queryDeliverFeeReq.getRemark());

        String jsonStr=new JSONObject(reqMap).toJSONString();
        Object resultObj = null;
        try {
            resultObj = DadaTransport.invoke("/api/order/queryDeliverFee",jsonStr );
        } catch (Exception e) {
            throw  new BusinessException("调用达达接口失败");
        }

        JSONObject json = JSONObject.parseObject(resultObj.toString());

        ResponseResult<QueryDeliverFeeResp> rr=new ResponseResult<QueryDeliverFeeResp>();

        rr.setCode(Integer.parseInt(json.getString("code")));
        rr.setMsg(json.getString("msg"));
        rr.setStatus(json.getString("status"));

        if("success".equals(rr.getStatus())){
            //对result的解析
            JSONObject result= json.getJSONObject("result");

            QueryDeliverFeeResp rs=new QueryDeliverFeeResp();


            rs.setDeliverFee(CastingUtil.DoubleStrToLong(result.getString("deliverFee")));
            rs.setDistance(Double.parseDouble(result.getString("distance")));
            rs.setDeliveryNo(result.getString("deliveryNo"));

            rr.setResult(rs);

            long deliverFee=CastingUtil.DoubleStrToLong(result.getString("deliverFee"));
            long allFee=deliverFee+CastingUtil.ServiceFee(deliverFee);

            OrderDeliverDO odd=new OrderDeliverDO();
            odd.setDeliveryId(queryDeliverFeeReq.getDeliveryId());
            odd.setDeliveryNo(result.getString("deliveryNo"));
            odd.setShopId(queryDeliverFeeReq.getShopId());
            odd.setStoreId(queryDeliverFeeReq.getStoreId());
            odd.setDeliveryFee(deliverFee);
            odd.setServiceFee(CastingUtil.ServiceFee(deliverFee));
            odd.setAllFee(allFee);

            orderDeliverMysqlDAO.save(odd);

        }



        return rr;
    }

    @Override
    public ResponseResult ConfirmOrder(long deliveryId) {

        ResponseResult rr=new ResponseResult();

        OrderDeliverDO odd=orderDeliverMysqlDAO.findById(deliveryId);
        long balance=deliverBalanceMysqlDAO.queryBalance(odd.getShopId());

        if(balance<odd.getAllFee()){
            rr.setStatus("fail");
            rr.setCode(1);
            rr.setMsg("配送余额不足,无法下单");

            return rr;
        }

        Map  reqMap=new HashMap();
        reqMap.put("deliveryNo",odd.getDeliveryNo());

        String jsonStr=new JSONObject(reqMap).toJSONString();
        Object resultObj = null;
        try {
            resultObj = DadaTransport.invoke("/api/order/addAfterQuery",jsonStr );
        } catch (Exception e) {
            throw  new BusinessException("调用达达接口失败");
        }

        JSONObject json = JSONObject.parseObject(resultObj.toString());

        rr.setCode(Integer.parseInt(json.getString("code")));
        rr.setMsg(json.getString("msg"));
        rr.setStatus(json.getString("status"));

        if("success".equals(rr.getStatus())){

            deliverBalanceMysqlDAO.updateBalance(odd.getShopId(),-odd.getAllFee());
        }



        return rr;
    }

    @Override
    public ResponseResult<OrderDeliveryResp> queryOrder(long deliveryId) {

        Map  reqMap=new HashMap();
        reqMap.put("order_id",deliveryId+"");

        String jsonStr=new JSONObject(reqMap).toJSONString();
        Object resultObj = null;
        try {
            resultObj = DadaTransport.invoke("/api/order/status/query",jsonStr );
        } catch (Exception e) {
            throw  new BusinessException("调用达达接口失败");
        }

        JSONObject json = JSONObject.parseObject(resultObj.toString());

        ResponseResult<OrderDeliveryResp> rr=new ResponseResult<OrderDeliveryResp>();

        rr.setCode(Integer.parseInt(json.getString("code")));
        rr.setMsg(json.getString("msg"));
        rr.setStatus(json.getString("status"));

       if("success".equals(rr.getStatus())){
           //对result的解析
           JSONObject result= json.getJSONObject("result");

           OrderDeliveryResp odr=new OrderDeliveryResp();

           odr.setDeliveryId(Long.parseLong(result.getString("orderId")));
           odr.setStatusCode(Integer.parseInt(result.getString("statusCode")));
           odr.setStatusMsg(result.getString("statusMsg"));
           odr.setTransporterName(result.getString("transporterName"));
           odr.setTransporterPhone(result.getString("transporterPhone"));
           odr.setTransporterLng(result.getString("transporterLng"));
           odr.setTransporterLat(result.getString("transporterLat"));
           odr.setDeliveryFee(CastingUtil.DoubleStrToLong(result.getString("deliveryFee")));
           odr.setDistance(Double.parseDouble(result.getString("distance")));
           odr.setAcceptTime(result.getString("acceptTime"));
           odr.setFetchTime(result.getString("fetchTime"));
           odr.setFinishTime(result.getString("finishTime"));
           odr.setCancelTime(result.getString("cancelTime"));
           rr.setResult(odr);


       }

        return rr;
    }

    @Override
    public ResponseResult<OrderCancelResp> orderCancel(long deliveryId) {
        Map  reqMap=new HashMap();
        reqMap.put("order_id",deliveryId+"");
        reqMap.put("cancel_reason_id",36);

        String jsonStr=new JSONObject(reqMap).toJSONString();
        Object resultObj = null;
        try {
            resultObj = DadaTransport.invoke("/api/order/formalCancel",jsonStr );
        } catch (Exception e) {
            throw  new BusinessException("调用达达接口失败");
        }

        JSONObject json = JSONObject.parseObject(resultObj.toString());

        ResponseResult<OrderCancelResp> rr=new ResponseResult<OrderCancelResp>();

        rr.setCode(Integer.parseInt(json.getString("code")));
        rr.setMsg(json.getString("msg"));
        rr.setStatus(json.getString("status"));

        if("success".equals(rr.getStatus())){
            //对result的解析
            JSONObject result= json.getJSONObject("result");

            OrderCancelResp rs=new OrderCancelResp();

            rs.setDeductFee(CastingUtil.DoubleStrToLong(result.getString("deduct_fee")));

            rr.setResult(rs);

            //返还运费
            OrderDeliverDO odd=orderDeliverMysqlDAO.findById(deliveryId);

            deliverBalanceMysqlDAO.updateBalance(odd.getShopId(),odd.getAllFee()-CastingUtil.DoubleStrToLong(result.getString("deduct_fee")));
        }


        return rr;
    }




    public static void main(String[] args) throws Exception {

//        Object resultObj = DadaTransport.invoke("/api/order/formalCancel", "{\"order_id\":\"65415151\",\"cancel_reason_id\":\"1\",\"cancel_reason\":\"没有配送员接单\"}");
//
//        System.out.println(resultObj);

         OrderDeliveryRpcServiceImpl od=new OrderDeliveryRpcServiceImpl();

         od.queryOrder(65415116);






    }









}
