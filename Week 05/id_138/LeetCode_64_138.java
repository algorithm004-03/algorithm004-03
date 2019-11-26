/**
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	说明：每次只能向下或者向右移动一步。
 * @author L
 *
 */
public class LeetCode_64_138 {

	/**
	 * 暴力法
	 * @param grid
	 * @return
	 */
	public int minPathSum_solution1(int[][] grid) {
        return minHelper(grid,0,0);
    }
	
	private int minHelper(int[][] grid, int i, int j) {
		if(i == grid.length || j == grid[0].length) {//从行的开头或者列的开头出发，默认最大
			return Integer.MAX_VALUE;
		}
		if(i == grid.length-1 && j == grid[0].length-1)//右下角出发最小值即当前值
			return grid[i][j];
		
		return grid[i][j]+Math.min(minHelper(grid, i+1, j), minHelper(grid, i, j+1));
	}
	
	/**
	 * 动态规划解决
	 * 1 归纳出重复子问题 
	 * 2 动态规划状态定义
	 * 3 动态规划方程 dp[i][j] = grid[i][j]+min(dp[i+1][j],dp[i][j+1])
	 * @param grid
	 * @return
	 */
	public int minPathSum_solution2(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		
		int row = grid.length;
		int col = grid[0].length;
		//定义dp状态为二维数组
		int dp [][] = new int[row][col]; //存放m,n位置对应的最小路径和，默认全为0
		
		for(int i=row-1;i>=0;i--) {
			for(int j=col-1;j>=0;j--) {//从右下角开始遍历处理
				if(i == row-1 && j != col-1) {//最后一行但不是最后一列,只能向右走
					dp[i][j] = grid[i][j] + dp[i][j+1];//当前的位置值+右侧最小值
				}
				else if(i != row-1 && j == col-1) {//最后一列但不是最后一行，只能向下走
					dp[i][j] = grid[i][j] + dp[i+1][j];//当前位置值+下方最小值
				}else if(i != row-1 && j != col-1){//不是最后一行也不是最后一列，既可以向右也可以向下
					dp[i][j] = grid[i][j]+ Math.min(dp[i+1][j], dp[i][j+1]);
				}else {//右下角的位置
					dp[i][j] = grid[i][j];
				}
			}
		}
		return dp[0][0];
	}
}
