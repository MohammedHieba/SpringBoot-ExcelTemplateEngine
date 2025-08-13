package com.demo.excelParserEngine.service;


import com.demo.excelParserEngine.dtos.*;
import com.demo.excelParserEngine.service.excelparser.ExcelParser;
import com.demo.excelParserEngine.service.excelparser.ParserFactory;
import com.demo.excelParserEngine.service.excelparser.ParsersEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    private final ParserFactory parserFactory;

    @Override
    public ResponseUploadPaymentFile parsePaymentFile(ExcelFileDTO excelFileDTO) throws IOException {
        ExcelParser<ExcelBatchMarker> parser = parserFactory.getParser(ParsersEnum.PAYMENT_PARSER);
        log.info("Payment parser Instance:------------{}", parser);
        List batches = parser.process(excelFileDTO);
        ResponseUploadPaymentFile res = new ResponseUploadPaymentFile();
        res.setBatches(batches);

        return res;
    }
}
