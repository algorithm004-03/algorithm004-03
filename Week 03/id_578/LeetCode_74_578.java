package com.hand.week3;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/2
 */
public class LeetCode_74_578 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int tmp = matrix[mid / n][mid % n];
            if (target == tmp) return true;
            if (target > tmp) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
