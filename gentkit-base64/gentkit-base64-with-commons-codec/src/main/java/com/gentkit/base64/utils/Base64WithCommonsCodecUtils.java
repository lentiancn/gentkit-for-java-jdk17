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
package com.gentkit.base64.utils;

import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;

/**
 * 基于 commons codec 的 Base64 工具。<br>
 * 基於 commons codec 的 Base64 工具。<br>
 * Base64 based on commons codec utility.<br>
 *
 * @author Len<lentiancn@126.com>
 * @since 2025-11-18 22:29
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Base64WithCommonsCodecUtils {

    /**
     * 解码 Base64 字节数组。<br>
     * 解碼 Base64 位元組陣列。<br>
     * Decode Base64 bytes.<br>
     *
     * @param base64 Base64 字节数组<br>Base64 位元組陣列<br>Base64 bytes<br>
     * @return 解码后的字节数组<br>解碼後的位元組陣列<br>Decoded bytes<br>
     */
    public static byte[] decode(final byte[] base64) {
        return Base64.decodeBase64(base64);
    }

    /**
     * 解码 Base64 字符串。<br>
     * 解碼 Base64 字串。<br>
     * Decode Base64 string.<br>
     *
     * @param base64 Base64 字符串<br>Base64 字串<br>Base64 string<br>
     * @return 解码后的字节数组<br>解碼後的位元組陣列<br>Decoded bytes<br>
     */
    public static byte[] decodeFromString(final String base64) {
        return Base64.decodeBase64(base64);
    }

    /**
     * 编码字节数组。<br>
     * 編碼位元組陣列。<br>
     * Encode raw bytes.<br>
     *
     * @param rawData 原始字节数组<br>原始位元組陣列<br>raw bytes<br>
     * @return 编码后的字节数组<br>編碼後的位元組陣列<br>Encoded bytes<br>
     */
    public static byte[] encode(final byte[] rawData) {
        return Base64.encodeBase64(rawData);
    }

    /**
     * 编码字节数组。<br>
     * 編碼位元組陣列。<br>
     * Encode raw bytes.<br>
     *
     * @param rawData 原始字节数组<br>原始位元組陣列<br>raw bytes<br>
     * @return 编码后的 Base64 字符串<br>編碼後的 Base64 字串<br>Encoded Base64 string<br>
     */
    public static String encodeToString(final byte[] rawData) {
        return Base64.encodeBase64String(rawData);
    }
}
