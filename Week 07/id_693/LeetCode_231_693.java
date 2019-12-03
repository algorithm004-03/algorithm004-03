package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 231. 2的幂	https://leetcode-cn.com/problems/power-of-two/
 * @Date 2019/11/26
 */
public class LeetCode_231_693 {
    /**
     * 位运算1：直接套用计算1的数量， 2的幂只有一个1
     */
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n < 0) return false;
            int count = 0;
            while (n != 0) {
                count++;
                n &= (n - 1);
            }
            return count == 1;
        }
    }

    /**
     * 位运算2：直接和自身-1 比较，如果是0 那么肯定就是2的倍数了
     */
    class Solution2 {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
