/*
思路
DP算法解决LCS问题

dp[i][j]表示text1前i个字符和text2前j个字符能构造出来的LCS长度
显然有下面状态转移关系
如果 text1[i] == text[j]
    dp[i][j] = dp[i-1][j-1] + 1
反之
    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
*/


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        if ((m == 0) || (n == 0)) {
            return 0;
        }

        int[] dp = new int[n];
        // i 为 0 初始化种子
        dp[0] = (text1.charAt(0) == text2.charAt(0)) ? 1 : 0;
        for (int j = 1; j < n; j++) {
            dp[j] = (dp[j-1] == 1) ? 1 : ((text1.charAt(0) == text2.charAt(j)) ? 1: 0);
        }

        for (int i = 1; i < m; i++) {
            int dp_old = dp[0];     // 保存dp[i-1][j-1], 因为这里用一维数组代替二位数组进行空间复杂度优化，所以这个老值要提前保存
            int dp_tmp = 0;

            dp[0] = (text1.charAt(i) == text2.charAt(0)) ? 1 : dp[0];
            for (int j = 1; j < n; j++) {
                dp_tmp = dp[j];     // 保存老状态dp[i-1][j] 下一轮迭代计算dp[i][j+1]要使用这个值
                dp[j] = (text1.charAt(i) == text2.charAt(j)) ? (dp_old + 1) : Math.max(dp[j-1], dp[j]);
                dp_old = dp_tmp;
            }
        }

        return dp[n-1];
    }
}