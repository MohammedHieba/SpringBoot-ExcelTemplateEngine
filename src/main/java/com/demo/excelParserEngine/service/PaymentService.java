package com.demo.excelParserEngine.service;

import com.demo.excelParserEngine.dtos.ExcelFileDTO;
import com.demo.excelParserEngine.dtos.ResponseUploadPaymentFile;

import java.io.IOException;

public interface PaymentService {
    ResponseUploadPaymentFile parsePaymentFile(ExcelFileDTO excelFileDTO) throws IOException;



}
