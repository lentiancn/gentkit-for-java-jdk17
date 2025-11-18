package com.gentkit.base64.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class Base64UtilsTest {

    // -- decode

    @DisplayName("decode")
    @Test
    public void decode() {
        byte[] value = Base64Utils.decode("test".getBytes(StandardCharsets.UTF_8));

        System.out.println(value.length);
    }

    // -- decodeFromString

    @DisplayName("decodeFromString")
    @Test
    public void decodeFromString() {
        byte[] value = Base64Utils.decodeFromString("test");

        System.out.println(value.length);
    }

    // -- encode

    @DisplayName("encode")
    @Test
    public void encode() {
        byte[] value = Base64Utils.encode("test".getBytes(StandardCharsets.UTF_8));

        System.out.println(value.length);
    }

    // -- encodeToString

    @DisplayName("encodeToString")
    @Test
    public void encodeToString() {
        String value = Base64Utils.encodeToString("test".getBytes(StandardCharsets.UTF_8));

        System.out.println(value.length());
    }
}
