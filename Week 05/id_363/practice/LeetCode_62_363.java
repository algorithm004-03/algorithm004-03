package com.test.leetcode.week05;

import org.junit.Test;

import java.util.Arrays;


public class SolutionUniquePaths62 {


    @Test
    public void test1() {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));

        System.out.println(uniquePaths2(3, 2));
        System.out.println(uniquePaths2(7, 3));

        System.out.println(uniquePaths3(3, 2));
        System.out.println(uniquePaths3(7, 3));

        System.out.println(uniquePaths4(3, 2));
        System.out.println(uniquePaths4(7, 3));
        System.out.println(uniquePaths5(3, 2));
        System.out.println(uniquePaths5(7, 3));

    }

    /**
     * 问题：一个机器人位于m*n网格的左上角，机器人只能想上或者向下移动一步，机器人到达右下角有多少总不同的路径
     * 数学归纳法:先计算机器人在最右边和最下面的路径
     *
     * 子问题
     * 状态数组 状态数组中存储 当前格子到终点的路径数
     * 动态规划方程 dp[i , j] = dp[i - 1, j] + dp[i,j + 1]
     *
     *
     * 代码：递归 -> 自顶想下 -> 自下向上 -> 时间复杂度和空间复杂度优化
     *
     * m 表示列 n表示行
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
       return helper(m - 1, n - 1);
    }

    private int helper(int c, int r) {
        // termination
        if ( c == 0 || r == 0) {
            return 1;
        }
        // process
        int right = helper(c - 1, r);
        int below = helper(c, r - 1);
        return right + below;
        // drill down
        // reverse
    }
    // m是列 n是行
    public int uniquePaths2(int m, int n) {
        // 记忆表初始化
        int[][] memo = new int[n][m];
        for (int i = 0; i < m; i ++) {
            memo[0][i] = 1;
        }
        for (int i = 0; i < n; i ++) {
            memo[i][0] = 1;
        }

        return helper2(m - 1, n - 1, memo);
    }

    private int helper2(int c, int r, int[][] memo) {
        // termination: 终止条件是记忆表中已经计算好了
        if (memo[r][c] > 0) {
            return memo[r][c];
        }
        // process
        int right = helper2(c - 1, r, memo);
        int below = helper2(c, r - 1, memo);
        // drill down：把算好的结果放入到记忆表中
        memo[r][c] = right + below;
        // reverse
        return memo[r][c];
    }

    // m表示列 n表示行
    public int uniquePaths3(int m, int n) {
        // 记忆表初始化
        int[][] memo = new int[n][m];
        for (int i = 0; i < m; i ++) {
            memo[0][i] = 1;
        }
        for (int i = 0; i < n; i ++) {
            memo[i][0] = 1;
        }
        for (int r = 1; r < n; r ++) {
            for (int c = 1; c < m ; c ++ ) {
                memo[r][c] = memo[r - 1][c] + memo[r][c - 1];
            }
        }
        return memo[n - 1][m - 1];
    }

    // m 表示列 n表示行
    public int uniquePaths4(int m, int n) {
        // 记忆表初始化
        int[] memo = new int[m];
        Arrays.fill(memo, 1);

        for (int r = 1; r < n; r ++) {
            for (int c = 1; c < m; c ++) {
                memo[c] = memo[c] + memo[c - 1];
            }
        }
        return memo[m - 1];
    }


    /**
     * 使用公式
     * m表示列 n表示行  需要 m -1 right 和 n -1 down 才能到达终点
     * 所以这也是全排列的问题 m-1个 R 和 n- 1个D的全排列
     * 方程是(m + n)! / (m ! * n !);
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths5(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        m --;
        n --;
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        long j = 1, res = 1;
        for (int i = m + 1; i <= m + n; i ++, j ++) {
            res *= i;
            res /= j;
        }
        return (int)res;
    }


}
