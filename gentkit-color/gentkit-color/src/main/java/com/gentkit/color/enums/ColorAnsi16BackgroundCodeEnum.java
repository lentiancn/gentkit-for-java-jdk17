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
package com.gentkit.color.enums;

import lombok.Getter;

@Getter
public enum ColorAnsi16BackgroundCodeEnum {

    BLACK_BG(40),
    RED_BG(41),
    GREEN_BG(42),
    YELLOW_BG(43),
    BLUE_BG(44),
    PURPLE_BG(45),
    CYAN_BG(46),
    WHITE_BG(47),

    BLACK_BG_B(100),
    RED_BG_B(101),
    GREEN_BG_B(102),
    YELLOW_BG_B(103),
    BLUE_BG_B(104),
    PURPLE_BG_B(105),
    CYAN_BG_B(106),
    WHITE_BG_B(107);

    private final int value;

    ColorAnsi16BackgroundCodeEnum(int value) {
        this.value = value;
    }

    public static ColorAnsi16BackgroundCodeEnum getByValue(int value) {
        for (ColorAnsi16BackgroundCodeEnum ansi16 : ColorAnsi16BackgroundCodeEnum.values()) {
            if (ansi16.value == value) {
                return ansi16;
            }
        }
        return null;
    }
}
