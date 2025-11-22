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
public enum ColorAnsi16ForegroundCodeEnum {

    BLACK(30, "#181818"),
    RED(31, "#AC4242"),
    GREEN(32, "#90A959"),
    YELLOW(33, "#F4BF75"),
    BLUE(34, "#6A9FB5"),
    PURPLE(35, "#AA759F"),
    CYAN(36, "#75B5AA"),
    WHITE(37, "#D8D8D8"),

    BLACK_B(90, "#6B6B6B"),
    RED_B(91, "#C55555"),
    GREEN_B(92, "#AAC474"),
    YELLOW_B(93, "#FECA88"),
    BLUE_B(94, "#82B8C8"),
    PURPLE_B(95, "#C28CB8"),
    CYAN_B(96, "#93D3C3"),
    WHITE_B(97, "#F8F8F8"),

    ;

    private final int value;

    private final String hex;

    ColorAnsi16ForegroundCodeEnum(int value, String hex) {
        this.value = value;
        this.hex = hex;
    }

    public static ColorAnsi16ForegroundCodeEnum getByValue(int value) {
        for (ColorAnsi16ForegroundCodeEnum ansi16 : ColorAnsi16ForegroundCodeEnum.values()) {
            if (ansi16.value == value) {
                return ansi16;
            }
        }
        return null;
    }
}
