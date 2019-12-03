
/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 题号：231
 * 题目：2的幂
 */

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}