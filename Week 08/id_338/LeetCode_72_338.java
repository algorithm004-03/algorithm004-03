package id_338;

/**
 * @author Leesen
 * @date 2019/12/8 23:08
 */
public class LeetCode_72_338 {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //****自底向上, 初始化条件要联想那个表格, 代表空字符与字符串的编辑距离。 各种等号容易遗漏
        for (int i=1; i<word1.length(); i++) {
            dp[i][0] = dp[i-1][0] + 1; //空字符串替换成单词需要操作数
        }
        for (int j=1; j<word2.length(); j++) {
            dp[0][j] = dp[0][j-1] + 1;
        }

        for (int j=1; j<word2.length(); j++) {
            dp[0][j] = word1.charAt(0) == word2.charAt(j) ? 0 : 1;
        }
        for (int i=1; i<=word1.length(); i++) {
            for (int j=1; j<=word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(
                            dp[i-1][j-1],
                            dp[i-1][j]),
                            dp[i][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
