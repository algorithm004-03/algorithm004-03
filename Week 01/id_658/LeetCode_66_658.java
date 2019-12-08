/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        // 给最后一个元素做加一操作，如果满足进位 就往前进一位
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            // 判断是否加一后需要进位 
            digits[i] %= 10;
            // 如果不需要就加完了直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 如果循环完没返回就是都进了一位，就变为比原来多一位的1xxxx数
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
