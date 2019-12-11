package com.test.leetcode.week08;

import org.junit.Test;


public class SolutionDistinctSubsequence115 {


    /**
     * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
     *
     * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
     * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是
     *
     * 输入: S = "rabbbit", T = "rabbit"
     * 输出: 3
     * 解释:
     *
     * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
     * (上箭头符号 ^ 表示选取的字母)
     *
     * rabbbit
     * ^^^^ ^^
     * rabbbit
     * ^^ ^^^^
     * rabbbit
     * ^^^ ^^^
     *
     */
    @Test
    public void test1() {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }

    /**
     * DP
     * 两个字符串之间的变换问题经常使用一个二维数组来解决
     * 1.子问题
     * 2.状态数组 存储当前s,t 中 s的子序列中t出现的个数
     * 3.DP方程
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (t == null || t.length() == 0) {
            return 1;
        }
        char[] cols = ("#" + s).toCharArray();
        char[] rows = ("#" + t).toCharArray();
        int rowCnt = rows.length, colCnt = cols.length;
        int[][] dp = new int[rowCnt][colCnt];
        dp[0][0] = 1;
        for (int c = 1; c < colCnt; c ++) {
            dp[0][c] = 1;
        }
        for (int r = 1; r < rowCnt; r ++) {
            dp[r][0] = 0;
        }
        for (int r = 1; r < rowCnt; r ++) {
            for (int c = 1; c < colCnt; c++) {
                if (rows[r] == cols[c]) {
                    dp[r][c] = dp[r - 1][c - 1] + dp[r][c - 1];
                } else {
                    dp[r][c] = dp[r][c - 1];
                }
            }
        }
        return dp[rowCnt - 1][colCnt - 1];
    }





}
