package com.tota.transport.common.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tota.se.common.exception.BusinessException;
import com.tota.transport.common.domain.BaseDadaReq;
import com.tota.transport.common.util.HttpClientUtil;
import com.tota.transport.common.util.SignUtil;
import java.lang.reflect.Field;
import java.util.*;

public class DadaTransport {



    public static Object invoke(String serviceName, String body) throws Exception {
//        List<String> list = DadaApiConfig.getInstance().getApiUrls();
//        if (!list.contains(serviceName)) {
//            return null;
//        }
        BaseDadaReq requestData = new BaseDadaReq();
        requestData.body = body;
        Class<?> c = BaseDadaReq.class;
        Field[] fields = c.getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        Map<String, Object> fieldMap = new HashMap<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (fieldName.equals("signature")) {
                continue;
            }
            fieldNames.add(fieldName);
            fieldMap.put(fieldName, field.get(requestData));
        }
        Collections.sort(fieldNames);
        String signature= SignUtil.getDadaSign(fieldNames,fieldMap);
        requestData.signature=signature;
        String url = "http://newopen.qa.imdada.cn"+serviceName;
        String result= HttpClientUtil.post(url, JSON.toJSONString(requestData));
        return result;
    }


    public static  String  getCityCode(String cityName){
        Object resultObj = null;
        try {
            resultObj =invoke("/api/cityCode/list","" );
        } catch (Exception e) {
            throw  new BusinessException("调用达达查询城市code接口失败");
        }
         JSONObject result=JSONObject.parseObject(resultObj.toString());

        JSONArray json = JSONArray.parseArray(result.getString("result"));

        for (int i = 0; i <json.size() ; i++) {
            JSONObject job = json.getJSONObject(i);

            if (job.getString("cityName").equals(cityName)) {
                 return job.getString("cityCode");
            }

        }

        return  "";
    }

    public static void main(String[] args) throws Exception{

        //System.out.println(new DadaTransport().invoke("/api/cityCode/list",""));

      System.out.println(getCityCode("武汉"));

      System.exit(0);
    }



//    public static void main(String args[]) {
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        String url = "http://newopen.qa.imdada.cn/api/order/reAddOrder";
//        HttpPost httpPost = new HttpPost(url);
//        // 设置请求的header
//        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
//        // 设置请求的参数
//        JSONObject jsonParam = new JSONObject();
//        jsonParam.put("app_key", "dadac6d41524123d778");
//        jsonParam.put("body", "{\"callback\":\"4141\",\"cargo_price\":12.0,\"city_code\":\"1432\",\"is_prepay\":1,\"origin_id\":\"432414\",\"receiver_address\":\"gagaga\",\"receiver_lat\":22.545771,\"receiver_lng\":114.084102,\"receiver_name\":\"ssss\",\"receiver_phone\":\"15712102476\",\"shop_no\":\"11047059\"}");
//        jsonParam.put("format", "json");
//        jsonParam.put("signature", "ECBFC82C2F6E637A5AB182FCC92A0902");
//        jsonParam.put("source_id", "73753");
//        jsonParam.put("timestamp", "1537254168");
//        jsonParam.put("v", "1.0");
//        StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
//        entity.setContentEncoding("UTF-8");
//        entity.setContentType("application/json");
//        httpPost.setEntity(entity);
//        // 执行请求
//        HttpResponse response = null;
//        try {
//            response = httpclient.execute(httpPost);
//            String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
//            JSONObject jsonObject = JSONObject.parseObject(json2);
//            // 打印执行结果
//            System.out.println(jsonObject);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}
