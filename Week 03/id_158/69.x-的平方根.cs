/*
 * @lc app=leetcode.cn id=69 lang=csharp
 *
 * [69] x 的平方根
 */

// @lc code=start
public class Solution {
    public int MySqrt(int x) {
        
            long left = 0;
            long right = x;
            long mid = 0;
            while (left < right)
            {
                mid = (right + left) / 2;
                long square = mid * mid;
                if (square > x)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid+1;
                }
            }

            if (right * right == x)
            {
                return (int)right;
            }
            if (left * left > x)
            {
                return (int)left - 1;
            }

            return (int)left ;
    }
}
// @lc code=end

