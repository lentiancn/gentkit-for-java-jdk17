package com.gentkit.string.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringDefaultUtilsTest {

    // -- String defaultIfFalse(String, String, boolean)

    @DisplayName("defaultIfFalse_shouldReturnTrue_whenArg0IsBlankArg2IsTrue")
    @Test
    public void defaultIfFalse_shouldReturnTrue_whenArg0IsBlankArg2IsTrue() {
        String value = StringDefaultUtils.defaultIfFalse("", "default123456", true);

        assertEquals("default123456", value);
    }

    @DisplayName("defaultIfFalse_shouldReturnTrue_whenArg0IsBlankArg2IsFalse")
    @Test
    public void defaultIfFalse_shouldReturnTrue_whenArg0IsBlankArg2IsFalse() {
        String value = StringDefaultUtils.defaultIfFalse("", "default123456", false);

        assertEquals("default123456", value);
    }

    @DisplayName("defaultIfFalse_shouldReturnTrue_whenArg0IsTrueArg2IsTrue")
    @Test
    public void defaultIfFalse_shouldReturnTrue_whenArg0IsTrueArg2IsTrue() {
        String value = StringDefaultUtils.defaultIfFalse("123456", "default123456", true);

        assertEquals("default123456", value);
    }

    @DisplayName("defaultIfFalse_shouldReturnTrue_whenArg0IsNotBlankArg2IsFalse")
    @Test
    public void defaultIfFalse_shouldReturnTrue_whenArg0IsNotBlankArg2IsFalse() {
        String value = StringDefaultUtils.defaultIfFalse("true", "default123456", false);

        assertEquals("true", value);
    }
}