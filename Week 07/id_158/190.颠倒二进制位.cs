/*
 * @lc app=leetcode.cn id=190 lang=csharp
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution
{
    public uint reverseBits(uint n)
    {
        uint res = 0;
        for (int i = 0; i < 32; i++)
        {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
// @lc code=end

