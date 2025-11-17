package com.gentkit.excel.utils;

import lombok.NoArgsConstructor;
import org.apache.poi.ss.SpreadsheetVersion;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ExcelUtils {

    public static SpreadsheetVersion excelVersionByMimeType(final String mimeType) {
        // .xlsx
        if ("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(mimeType)) {
            return SpreadsheetVersion.EXCEL2007;
        }
        // .xls
        if ("application/vnd.ms-excel".equals(mimeType)) {
            return SpreadsheetVersion.EXCEL97;
        }
        return null;
    }
}
