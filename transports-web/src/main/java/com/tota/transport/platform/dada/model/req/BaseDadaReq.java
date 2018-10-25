package com.tota.transport.platform.dada.model.req;

public class BaseDadaReq {

    public String app_key="dadac6d41524123d778";

    public String body;

    public String format="json";

    public String  source_id="73753";//商户编号（创建商户账号分配的编号）	测试环境默认为：73753

    public String timestamp=String.valueOf(System.currentTimeMillis()/1000) ;

    public String v="1.0";

    public String signature;

}
