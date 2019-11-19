/*

思路
每次迭代求以第i层为底，第j层为顶的矩形中和不超过k的最大和
所有i j组合计算出来的最大值就是最后答案

对于一组i j的计算过程可以抽象成求取一维数组中和不超过K的连续子数组的
和的最大值


 */


class Solution {


    private int maxSubSum(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum < k) {
                    maxVal = Math.max(maxVal, sum);
                } else {
                    if (sum == k) {
                        return k;
                    }
                }
            }
        }

        return maxVal;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if ((matrix.length == 0) || (matrix[0].length == 0)) {
            return 0;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] nums = new int[colLen];
        int maxVal = Integer.MIN_VALUE;

        for (int top_i = 0; top_i < rowLen; top_i++) {
            for (int jj = 0; jj < colLen; jj++) {
                nums[jj] = 0;
            }

            for (int bottom_i = top_i; bottom_i < rowLen; bottom_i++) {
                for (int jj = 0; jj < colLen; jj++) {
                    nums[jj] += matrix[bottom_i][jj];
                }

                maxVal = Math.max(maxVal, maxSubSum(nums, k));
                if (maxVal == k) {
                    break;
                }
            }
        }

        return maxVal;
    }
}