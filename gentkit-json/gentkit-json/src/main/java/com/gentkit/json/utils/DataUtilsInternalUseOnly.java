package com.gentkit.json.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
final class DataUtilsInternalUseOnly {

    static boolean isBlankString(String s) {
        return (s == null) || s.trim().isEmpty();
    }
}
