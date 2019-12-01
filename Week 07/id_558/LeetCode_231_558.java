package Week06;

/**
 * @see <a href="231">https://leetcode-cn.com/problems/number-of-1-bits/submissions/</a>
 * 2的幂
 */
public class LeetCode_231_558 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
