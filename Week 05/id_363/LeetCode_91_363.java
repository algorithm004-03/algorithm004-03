package com.test.leetcode.week05;

import org.junit.Test;


public class SolutionNumsEncoding91 {


    @Test
    public void test1() {
        System.out.println(numDecodings("220"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("226"));
    }

    /**
     * 给定字符串，计算解码方法的总数
     *
     * 数学归纳法
     *
     * dp：
     * 子问题：将字符串边短
     * 状态数组：存储从0到i处字符串的解码方法总数
     * dp方程：dp[i] = dp[i - 1] + if (s.substr(i-1,i) <= 26) : dp[i - 2]
     *
     *
     * s[i] == 0, s[i - 1] == 1/2 dp[i]=dp[i-2]
     * s[i-1] == 1 || s[i-1]== 2 && s[i]<= 6 dp[i] = dp[i-1]+dp[i-2]
     * else dp[i] = dp[i - 1]
     * 注意：0 和 26
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] chars = ("#" + s).toCharArray();
        if (chars[1] == '0') {
            return 0;
        }
        int[] dp = new int[chars.length];
        dp[0] = 1; dp[1]= 1;
        for (int i = 2; i < chars.length; i ++) {
            if (chars[i] == '0') {
                if (chars[i - 1] == '1' || chars[i - 1] == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }


}
