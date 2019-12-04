package com.hand.week5;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/16
 */
public class LeetCode_91_578 {
//    public int numDecodings(String s) {
//        char[] s1 = s.toCharArray();
//        if (s1[0] == '0') return 0;
//        int[] dp = new int[s1.length];
//        dp[0] = 1;
//        for (int i = 1; i < dp.length; ++i) {
//            if (s1[i] == '0') {
//                if (s1[i - 1] == '1' || s1[i - 1] == '2') dp[i] = (i >= 2 ? dp[i - 2] : 1);
//                else return 0;
//            } else if (s1[i - 1] == '1' || (s1[i - 1] == '2' && s1[i] >= '1' && s1[i] <= '6')) {
//                dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[s1.length - 1];
//    }

    public int numDecodings(String s) {
        char[] s1 = s.toCharArray();
        if (s1[0] == '0') return 0;
        int pre = 1, current = 1;
        for (int i = 1; i < s1.length; ++i) {
            int tmp = current;
            if (s1[i] == '0') {
                if (s1[i - 1] == '1' || s1[i - 1] == '2') current = (i >= 2 ? pre : 1);
                else return 0;
            } else if (s1[i - 1] == '1' || (s1[i - 1] == '2' && s1[i] >= '1' && s1[i] <= '6')) {
                current = current + (i >= 2 ? pre : 1);
            }
            pre = tmp;
        }
        return current;
    }
}
