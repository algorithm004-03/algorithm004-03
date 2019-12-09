package leetcode.week7;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 *
 * @author eason.feng at 2019/12/1/0001 11:42
 **/
public class LeetCode_190_218 {
    public int reverseBits(int n) {
        int res = 0b0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
