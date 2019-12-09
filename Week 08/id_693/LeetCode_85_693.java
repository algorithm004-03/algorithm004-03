package id_693;

import java.util.Arrays;

/**
 * @Author 李雷（KyLin）
 * @Desc 85. 最大矩形	https://leetcode-cn.com/problems/maximal-rectangle/
 * @Date 2019/12/04
 */
public class LeetCode_85_693 {
    /**
     * 动态规划 - 每个点的最大高度
     */
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[] leftMin = new int[n];
            int[] rightMin = new int[n];
            int[] height = new int[n];
            Arrays.fill(leftMin,-1);
            Arrays.fill(rightMin,n);
            int areaMax = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        height[j] += 1;
                    } else {
                        height[j] = 0;
                    }
                }
                int boundary = -1;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        leftMin[j] = Math.max(leftMin[j],boundary);
                    } else {
                        leftMin[j] = -1;
                        boundary = j;
                    }
                }
                boundary = n;
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') {
                        rightMin[j] = Math.min(rightMin[j],boundary);
                    } else {
                        rightMin[j] = n;
                        boundary = j;
                    }
                }
                for (int j = 0; j < n; j++) {
                    int area = (rightMin[j] - leftMin[j] - 1) * height[j];
                    areaMax = Math.max(area,areaMax);
                }
            }
            return areaMax;
        }
    }
}
