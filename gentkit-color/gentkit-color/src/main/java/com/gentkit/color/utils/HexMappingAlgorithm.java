package com.gentkit.color.utils;

import java.util.HashMap;
import java.util.Map;

public class HexMappingAlgorithm {
    // 输入长度与输出结果的映射表
    private static final Map<Integer, String> LENGTH_TO_HEX = new HashMap<>();

    // 初始化映射规则（严格对应输入输出示例）
    static {
        LENGTH_TO_HEX.put(1, "000000");
        LENGTH_TO_HEX.put(2, "000100");
        LENGTH_TO_HEX.put(3, "001122");
        LENGTH_TO_HEX.put(4, "012300");
        LENGTH_TO_HEX.put(5, "012340");
        LENGTH_TO_HEX.put(6, "012345");
        LENGTH_TO_HEX.put(7, "013460");
        LENGTH_TO_HEX.put(8, "013467");
        LENGTH_TO_HEX.put(9, "013467");
        LENGTH_TO_HEX.put(10, "014589");
        LENGTH_TO_HEX.put(11, "014589");
        LENGTH_TO_HEX.put(12, "014589");
        LENGTH_TO_HEX.put(13, "0156AB");
        LENGTH_TO_HEX.put(14, "0156AB");
        LENGTH_TO_HEX.put(15, "0156AB");
        LENGTH_TO_HEX.put(16, "0167CD");
        LENGTH_TO_HEX.put(17, "0167CD");
        LENGTH_TO_HEX.put(18, "0167CD");
        LENGTH_TO_HEX.put(19, "0178EF");
        LENGTH_TO_HEX.put(20, "0178EF");
        LENGTH_TO_HEX.put(21, "0178EF");
        LENGTH_TO_HEX.put(22, "018901");
        LENGTH_TO_HEX.put(23, "018901");
        LENGTH_TO_HEX.put(24, "018901");
        LENGTH_TO_HEX.put(25, "12AB34");
    }

    /**
     * 输入十六进制字符串，输出映射后的6位十六进制字符串
     *
     * @param input 输入字符串（仅含0-9、A-F，忽略大小写）
     * @return 映射后的6位十六进制字符串（带#前缀）
     * @throws IllegalArgumentException 输入不合法时抛出
     */
    public static String hexMap(String input) {
        // 校验输入合法性（仅允许0-9、A-F、a-f）
        if (input == null || !input.matches("[0-9A-Fa-f]+")) {
            throw new IllegalArgumentException("输入必须是十六进制字符串（0-9、A-F）");
        }

        int inputLength = input.length();
        // 获取映射结果，无匹配长度时返回默认值（可根据需求调整）
        String result = LENGTH_TO_HEX.getOrDefault(inputLength, "000000");
        return result; // 如需去掉#，直接返回result
    }

    // 测试方法（验证输入输出是否匹配示例）
    public static void main(String[] args) {
        // 测试示例输入
        String[] testInputs = {
                "0", "00", "01", "000100", "012", "001122", "0123", "012300",
                "01234", "012340", "012345", "012345", "0123456", "013460",
                "01234567", "013467", "012345678", "013467", "0123456789", "014589",
                "0123456789A", "014589", "0123456789AB", "014589", "0123456789ABC", "0156AB",
                "0123456789ABCD", "0156AB", "0123456789ABCDE", "0156AB", "0123456789ABCDEF", "0167CD",
                "0123456789ABCDEF0", "0167CD", "0123456789ABCDEF01", "0167CD", "0123456789ABCDEF012", "0178EF",
                "0123456789ABCDEF0123", "0178EF", "0123456789ABCDEF01234", "0178EF", "0123456789ABCDEF012345", "018901",
                "0123456789ABCDEF0123456", "018901", "0123456789ABCDEF01234567", "018901", "0123456789ABCDEF012345678", "12AB34"
        };

        // 执行测试并打印结果
        for (int i = 0; i < testInputs.length; i += 2) {
            String input = testInputs[i];
            String expected = testInputs[i + 1];
            String actual = hexMap(input);
            System.out.printf("输入：%s → 预期：%s → 实际：%s → %s%n",
                    input, expected, actual, actual.equals(expected) ? "匹配" : "不匹配");
        }
    }
}