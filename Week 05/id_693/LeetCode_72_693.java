package id_693;

/**
 * @Desc 72. 编辑距离	https://leetcode-cn.com/problems/edit-distance/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/15
 */
public class LeetCode_72_693 {
    //dp方程：类似1143. 最长公共子序列
    /*
        1、分解子问题：相同f(i) =  f(i -1,j-1) ;
                     不同f(i) = min(f(i-1,j), f(i,j-1), f(i -1,j-1)) + 1;
        2、定义状态数组：f[i][j]
        3、dp方程：相同dp[i][j] =  dp[i-1][j-1]
                  不同dp[i][j] = Math.min(dp[i - 1][j],dp[i][j-1],dp[i-1][j-1]) + 1

        注意 [i][0] = i 初始化
            [0][j] = j 初始化
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    //初始化base
                    dp[i][j] = i == 0 ? j : i;
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        assert new LeetCode_72_693().minDistance("horse", "ros") == 3;
        assert new LeetCode_72_693().minDistance("intention", "execution") == 5;
        assert new LeetCode_72_693().minDistance("intention", "nation") == 4;
    }

    /*规律图
                N	A	T	I	O	N
            0	1	2	3	4	5	6
        I	1	1	2	3	3	4	5
        N	2	1	2	3	4	4	4
        T	3	2	2	2	3	4	5
        E	4	3	3	3	3	4	5
        N	5	4	4	4	4	4	4
        T	6	5	5	4	5	5	5
        I	7	6	6	5	4	5	6
        O	8	7	7	6	5	4	5
        N	9	8	8	7	6	5	4


     */
}
