package com.hand.week8;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/8
 */
public class LeetCode_91_578 {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            if (chars[i] == '0') {
                if (chars[i - 1] == '1' || chars[i - 1] == '2') dp[i] = (i >= 2 ? dp[i - 2] : 1);
                else return 0;
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {
                dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}
