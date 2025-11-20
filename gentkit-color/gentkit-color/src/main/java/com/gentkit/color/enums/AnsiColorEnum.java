package com.gentkit.color.enums;

import lombok.Getter;

@Getter
public enum AnsiColorEnum {
    GREEN(32)

    ;

    private final int value;

    AnsiColorEnum(int value) {
        this.value = value;
    }

    public static AnsiColorEnum getByValue(int value) {
        for (AnsiColorEnum ansiColor : AnsiColorEnum.values()) {
            if (ansiColor.value == value) {
                return ansiColor;
            }
        }
        return null;
    }
}
