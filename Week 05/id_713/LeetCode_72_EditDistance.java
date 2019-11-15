package id_713;

/**
 * 72. 编辑距离
 */
public class LeetCode_72_EditDistance {
    /*
    给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

    你可以对一个单词进行如下三种操作：

        插入一个字符
        删除一个字符
        替换一个字符

    示例 1:

    输入: word1 = "horse", word2 = "ros"
    输出: 3
    解释:
    horse -> rorse (将 'h' 替换为 'r')
    rorse -> rose (删除 'r')
    rose -> ros (删除 'e')

    示例 2:

    输入: word1 = "intention", word2 = "execution"
    输出: 5
    解释:
    intention -> inention (删除 't')
    inention -> enention (将 'i' 替换为 'e')
    enention -> exention (将 'n' 替换为 'x')
    exention -> exection (将 'n' 替换为 'c')
    exection -> execution (插入 'u')

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/edit-distance
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



    E   5   4   4   3
    S   4   3   3   2
    R   3   2   2   2       R和R相等, 所以 min(左,下,左下)不加1
    O   2   2   1   2       O和O相等, 所以 min(左,下,左下)不加1
    H   1   1   2   3
    #   0   1   2   3
        #   R   O   S


     */

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m == 0 || n == 0) { // 如果其中一个为空串, 则返回另一个串的长度
            return n + m;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }

        for (int j = 0; j < n + 1; j++) {
            dp[j][0] = j;
        }


        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i][j - 1] + 1;
                int down = dp[i - 1][j] + 1;
                int leftDown = dp[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }

                dp[i][j] = Math.min(left, Math.min(down, leftDown));


            }
        }

        return dp[m][n];
    }
}
