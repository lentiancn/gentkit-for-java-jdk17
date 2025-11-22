/*
 * Copyright (c) 2025-2025 田隆 (Len)
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

import com.gentkit.logger.utils.LoggerUtils;
import com.gentkit.string.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.gentkit.json.JsonConstants.GSON;

/**
 * @author 田隆 (Len)
 * @since 2025-11-18 08:35
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class JsonUtils {

    public static <T> T toBean(final Gson gson, final String json, final Class<T> classOfT) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return gson.fromJson(json, classOfT);
        } catch (Throwable ex) {
            return null;
        }
    }

    public static <T> T toBean(final String json, final Class<T> classOfT) {
        return toBean(GSON, json, classOfT);
    }

    public static short getShort(final String memberName, final JsonObject json, final short defaultValue) {
        try {
            return json.getAsJsonPrimitive(memberName).getAsShort();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static int getInt(final String memberName, final JsonObject json, final int defaultValue) {
        try {
            return json.getAsJsonPrimitive(memberName).getAsInt();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static long getLong(final String memberName, final JsonObject json, final long defaultValue) {
        try {
            return json.getAsJsonPrimitive(memberName).getAsLong();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static float getFloat(final String memberName, final JsonObject json, final float defaultValue) {
        try {
            return json.getAsJsonPrimitive(memberName).getAsFloat();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static double getDouble(final String memberName, final JsonObject json, final double defaultValue) {
        try {
            return json.getAsJsonPrimitive(memberName).getAsDouble();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static String getString(final String memberName, final JsonObject json, final String defaultValue) {
        try {
            return json.getAsJsonPrimitive(memberName).getAsString();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static boolean getBoolean(final String memberName, final JsonObject json, final boolean defaultValue) {
        try {
            return json.getAsJsonPrimitive(memberName).getAsBoolean();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static Date getDate(String memberName, JsonObject json, String format, Date defaultValue) {
//        Date d = DateFormatUtility.parse(format, getString(memberName, json, null));
//        if (d != null) {
//            return d;
//        }
//
        return defaultValue;
    }

    public static JsonObject getJsonObject(String memberName, JsonObject json, JsonObject defaultValue) {
        try {
            return json.getAsJsonObject(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static JsonArray getJsonArray(final String memberName, final JsonObject json, final JsonArray defaultValue) {
        try {
            JsonArray ja = json.getAsJsonArray(memberName);
            return ja != null ? ja : defaultValue;
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }


    public static String getString(final int index, final JsonArray json, final String defaultValue) {
        try {
            return json.get(index).getAsString();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }

    public static JsonObject getJsonObject(int index, JsonArray json, JsonObject defaultValue) {
        try {
            return json.get(index).getAsJsonObject();
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonUtils.class).warn(ex);
        }
        return defaultValue;
    }
}
