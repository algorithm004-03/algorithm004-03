package com.company.leetcode.editor.cn;

//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
//count = 2
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//
// 若这两个字符串没有公共子序列，则返回 0。
//
//
//
// 示例 1:
//
// 输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace"，它的长度为 3。
//
//
// 示例 2:
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
//
//
// 示例 3:
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
//
//
//
//
// 提示:
//
//
// 1 <= text1.length <= 1000
// 1 <= text2.length <= 1000
// 输入的字符串只含有小写英文字符。
//
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1143 {

    public int longestCommonSubsequence(String text1, String text2) {

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();

        if (c1.length < 1 || c2.length < 1) {
            return 0;
        }

        int[][] dp = new int[c1.length][c2.length];
        dp[0][0] = c1[0] == c2[0] ? 1 : 0;
        //row0
        for (int i = 1; i < c2.length; i++) {
            if (c1[0] == c2[i]) {
                dp[0][i] =  1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        //col0
        for (int j = 1; j < c1.length; j++) {
            if (c1[j] == c2[0]) {
                dp[j][0] = 1;
            } else {
                dp[j][0] = dp[j - 1][0];
            }
        }

        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[c1.length - 1][c2.length - 1];
    }


//    public static void main(String[] args) {
//        Solution s = new Solution();
//        String text1 = "dknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxe";
//        String text2 = "dulixqfgvipenkfubgtyxujixspoxmhgvahqdmzmlyhajerqz";
//        //Wrong Answer: input:"bsbininm" "jmjkbkjkv" Output:2 Expected:1
//        //Wrong Answer: input:"dknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxe"
//        // "dulixqfgvipenkfubgtyxujixspoxmhgvahqdmzmlyhajerqz"
//        // Output:15 Expected:14
//        int len = s.longestCommonSubsequence(text1,text2);
//        System.out.println(len);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
