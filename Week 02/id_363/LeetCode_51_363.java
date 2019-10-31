package com.test.leetcode.week02;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class SolutionNQueens51 {


    @Test
    public void test1() {
        System.out.println(solveNQueens(4));
    }

    /**
     * 1. 回溯
     * DFS
     * int[] 第一个数放在第一个 第二个数放在第二个
     * @param n
     * @return
     */


    int[] cols; // 表示那一列已经有值了
    int[] hill;
    int[] dale;
    int[] queens;
    int n = 0;
    List<List<String>> result = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new int[n];
        hill = new int[2 * n + 1];
        dale = new int[2 * n + 1];
        queens = new int[n];

        backtrace(0);
        return result;
    }

    private void backtrace(int row) {
        for (int col = 0; col < n; col ++) {
            if (ok(row, col)) {
                placeQueen(row, col);
                if (row + 1 == n) {
                    addResult(queens);
                }
                backtrace(row + 1);
                removeQueen(row, col);
            }
        }
    }

    private void removeQueen(int row, int col) {
        cols[col] = 0;
        hill[row + col] = 0;
        dale[row - col + n] = 0;
        queens[row]= 0;
    }

    private void addResult(int[] queens) {
        List<String> temp = new LinkedList<>();
        for (int i = 0; i < queens.length; i ++) {
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < queens[i]; j ++) {
                buffer.append(".");
            }
            buffer.append("Q");
            for (int j = queens[i] + 1; j < queens.length; j ++) {
                buffer.append(".");
            }
            temp.add(buffer.toString());
        }
        result.add(temp);
    }

    private void placeQueen(int row, int col) {
        cols [col] = 1;
        hill[row + col ] = 1;
        dale[row - col + n] = 1;
        queens[row] = col;
    }

    private boolean ok(int row, int col) {
        int res = cols[col] + hill[row + col] + dale[row - col + n];
        return res == 0;
    }


}
