package id_693;

import java.util.Arrays;

/**
 * @Desc 529. 扫雷游戏  https://leetcode-cn.com/problems/minesweeper/description/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/01
 */
public class LeetCode_529_693 {
    int[] xForWord = {-1, 1, -1, 1, 0, 1, -1, 0};
    int[] yForWord = {-1, 1, 1, -1, 1, 0, 0, -1};

    //dfs ，
    /*
    思路：
        1、判断当前是否有雷，有则修改返回
        2、专门检查周围雷的数量，如果有雷，修改当前坐标为雷数 并且返回
        2、如果没雷，则直接dfs修改周围的数据为对应的
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
            return;
        }
        int count = getThunderNumber(board, x, y);
        if (count == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < xForWord.length; i++) {
                int qx = x + xForWord[i];
                int qy = y + yForWord[i];
                dfs(board, qx, qy);
            }
        } else {
            board[x][y] = (char) ('0' + count);
        }
    }

    private int getThunderNumber(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < xForWord.length; i++) {
            int qx = x + xForWord[i];
            int qy = y + yForWord[i];
            if (qx < 0 || qx >= board.length || qy < 0 || qy >= board[0].length) {
                continue;
            }
            if (board[qx][qy] == 'M' || board[qx][qy] == 'X') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] b = new LeetCode_529_693().updateBoard(new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0});
        for (int i = 0; i < b.length; i++) {


            System.out.println(Arrays.toString(b[i]));
        }
    }
}
