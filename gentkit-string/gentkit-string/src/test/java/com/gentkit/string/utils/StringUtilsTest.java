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
}
