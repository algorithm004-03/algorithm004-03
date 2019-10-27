package com.ning.test;

import org.junit.Test;

/**
 * 描述：
 *
 * @author yu.shao@okcoin.com
 * @create 2019-10-20 下午11:40
 */
public class LeetCode_66_148 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    @Test
    public void test () {
        System.out.println((1003213 >> 2)% 10);
    }
}
