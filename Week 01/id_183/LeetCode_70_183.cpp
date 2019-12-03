/*
 * @lc app=leetcode id=70 lang=cpp
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
public:
    int climbStairs(int n) {
        if(n<=2)
        return n;
        //f3=f1+f2;f4=f2+f3;f5=f3+f4
        int first = 1;
        int second = 2;
        for(int i=3;i<=n;++i)
        {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
 ·   }
};
// @lc code=end

