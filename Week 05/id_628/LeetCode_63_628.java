//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_63_628 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //边界条件
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 0 || n == 0)return -1;
        //定义dp数组
        int[][] dp =  new int[m][n];
        //初始化dp数组

        dp[m-1][n-1] = obstacleGrid[m-1][n-1] != 0 ? 0 : 1;
        //--若不是障碍物则标记为1，若是障碍物则标记为0
        for (int i = m-2; i >= 0 ; i--) {
            dp[i][n-1] = obstacleGrid[i][n-1] != 0 ? 0 :  dp[i+1][n-1];
        }
        for (int i = n-2; i >= 0 ; i--) {

            dp[m-1][i] = obstacleGrid[m-1][i] != 0 ? 0 : dp[m-1][i+1];
        }
        //状态转移方程
        for (int i = m-2; i >= 0  ; i--) {
            for (int j = n-2; j >= 0  ; j--) {
                if(obstacleGrid[i][j] != 0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }

            }
        }
        return dp[0][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
