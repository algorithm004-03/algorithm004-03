package com.company.leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
// 示例 1:
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
//
//
// 示例 2:
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false
// Related Topics 数组 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) {
                return false;
            }
        }

        //判断在哪一行
        int leftIndex = 0;
        int rightIndex = matrix.length - 1;
        int len = matrix[matrix.length - 1].length;

        //边界处理
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][len - 1]) {
            return false;
        }

        int targetRow = -1;
        if (matrix[rightIndex][0] <= target) {
            targetRow = matrix.length - 1;
        } else {
            while (leftIndex < rightIndex) {
                int mid = leftIndex + (rightIndex - leftIndex) / 2;
                len = matrix[mid].length;
                if (matrix[mid][len - 1] == target) {
                    return true;
                }
                if (matrix[mid][len - 1] < target) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid;
                }
            }
            targetRow = rightIndex;
        }

        //从targart row查找
        int[] row = matrix[targetRow];
        int left = 0;
        int right = row.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == target) {
                return true;
            }

            if (row[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == right && row[left] == target) {
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//
//        int[] row0 = new int[]{1,   3,  5,  7};
//        int[] row1 = new int[]{10, 11, 16, 20};
//        int[] row2 = new int[]{23, 30, 34, 50};
////        int[] row0 = new int[]{1,3};
////        int[][] martrix = new int[][]{row0};
//
//        int[][] martrix = new int[][]{row0,row1,row2};
//
//        boolean res = s.searchMatrix(martrix,20);
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
