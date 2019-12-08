package com.company.leetcode.editor.cn;
//让我们一起来玩扫雷游戏！
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，
// 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
// 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
//
//
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。
//
//
//
//
// 示例 1：
//
// 输入:
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
//
//
// 示例 2：
//
// 输入:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
//
//
//
//
// 注意：
//
//
// 输入矩阵的宽和高的范围为 [1,50]。
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
// Related Topics 深度优先搜索 广度优先搜索


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        Set<String> visited = new HashSet<>();

        if (board[click[0]][click[1]] =='M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        dfs(board,visited,click[0],click[1]);

        return board;
    }

    private void dfs(char[][] board, Set<String> visited, int i, int j) {

        if (i == 5 && j == 0) {
            System.out.println(1);
        }

        if (i < 0 || i >= board.length) {
            return;
        }
        if (j < 0 || j >= board[i].length) {
            return;
        }

        if (visited.size() == board.length * board[0].length) {//// 如果在此次点击中，若无更多方块可被揭露，则返回面板。
            return;
        }

        String key = i + "#" + j;
        if (visited.contains(key)) {
            return;
        }

        //如果是雷
        visited.add(key);

        int[] x = new int[]{0,0,-1,1,-1,1,-1,1};
        int[] y = new int[]{-1,1,0,0,-1,-1,1,1};
        boolean needDfs = true;
        if (board[i][j] == 'M' || board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == 'E') {

            //计算周边地雷个数
            char mCount = '0';
            for (int k = 0; k < x.length; k++) {
                int row = i + x[k];
                int col = j + y[k];

                if (row < 0 || row >= board.length) {
                    continue;
                }
                if (col < 0 || col >= board[i].length) {
                    continue;
                }

                if (board[row][col] == 'M' || board[row][col] == 'X') {
                    mCount++;
                }
            }

            if (mCount != '0') {
                //周边有地雷
                board[i][j] = mCount;
                return;

            }
            //周边没有地雷
            board[i][j] = 'B';

            //上下左右对角线
            for (int k = 0; k < x.length; k++) {
                dfs(board,visited,i + x[k],j + y[k]);
            }
        }

        // 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
        // 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
        // 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
        // 如果在此次点击中，若无更多方块可被揭露，则返回面板。
    }

//    public static void main(String[] args) {
//
//        char[] row0 = new char[]{'B','B','B','B','1','M','M','E'};
//        char[] row1 = new char[]{'B','B','B','B','1','4','M','E'};
//        char[] row2 = new char[]{'B','B','B','B','B','3','M','E'};
//        char[] row3 = new char[]{'B','B','B','B','B','2','M','E'};
//        char[] row4 = new char[]{'1','2','2','1','B','1','1','1'};
//        char[] row5 = new char[]{'E','M','M','1','B','B','B','B'};
//        char[] row6 = new char[]{'E','E','E','2','2','2','2','1'};
//        char[] row7 = new char[]{'E','E','E','E','M','M','E','M'};
//
//        char[][] board = new char[][]{row0,row1,row2,row3,row4,row5,row6,row7};
//        Solution s = new Solution();
//        char[][] res = s.updateBoard(board,new int[]{7,2});
//
//        for (int i = 0; i < res.length; i++) {
//            System.out.println( String.valueOf(res[i]));
//        }
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
