package com.gentkit.datetime.utils;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class DateTimeUtilsTest {

    @Test
    public void testFormatWithDate() {
        Date date = new Date(1251763200000L); // 2009-09-01 00:00:00 UTC
        String result = DateTimeUtils.format("yyyy-MM-dd", date);
        assertEquals("2009-09-01", result);
    }

    @Test
    public void testFormatWithNullDate() {
        String result = DateTimeUtils.format("yyyy-MM-dd", (Date) null);
        assertNull(result);
    }

    @Test
    public void testFormatWithNullPattern() {
        Date date = new Date();
        String result = DateTimeUtils.format(null, date);
        assertNull(result);
    }

    @Test
    public void testFormatWithTimestamp() {
        long timestamp = 1251763200000L; // 2009-09-01 00:00:00 UTC
        String result = DateTimeUtils.format("yyyy-MM-dd", timestamp);
        assertEquals("2009-09-01", result);
    }

    @Test
    public void testParse() {
        String dateString = "2009-09-01";
        Date result = DateTimeUtils.parse("yyyy-MM-dd", dateString);
        assertNotNull(result);
        assertEquals(dateString, DateTimeUtils.format("yyyy-MM-dd", result));
    }

    @Test
    public void testParseWithNullSource() {
        Date result = DateTimeUtils.parse("yyyy-MM-dd", null);
        assertNull(result);
    }

    @Test
    public void testParseWithNullPattern() {
        Date result = DateTimeUtils.parse(null, "2009-09-01");
        assertNull(result);
    }

    @Test
    public void testParseWithInvalidDate() {
        Date result = DateTimeUtils.parse("yyyy-MM-dd", "invalid-date");
        assertNull(result);
    }

    @Test
    public void testParseWithInvalidPattern() {
        Date result = DateTimeUtils.parse("invalid-pattern", "2009-09-01");
        assertNull(result);
    }
}