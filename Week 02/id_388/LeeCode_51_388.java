package com.company.leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
// Related Topics 回溯算法


import javafx.util.Pair;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    private Set<Integer> col;
    private Set<Integer> pie;
    private Set<Integer> na;

    private List<List<String>> finalRes = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        col = new HashSet<>();
        pie = new HashSet<>();
        na = new HashSet<>();

        List board = this.generateBoard(n);
        helper(0,n,board);

        return finalRes;
    }

    private List<StringBuilder> generateBoard(int n){
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb);
        }
        return board;
    }

    private void helper(int row, int n,List<StringBuilder> board) {
        if (row >= n) {
            List<String> newBoard = new ArrayList<>();
            for (int i = 0; i < board.size(); i++) {
                newBoard.add(board.get(i).toString());
            }
            finalRes.add(newBoard);
            return;
        }
        //row
        for (int i = 0; i < n; i++) {
            //c
            if (col.contains(i)) {
                continue;
            }

            //bie
            if (this.pie.contains(row + i)) {
                continue;
            }

            //na
            if (this.na.contains(row - i)) {
                continue;
            }

            this.col.add(i);
            this.pie.add(row + i);
            this.na.add(row - i);

            board.get(row).replace(i,i + 1,"Q");

            helper(row + 1,n,board);

            //恢复状态
            board.get(row).replace(i,i + 1,".");
            this.col.remove(i);
            this.pie.remove(row + i);
            this.na.remove(row - i);

        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
