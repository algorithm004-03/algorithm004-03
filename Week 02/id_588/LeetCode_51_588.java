import java.util.ArrayList;
import java.util.List;

/**
 * n皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class LeetCode_51_588 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                chessboard[i][j] = '.';
            }
        }
        _solveHelper(chessboard, 0, list);
        return list;
    }

    private void _solveHelper(char[][] chessboard, int row, List<List<String>> list) {
        if (chessboard.length == row) {
            list.add(_buildListStringFromChessboard(chessboard));
            return;
        }

        for (int column = 0; column < chessboard.length; column ++) {
            if (_isValid(chessboard, row, column)) {
                chessboard[row][column] = 'Q';
                _solveHelper(chessboard, row + 1, list);
                // 解决了下一列的问题之后，将棋盘复原
                chessboard[row][column] = '.';
            }
        }
    }

    private boolean _isValid(char[][] chessboard, int row, int column) {
        if (row < 1) {
            return true;
        }

        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0 ; i --) {
            // 竖直方向
            if ('Q' == chessboard[i][column]) {
                return false;
            }
            // 左上角斜线
            if (leftUp >= 0) {
                if ('Q' == chessboard[i][leftUp]) {
                    return false;
                }
            }
            // 右上角斜线
            if (rightUp < chessboard.length) {
                if ('Q' == chessboard[i][rightUp]) {
                    return false;
                }
            }
            leftUp --;
            rightUp ++;
        }

        return true;
    }

    private List<String> _buildListStringFromChessboard(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chessboard.length; i++) {
            String s = new String(chessboard[i]);
            list.add(s);
        }
        return list;
    }


    public static void main(String[] args) {

        LeetCode_51_588 solution = new LeetCode_51_588();
        System.out.println(solution.solveNQueens(8));
    }

}
