package com.test.leetcode.week02;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class SolutionNQueens51 {


    @Test
    public void test1() {
        System.out.println(solveNQueens_20191130(8));
    }


    /**
     * 从第0行开始递归
     * 递归：循环所有列，如果可以放皇后，那么递归下一行。如果不可以，循环下一列
     * 不能使用位运算的原因：不知道queens中数组怎么放值。
     *
     * @param n
     * @return
     */
    int[] cols_20191130;
    int[] pie_20191130;
    int[] na_20191130;
    int[] queen_20191130;
    List<List<String>> result_20191130;
    int n_20191130;
    public List<List<String>> solveNQueens_20191130(int n) {
        // 初始化
        n_20191130 = n;
        queen_20191130 = new int[n];
        cols_20191130 = new int[n];
        pie_20191130 = new int[2 * n + 1];
        na_20191130 = new int[2 * n + 1];
        result_20191130 = new LinkedList<>();
        // 递归
        helper_20191130(0);
        // 返回
        return result_20191130;
    }

    private void helper_20191130(int r) {
        // termination
        if (r == n_20191130) {
            result_20191130.add(genResult(queen_20191130));
            return;
        }
        // process
        for (int c = 0; c < n_20191130; c  ++) {
            if (cols_20191130[c] + pie_20191130[r + c] + na_20191130[r - c + n_20191130] == 0) {
                cols_20191130[c] = 1;
                pie_20191130[r + c] = 1;
                na_20191130[ r - c + n_20191130] = 1;
                queen_20191130[r] = c;

                helper_20191130(r + 1);

                cols_20191130[c] = 0;
                pie_20191130[r + c] = 0;
                na_20191130[ r - c + n_20191130] = 0;
                queen_20191130[r] = 0;
            }
        }
        // drill down
        // reverse
    }

    private List<String> genResult(int[] queen) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < queen.length; i ++) {
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < queen[i]; j ++) {
                buffer.append(".");
            }
            buffer.append("Q");
            for (int j = queen[i] + 1; j < queen.length; j ++) {
                buffer.append(".");
            }
            result.add(buffer.toString());
        }
        return  result;
    }

}
