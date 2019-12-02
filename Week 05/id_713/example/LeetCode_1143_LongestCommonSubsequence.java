package id_713.example;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 * 示例 1:
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * <p>
 * 示例 2:
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * <p>
 * 示例 3:
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1143_LongestCommonSubsequence {

    /*
    思路:
    1. 子问题划分
        如果 str1最一位 == str2最后一位, 最大子序列为 str1[1...m-1]与str2[1...n-1]的最大子序列 + 1
        如果 串1最一位 != 串2最后一位, 最大子序列为
            str1[1...m]与str2[1...n-1]
            str1[1...m-1]与str2[1...n]
            中的最大值
     2. 边界

     3. dp方程
        如果 str[i] == str[j], dp[i][j] = dp[i-1][j-1] + 1
        否则 max(dp[i-1][j], dp[i][j-1])
     */

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();


        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; i < n + 1; i++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}