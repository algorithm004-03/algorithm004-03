/**
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class LeetCode_74_588 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        int column = matrix[0].length;
        int row = matrix.length;
        // 如果target小于左上角或者大于右下角，则找不到该target
        if (target < matrix[0][0] || target > matrix[row - 1][column - 1]) {
            return false;
        }

        // 先在第一列里面进行二分查找，找到第一个大于target的值
        int rowIndex = 0;
        int top = 0, bottom = row - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (target == matrix[mid][0]) {
                return true;
            }
            // 如果某一行的第一个元素小于target
            if (matrix[mid][0] < target) {
                // 如果这行是最后一行，则在最后一行里面进行二分搜索
                if (row - 1 == mid) {
                    rowIndex = mid;
                    break;
                } else {
                    top = mid + 1;
                }
            } else {
                if (0 == mid || matrix[mid - 1][0] < target) {
                    rowIndex = mid - 1;
                    break;
                } else {
                    bottom = mid - 1;
                }
            }
        }

        System.out.println(rowIndex);
        return normalBinarySearch(matrix[rowIndex], target);
    }

    public boolean normalBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        LeetCode_74_588 solution = new LeetCode_74_588();
        System.out.println(solution.searchMatrix(matrix, 3));
    }
}
