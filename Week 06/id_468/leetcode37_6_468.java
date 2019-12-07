package week6;

/**
 * @program: leetcode
 * @description: 数独
 * @author: 王瑞全
 * @create: 2019-11-2423:24
 **/


public class leetcode37_6_468 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    for (char num = '1'; num <= '9'; num++){
                        if (isValid(i, j, board, num)){
                            board[i][j] = num;
                            if (solve(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(int i, int j, char[][] board, char num){
        for (int m = 0; m < 9; m++){
            // for the row
            if (board[i][m] == num) {
                return false;
            }

            // for the col
            if (board[m][j] == num) {
                return false;
            }

            // for the box
            int boxIndex = 3 *(i/3) + j/3;
            int boxX = 3 *(boxIndex/3), boxY = 3*(boxIndex%3); //first coordinates
            if (board[boxX + m/3][boxY + m%3] == num) {
                return false;
            }
        }
        return true;
    }
}
