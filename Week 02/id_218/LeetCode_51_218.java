package leetcode.week2;

import java.util.*;

/**
 * https://blog.csdn.net/piyongduo3393/article/details/86497081
 *
 * https://leetcode.com/problems/n-queens/
 * https://leetcode-cn.com/problems/n-queens/
 *
 * 撇坐标和恒等
 * 捺坐标差（列-行）恒等（ > 0）
 *
 * @author eason.feng at 2019/10/27/0027 15:32
 **/
public class LeetCode_51_218 {

    public static void main(String[] args) {
        LeetCode_51_218 leetCode_51_218 = new LeetCode_51_218();
        List<List<String>> res = leetCode_51_218.solveNQueens(4);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n == 0) {
            return res;
        }
        char[][] chs = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chs[i][j] = '.';
            }
        }
        backTracking(chs, 0, n, res);
        return res;
    }

    private void backTracking(char[][] chs, int row, int n, List<List<String>> res) {
        if (row == n) {
            res.add(chsToList(chs));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(chs, row, col)) {
                chs[row][col] = 'Q';
                //递归
                backTracking(chs, row + 1, n, res);
                //回溯
                chs[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] chs, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < chs[0].length; j++) {
                //遍历当前为皇后，坐标为(i, j) 域 (row, col) 的横纵坐标之差相等即为在一条斜线上。
                if (chs[i][j] == 'Q' && (j == col || Math.abs(row - i) == Math.abs(col -j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> chsToList(char[][] chs) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <chs[0].length; i++) {
            list.add(new String(chs[i]));
        }
        return list;
    }
}
