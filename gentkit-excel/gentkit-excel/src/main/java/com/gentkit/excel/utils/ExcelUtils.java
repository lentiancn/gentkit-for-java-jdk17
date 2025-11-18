package com.gentkit.excel.utils;

import com.gentkit.excel.enums.FileTypeEnum;
import com.gentkit.excel.enums.SpreadsheetVersionEnum;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ExcelUtils {

    public static String[] fileSuffixToMimeType(final String fileSuffix) {
        if (fileSuffix == null || fileSuffix.trim().isEmpty()) {
            return new String[0];
        }
        List<String> mimeTypes = new ArrayList<>();
        for (FileTypeEnum fileTypeEnum : FileTypeEnum.values()) {
            if (fileSuffix.equals(fileTypeEnum.getFileSuffix())) {
                mimeTypes.add(fileTypeEnum.getMimeType());
            }
        }
        return mimeTypes.toArray(new String[0]);
    }

    public static String[] mimeTypeToFileSuffix(final String mimeType) {
        if (mimeType == null || mimeType.trim().isEmpty()) {
            return new String[0];
        }
        List<String> fileSuffixes = new ArrayList<>();
        for (FileTypeEnum fileTypeEnum : FileTypeEnum.values()) {
            if (mimeType.equals(fileTypeEnum.getMimeType())) {
                fileSuffixes.add(fileTypeEnum.getFileSuffix());
            }
        }
        return fileSuffixes.toArray(new String[0]);
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
