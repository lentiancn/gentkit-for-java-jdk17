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

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.gentkit.datetime.utils.DateTimeUtils;
import com.gentkit.logger.utils.LoggerUtils;
import com.gentkit.string.utils.StringUtils;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 田隆 (Len)
 * @since 2025-11-18 08:35
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class JsonWithFastJson2Utils {

    public static <T> T toBean(final String json, final Class<T> classOfT) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return JSON.parseObject(json, classOfT);
        } catch (Throwable ex) {
            return null;
        }
    }

    public static short getShort(final JSONObject json, final String memberName, final short defaultValue) {
        try {
            Object value = json.get(memberName);
            if (value instanceof Number n) {
                return n.shortValue();
            } else if (value instanceof String s) {
                return Short.parseShort(s);
            }
            return json.getShortValue(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static int getInt(final JSONObject json, final String memberName, final int defaultValue) {
        try {
            Object value = json.get(memberName);
            if (value instanceof Number n) {
                return n.intValue();
            } else if (value instanceof String s) {
                return Integer.parseInt(s);
            }
            return json.getIntValue(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static long getLong(final JSONObject json, final String memberName, final long defaultValue) {
        try {
            Object value = json.get(memberName);
            if (value instanceof Number n) {
                return n.longValue();
            } else if (value instanceof String s) {
                return Long.parseLong(s);
            }
            return json.getLongValue(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static float getFloat(final JSONObject json, final String memberName, final float defaultValue) {
        try {
            Object value = json.get(memberName);
            if (value instanceof Number n) {
                return n.floatValue();
            } else if (value instanceof String s) {
                return Float.parseFloat(s);
            }
            return json.getFloatValue(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static double getDouble(final JSONObject json, final String memberName, final double defaultValue) {
        try {
            Object value = json.get(memberName);
            if (value instanceof Number n) {
                return n.doubleValue();
            } else if (value instanceof String s) {
                return Double.parseDouble(s);
            }
            return json.getDoubleValue(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static String getString(final JSONObject json, final String memberName, final String defaultValue) {
        try {
            Object value = json.get(memberName);
            if (value != null) {
                return value.toString();
            }
            return json.getString(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static boolean getBoolean(final JSONObject json, final String memberName, final boolean defaultValue) {
        try {
            Object value = json.get(memberName);
            if (value instanceof Boolean b) {
                return b;
            } else if (value instanceof String s) {
                return Boolean.parseBoolean(s);
            } else if (value instanceof Number n) {
                return n.intValue() != 0;
            }
            return json.getBooleanValue(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static Date getDate(final JSONObject json, final String memberName, final String format, final Date defaultValue) {
        String dateString = getString(json, memberName, null);
        if (dateString != null) {
            Date d = DateTimeUtils.parse(format, dateString);
            if (d != null) {
                return d;
            }
        }
        return defaultValue;
    }

    public static JSONObject getJsonObject(final JSONObject json, final String memberName, final JSONObject defaultValue) {
        try {
            Object obj = json.get(memberName);
            if (obj instanceof JSONObject j) {
                return j;
            }
            return json.getJSONObject(memberName);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static JSONArray getJsonArray(final JSONObject json, final String memberName, final JSONArray defaultValue) {
        try {
            Object obj = json.get(memberName);
            if (obj instanceof JSONArray j) {
                return j;
            }
            JSONArray ja = json.getJSONArray(memberName);
            return ja != null ? ja : defaultValue;
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static short getShort(final JSONArray json, final int index, final short defaultValue) {
        try {
            Object value = json.get(index);
            if (value instanceof Number n) {
                return n.shortValue();
            } else if (value instanceof String s) {
                return Short.parseShort(s);
            }
            return json.getShortValue(index);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static int getInt(final JSONArray json, final int index, final int defaultValue) {
        try {
            Object value = json.get(index);
            if (value instanceof Number n) {
                return n.intValue();
            } else if (value instanceof String s) {
                return Integer.parseInt(s);
            }
            return json.getIntValue(index);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static long getLong(final JSONArray json, final int index, final long defaultValue) {
        try {
            Object value = json.get(index);
            if (value instanceof Number n) {
                return n.longValue();
            } else if (value instanceof String s) {
                return Long.parseLong(s);
            }
            return json.getLongValue(index);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static float getFloat(final JSONArray json, final int index, final float defaultValue) {
        try {
            Object value = json.get(index);
            if (value instanceof Number n) {
                return n.floatValue();
            } else if (value instanceof String s) {
                return Float.parseFloat(s);
            }
            return json.getFloatValue(index);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static double getDouble(final JSONArray json, final int index, final double defaultValue) {
        try {
            Object value = json.get(index);
            if (value instanceof Number n) {
                return n.doubleValue();
            } else if (value instanceof String s) {
                return Double.parseDouble(s);
            }
            return json.getDoubleValue(index);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static String getString(final JSONArray json, final int index, final String defaultValue) {
        try {
            Object value = json.get(index);
            if (value != null) {
                return value.toString();
            }
            return json.getString(index);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static boolean getBoolean(final JSONArray json, final int index, final boolean defaultValue) {
        try {
            Object value = json.get(index);
            if (value instanceof Boolean b) {
                return b;
            } else if (value instanceof String s) {
                return Boolean.parseBoolean(s);
            } else if (value instanceof Number n) {
                return n.intValue() != 0;
            }
            return json.getBooleanValue(index);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static Date getDate(final JSONArray json, final int index, final String format, final Date defaultValue) {
        String dateString = getString(json, index, null);
        if (dateString != null) {
            Date d = DateTimeUtils.parse(format, dateString);
            if (d != null) {
                return d;
            }
        }
        return defaultValue;
    }

    public static JSONObject getJsonObject(final JSONArray json, final int index, final JSONObject defaultValue) {
        try {
            Object obj = json.get(index);
            if (obj instanceof JSONObject j) {
                return j;
            }
            return json.getJSONObject(index);
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }

    public static JSONArray getJsonArray(final JSONArray json, final int index, final JSONArray defaultValue) {
        try {
            Object obj = json.get(index);
            if (obj instanceof JSONArray j) {
                return j;
            }
            JSONArray ja = json.getJSONArray(index);
            return ja != null ? ja : defaultValue;
        } catch (Throwable ex) {
            LoggerUtils.getLogger(JsonWithFastJson2Utils.class).warn(ex);
        }
        return defaultValue;
    }
}