package com.demo.excelParserEngine.service.excelparser;


public enum ParsersEnum {
    MOI_PAYMENTS_PREPARE_ALIEN_CONTROL("moiPaymentsPrepareAlienControl"),
    MOI_PAYMENTS_VEHICLE_REGISTRATION("moiPaymentsVehicleRegistration");

    String beanName;

    ParsersEnum(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
