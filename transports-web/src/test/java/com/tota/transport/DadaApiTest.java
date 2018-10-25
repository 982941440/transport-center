//package com.tota.transport;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.tota.transport.util.HttpClientUtil;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class DadaApiTest {
//
//
//    private static String url = "http://localhost:80/transport-center/transport";
//
//    /**
//     * 新增订单
//
//     */
//    @Test
//    public void addOrder() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/addOrder");
//        JSONObject json=new JSONObject();
//        json.put("shop_no","11047059");
//        json.put("origin_id","654151516");
//        json.put("city_code","1432");
//        json.put("cargo_price",1.00);
//        json.put("is_prepay","0");
//        json.put("receiver_name","szg");
//        json.put("receiver_address","SZ");
//        json.put("receiver_lat",22.563612);
//        json.put("receiver_lng",113.88391);
//        json.put("callback","www.google.com");
//        json.put("receiver_phone","15712102476");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, new HashMap<String, String>(),paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 重发订单
//
//     */
//    @Test
//    public void reAddOrder() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/reAddOrder");
//        JSONObject json=new JSONObject();
//        json.put("shop_no","11047059");
//        json.put("origin_id","5525115");
//        json.put("city_code","1432");
//        json.put("cargo_price",12.00);
//        json.put("is_prepay","0");
//        json.put("receiver_name","szg");
//        json.put("receiver_address","SZ");
//        json.put("receiver_lat",22.563612);
//        json.put("receiver_lng",113.88391);
//        json.put("callback","www.google.com");
//        json.put("receiver_phone","15712102476");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, new HashMap<String, String>(),paramMap,"utf-8");
//        System.out.println(result); //取消订单后，重新发单成功
//    }
//
//
//    /**
//     * 查询订单运费
//     */
//    @Test
//    public void queryDeliverFee() throws Exception {
//        String url = "http://localhost:80/transport-center/transport";
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/queryDeliverFee");
//        JSONObject json=new JSONObject();
//        json.put("shop_no","11047059");
//        json.put("origin_id","87683534");
//        json.put("city_code","0755");
//        json.put("cargo_price",14.00);
//        json.put("is_prepay","0");
//        json.put("receiver_name","szg");
//        json.put("receiver_address","深圳市宝安区建安一路99号");
//        json.put("callback","www.google.com");
//        json.put("receiver_phone","15712102476");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, new HashMap<String, String>()  , paramMap,"utf-8");
//        System.out.println(result); // 请求返回 ：订单价格信息已过期,请重新查询后发单
//    }
//
//
//    /**
//     * 查询运费后发单
//     */
//    @Test
//    public void addAfterQuery() throws Exception {
//        String url = "http://localhost:80/transport-center/transport";
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/addAfterQuery");
//        JSONObject json=new JSONObject();
//        json.put("deliveryNo","Dadae9353fbd225342bc9a0556d76f3b7196");//接口文档没有此项参数，但请求却提示不能为空
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result); // 使用【查询订单运费接口】获取平台订单编号，调用【查询运费后发单接口】即可发布订单
//    }
//
//    /**
//     * 添加小费
//     */
//    @Test
//    public void addTip() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/addTip");
//        JSONObject json=new JSONObject();
//        json.put("order_id","5525115");
//        json.put("tips",1.0);
//        json.put("city_code","1432");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, new HashMap<String, String>(),paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 订单详情查询
//
//     */
//    @Test
//    public void queryOrder() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/status/query");
//        JSONObject json=new JSONObject();
//        json.put("order_id","5525115");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, new HashMap<String, String>(),paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//
//    /**
//     * 订单取消原因
//
//     */
//    @Test
//    public void cancelReasons() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/cancel/reasons");
//        paramMap.put("body","");
//        System.out.println("请求参数body===============:");
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//
//    /**
//     * 订单取消
//
//     */
//    @Test
//    public void formalCancel() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/formalCancel");
//        JSONObject json=new JSONObject();
//        json.put("order_id","5525115");
//        json.put("cancel_reason_id","1");
//        json.put("cancel_reason","没有配送员接单");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 查询配送员
//     */
//    @Test
//    public void queryTransporter() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/appoint/list/transporter");
//        JSONObject json=new JSONObject();
//        json.put("shop_no","11047059");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//
//    /**
//     * 追加订单给配送员
//
//     */
//    @Test
//    public void appendOrder() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/appoint/exist");
//        JSONObject json=new JSONObject();
//        json.put("order_id","5525115");
//        json.put("transporter_id","666");//先查询配送员id
//        json.put("shop_no","11047059");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 取消追加订单给配送员
//
//     */
//    @Test
//    public void cancelAppendOrder() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/order/appoint/cancel");
//        JSONObject json=new JSONObject();
//        json.put("order_id","5525115");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//
//    /**
//     * 获取城市信息
//
//     */
//    @Test
//    public void cityCodeList() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/cityCode/list");
//        paramMap.put("body","");
//        System.out.println("请求参数body===============:");
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 注册商户
//
//     */
//    @Test
//    public void registMerchant() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/merchantApi/merchant/add");
//        System.out.println("请求参数body===============:");
//        paramMap.put("body","");
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);//多次测试 提示服务器异常
//    }
//
//    /**
//     * 新增门店
//
//     */
//    @Test
//    public void addShop() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/shop/add");
//        JSONObject json=new JSONObject();
//        json.put("station_name","bigshop");
//        json.put("business",1);
//        json.put("city_name","深圳");
//        json.put("area_name","南山区");
//        json.put("station_address","深圳南山区TCL国际E城");
//        json.put("lng",113.92985);
//        json.put("lat",22.544786);
//        json.put("contact_name","gahaga");
//        json.put("phone","15712102477");
//        JSONArray jsonArray=new JSONArray();
//        jsonArray.add(json);
//        String body=jsonArray.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 门店更新
//
//     */
//    @Test
//    public void updateShop() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/shop/update");
//        JSONObject json=new JSONObject();
//        json.put("origin_shop_id","73753-26342");//新增门店可以获取到origin_shop_id
//        json.put("station_name","cuteShop");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 门店详情
//
//     */
//    @Test
//    public void shopDetail() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/shop/detail");
//        JSONObject json=new JSONObject();
//        json.put("origin_shop_id","73753-26342");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 商家投诉达达原因
//
//     */
//    @Test
//    public void complaintReasons() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/complaint/reasons");
//        System.out.println("请求参数body===============:");
//        paramMap.put("body","");
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 商家投诉达达
//
//     */
//    @Test
//    public void complaint() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/complaint/dada");
//        JSONObject json=new JSONObject();
//        json.put("order_id","5525115");
//        json.put("reason_id","4"); //先调上面投诉原因接口
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result);
//    }
//
//    /**
//     * 充值
//
//     */
//    @Test
//    public void recharge() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/recharge");
//        JSONObject json=new JSONObject();
//        json.put("amount",0.01);
//        json.put("category","H5");
//        json.put("notify_url","www.baidu.com");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result); //返回一个支付链接 并支付成功
//    }
//
//
//    /**
//     * 查询余额
//
//     */
//    @Test
//    public void queryBalance() throws Exception {
//        Map<String,String> paramMap=new HashMap<>();
//        paramMap.put("transType","1");
//        paramMap.put("service","/api/balance/query");
//        JSONObject json=new JSONObject();
//        json.put("category","1");
//        String body=json.toJSONString();
//        System.out.println("请求参数body===============:"+body);
//        paramMap.put("body",body);
//        String result=HttpClientUtil.post(url, null,paramMap,"utf-8");
//        System.out.println(result); //返回一个支付链接 并支付成功
//    }
//
//
//
//}
