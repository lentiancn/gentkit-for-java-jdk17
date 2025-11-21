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
package com.gentkit.color.model;

import com.gentkit.color.exception.RgbColorOutOfRangeException;
import lombok.Data;

import java.io.Serializable;

/**
 * RGB 颜色。<br>
 * RGB 顏色。<br>
 * RGB Color.<br>
 *
 * @author 田隆 (Len)
 * @since 2025-11-10 22:42
 */
@Data
public class RgbColor implements Serializable {

    /**
     * 红色。<br>
     * 紅色。<br>
     * red.<br>
     */
    private int red;
    /**
     * 绿色。<br>
     * 綠色。<br>
     * green.<br>
     */
    private int green;
    /**
     * 蓝色。<br>
     * 藍色。<br>
     * blue.<br>
     */
    private int blue;

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param red   红色<br>紅色<br>Red<br>
     * @param green 绿色<br>綠色<br>Green<br>
     * @param blue  蓝色<br>藍色<br>Blue<br>
     */
    public RgbColor(final int red, final int green, final int blue) {
        // Validate all color components are in valid range (0-255)
        if (red < 0 || red > 255) {
            throw new RgbColorOutOfRangeException("red must be between 0 and 255", red, green, blue);
        }
        if (green < 0 || green > 255) {
            throw new RgbColorOutOfRangeException("green must be between 0 and 255", red, green, blue);
        }
        if (blue < 0 || blue > 255) {
            throw new RgbColorOutOfRangeException("blue must be between 0 and 255", red, green, blue);
        }

        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * 获取 RGB 颜色字符串。<br>
     * 取得 RGB 顏色字串。<br>
     * Get RGB color String.<br>
     *
     * @return RGB 颜色字符串<br>RGB 顏色字串<br>RGB color string
     */
    @Override
    public String toString() {
        return "RGB(" + red + ", " + green + ", " + blue + ")";
    }
}