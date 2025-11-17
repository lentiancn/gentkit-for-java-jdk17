package com.gentkit.excel.utils;

import com.gentkit.excel.enums.FileTypeEnum;
import com.gentkit.excel.enums.SpreadsheetVersionEnum;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ExcelUtils {

    public static String suffixToMimeType(final String suffix) {
        if (suffix == null || suffix.trim().isEmpty()) {
            return null;
        }
        for (FileTypeEnum fileTypeEnum : FileTypeEnum.values()) {
            if (suffix.equals(fileTypeEnum.getSuffix())) {
                return fileTypeEnum.getMimeType();
            }
        }
        return null;
    }

    public static String mimeTypeToFileSuffix(final String mimeType) {
        if (mimeType == null || mimeType.trim().isEmpty()) {
            return null;
        }
        for (FileTypeEnum fileTypeEnum : FileTypeEnum.values()) {
            if (mimeType.equals(fileTypeEnum.getMimeType())) {
                return fileTypeEnum.getSuffix();
            }
        }
        return null;
    }

    public static SpreadsheetVersionEnum mimeTypeToSpreadsheetVersion(final String mimeType) {
        if (FileTypeEnum.XLSX.getMimeType().equals(mimeType)) {
            return SpreadsheetVersionEnum.EXCEL2007;
        }
        if (FileTypeEnum.XLS.getMimeType().equals(mimeType)) {
            return SpreadsheetVersionEnum.EXCEL97;
        }
        return null;
    }
}
