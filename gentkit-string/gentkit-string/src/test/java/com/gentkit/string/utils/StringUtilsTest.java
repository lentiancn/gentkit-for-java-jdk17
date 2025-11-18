package com.gentkit.string.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    // -- isNotNull

    @DisplayName("isNotNull_shouldReturnFalse_whenStringIsNull")
    @Test
    public void isNotNull_shouldReturnFalse_whenStringIsNull() {
        boolean value = StringUtils.isNotNull(null);

        Assertions.assertFalse(value);
    }

    @DisplayName("isNotNull_shouldReturnTrue_whenStringIsBlank")
    @Test
    public void isNotNull_shouldReturnTrue_whenStringIsBlank() {
        boolean value = StringUtils.isNotNull("    ");

        Assertions.assertTrue(value);
    }

    @DisplayName("isNotNull_shouldReturnTrue_whenStringIsNotNull")
    @Test
    public void isNotNull_shouldReturnTrue_whenStringIsNotNull() {
        boolean value = StringUtils.isNotNull("test");

        Assertions.assertTrue(value);
    }

    // -- isNull

    @DisplayName("isNull_shouldReturnTrue_whenStringIsNull")
    @Test
    public void isNull_shouldReturnTrue_whenStringIsNull() {
        boolean value = StringUtils.isNull(null);

        Assertions.assertTrue(value);
    }

    @DisplayName("isNull_shouldReturnFalse_whenStringIsBlank")
    @Test
    public void isNull_shouldReturnFalse_whenStringIsBlank() {
        boolean value = StringUtils.isNull("    ");

        Assertions.assertFalse(value);
    }

    @DisplayName("isNull_shouldReturnFalse_whenStringIsNotNull")
    @Test
    public void isNull_shouldReturnFalse_whenStringIsNotNull() {
        boolean value = StringUtils.isNull("test");

        Assertions.assertFalse(value);
    }
}
