package com.tota.transport.util;

import com.tota.se.common.util.secret.MD5Util;

import java.util.List;
import java.util.Map;

public class SignUtil {


   public static String getDadaSign(List<String> fieldNames, Map<String,Object> fieldMap){
       StringBuilder sb=new StringBuilder();
       for (String s :fieldNames){
           sb.append(s+fieldMap.get(s).toString());
       }
       String app_secret="c8d6ddbecba3c671b65be0341edcc11f";
       String pre_str=app_secret+sb.toString()+app_secret;
       String sign=MD5Util.encrypt(pre_str).toUpperCase();
       return sign;
    }

}
