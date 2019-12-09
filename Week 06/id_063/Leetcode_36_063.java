import java.util.HashSet;
import java.util.Set;


/*
思路

就是循环判断，没有什么特殊的地方

 */


class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            set1.clear();
            set2.clear();

            for (int j = 0; j < 9 ;j++) {
                if (set1.contains(board[i][j])) {
                    return false;
                }

                if (board[i][j] != '.') {
                    set1.add(board[i][j]);
                }

                if (set2.contains(board[j][i])) {
                    return false;
                }

                if (board[j][i] != '.') {
                    set2.add(board[j][i]);
                }
            }
        }

        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                int start_i = ii * 3;
                int start_j = jj * 3;

                set1.clear();
                for (int i = start_i; i < start_i + 3; i++) {
                    for (int j = start_j; j < start_j + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }

                        if (set1.contains(board[i][j])) {
                            return false;
                        }

                        if (board[i][j] != '.') {
                            set1.add(board[i][j]);
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().isValidSudoku(new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}});
    }
}
