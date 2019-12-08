//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_64_628 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)return -1;
        //定义行列，dp数组
        int m = grid[0].length;
        int n = grid.length;
        int[][] dp = new int[n][m];
        //初始化dp数组
        dp[n-1][m-1]=grid[n-1][m-1];
        //--边界初始化
        for (int i = m-2; i >= 0 ; i--) {
            dp[n-1][i] = dp[n-1][i+1] + grid[n-1][i];
        }
        for (int i = n-2; i >= 0 ; i--) {
            dp[i][m-1] = dp[i+1][m-1] + grid[i][m-1];
        }
        //dp
        for (int i = n-2; i >=0 ; i--) {
            for (int j = m-2; j >= 0 ; j--) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])  + grid[i][j];
            }
        }

        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
