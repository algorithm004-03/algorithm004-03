/*
 * @lc app=leetcode id=190 lang=cpp
 *
 * [190] Reverse Bits
 */

// @lc code=start
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        int i = 32;
        uint32_t reverse_n = 0;
        while(i--) {
            reverse_n = (reverse_n << 1) + (n & 1);
            n >>= 1;
        }
        return reverse_n;
    }
};
// @lc code=end

