/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int rows = matrix.length;
        if(rows == 0 ){
            return false;
        }
        int cols = matrix[0].length;
        int right = rows * cols - 1;
        int midIndex,midValue;
        while(left <= right){
            midIndex = left + (right - left) / 2;
            midValue = matrix[midIndex / cols][midIndex % cols];

            if(target == midValue){
                return true;
            }else if(target > midValue){
                left = midIndex + 1;
            }else {
                right = midIndex - 1 ;
            }
        }



        return false;

    }
}
// @lc code=end

