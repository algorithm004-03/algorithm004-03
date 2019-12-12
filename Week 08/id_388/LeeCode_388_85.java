package com.company.leetcode.editor.cn;
//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 示例:
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6
// Related Topics 栈 数组 哈希表 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_85 {
    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int maxarea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '0') {
                    continue;
                }

                //update width
                dp[i][j] = j == 0 ? 1 : (dp[i][j - 1] + 1);
                int width = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    width = Math.min(width,dp[k][j]);
                    maxarea = Math.max(maxarea,width * (i - k + 1));
                }
            }
        }

        return maxarea;

    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//
//        char[][] matrix = new char[][]{
//                new char[]{'1','0','1','0','0'},
//                new char[]{'1','0','1','1','1'},
//                new char[]{'1','1','1','1','1'},
//                new char[]{'1','0','0','1','0'}
//        };
//
//        System.out.println(s.maximalRectangle(matrix));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
