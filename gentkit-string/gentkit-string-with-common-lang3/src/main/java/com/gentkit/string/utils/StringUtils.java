package com.gentkit.string.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static boolean isNotNull(String s) {
        return (s != null);
    }

    public static boolean isNull(String s) {
        return !isNotNull(s);
    }
}
