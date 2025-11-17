package com.gentkit.excel.enums;

import lombok.Getter;

@Getter
public enum FileTypeEnum {
    XLSX("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    XLS("xls", "application/vnd.ms-excel"),
    XLSM("xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12"),
    XLSB("xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12"),
    CSV("csv", "text/csv"),

    ;

    private final String suffix;

    private final String mimeType;

    FileTypeEnum(String suffix, String mimeType) {
        this.suffix = suffix;
        this.mimeType = mimeType;
    }
}
