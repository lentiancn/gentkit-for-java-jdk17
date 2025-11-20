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
import com.gentkit.hex.utils.HexUtils;
import lombok.NoArgsConstructor;

import java.util.Arrays;

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

    public static String normalize(final String hexColor) {
        String hex01 = hexColor.startsWith(ColorConstants.HEX_PREFIX) ? hexColor.substring(1) : hexColor;

        char[] cs = hex01.toCharArray();
        int length = cs.length;

        if (length == 1) {
            return ColorConstants.HEX_PREFIX + "0000" + channel(cs);
        }

        int channelSize = (int) Math.ceil(length / 3F);

        return ColorConstants.HEX_PREFIX + channel(Arrays.copyOfRange(cs, 0, channelSize)) +
                channel(Arrays.copyOfRange(cs, channelSize, channelSize * 2)) +
                channel(Arrays.copyOfRange(cs, channelSize * 2, channelSize * 3));
    }

    private static char[] fill(final char[] cs) {
        for (int i = 0; i < cs.length; i++) {
            if (!HexUtils.isHexChar(cs[i])) {
                cs[i] = '0';
            }
        }
        return cs;
    }

    private static String channel(final char[] cs) {
        if (cs.length == 0) {
            return "00";
        }
        if (cs.length == 1) {
            return ('0' + new String(fill(cs)));
        }
        return new String(fill(cs), 0, 2);
    }
}
