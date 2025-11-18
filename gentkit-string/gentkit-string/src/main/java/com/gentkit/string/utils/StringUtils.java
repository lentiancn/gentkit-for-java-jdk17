package com.gentkit.string.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class StringUtils {

    public static boolean isNotNull(final String s) {
        return (s != null);
    }

    public static boolean isNull(final String s) {
        return !isNotNull(s);
    }

    public static boolean isNotEmpty(String s) {
        return (s != null && !s.isEmpty());
    }

    public static boolean isEmpty(String s) {
        return !isNotEmpty(s);
    }

    public static boolean isNotBlank(String s) {
        if (s == null) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlank(String s) {
        return !isNotBlank(s);
    }
}
