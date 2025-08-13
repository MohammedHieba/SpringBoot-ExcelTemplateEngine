package com.demo.excelParserEngine.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class ResponseUploadPaymentFile implements Serializable {

    @Serial
    private static final long serialVersionUID = 4213752578038292059L;

    private List<PaymentsGeneralBatch> batches;
}
