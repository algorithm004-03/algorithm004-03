package com.test.leetcode.week06;

import org.junit.Test;

/**
 * done 20191124
 * todo 20191125
 * todo 20191126
 * todo 20191201
 */
public class SolutionSurroundRegion130 {


    @Test
    public void test1() {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);
        System.out.println(board);
    }


    /**
     * 找到被x围绕的区域，并将这些区域里面的x转换成o
     * 被围绕的区域不会存在于边界
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length < 2) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                boolean isEdage = r == 0 || r == row - 1 || c == 0 || c == col - 1;
                if (isEdage && board[r][c] == 'O') {
                    helper(board, r, c);
                }
            }
        }
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }

            }
        }
    }

    // 把所有和外界联通的o转换成#
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    private void helper(char[][] board, int r, int c) {
        // termination
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        // process
        board[r][c] = '#';
        // drill down
        for (int k = 0; k < 4; k ++) {
            helper(board, r + dx[k], c + dy[k]);
        }
        // reverse

    }


}
