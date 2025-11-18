package com.gentkit.base64.utils;

import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Base64Utils {

    public static byte[] decode(final byte[] base64) {
        return Base64.decodeBase64(base64);
    }

    public static byte[] decodeFromString(final String base64) {
        return Base64.decodeBase64(base64);
    }

    public static byte[] encode(final byte[] rawData) {
        return Base64.encodeBase64(rawData);
    }

    public static String encodeToString(final byte[] rawData) {
        return Base64.encodeBase64String(rawData);
    }
}
