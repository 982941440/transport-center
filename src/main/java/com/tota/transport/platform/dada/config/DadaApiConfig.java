package com.tota.transport.platform.dada.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DadaApiConfig {

    private  static volatile DadaApiConfig instance;

    private List<String> apiUrls=new ArrayList<>();

    private static Object LOCK = new Object();

    public static DadaApiConfig getInstance() {
        if (null == instance) {
            synchronized (LOCK) {
                if (null == instance) {
                    instance = new DadaApiConfig();
                }
            }
        }
        return instance;
    }

    public void init() throws IOException {
        InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("dadaapi.properties");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.contains("#") || str.trim().length() == 0) {
                continue;
            }
            apiUrls.add(str);
        }
        bufferedReader.close();
        inputStream.close();
    }

    public  List<String> getApiUrls() {
        return apiUrls;
    }
}
