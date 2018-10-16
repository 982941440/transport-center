package com.tota.transport.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.*;

public class HttpClientUtil {
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);
    private static String DEFAULT_CHARSET = "UTF-8";
    private static int DEFAULT_PORT = 80;

    public HttpClientUtil() {
    }

    public static String get(String url) {
        return get(url, DEFAULT_CHARSET);
    }

    public static String get(String url, String charSet) {
        String responseStr = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    responseStr = EntityUtils.toString(entity, charSet);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException var28) {
            log.error("Http get request error", var28);
        } catch (ParseException var29) {
            log.error("Http get request error", var29);
        } catch (IOException var30) {
            log.error("Http get request error", var30);
        } finally {
            try {
                httpclient.close();
            } catch (IOException var26) {
                log.error("Httpclient close error", var26);
            }

        }

        return responseStr;
    }


    public static String post(String url, Object requestData) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        // 设置请求的header
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        // 设置请求的参数
        StringEntity entity = new StringEntity(requestData.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String json = EntityUtils.toString(response.getEntity(), "utf-8");
        // 打印执行结果
        System.out.println(json);
        return json;
    }


    public static String post(String url, Map<String, String> headerMap, Map<String, String> paramterMap, String charSet) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        //设置请求头
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpPost.setHeader(entry.getKey(), entry.getValue());
        }
        List<NameValuePair> params = new ArrayList();
        for (Map.Entry<String, String> entry : paramterMap.entrySet()) {
            params.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, charSet);
        httpPost.setEntity(uefEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String responseStr = EntityUtils.toString(entity, charSet);
                log.info("请求响应：" + responseStr);
                return responseStr;
            }
        } finally {
            response.close();
            httpClient.close();
        }
        return "";
    }


    public static String purge(String varnishIp, String url) {
        String responseStr = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpClientUtil.HttpPurge httpPurge = new HttpClientUtil.HttpPurge(url);
            RequestConfig requestConfig = RequestConfig.custom().setProxy(new HttpHost(varnishIp, DEFAULT_PORT)).build();
            httpPurge.setConfig(requestConfig);
            CloseableHttpResponse response = httpclient.execute(httpPurge);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    responseStr = EntityUtils.toString(entity, DEFAULT_CHARSET);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException var29) {
            log.error("Http purge request error", var29);
        } catch (ParseException var30) {
            log.error("Http purge request error", var30);
        } catch (IOException var31) {
            log.error("Http purge request error", var31);
        } finally {
            try {
                httpclient.close();
            } catch (IOException var27) {
                log.error("Httpclient close error", var27);
            }
        }
        return responseStr;
    }

    static class HttpPurge extends HttpRequestBase {
        public static final String METHOD_NAME = "PURGE";

        public HttpPurge() {
        }

        public HttpPurge(URI uri) {
            this.setURI(uri);
        }

        public HttpPurge(String uri) {
            this.setURI(URI.create(uri));
        }

        public String getMethod() {
            return "PURGE";
        }
    }
}