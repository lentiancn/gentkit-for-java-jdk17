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
import com.gentkit.color.exception.ColorHexNormalizationException;
import com.gentkit.color.exception.ColorRgbOutOfRangeException;
import com.gentkit.color.model.ColorHex;
import com.gentkit.color.model.ColorRgb;
import lombok.NoArgsConstructor;

/**
 * 颜色工具。<br>
 * 顏色工具。<br>
 * Color utils.<br>
 *
 * @author 田隆 (Len)
 * @since 2025-11-10 22:36
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ColorConversionUtils {

    /**
     * 将16进制颜色转换为RGB颜色。<br>
     * 將16進位顏色轉換為RGB顏色。<br>
     * Convert hexadecimal colors to RGB colors.<br>
     *
     * @throws ColorHexNormalizationException
     * @see #hexToRgb(String)
     */
    public static ColorRgb hexToRgb(final ColorHex hex) {
        if (hex != null) {
            return new ColorRgb(Integer.parseInt(hex.getHexRed(), 16), Integer.parseInt(hex.getHexGreen(), 16), Integer.parseInt(hex.getHexBlue(), 16));
        }
        return null;
    }

    /**
     * 将16进制颜色转换为RGB颜色。<br>
     * 將16進位顏色轉換為RGB顏色。<br>
     * Convert hexadecimal colors to RGB colors.<br>
     *
     * @throws ColorHexNormalizationException
     * @see #hexToRgb(ColorHex)
     */
    public static ColorRgb hexToRgb(final String hex) {
        return hexToRgb(new ColorHex(hex));
    }

    /**
     * 将RGB颜色转换为16进制颜色。<br>
     * 将RGB顏色轉換為16進位顏色。<br>
     * Convert RGB colors to hexadecimal colors.<br>
     *
     * @throws ColorRgbOutOfRangeException
     */
    public static String rgbToHex(final int red, final int green, final int blue) {
        ColorRgb rgbColor = new ColorRgb(red, green, blue);

        return (ColorConstants.HEX_PREFIX + String.format("%02x%02x%02x", rgbColor.getRed(), rgbColor.getGreen(), rgbColor.getBlue()).toUpperCase());
    }

    /**
     * 将RGB颜色转换为16进制颜色。<br>
     * 将RGB顏色轉換為16進位顏色。<br>
     * Convert RGB colors to hexadecimal colors.<br>
     */
    public static String rgbToHex(final ColorRgb rgb) {
        return rgbToHex(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    }

//    public static AnsiColor hexToAnsiColor(final String hex) {
//        RgbaColor rgb = hexToRgb(hex);
//        return String.format("%d;%d;%d", rgb.getRed(), rgb.getGreen(), rgb.getBlue());
//    }

    public static String ansiColorAsBold(final String ansiColor) {
        return ColorConstants.ANSI_BOLD + ansiColor;
    }

    public static String ansiColorAsBold(final int ansiColor) {
        return ColorConstants.ANSI_BOLD + ansiColor;
    }

    /**
     * 将16进制颜色转换为ANSI前景色序列。<br>
     * 將16進位顏色轉換為ANSI前景色序列。<br>
     * Convert hexadecimal colors to ANSI foreground color sequences.<br>
     */
    public static String hexToAnsiForeground(final boolean bold, final String hex) {
        ColorRgb rgb = hexToRgb(hex);
        String ansiBold = bold ? ColorConstants.ANSI_BOLD : "";
        return String.format("%s%s38;2;%d;%d;%d%s", ColorConstants.ANSI_START, ansiBold, rgb.getRed(), rgb.getGreen(), rgb.getBlue(), ColorConstants.ANSI_END);
    }

    /**
     * 将16进制颜色转换为ANSI前景色序列。<br>
     * 將16進位顏色轉換為ANSI前景色序列。<br>
     * Convert hexadecimal colors to ANSI foreground color sequences.<br>
     */
    public static String hexToAnsiForeground(final String hex) {
        return hexToAnsiForeground(false, hex);
    }

    /**
     * 将16进制颜色转换为ANSI背景色序列。<br>
     * 將16進位顏色轉換為ANSI背景色序列。<br>
     * Convert hexadecimal colors to ANSI background color sequences.<br>
     */
    public static String hexToAnsiBackground(final String hex) {
        ColorRgb rgb = hexToRgb(hex);
        return String.format("%s48;2;%d;%d;%d%s", ColorConstants.ANSI_START, rgb.getRed(), rgb.getGreen(), rgb.getBlue(), ColorConstants.ANSI_END);
    }

    public static void main(String[] args) {
        System.out.println(rgbToHex(256, 255, 255));
    }
}
