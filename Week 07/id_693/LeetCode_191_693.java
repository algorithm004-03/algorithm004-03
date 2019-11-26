package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 191. 位1的个数 https://leetcode-cn.com/problems/number-of-1-bits/
 * @Date 2019/11/26
 */
public class LeetCode_191_693 {
    /**
     * 位运算1 ：(x >> n) & 1    获取x的n位的值（0或1）
     */
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 1; i <= 32; i++) {
                if (((n >> i) & 1) == 1) {
                    count++;
                }
            }
            return count;
        }

    }

    /**
     * 位运算2 ：n & (n - 1)  清零最低位的1
     */
    public class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                n = n & (n - 1);
            }
            return count;
        }
    }
}
