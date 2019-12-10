package com.ljg.leetcode.week08.a05;

import lombok.val;

/**
 * StringToIntegerAtoi
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        String[] arrs = new String[] { "+1", "42", "   -42", "4193 with words", "words and 987", "-91283472332","-2147483647", "-2147483648","2147483648" };
        StringToIntegerAtoi sti = new StringToIntegerAtoi();
        for (String string : arrs) {
            int value = sti.myAtoi(string);
            System.out.println(string + "\t:" + value);
        }

    }

    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();
        int len = str.length();
        char[] chs = str.toCharArray();

        char firstChar = chs[0];
        if (!(firstChar == '-' || firstChar == '+' || (firstChar >= '0' && firstChar <= '9'))) {
            return 0;
        }
        int flag = firstChar == '-' ? -1 : 1;
        int i = (firstChar == '-' || firstChar == '+') ? 1 : 0;
        int value = 0;
        for (; i < len; i++) {
            int curValue = chs[i] - '0';
            if (curValue > 9 || curValue < 0) {
                return flag * value;
            }
            if (Integer.MAX_VALUE / 10 < value) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else if (Integer.MAX_VALUE / 10 == value) {
                if (Integer.MAX_VALUE % 10 < curValue) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            value = (value * 10) + curValue;
        }

        return flag * value;
    }
}