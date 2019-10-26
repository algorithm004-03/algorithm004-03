package id_693;


import java.util.Arrays;

/**
 * @Author 李雷（KyLin）
 * @Desc 66.加一 https://leetcode-cn.com/problems/plus-one/
 * @Date 2019/10/18
 */
public class LeetCode_66_693 {
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

    //对于同学的review 进行优化,非常感谢这位同学
    /*
    1、f 为进位，不是0就是1，没必要除以10进行计算
    2、如果f为0，那么循环可以结束了，没必要继续下去
    * */
    public int[] plusOne2(int[] digits) {
        boolean f = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                digits[i] = digits[i] + 1 - 10;
            } else {
                digits[i] += 1;
                f = false;
                break;
            }
        }
        if (f) {
            int[] r = new int[digits.length + 1];
            r[0] = 1;
            System.arraycopy(digits,0,r,1,r.length - 1);
            return r;
        }
        return digits;
    }

    //根据效率最高的代码再次进行优化，
    //思路：直接修改digits[i] 的值，如果不等于0  说明没有超出，则直接return，否则继续改变
    //      后面的新建数组的思路很巧妙，
    //          因为到了最后一个就代表，数组的值全是9的情况下才会出现，那么说明结果只需要在数组头增加一个1  后面全是0，
    //          利用数组的默认0来实现，666
    public int[] plusOne3(int[] digits) {
        boolean is = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode_66_693().plusOne2(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new LeetCode_66_693().plusOne2(new int[]{1,2,9})));
        System.out.println(Arrays.toString(new LeetCode_66_693().plusOne2(new int[]{1,9,9})));
        System.out.println(Arrays.toString(new LeetCode_66_693().plusOne2(new int[]{9,9,9})));
        System.out.println(Arrays.toString(new LeetCode_66_693().plusOne2(new int[]{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9})));
    }
}

