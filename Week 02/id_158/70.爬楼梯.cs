/*
 * @lc app=leetcode.cn id=70 lang=csharp
 *
 * [70] 爬楼梯
 */

// @lc code=start
using System.Collections.Generic;

public class Solution5 {
    private Dictionary<int,int> dict = new Dictionary<int, int>();
    public int ClimbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(dict.ContainsKey(n)){
            return dict[n];
        }
        var fn= ClimbStairs(n-1)+ClimbStairs(n-2);
        dict.Add(n,fn);
        return fn;
    }
}
// @lc code=end

