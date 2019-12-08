# 学习总结
## 路径I
1. 题目：
[不同路径](https://leetcode-cn.com/problems/unique-paths/submissions/)
2. 状态数组：`dp[i][j]`
3. 状态转移方程：
> dp[i][j] = dp[i-1][j] + dp[i][j-1]
4. 代码实现：
```
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    //边界条件
    for(int i = 0;i < m;i++){
        dp[i][0] = 1;
    }
    for(int j = 0;j < n;j++){
        dp[0][j] = 1;
    }
    for(int i = 1;i < m;i++){
        for(int j = 1;j < n;j++){
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    return dp[m-1][n-1];
}
```
## 作业：路径II状态转移方程
1. 题目：
[不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)
2. 状态数组：`dp[i][j]`
3. 状态转移方程：
* 当i不为障碍物时，
> dp[i][j] = dp[i][j-1] + dp[i-1][j];
* 当i为障碍物时，
> dp[i][j] = 0;
4. 代码实现：
```
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    //起点为障碍
    if(obstacleGrid[0][0] == 1){
        return 0;
    }
    //边界条件
    obstacleGrid[0][0] = 1;
    for(int i = 1;i < m;i++){
        obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1)? 1:0;
    }
    for(int j = 1;j < n;j++){
        obstacleGrid[0][j] = (obstacleGrid[0][j]  == 0 && obstacleGrid[0][j-1] == 1)? 1:0;
    }
    for(int i = 1;i < m;i++){
        for(int j = 1;j < n;j++){
            obstacleGrid[i][j] = obstacleGrid[i][j] == 0? (obstacleGrid[i-1][j]+obstacleGrid[i][j-1]) : 0;
        }
    }
    return obstacleGrid[m-1][n-1];
}
```
  

