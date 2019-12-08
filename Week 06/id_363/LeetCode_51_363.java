package com.test.leetcode.week02;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class SolutionNQueens51 {


    @Test
    public void test1() {
        System.out.println(solveNQueens_20191124(8));
    }


    /**
     * N 皇后
     * pie:
     * na:
     * queen:
     *
     * 从第0行开始递归，循环每一列，判断是否能放皇后
     * 如果可以放皇后，那么继续递归下一行
     * 如果不可以放皇后，继续下一列
     *
     * @param n
     * @return
     */
    int[] pie;
    int[] na;
    int[] cols_20191124;
    int[] queen_20191124;
    List<List<String>> result_20191124;

    public List<List<String>> solveNQueens_20191124(int n) {
        // 初始化
        pie = new int[2 * n + 1];
        na = new int[2 * n + 1];
        cols_20191124 = new int[n];
        queen_20191124 = new int[n];
        result_20191124 = new LinkedList<>();
        // 从第0行开始递归
        helper_20191124(0, n);
        return result_20191124;
    }

    private void helper_20191124(int row,  int n) {
        // termination
        if (row == n) {
            result_20191124.add(addResult_20191124(queen_20191124));
            return;
        }
        // process
        for (int c = 0; c < n; c ++) {
            if (pie[row + c] == 0 && na[row - c + n] == 0 && cols_20191124[c] == 0) {
                pie[row + c] = 1;
                na[row - c + n] = 1;
                cols_20191124[c] = 1;
                queen_20191124[row] = c;
                helper_20191124(row + 1, n);
                pie[row + c] = 0;
                na[row - c + n] = 0;
                cols_20191124[c] = 0;
                queen_20191124[row] = 0;
            }
        }
        // drill down
        // reverse
    }

    private List<String> addResult_20191124(int[] queen) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < queen.length; i ++) {
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < queen[i]; j ++) {
                buffer.append(".");
            }
            buffer.append("Q");
            for (int j = queen[i] + 1;j < queen.length; j ++) {
                buffer.append(".");
            }
            result.add(buffer.toString());
        }
        return result;
    }


}
