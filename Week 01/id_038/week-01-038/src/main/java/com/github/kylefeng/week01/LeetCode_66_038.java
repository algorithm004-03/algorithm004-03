package com.github.kylefeng.week01;

/**
 * 66. 加一
 *
 * @author kylefeng
 * @time 2019/10/19 23:40
 */
public class LeetCode_66_038 {

    public static int[] plusOne(int[] digits) {
        // Handle special cases
        if (digits == null || digits.length == 0) {
            return digits;
        }

        if (digits.length == 1) {
            ++digits[0];
            if (digits[0] == 10) {
                return new int[]{1, 0};
            } else {
                return digits;
            }
        }
        //////////////////////////////////////////
        int last = digits[digits.length - 1];
        ++last;


        if (last < 10) {
            digits[digits.length - 1] = last;
            return digits;
        }

        boolean promote = false;
        // 等于 10 了，要进位
        if (last == 10) {
            digits[digits.length - 1] = 0;
            promote = true;
        }

        for (int i = digits.length - 2; i >= 0; i--) {
            if (!promote) {
                break;
            }

            int d = digits[i];
            ++d;

            if (d < 10) {
                digits[i] = d;
                break;
            }

            if (d == 10 && i != 0) {
                digits[i] = 0;
                promote = true;
                continue;
            }

            if (d >= 10 && i == 0) {
                digits[i] = d;
            }
        }

        if (digits[0] >= 10) {
            return handleFirstDigitGreatThanTen(digits);
        }

        return digits;
    }

    private static int[] handleFirstDigitGreatThanTen(int[] digits) {
        int num = digits[0];
        int first = num / 10;
        int second = num % 10;

        int[] newDigits = new int[digits.length + 1];
        System.arraycopy(digits, 1, newDigits, 2, digits.length - 1);
        newDigits[0] = first;
        newDigits[1] = second;
        return newDigits;
    }

}
