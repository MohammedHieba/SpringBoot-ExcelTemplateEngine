package com.demo.excelParserEngine.Controller;


import com.demo.excelParserEngine.dtos.ExcelFileDTO;
import com.demo.excelParserEngine.dtos.PaymentsGeneralBatch;
import com.demo.excelParserEngine.dtos.ResponseUploadPaymentFile;
import com.demo.excelParserEngine.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ExcelController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/upload/{accountNumber}")
    public ResponseEntity<ResponseUploadPaymentFile> parsePaymentsExcelFile(@RequestPart(required = true) MultipartFile file, @PathVariable("accountNumber") String accountNumber) throws IOException {

        ResponseUploadPaymentFile response = paymentService.parsePaymentFile(ExcelFileDTO.builder().file(file).accountNo(accountNumber).build());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
