package com.hand.week5;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/16
 */
public class LeetCode_32_578 {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
}
