package com.test.leetcode.week05;

import org.junit.Test;

import java.util.Stack;


public class SolutionLongestValidParenthese32 {



    @Test
    public void test1() {
        System.out.println(longestValidParentheses_20191208_1(")()())"));
        System.out.println(longestValidParentheses_20191208_1("())"));
        System.out.println(longestValidParentheses_20191208_1("(()"));
    }


    /**
     * DP
     * 1.子问题
     * 2.状态数组：记录以当前元素结尾的所有字序列中最大有效括号的对数
     * 3.dp方程
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_20191208_1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        char[] schars = s.toCharArray();
        int max = 0;
        for (int i = 1; i < schars.length; i ++) {
            if (schars[i] == ')') {
                if (schars[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i > dp[i - 1] && schars[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + (i >= dp[i - 1] + 2 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
