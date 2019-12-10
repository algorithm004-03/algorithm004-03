package com.github.kylefeng;

/**
 * 91. 解码方法
 */
public class LeetCode_91_038 {


    public static int solution(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int strLen = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[strLen];


        dp[0] = chars[0] == '0' ? 0 : 1;

        for (int i = 1; i < strLen; i++) {
            int cur = chars[i] - '0';
            int pre = (chars[i - 1] - '0') * 10 + cur;

            if (cur != 0) {
                dp[i] += dp[i - 1];
            }

            if (10 <= pre && pre <= 26) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }

        return dp[strLen - 1];
    }
}
