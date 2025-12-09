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
package com.gentkit.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author Len (lentiancn@126.com)
 * @since 2025-11-18 08:35
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class JsonWithJacksonConstants {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            // ===================== 1. 必选核心模块 =====================
            .registerModule(new JavaTimeModule())

            // ===================== 2. 核心序列化配置 =====================
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)

            // ===================== 3. 核心反序列化配置 =====================
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)

            // ===================== 4. 全局基础配置 =====================
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")) // 传统 Date 类型格式化
            .setTimeZone(TimeZone.getTimeZone("GMT+8"))                 // 统一时区（避免东八区偏移）
            .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)  // 排除 null 字段（减少流量）

            // ===================== 5. 注解/字段访问配置 =====================
            .enable(MapperFeature.USE_ANNOTATIONS) // 启用 @JsonProperty/@JsonIgnore 等注解
            .enable(MapperFeature.AUTO_DETECT_FIELDS) // 允许直接访问字段（无 getter/setter 也能序列化）
            .disable(MapperFeature.AUTO_DETECT_GETTERS) // 仅按需开启，减少反射开销
            .disable(MapperFeature.AUTO_DETECT_SETTERS);
}
