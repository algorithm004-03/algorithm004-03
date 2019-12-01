package id_693;

import org.junit.Assert;

/**
 * @Desc 74. 搜索二维矩阵	https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/03
 */
public class LeetCode_74_693 {
    //暴力求解0(M N)
    public boolean searchMatrix2(int[][] matrix,int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //暴力求解优化：因为有序，所以跳过最大值大于当前列的 0(M N)
    public boolean searchMatrix3(int[][] matrix,int target) {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (target > matrix[i][matrix[i].length - 1]) {
                    break;
                }
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //二分法; 找出区间范围，然后进行二分查找 O（M + log(N)） 当m远远大于n 时 这个效率很低
    public boolean searchMatrix4(int[][] matrix,int target) {
        for (int i = 0; i < matrix.length; i++) {
            int a = matrix[i].length - 1;
            if (a >= 0 && target >= matrix[i][0] && target <= matrix[i][a]) {
                int lo = 0;
                int hi = a;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (target == matrix[i][mid]) {
                        return true;
                    } else if (target > matrix[i][mid]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                return false;
            }

        }
        return false;
    }

    //指针法，直接用行列指针，  O(M + N)
    // 1、第一行最后一列开始，   如果行的 最后值小于目标值，行指针下移移行
    // 2、                    如果列的 当前值大于目标值，列指针左移一列
    public boolean searchMatrix5(int[][] matrix,int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

    //标准二分查找  O(log(mn))        这个效率比方法4 要更好一些
    public boolean searchMatrix(int[][] matrix,int target) {
        int cow = matrix.length;
        if (cow == 0) {
            return false;
        }
        int col = matrix[0].length;
        // 二分查找
        int left = 0;
        int right = cow * col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //pivotIdx / 列就可以索引在哪一行了。private % 列 就可以知道索引再哪一列，太完美了。超帅气
            int val = matrix[mid / col][mid % col];
            if (target == val) {
                return true;
            } else {
                if (target < val) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Assert.assertTrue(new LeetCode_74_693().searchMatrix(new int[][]{{1},{3}},3));
        Assert.assertFalse(new LeetCode_74_693().searchMatrix(new int[][]{{}},1));
        Assert.assertTrue(new LeetCode_74_693().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},3));
    }
}
