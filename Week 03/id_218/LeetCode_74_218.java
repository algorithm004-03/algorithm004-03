package leetcode.week3;

/**
 * @author eason.feng at 2019/11/3/0003 16:55
 **/
public class LeetCode_74_218 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                return binarySearch(matrix[row], target);
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (matrix[mid] == target) {
                return true;
            }
            if (matrix[mid] > target) {
                high = mid - 1;
            }
            if (matrix[mid] < target) {
                low = mid + 1;
            }
        }
        return false;
    }

}
