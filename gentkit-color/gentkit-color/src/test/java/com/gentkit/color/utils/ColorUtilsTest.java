package com.gentkit.color.utils;

import com.gentkit.color.ColorConstants;
import org.junit.jupiter.api.Test;

public class ColorUtilsTest {

    @Test
    public void ansiColor() {
        String text = "Hello world !";

        // 前景色
        System.out.println(ColorUtils.hexToAnsiForeground(true, "#FF2400") + text + ColorConstants.ANSI_RESET);

        // 背景色
        System.out.println(ColorUtils.hexToAnsiBackground("#FFFF00") + text + ColorConstants.ANSI_RESET);

        // 前景色 + 背景色
        System.out.println(ColorUtils.hexToAnsiForeground(true, "#FF2400") + ColorUtils.hexToAnsiBackground("#FFFF00") + text + ColorConstants.ANSI_RESET);

        // 背景色 + 前景色
        System.out.println(ColorUtils.hexToAnsiBackground("#FFFF00") + ColorUtils.hexToAnsiForeground(true, "#FF2400") + text + ColorConstants.ANSI_RESET);
    }
}
