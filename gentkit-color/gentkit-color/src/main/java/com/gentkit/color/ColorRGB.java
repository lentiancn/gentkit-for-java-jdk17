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
package com.gentkit.color;

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
public class ColorRGB implements Serializable {

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
}
