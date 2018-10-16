package com.tota.transport.enums;

public enum TransTypeEnum {

    Dada("1","达达物流"),SF("2","顺丰物流"),EMS("3","中国邮政");

    String key;

    String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    TransTypeEnum(String key, String value) {
        this.key=key;
        this.value=value;
    }




   public static void main(String args[]){
      for(TransTypeEnum typeEnum:TransTypeEnum.values()){
          System.out.println(typeEnum.getKey());

      }
//        System.out.println(TransTypeEnum.Dada.getValue());

   }
}
