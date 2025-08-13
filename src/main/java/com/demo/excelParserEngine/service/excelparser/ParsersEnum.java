package com.demo.excelParserEngine.service.excelparser;


public enum ParsersEnum {
    PAYMENT_PARSER("paymentParser");

    String beanName;

    ParsersEnum(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
