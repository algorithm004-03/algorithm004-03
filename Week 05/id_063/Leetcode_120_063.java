/*
        DP算法解决
        递推公式  f[i][n] = min(f[i+1][n], f[i+1, n+1]) + num[i][n]
*/


import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[j] = (i == len - 1) ? triangle.get(i).get(j) : Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}