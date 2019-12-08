/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        long x0 = x;

        while (x0*x0 > x) {
            x0 = (x0 + x / x0) / 2;
        }
        return (int)x0;

    }
}
// @lc code=end

