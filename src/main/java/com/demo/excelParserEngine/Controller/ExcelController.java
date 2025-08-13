package com.demo.excelParserEngine.Controller;


import com.demo.excelParserEngine.dtos.ResponsePaymentsGeneralBatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelController {


    public ResponseEntity<ResponsePaymentsGeneralBatch> parsePaymentsExcelFile(@RequestPart(required = true) MultipartFile file){
        ResponsePaymentsGeneralBatch responsePaymentsGeneralBatch = new ResponsePaymentsGeneralBatch();

        return new ResponseEntity<>(responsePaymentsGeneralBatch, HttpStatus.OK);
    }
}
