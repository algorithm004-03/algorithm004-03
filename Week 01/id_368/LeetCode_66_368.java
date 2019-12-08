import java.util.Arrays;

public class LeetCode_66_368 {

    public static void main(String[] args) {

        /* 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
        你可以假设除了整数 0 之外，这个整数不会以零开头。
        链接：https://leetcode-cn.com/problems/plus-one */

        int[] digits = {9, 9, 9, 9, 9};
        Arrays.stream(plusOne(digits)).forEach(i -> System.out.print(i));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
