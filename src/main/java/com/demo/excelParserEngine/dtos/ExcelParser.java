package com.demo.excelParserEngine.dtos;

import io.micrometer.common.util.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.demo.excelParserEngine.utils.ExcelUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


abstract public class ExcelParser <T extends ExcelBatchMarker>{

    public final List<T> process(ExcelFileDTO excelFileDTO) throws IOException {
        List<T> batches =  new ArrayList<>();
        try (InputStream inputStream = excelFileDTO.getFile().getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(getSheetIndex());
            int rowNum = getRow();
            while (StringUtils.isNotBlank(ExcelUtils.getCellValueFromFormula(rowNum, 0, sheet, workbook))) {
                T data =  parseRow(rowNum, excelFileDTO, sheet, workbook );
                batches.add(data);
                rowNum++;
            }
            workbook.close();

        }catch (Exception ex){
            throw new RuntimeException("error.parsing.excel.file");
        }
        return batches;
    }
    protected abstract int getSheetIndex();
    protected abstract int getRow();
    protected abstract T parseRow(int rowNum,  ExcelFileDTO excelFileDTO, Sheet sheet, Workbook workbook);

}
