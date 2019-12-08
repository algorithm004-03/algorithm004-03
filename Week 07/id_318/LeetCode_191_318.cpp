/*
 * @lc app=leetcode id=191 lang=cpp
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
class Solution {
public:
    int hammingWeight(uint32_t n) {
        return (n > 0) ? 1 + hammingWeight(n & (n - 1)) : 0;
    }
};
// @lc code=end

