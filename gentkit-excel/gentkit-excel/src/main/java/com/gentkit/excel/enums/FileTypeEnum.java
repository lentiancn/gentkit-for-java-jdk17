package com.gentkit.excel.enums;

import lombok.Getter;

@Getter
public enum FileTypeEnum {
    XLSX("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    XLS("xls", "application/vnd.ms-excel"),
    CSV("csv", "text/csv"),
    XLT("xlt", "application/vnd.ms-excel"),
    XLW("xlw", "application/vnd.ms-excel"),
    XLSM("xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12"),
    XLSB("xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12"),

    ;

    private final String fileSuffix;

    private final String mimeType;

    FileTypeEnum(String fileSuffix, String mimeType) {
        this.fileSuffix = fileSuffix;
        this.mimeType = mimeType;
    }
}
