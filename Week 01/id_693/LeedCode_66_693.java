package id_693;


import java.util.Arrays;

/**
 * @Author 李雷（KyLin）
 * @Desc 66.加一 https://leetcode-cn.com/problems/plus-one/
 * @Date 2019/10/18
 */
public class LeedCode_66_693 {
    public int[] plusOne(int[] digits) {
        int f = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i];
            digits[i] = (digits[i] + f) % 10;
            f = (temp + f) / 10;
        }
        if (f == 1) {
            int[] r = new int[digits.length + 1];
            r[0] = 1;
            System.arraycopy(digits,0,r,1,r.length - 1);
            return r;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeedCode_66_693().plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new LeedCode_66_693().plusOne(new int[]{1,2,9})));
        System.out.println(Arrays.toString(new LeedCode_66_693().plusOne(new int[]{1,9,9})));
        System.out.println(Arrays.toString(new LeedCode_66_693().plusOne(new int[]{9,9,9})));
        System.out.println(Arrays.toString(new LeedCode_66_693().plusOne(new int[]{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9})));
    }
}

