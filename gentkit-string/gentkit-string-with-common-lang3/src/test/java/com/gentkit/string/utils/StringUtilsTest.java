package com.gentkit.string.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    // -- isNotNull

    @DisplayName("isNotNull_shouldReturnTrue_whenStringIsNotNull")
    @Test
    public void isNotNull_shouldReturnTrue_whenStringIsNotNull() {
        boolean value = StringUtils.isNotNull("test");

        Assertions.assertTrue(value);
    }

    @DisplayName("isNotNull_shouldReturnTrue_whenStringIsBlank")
    @Test
    public void isNotNull_shouldReturnTrue_whenStringIsBlank() {
        boolean value = StringUtils.isNotNull("    ");

        Assertions.assertTrue(value);
    }

    @DisplayName("isNotNull_shouldReturnFalse_whenStringIsNull")
    @Test
    public void isNotNull_shouldReturnFalse_whenStringIsNull() {
        boolean value = StringUtils.isNotNull(null);

        Assertions.assertFalse(value);
    }

    // -- isNull

    @DisplayName("isNull_shouldReturnTrue_whenStringIsNull")
    @Test
    public void isNull_shouldReturnTrue_whenStringIsNull() {
        boolean value = StringUtils.isNull(null);

        Assertions.assertTrue(value);
    }

    @DisplayName("isNull_shouldReturnFalse_whenStringIsNotNull")
    @Test
    public void isNull_shouldReturnFalse_whenStringIsNotNull() {
        boolean value = StringUtils.isNull("test");

        Assertions.assertFalse(value);
    }

    @DisplayName("isNull_shouldReturnFalse_whenStringIsBlank")
    @Test
    public void isNull_shouldReturnFalse_whenStringIsBlank() {
        boolean value = StringUtils.isNull("    ");

        Assertions.assertFalse(value);
    }

    // -- isNotEmpty

    @DisplayName("isNotEmpty_shouldReturnTrue_whenStringIsNotEmpty")
    @Test
    public void isNotEmpty_shouldReturnTrue_whenStringIsNotEmpty() {
        boolean value = StringUtils.isNotEmpty("test");

        Assertions.assertTrue(value);
    }

    @DisplayName("isNotEmpty_shouldReturnTrue_whenStringIsBlank")
    @Test
    public void isNotEmpty_shouldReturnTrue_whenStringIsBlank() {
        boolean value = StringUtils.isNotEmpty("    ");

        Assertions.assertTrue(value);
    }

    @DisplayName("isNotEmpty_shouldReturnFalse_whenStringIsNull")
    @Test
    public void isNotEmpty_shouldReturnFalse_whenStringIsNull() {
        boolean value = StringUtils.isNotEmpty(null);

        Assertions.assertFalse(value);
    }

    @DisplayName("isNotEmpty_shouldReturnFalse_whenStringIsEmpty")
    @Test
    public void isNotEmpty_shouldReturnFalse_whenStringIsEmpty() {
        boolean value = StringUtils.isNotEmpty("");

        Assertions.assertFalse(value);
    }

    // -- isEmpty

    @DisplayName("isEmpty_shouldReturnTrue_whenStringIsNull")
    @Test
    public void isEmpty_shouldReturnTrue_whenStringIsNull() {
        boolean value = StringUtils.isEmpty(null);

        Assertions.assertTrue(value);
    }

    @DisplayName("isEmpty_shouldReturnTrue_whenStringIsEmpty")
    @Test
    public void isEmpty_shouldReturnTrue_whenStringIsEmpty() {
        boolean value = StringUtils.isEmpty("");

        Assertions.assertTrue(value);
    }

    @DisplayName("isEmpty_shouldReturnFalse_whenStringIsBlank")
    @Test
    public void isEmpty_shouldReturnFalse_whenStringIsBlank() {
        boolean value = StringUtils.isEmpty("    ");

        Assertions.assertFalse(value);
    }

    @DisplayName("isEmpty_shouldReturnFalse_whenStringIsNotEmpty")
    @Test
    public void isEmpty_shouldReturnFalse_whenStringIsNotEmpty() {
        boolean value = StringUtils.isEmpty("test");

        Assertions.assertFalse(value);
    }

    // -- isNotBlank

    @DisplayName("isNotBlank_shouldReturnTrue_whenStringIsNotBlank")
    @Test
    public void isNotBlank_shouldReturnTrue_whenStringIsNotBlank() {
        boolean value = StringUtils.isNotBlank("test");

        Assertions.assertTrue(value);
    }

    @DisplayName("isNotBlank_shouldReturnFalse_whenStringIsNull")
    @Test
    public void isNotBlank_shouldReturnFalse_whenStringIsNull() {
        boolean value = StringUtils.isNotBlank(null);

        Assertions.assertFalse(value);
    }

    @DisplayName("isNotBlank_shouldReturnFalse_whenStringIsBlank")
    @Test
    public void isNotBlank_shouldReturnFalse_whenStringIsBlank() {
        boolean value = StringUtils.isNotBlank("    ");

        Assertions.assertFalse(value);
    }

    // -- isBlank

    @DisplayName("isBlank_shouldReturnTrue_whenStringIsBlank")
    @Test
    public void isBlank_shouldReturnTrue_whenStringIsBlank() {
        boolean value = StringUtils.isBlank("    ");

        Assertions.assertTrue(value);
    }

    @DisplayName("isBlank_shouldReturnTrue_whenStringIsNull")
    @Test
    public void isBlank_shouldReturnTrue_whenStringIsNull() {
        boolean value = StringUtils.isBlank(null);

        Assertions.assertTrue(value);
    }

    @DisplayName("isBlank_shouldReturnFalse_whenStringIsNotBlank")
    @Test
    public void isBlank_shouldReturnFalse_whenStringIsNotBlank() {
        boolean value = StringUtils.isBlank("test");

        Assertions.assertFalse(value);
    }

    // -- defaultIfBlank

    @DisplayName("defaultIfBlank_shouldReturnDefaultValue_whenStringIsBlank")
    @Test
    public void defaultIfBlank_shouldReturnDefaultValue_whenStringIsBlank() {
        String value = StringUtils.defaultIfBlank("    ", "default");

        Assertions.assertEquals("default", value);
    }

    @DisplayName("defaultIfBlank_shouldReturnValue_whenStringIsNotBlank")
    @Test
    public void defaultIfBlank_shouldReturnValue_whenStringIsNotBlank() {
        String value = StringUtils.defaultIfBlank("666", "default");
        Assertions.assertEquals("666", value);
    }
}
