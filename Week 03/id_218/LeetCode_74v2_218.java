package leetcode.week3;

/**
 * @author eason.feng at 2019/11/3/0003 18:35
 **/
public class LeetCode_74v2_218 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if(matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
