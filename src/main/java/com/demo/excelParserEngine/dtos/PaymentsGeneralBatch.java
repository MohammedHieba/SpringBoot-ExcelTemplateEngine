package com.demo.excelParserEngine.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PaymentsGeneralBatch implements ExcelBatchMarker {


    private String borderNumber;
    private String iqamaId;
    private String householdIdNumber;
    private String numberDependant;
    private String citizenId;
    private String iqamaDuration;
    private String visaNumber;
    private String sponsorId;
    private String jobCategory;
    private String amount;
    private String serviceName;
    private String transactionType;
    private String serviceType;
    private String applicationType;
    private String accountNumber;
    private String customerReference;
    private String visaDuration;
}
