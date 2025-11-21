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
package com.gentkit.color.utils;

import com.gentkit.color.ColorConstants;
import lombok.NoArgsConstructor;

/**
 * 颜色工具。<br>
 * 顏色工具。<br>
 * Color utils.<br>
 *
 * @author 田隆 (Len)
 * @since 2025-11-20 22:32
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class HexColorUtils {

    public static String normalize(final String hexColor, final String defaultValue) {
        if (hexColor == null) {
            return defaultValue;
        }
        String hexColor01 = hexColor.trim();

        // Remove '#'
        hexColor01 = hexColor01.startsWith(ColorConstants.HEX_PREFIX) ? hexColor01.substring(1) : hexColor01;
        if (hexColor01.isEmpty()) {
            return "#000000";
        }

        // Length is 3 or 4 to 6 will be valid
        if (hexColor01.length() == 3 || hexColor01.length() == 4) {
            char rc = hexColor01.charAt(0);
            char gc = hexColor01.charAt(1);
            char bc = hexColor01.charAt(2);
            return (ColorConstants.HEX_PREFIX + rc + rc +
                    gc + gc +
                    bc + bc).toUpperCase();
        } else if (hexColor01.length() == 6) {
            return ColorConstants.HEX_PREFIX + hexColor01.toUpperCase();
        }

        return defaultValue;
    }
}
