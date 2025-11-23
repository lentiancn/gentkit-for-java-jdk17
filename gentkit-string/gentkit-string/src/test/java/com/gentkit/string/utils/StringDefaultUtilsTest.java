package com.gentkit.string.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringDefaultUtilsTest {

    // -- String defaultIfFalse(String, String, boolean)

    @DisplayName("defaultIfFalse_shouldReturnDefault_whenArg0IsBlankArg2IsTrue")
    @Test
    public void defaultIfFalse_shouldReturnDefault_whenArg0IsBlankArg2IsTrue() {
        String value = StringDefaultUtils.defaultIfFalse("", "default123456", true);

        assertEquals("default123456", value);
    }

    @DisplayName("defaultIfFalse_shouldReturnDefault_whenArg0IsBlankArg2IsFalse")
    @Test
    public void defaultIfFalse_shouldReturnDefault_whenArg0IsBlankArg2IsFalse() {
        String value = StringDefaultUtils.defaultIfFalse("", "default123456", false);

        assertEquals("default123456", value);
    }

    @DisplayName("defaultIfFalse_shouldReturnTrue_whenArg0IsTrueArg2IsTrue")
    @Test
    public void defaultIfFalse_shouldReturnTrue_whenArg0IsTrueArg2IsTrue() {
        String value = StringDefaultUtils.defaultIfFalse("true", "default123456", true);

        assertEquals("true", value);
    }

    @DisplayName("defaultIfFalse_shouldReturnDefault_whenArg0IsNotBlankArg2IsFalse")
    @Test
    public void defaultIfFalse_shouldReturnDefault_whenArg0IsNotBlankArg2IsFalse() {
        String value = StringDefaultUtils.defaultIfFalse("123456", "default123456", false);

        assertEquals("default123456", value);
    }

    // -- String defaultIfFalse(String, String)

    @DisplayName("defaultIfFalse_shouldReturnDefault_whenArg0IsBlank")
    @Test
    public void defaultIfFalse_shouldReturnDefault_whenArg0IsBlank() {
        String value = StringDefaultUtils.defaultIfFalse("", "default123456");

        assertEquals("default123456", value);
    }

    @DisplayName("defaultIfFalse_shouldReturnDefault_whenArg0IsTrue")
    @Test
    public void defaultIfFalse_shouldReturnDefault_whenArg0IsTrue() {
        String value = StringDefaultUtils.defaultIfFalse("true", "default123456");

        assertEquals("true", value);
    }

    @DisplayName("defaultIfFalse_shouldReturnDefault_whenArg0IsNotBlank")
    @Test
    public void defaultIfFalse_shouldReturnDefault_whenArg0IsNotBlank() {
        String value = StringDefaultUtils.defaultIfFalse("123456", "default123456");

        assertEquals("default123456", value);
    }
}