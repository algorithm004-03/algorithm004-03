/*
思路

简单的递归搜索
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    static int[][] move = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1},
        {1, 1},
        {-1, 1},
        {-1, -1},
        {1, -1}
    };

    private boolean isValid(int i, int j, char[][] board) {
        return (i >= 0) && (i < board.length) && (j >= 0) && (j < board[0].length);
    }

    void dfs(int i, int j, char[][] board, Set<Integer> visited, boolean searchOnlyEmptyBLock) {
        if (searchOnlyEmptyBLock && board[i][j] != 'E') {
            return;
        }

        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }

        if (board[i][j] == 'E') {
            board[i][j] = 'B';

            int cnt = 0;
            for (int ii = 0; ii < move.length; ii++) {
                int pos_i = i + move[ii][0];
                int pos_j = j + move[ii][1];
                if (isValid(pos_i, pos_j, board)) {
                    if ((board[pos_i][pos_j] == 'M') || (board[pos_i][pos_j] == 'X')) {
                        cnt++;
                    }
                }
            }

            if (cnt != 0) {
                board[i][j] = (char)('0' + cnt);
                return;
            }


            for (int ii = 0; ii < move.length; ii++) {
                if (isValid(i + move[ii][0], j + move[ii][1], board)) {
                    int idx = (i + move[ii][0]) * board[0].length + (j + move[ii][1]);
                    if (visited.contains(idx)) {
                        continue;
                    }

                    visited.add(idx);
                    dfs(i + move[ii][0], j + move[ii][1], board, visited, true);
                }
            }
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        char[][] result = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            result[i] = Arrays.copyOf(board[i], board[i].length);
        }

        dfs(click[0], click[1], result, new HashSet<Integer>(), false);

        return result;
    }

    public static void main(String[] args) {
        new Solution().updateBoard(new char[][] {
                {'E','E','E','E','E'},
                {'E','E','M','E','E'},
                {'E','E','E','E','E'},
                {'E','E','E','E','E'},
        }, new int[] {3, 0});
    }
}