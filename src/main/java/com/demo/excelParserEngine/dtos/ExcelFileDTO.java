package com.demo.excelParserEngine.dtos;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class ExcelFileDTO {

    private MultipartFile file;
    private String accountNo;
}
