/*
 * @lc app=leetcode.cn id=32 lang=csharp
 *
 * [32] 最长有效括号
 */

// @lc code=start
using System;
using System.Collections.Generic;

public class Solution {
    // 栈
    public int LongestValidParentheses(string s) {
        int max = 0;
        Stack<int> stack = new Stack<int>();
        stack.Push(-1);
        for (int i = 0; i < s.Length; i++) {
            if (s[i] == '(') {
                stack.Push(i);
            } else {
                stack.Pop();
                if (stack.Count==0) {
                    stack.Push(i);
                } else {
                    max = Math.Max(max, i - stack.Peek());
                }
            }
        }
        return max;
    }

    // DP
    public int longestValidParentheses(string s) {
        int maxans = 0;
        int[] dp = new int[s.Length];
        for (int i = 1; i < s.Length; i++) {
            if (s[i] == ')') {
                if (s[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.Max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
// @lc code=end

