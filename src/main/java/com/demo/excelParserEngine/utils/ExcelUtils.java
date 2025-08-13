package com.demo.excelParserEngine.utils;

import org.apache.poi.ss.usermodel.*;

import java.util.Objects;

public class ExcelUtils {
    public static final String SERVICE_TRIM_REGEX = "-";

    public static String getCellValue(int rowNumber, int columnNumber, Sheet sheet) {
        String value="";
        if (sheet != null) {
            Row row=sheet.getRow(rowNumber);
            if(row==null){
                return value;
            }
            Cell cell = row.getCell(columnNumber);
            if(cell==null){
                return value;
            }
            DataFormatter dataFormatter = new DataFormatter();
            value = dataFormatter.formatCellValue(cell);

        }
        return value;
    }


    public static Double getCellNumericValue(int rowNumber, int columnNumber, Sheet sheet) {
        Double value = null;
        if (sheet != null) {
            Row row=sheet.getRow(rowNumber);
            if(row==null){
                return value;
            }
            Cell cell = row.getCell(columnNumber);
            if(cell==null){
                return value;
            }
            return Double.valueOf(cell.getNumericCellValue());

        }
        return value;
    }

    public static String getCellValueFromFormula(int rowNumber, int columnNumber, Sheet sheet, Workbook workbook) {
        String value="";
        if (sheet != null) {
            Row row=sheet.getRow(rowNumber);
            if(row==null){
                return value;
            }
            Cell cell = row.getCell(columnNumber);
            if(cell==null){
                return value;
            }
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            CellValue cellValue = evaluator.evaluate(cell);
            if(Objects.isNull(cellValue)) return value;
            switch (cellValue.getCellType()) {
                case NUMERIC:
                    return String.valueOf(cellValue.getNumberValue());
                case STRING:
                    return cellValue.getStringValue();
                case BOOLEAN:
                    return String.valueOf(cellValue.getBooleanValue());
                default:
                    return value;
            }

        }
        return value;
    }
}
