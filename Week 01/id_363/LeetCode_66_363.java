package com.test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class SolutionPlusOne66 {


    @Test
    public void test1() {
        System.out.println(Arrays.toString(plusOne3(new int[]{9,9,9})));
        System.out.println(Arrays.toString(plusOne3(new int[]{1,9,9})));
        System.out.println(Arrays.toString(plusOne3(new int[]{1,2,3})));
    }


    public void addOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
//        String resultNum = String.valueOf(Integer.valueOf(sb.toString()) + 1);
        String resultNum = String.valueOf(new BigInteger((sb.toString()) + 1));
        digits = new int[resultNum.length()];
        for (int i = 0; i < resultNum.length(); i++) {
            digits[i] = Integer.valueOf(resultNum.substring(i, i + 1));
        }
    }


    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        int len = digits.length;
        int lastValue = digits[ len - 1];
        if (9 != lastValue) {
            digits[len - 1] = lastValue + 1;
            return digits;
        }

        Boolean allNine = true;
        for (int i = 0;i < len ; i ++) {
            if (digits[i] != 9) {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            int[] newDigits = new int[len + 1];
            newDigits[0] = 0;
            System.arraycopy(digits, 0, newDigits, 1, len);
            digits = newDigits;
            len = len + 1;
        }

        for (int j = len - 1; j >= 0; j --) {
            if (digits[j] == 9) {
                digits[j] = 0;
                continue;
            } else {
                digits[j] = digits[j] + 1;
                break;
            }
        }
        return digits;
    }

    public int[] plusOne3(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        for (int i = digits.length - 1; i >= 0; i --) {
            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        for (int i = digits.length - 1; i >= 0; i --) {
            digits[i] ++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }




}
