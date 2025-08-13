package com.demo.excelParserEngine.service.excelparser;


import com.demo.excelParserEngine.dtos.ExcelBatchMarker;
import com.demo.excelParserEngine.dtos.ExcelFileDTO;
import com.demo.excelParserEngine.dtos.ExcelParser;
import com.thalesgroup.ecorp.srv.dto.ExcelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sa.alrajhi.ecorp.service.excelParser.ExcelParser;

import java.util.Map;

@Component
public class ParserFactory{
    private final Map<String, ExcelParser> parsers;

    @Autowired
    public ParserFactory(Map<String, ExcelParser> parsers) {
        this.parsers = parsers;
    }
    public  <T extends ExcelBatchMarker> ExcelParser<T> getParser(ParsersEnum type){

        ExcelParser passedParser = parsers.get(type.getBeanName());

        if(passedParser == null){
            throw new IllegalArgumentException("No parser found for name " + type.getBeanName());
        }
        return passedParser;
    }


}