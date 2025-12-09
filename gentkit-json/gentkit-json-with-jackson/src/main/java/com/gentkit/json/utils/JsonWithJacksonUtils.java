/*
 * MIT License
 *
 * Copyright (c) 2025 田隆 (Len)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.gentkit.json.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentkit.datetime.utils.DateTimeUtils;
import com.gentkit.logger.utils.LoggerUtils;
import com.gentkit.string.utils.StringUtils;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.gentkit.json.JsonWithJacksonConstants.OBJECT_MAPPER;

/**
 * @author Len (lentiancn@126.com)
 * @since 2025-12-09 10:45
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class JsonWithJacksonUtils {

    public static <T> T parse(final ObjectMapper objectMapper, final String json, final Class<T> classOfT, final T defaultValue) {
        if (StringUtils.isBlank(json)) {
            return defaultValue;
        }
        try {
            return objectMapper.readValue(json, classOfT);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static <T> T parse(final String json, final Class<T> classOfT, final T defaultValue) {
        return parse(OBJECT_MAPPER, json, classOfT, defaultValue);
    }

    public static short getShort(final JsonNode json, final String fieldName, final short defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isNumber()) {
                return node.shortValue();
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static int getInt(final JsonNode json, final String fieldName, final int defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isNumber()) {
                return node.intValue();
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static long getLong(final JsonNode json, final String fieldName, final long defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isNumber()) {
                return node.longValue();
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static float getFloat(final JsonNode json, final String fieldName, final float defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isNumber()) {
                return node.floatValue();
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static double getDouble(final JsonNode json, final String fieldName, final double defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isNumber()) {
                return node.doubleValue();
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static String getString(final JsonNode json, final String fieldName, final String defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isTextual()) {
                return node.textValue();
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static boolean getBoolean(final JsonNode json, final String fieldName, final boolean defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isBoolean()) {
                return node.booleanValue();
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static Date getDate(final JsonNode json, final String fieldName, final String format, final Date defaultValue) {
        String dateString = getString(json, fieldName, null);
        if (dateString != null) {
            Date d = DateTimeUtils.parse(format, dateString);
            if (d != null) {
                return d;
            }
        }
        return defaultValue;
    }

    public static JsonNode getJsonObject(final JsonNode json, final String fieldName, final JsonNode defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isObject()) {
                return node;
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static JsonNode getJsonArray(final JsonNode json, final String fieldName, final JsonNode defaultValue) {
        try {
            JsonNode node = json.get(fieldName);
            if (node != null && node.isArray()) {
                return node;
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static short getShort(final JsonNode json, final int index, final short defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isNumber()) {
                    return node.shortValue();
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static int getInt(final JsonNode json, final int index, final int defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isNumber()) {
                    return node.intValue();
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static long getLong(final JsonNode json, final int index, final long defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isNumber()) {
                    return node.longValue();
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static float getFloat(final JsonNode json, final int index, final float defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isNumber()) {
                    return node.floatValue();
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static double getDouble(final JsonNode json, final int index, final double defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isNumber()) {
                    return node.doubleValue();
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static String getString(final JsonNode json, final int index, final String defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isTextual()) {
                    return node.textValue();
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static boolean getBoolean(final JsonNode json, final int index, final boolean defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isBoolean()) {
                    return node.booleanValue();
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static Date getDate(final JsonNode json, final int index, final String format, final Date defaultValue) {
        String dateString = getString(json, index, null);
        if (dateString != null) {
            Date d = DateTimeUtils.parse(format, dateString);
            if (d != null) {
                return d;
            }
        }
        return defaultValue;
    }

    public static JsonNode getJsonObject(final JsonNode json, final int index, final JsonNode defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isObject()) {
                    return node;
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static JsonNode getJsonArray(final JsonNode json, final int index, final JsonNode defaultValue) {
        try {
            if (json.isArray() && json.size() > index) {
                JsonNode node = json.get(index);
                if (node != null && node.isArray()) {
                    return node;
                }
            }
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithJacksonUtils.class).warn(ex);
        }
        return defaultValue;
    }
}
