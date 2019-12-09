package com.test.leetcode.week05;

import org.junit.Test;


public class SolutionDecodeWays91 {


    @Test
    public void test1() {
        System.out.println(numDecodings_20191208("220"));
        System.out.println(numDecodings_20191208("12"));
        System.out.println(numDecodings_20191208("0"));
        System.out.println(numDecodings_20191208("226"));

    }

    /**
     * 题目： 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     * dp：
     * 1.子问题
     * 2.状态数组
     * 3.DP方程
     *
     * 循环数组
     * 如果当前值是0 前面的值 大于2 那么 返回 0 否则 dp[i] = dp[i - 1]
     * 如果前一个值是1  或者 前一个值是 2 当前值 <= 6 那么 dp[i] = dp[i-1] + dp[i - 2]
     * 其他情况 ： dp[i] = dp[i - 1];
     *
     * @param s
     * @return
     */
    public int numDecodings_20191208(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; dp[1] = 1;
        char[] schars = ("#" + s ).toCharArray();
        for (int i = 1; i < schars.length; i ++) {
            if (schars[i] == '0') {
                if (schars[i - 1] == '1' || schars[i - 1] == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else if (schars[i - 1] == '1' || (schars[i - 1] == '2' && schars[i] <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
