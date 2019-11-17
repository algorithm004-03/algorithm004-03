package Week03;

/**
 * @Date 2019/11/2.
 * @see <a href="74">https://leetcode-cn.com/problems/search-a-2d-matrix/</a>
 * 搜索二维矩阵
 */
public class LeetCode_74_558 {
    /**
     * 核心：
     * 二维矩阵中间值坐标：matrix[pivotIdx / n][pivotIdx % n]
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;

    }
}
