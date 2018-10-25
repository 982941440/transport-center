//package com.tota.transport;
//
//import com.tota.se.common.util.secret.MD5Util;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.io.UnsupportedEncodingException;
//import java.security.NoSuchAlgorithmException;
//
//public class DadaSignTest {
//
//
//    @Test
//    public void test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        String s="app_key123456body{\"order_id\":\"20170301000001\"}formatjsonsource_id73753timestamp1488363493v1.0";
//        String pre_str="abcdefg123"+s+"abcdefg123";
//        String sign= MD5Util.encrypt(pre_str).toUpperCase();
//        if("71CEE2D6544277940D8C72979E71D0E1".equals(sign)){
//            System.out.println(true);
//        }
//        Assert.assertEquals("71CEE2D6544277940D8C72979E71D0E1",sign);
//    }
//}
