/*
 * @lc app=leetcode.cn id=231 lang=cpp
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
public:
    bool isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
};
// @lc code=end

