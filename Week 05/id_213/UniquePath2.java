class Solution {
//该题思路与不同路径1类似：自底向上遍历，当有障碍时，该位置没有可行走的方式数量。
//故其左位置或者上位置的方法数量加0即可。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for(int[] rows : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if(rows[j] == 1) 
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j-1];
            }
        }
       return dp[width - 1];
    }
}