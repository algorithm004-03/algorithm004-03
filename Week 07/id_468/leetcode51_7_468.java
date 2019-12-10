package week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 王瑞全
 * @create: 2019-12-0122:18
 **/


public class leetcode51_7_468 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(n);
        solve(result, new int[n], 0, new char[n]);
        return result;
    }

    // rescursive solution
    void solve(List<List<String>> result, int[] board, int x, char[] buffer) {
        int n = board.length;
        if (x == n) {
            result.add(print(board, buffer));
            return;
        }
        for (int y=0; y < n; y++) {
            if (valid(board, x, y)) {
                board[x] = y;
                solve(result, board, x + 1, buffer);
            }
        }
    }

    // checks if the x,y is valid (only consideres left half of board)
    boolean valid(int[] board, int x, int y) {

        // horizontal going to the left
        for (int i=0; i < x; i++) {
            if (board[i] == y)
                return false;
        }

        // diagonal going up and to the left
        int cx = x-1, cy = y-1;
        while (cx >= 0 && cy >= 0) {
            if (board[cx] == cy)
                return false;
            cx--;
            cy--;
        }

        // diagonal going down and to the left
        cx = x-1; cy = y + 1;
        while (cx >= 0 && cy < board.length) {
            if (board[cx] == cy)
                return false;
            cx--;
            cy++;
        }

        return true;
    }

    // prints the board
    List<String> print(int[] board, char[] buffer) {
        int n = board.length;
        ArrayList<String> list = new ArrayList<>(n);
        for (int y=0; y < n; y++) {
            for (int x=0; x < n; x++) {
                buffer[x] = board[x] == y ? 'Q' : '.';
            }
            list.add(new String(buffer));
        }
        return list;
    }
}
