/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (58.45%)
 * Likes:    1763
 * Dislikes: 89
 * Total Accepted:    131K
 * Total Submissions: 224.2K
 * Testcase Example:  '"abc"'
 *
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        //2019.11.15 DP实现
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        boolean[][] dp = buildDPForCountSubstrings(s);
        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
    
    
    private boolean[][] buildDPForCountSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //注意i 和j 的边界，只计算上半部分，j - i <= 1是为了处理边界，dp[i + 1][j - 1]是dp[i][j]砍头去尾后的是否是回文
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1]);
                }
            }
        }
        return dp;
    }
}
// @lc code=end

