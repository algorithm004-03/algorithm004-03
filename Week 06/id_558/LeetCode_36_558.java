package Week05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @see <a href="36">https://leetcode-cn.com/problems/valid-sudoku/submissions/</a>
 * 有效的数独
 */
public class LeetCode_36_558 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!isValid(i, j, row, col, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int i, int j, int row, int col, char[][] board) {
        if (board[i][j] == '.') return true;
        Set<Character> set = new HashSet<Character>();
        for (int k = 0; k < row; k++) {
            if (board[i][k] != '.') {
                if (set.contains(board[i][k])) {
                    return false;
                } else {
                    set.add(board[i][k]);
                }
            }
        }
        set.clear();
        for (int k = 0; k < col; k++) {
            if (board[k][j] != '.') {
                if (set.contains(board[k][j])) {
                    return false;
                } else {
                    set.add(board[k][j]);
                }
            }
        }
        Map<Integer, Set<Character>> map = new HashMap<Integer, Set<Character>>();
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if (board[m][n] != '.') {
                    char num = board[m][n];
                    int box_index = (m / 3) * 3 + n / 3;
                    Set<Character> s = map.get(box_index);
                    if (s != null) {
                        if (s.contains(num)) {
                            return false;
                        } else {
                            s.add(num);
                        }
                    } else {
                        s = new HashSet<Character>();
                        s.add(num);
                        map.put(box_index, s);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new LeetCode_36_558().isValidSudoku(board));
    }
}
