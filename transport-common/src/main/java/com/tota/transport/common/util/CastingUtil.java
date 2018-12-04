package com.tota.transport.common.util;

public class CastingUtil {


    private static  final int x=20;

    private  static  final long y=100;

    //把分 转成元
    public static double longToDouble(double amount){
        return  (double)amount/100;

    }


    //把String元 转成分
    public static long DoubleStrToLong(String amount){
        return  (long)(Double.parseDouble(amount)*100);

    }

    //服务费计算
    public static  long ServiceFee(long amount){
         return  (amount*x)/100+y;
    }


    public static void main(String[] args) {
        System.out.println( CastingUtil.longToDouble(1520));
    }
}
