/*
 * @lc app=leetcode.cn id=455 lang=csharp
 *
 * [455] 分发饼干
 */

// @lc code=start
using System;

public class Solution {
    public int FindContentChildren(int[] g, int[] s) {
        int res=0;
        Array.Sort(g);
        Array.Sort(s);
        int i=0,j=0;
        while (i<g.Length && j<s.Length)
        {
            if(g[i]<=s[j]){
                res++;
                i++;
                j++;
            } else{
                j++;
            }
        }
        return res;
    }
}
// @lc code=end

