/*
先用二分查找在哪一行，然后再在行内进行第二次二分查找
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return false;
        }

        int left = 0;
        int right = matrix.length - 1;

        int row = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length-1]) {
                row = mid;
                break;
            }

            else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (row == -1) {
            return false;
        }

        left = 0; right = matrix[row].length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (matrix[row][mid] == target) {
                return true;
            }

            if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}