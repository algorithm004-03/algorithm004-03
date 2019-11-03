package org.geektime.weak01;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by fukan on 2019/10/24.
 */
public class LeetCode_66_178 {
    public static void main(String[] args) {
        LeetCode_66_178 instance = new LeetCode_66_178();
        int input[] = {1,2,3};
        instance.plusOne1(input);
        //1\2\3解法本质都是控制最后一位的进位来优化整个程序.

    }

    public int[] plusOne1(int[] digits) {
        //倒序遍历,控制进位
        for(int i = digits.length - 1; i >= 0 ; i--){
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0 ) return digits;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;

        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length -  1;i >= 0 ; i--){
            if (digits[i] != 9 ){
                digits[i]++;
                break;
            }else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0){
            int[] res  = new int[digits.length+1];
            res[0] = 1;
            return res;
        }

        return digits;
    }

    public int[] plusOne3(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1;i>=0;--i){
            digits[i] += carry;
            if (digits[i] <= 9){
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}


