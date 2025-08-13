package com.demo.excelParserEngine.service.excelparser;

import com.demo.excelParserEngine.dtos.ExcelBatchMarker;;
import com.demo.excelParserEngine.service.excelparser.ExcelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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