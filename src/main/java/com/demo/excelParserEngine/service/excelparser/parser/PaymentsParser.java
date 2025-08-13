package com.demo.excelParserEngine.service.excelparser.parser;

import com.demo.excelParserEngine.dtos.ExcelFileDTO;
import com.demo.excelParserEngine.dtos.ExcelParser;
import com.demo.excelParserEngine.dtos.ResponsePaymentsGeneralBatch;
import com.demo.excelParserEngine.utils.ExcelUtils;
import io.micrometer.common.util.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import com.demo.excelParserEngine.utils.ExcelUtils.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import static  com.demo.excelParserEngine.constants.PaymentsConstants.*;




@Component("paymentParser")
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PaymentsParser extends ExcelParser<ResponsePaymentsGeneralBatch> {

    public static final Map<String, String> SERVICE_MAP = new HashMap<>();
    static {
        SERVICE_MAP.put("090-004", "Exit Re-entry Visa (Single)");
        SERVICE_MAP.put("090-005", "Exit Re-entry Visa (Multiple)");
        SERVICE_MAP.put("090-002", "Issue New Iqama");
        SERVICE_MAP.put("090-003", "Renew Iqama");
        SERVICE_MAP.put("090-007", "Transfer of Sponsorship");
        SERVICE_MAP.put("090-012", "Change of Occupation");
    }
    public static String getServiceLabel(String key) {
        return SERVICE_MAP.getOrDefault(key, "Unknown");
    }


    @Override
    protected int getSheetIndex() {
        return MOI_PARSER_SHEET_INDEX;
    }

    @Override
    protected int getRow() {
        return ROW_MOI_PARSER_START_VALUE;
    }


    @Override
    protected ResponsePaymentsGeneralBatch parseRow(int rowNum, ExcelFileDTO excelFileDTO, Sheet sheet, Workbook workbook) {
        ResponsePaymentsGeneralBatch batch = new ResponsePaymentsGeneralBatch();

        batch.setAccountNumber(excelFileDTO.getAccountNo());
        String serviceName = getServiceLabel(ExcelUtils.getCellValueFromFormula(rowNum, COLUMN_SERVICE, sheet, workbook));
        batch.setServiceName(serviceName);
        String[] service = ExcelUtils.getCellValueFromFormula(rowNum, COLUMN_SERVICE, sheet, workbook).split(ExcelUtils.SERVICE_TRIM_REGEX);
        batch.setServiceType(service[0]);
        batch.setApplicationType(service[1]);
        batch.setTransactionType(TRANSACTION_TYPE);

        String iqamaId = ExcelUtils.getCellValue(rowNum, COLUMN_IQAMA_ID, sheet);
        batch.setIqamaId(iqamaId);
        batch.setBorderNumber(iqamaId);

        String iqamaDuration = ExcelUtils.getCellValue(rowNum, COLUMN_IQAMA_DURATION, sheet);
        batch.setIqamaDuration(iqamaDuration);

        String visaDuration = ExcelUtils.getCellValue(rowNum, COLUMN_VISA_DURATION, sheet);
        batch.setVisaDuration(visaDuration);


        String amount = ExcelUtils.getCellValue(rowNum, COLUMN_MOI_AMOUNT, sheet);
        if(StringUtils.isNotBlank(amount)){
            BigDecimal amt = new BigDecimal(amount);
            batch.setAmount(amt.toBigInteger().toString());
        }

        String sponsorId = ExcelUtils.getCellValue(rowNum, COLUMN_SPONSOR_ID, sheet);
        batch.setSponsorId(sponsorId);
        batch.setHouseholdIdNumber(sponsorId);
        


        String jobCategory = ExcelUtils.getCellValueFromFormula(rowNum, COLUMN_JOB_CATEGORY, sheet, workbook);
        if(StringUtils.isNotBlank(jobCategory)){
            BigDecimal value = new BigDecimal(jobCategory);
            batch.setJobCategory(value.toBigInteger().toString());
        }
        return batch;
    }


}
