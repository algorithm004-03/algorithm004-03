package com.ljg.leetcode.week08.a03;

/**
 * LongestPalindromicSubstring
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "babad";
        String res = lps.longestPalindrome(s);
        System.out.println("res=" + res);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String res = "";
        s = s.trim();
        int len = s.length();
        boolean[][] arrs = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                arrs[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || arrs[i + 1][j - 1]);

                if (arrs[i][j] & (j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}