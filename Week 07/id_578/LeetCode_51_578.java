package com.hand.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/1
 */
public class LeetCode_51_578 {
    boolean[] col;
    boolean[] pie;
    boolean[] na;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        pie = new boolean[2 * n - 1];
        na = new boolean[2 * n - 1];
        char[][] board = new char[n][n];
        dfs(board, 0, n);
        return result;
    }

    private void dfs(char[][] board, int row, int n) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        Arrays.fill(board[row], '.');
        for (int i = 0; i < n; ++i) {
            if (!col[i] && !pie[row + i] && !na[i - row + n - 1]) {
                col[i] = true;
                pie[row + i] = true;
                na[i - row + n - 1] = true;
                board[row][i] = 'Q';
                dfs(board, row + 1, n);
                col[i] = false;
                pie[row + i] = false;
                na[i - row + n - 1] = false;
                board[row][i] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            list.add(new String(board[i]));
        }
        return list;
    }
}
