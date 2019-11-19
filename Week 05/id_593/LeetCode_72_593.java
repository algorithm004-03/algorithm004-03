/**
 * 72. 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：
 * dp
 * a. 子问题
 * b. 状态定义
 * c. dp方程
 * word1[i] == word2[j], dp[i][j] = dp[i-1][j-1];
 * word1[i] != word2[j],
 * dp[i-1][j] 到 d[i][j] 需要进行删除操作，dp[i-1][j-1] 到 dp[i][j] 需要进行替换操作，dp[i][j-1] 到 d[i][j] 需要进行插入操作。
 * dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1;
 *
 * @author jaryoung
 * @version 1.0 默写，别人的思路
 */
public class LeetCode_72_593 {

    public int minDistance(String word1, String word2) {
        int row = word1.length();
        int column = word2.length();
        int[][] dp = new int[row + 1][column + 1];
        // 第一行，word1 变成 word2 最少操作数，就是插入操作
        for (int i = 1; i <= row; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        // 第一列，word1 变成 ''， 最少操作数，就是删除操作
        for (int j = 1; j <= column; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[row][column];
    }
}
