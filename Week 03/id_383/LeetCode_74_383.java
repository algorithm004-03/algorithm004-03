public class LeetCode_74_383 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;

        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = matrix[mid / n][mid % n];
            if (value == target) return true;
            if (target < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
