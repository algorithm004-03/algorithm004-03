package id_713;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 */
public class LeetCode_51_NQueens {

    /*
    n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

    上图为 8 皇后问题的一种解法。

    给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

    每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

    示例:

    输入: 4
    输出: [
     [".Q..",  // 解法 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // 解法 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
    解释: 4 皇后问题存在两个不同的解法。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/n-queens
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    int rows[];
    int hills[]; // 撇
    int dales[]; // 捺
    int n;
    List<List<String>> output = new ArrayList<>();
    int queens[];

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.rows = new int[n];
        this.hills = new int[4 * n - 1];
        this.dales = new int[2 * n - 1];
        this.queens = new int[n];

        this.backtrace(0);
        return output;
    }

    private void backtrace(int row) {
        for (int col = 0; col < n; col++) {
            if (this.isNotUnderAttack(row, col)) {
                this.placeQueen(row, col);
                // 如果已经放置了
                if (row + 1 == n) this.addSulotion();
                else backtrace(row + 1);

                this.removeQueen(row, col);
            }
        }
    }


    private boolean isNotUnderAttack(int row, int col) {
        // 下一层正下方, 下一层撇, 下一层捺, 相加为0 则认为是不会被攻击
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return res == 0;
    }


    private void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n - 1] = 1;
        dales[row + col] = 1;
    }


    private void addSulotion() {
        List<String> solution = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < col; j++) {
                sb.append(".");
            }
            sb.append("Q");

            for (int j = 0; j < n - col - 1; j++) {
                sb.append(".");
            }
            sb.append("Q");
        }
        output.add(solution);

    }

    private void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n - 1] = 0;
        dales[row + col] = 0;
    }

}
