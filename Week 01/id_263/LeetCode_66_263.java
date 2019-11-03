package io.beansoft.pencil.leetcode;


/**
 * @author beanlam
 * @version 1.0
 * @date 2019-10-20 17:10
 */
public class LeetCode_66_263 {

    public int[] plusOne(int[] digits) {


        boolean increment = false;

        int[] result = digits;

        for (int i = digits.length - 1; i >= -1; i--) {


            if (i == -1) {
                if (increment) {
                    result = new int[digits.length + 1];
                    result[0] = 1;
                    System.arraycopy(digits, 0, result, 1, digits.length);
                }
                break;
            }

            int currentValue = digits[i];
            if (i == digits.length - 1) {
                currentValue++;
            }

            int popupValue = currentValue + (increment ? 1 : 0) - 10;
            if (popupValue >= 0) {
                increment = true;
                digits[i] = popupValue;
            } else {
                digits[i] = currentValue + (increment ? 1 : 0);
                increment = false;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        for (int i : new LeetCode_66_263().plusOne(new int[]{8,9,9,9})) {
            System.out.print(i + ",");
        }
    }
}
