package id_713.example;

import java.util.Arrays;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_62_UniquePaths {

    /*
    思路1:
    1. 利用动态规划, 从右下角开始计算
    2. 方程: dp[i][j] = dp[i + 1][j] + dp[i][j + 1]

    思路2:
    1. 压缩空间, 把二维数组一层一层向上执行
    2. 从右至左(列), 从下至上(行), 用一个数组维护, 之前用完的覆盖即可, 不用再保留
        从而达到压缩空间的目的


     */

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        arr[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    arr[i][j] = arr[i][j] + arr[i][j + 1];
                } else if (i != m - 1 && j == n - 1) {
                    arr[i][j] = arr[i][j] + arr[i + 1][j];
                } else if (i != m - 1 && j != n - 1) {
                    arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
                }

            }
        }

        return arr[0][0];
    }

    public int uniquePath2(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] += arr[j - 1];
            }
        }

        return arr[n - 1];
    }
}