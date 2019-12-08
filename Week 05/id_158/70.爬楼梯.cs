/*
 * @lc app=leetcode.cn id=70 lang=csharp
 *
 * [70] 爬楼梯
 */

// @lc code=start
using System.Collections.Generic;

public class Solution5 {

    // 递归
    // private Dictionary<int,int> dict = new Dictionary<int, int>();
    // public int ClimbStairs(int n) {
    //     if(n==1) return 1;
    //     if(n==2) return 2;
    //     if(dict.ContainsKey(n)){
    //         return dict[n];
    //     }
    //     var fn= ClimbStairs(n-1)+ClimbStairs(n-2);
    //     dict.Add(n,fn);
    //     return fn;
    // }

    // DP
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
// @lc code=end

