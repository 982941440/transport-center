package com.tota.transport.platform.dada.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tota.transport.platform.ITransportBaseService;
import com.tota.transport.platform.dada.config.DadaApiConfig;
import com.tota.transport.platform.dada.model.req.BaseDadaReq;
import com.tota.transport.util.HttpClientUtil;
import com.tota.transport.util.SignUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

@Service("dadaTransport")
public class DadaTransportService implements ITransportBaseService {


    @Override
    public Object invokeService(String serviceName, String body) throws Exception {
        List<String> list = DadaApiConfig.getInstance().getApiUrls();
        if (!list.contains(serviceName)) {
            return null;
        }
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
        String signature=SignUtil.getDadaSign(fieldNames,fieldMap);
        requestData.signature=signature;
        String url = "http://newopen.qa.imdada.cn"+serviceName;
        String result=HttpClientUtil.post(url, JSON.toJSONString(requestData));
        return result;
    }

    public static void main(String args[]) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://newopen.qa.imdada.cn/api/order/reAddOrder";
        HttpPost httpPost = new HttpPost(url);
        // 设置请求的header
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        // 设置请求的参数
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("app_key", "dadac6d41524123d778");
        jsonParam.put("body", "{\"callback\":\"4141\",\"cargo_price\":12.0,\"city_code\":\"1432\",\"is_prepay\":1,\"origin_id\":\"432414\",\"receiver_address\":\"gagaga\",\"receiver_lat\":22.545771,\"receiver_lng\":114.084102,\"receiver_name\":\"ssss\",\"receiver_phone\":\"15712102476\",\"shop_no\":\"11047059\"}");
        jsonParam.put("format", "json");
        jsonParam.put("signature", "ECBFC82C2F6E637A5AB182FCC92A0902");
        jsonParam.put("source_id", "73753");
        jsonParam.put("timestamp", "1537254168");
        jsonParam.put("v", "1.0");
        StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        // 执行请求
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
            JSONObject jsonObject = JSONObject.parseObject(json2);
            // 打印执行结果
            System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
