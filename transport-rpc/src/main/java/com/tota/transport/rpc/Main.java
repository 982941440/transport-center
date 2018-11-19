package com.tota.transport.rpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jcduan on 2018/9/19
 */
public class Main {
    private static ClassPathXmlApplicationContext context;

    private static String configPath = "classpath*:spring-config.xml";
    public static void main(String[] args) {

        System.out.println("================starting==========================");
        context = new ClassPathXmlApplicationContext(new String[] { configPath });
        context.start();

        System.out.println("================dubbo service server started==========================");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}