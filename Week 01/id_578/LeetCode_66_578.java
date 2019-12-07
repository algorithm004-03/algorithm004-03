package com.hand.week1.class3;

/**
 * @description:LeetCode66. 加一
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/16
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) return digits;

        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
