package com.demo.excelParserEngine.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponsePaymentsGeneralBatch implements ExcelBatchMarker {

    private static final long serialVersionUID = 4213752578038292059L;

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
