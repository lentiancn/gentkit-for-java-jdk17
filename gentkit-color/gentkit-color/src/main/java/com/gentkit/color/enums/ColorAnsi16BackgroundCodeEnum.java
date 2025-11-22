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

    BLACK_BG(40, "#181818"),
    RED_BG(41, "#AC4242"),
    GREEN_BG(42, "#90A959"),
    YELLOW_BG(43, "#F4BF75"),
    BLUE_BG(44, "#6A9FB5"),
    PURPLE_BG(45, "#AA759F"),
    CYAN_BG(46, "#75B5AA"),
    WHITE_BG(47, "#D8D8D8"),

    BLACK_BG_B(100, "#6B6B6B"),
    RED_BG_B(101, "#C55555"),
    GREEN_BG_B(102, "#AAC474"),
    YELLOW_BG_B(103, "#FECA88"),
    BLUE_BG_B(104, "#82B8C8"),
    PURPLE_BG_B(105, "#C28CB8"),
    CYAN_BG_B(106, "#93D3C3"),
    WHITE_BG_B(107, "#F8F8F8");

    private final int value;

    private final String hex;

    ColorAnsi16BackgroundCodeEnum(int value, String hex) {
        this.value = value;
        this.hex = hex;
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
