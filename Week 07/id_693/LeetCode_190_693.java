package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 190. 颠倒二进制位	https://leetcode-cn.com/problems/reverse-bits/
 * @Date 2019/11/26
 */
public class LeetCode_190_693 {
    /**
     * 位运算1
     */
    class Solution {
        // you need treat n as an unsigned value

        //输入: 00000010100101000001111010011100
        //输出: 00111001011110000010100101000000
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res = (res << 1) | (n & 1);
                n = n >> 1;
            }
            return res;
        }
    }

    /**
     * 位运算2
     */
    class Solution2 {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res = res << 1;
                res = res + (n & 1);
                n = n >> 1;
            }
            return res;
        }
    }
}
