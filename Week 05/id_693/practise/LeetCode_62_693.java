package id_693.practise;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @Desc 62. 不同路径	https://leetcode-cn.com/problems/unique-paths/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/11
 */
public class LeetCode_62_693 {
    //dp,第一版，听思路写题解-自低向上-空间复杂度O(N ^ 2)
    public int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] temp = new int[m][n];
        temp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                int ni = i + 1;
                int nj = j + 1;
                int t = 0;
                if (ni < m) {
                    t += temp[ni][j];
                }
                if (nj < n) {
                    t += temp[i][nj];
                }
                temp[i][j] = t;
            }
        }
        return temp[0][0];
    }

    //降低空间复杂度，从题得出，只需要一层的数字即可.切最右边只有1个路线-空间复杂度O(N)
    public int uniquePaths(int m, int n) {
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                temp[j] += temp[j + 1];
            }
        }
        return temp[0];
    }

    //leetcode题解，写法比我优美，自上而下-空间复杂度O(N)
    public int uniquePaths3(int m, int n) {
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[j] += temp[j - 1];
            }
        }
        return temp[n - 1];
    }

    //增加老师题解 -空间复杂度O(N ^ 2)  里面提前把为1的考虑
    public int uniquePaths4(int m, int n) {
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) temp[0][i] = 1;
        for (int i = 0; i < m; i++) temp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }
        return temp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Assert.assertEquals(1, new LeetCode_62_693().uniquePaths4(1, 1));
        Assert.assertEquals(28, new LeetCode_62_693().uniquePaths4(7, 3));
    }
}
