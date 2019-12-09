/**
 * 不同路径存在障碍物的情况
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * @author L
 *
 */
public class LeetCode_63_138 {
	/**
	 * 
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;//行
		int col = obstacleGrid[0].length;//列
		if(obstacleGrid[0][0] == 1)
			return 0;
        //在当前数组上修改状态值
		obstacleGrid[0][0] = 1;
        for(int i=1;i<col;i++) {//初始化第一行
        	obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1)?1:0;//如果原始obstacleGrid[0][i]不是障碍物并且左侧(0,i-1)位置可行则当前位置可行
        }
        for(int i=1;i<row;i++) {
        	obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1)?1:0;//如果原始obstacleGrid[i][0]不是障碍物并且上方位置(i-1,0)可行则当前位置可行
        }
        
        for(int i=1;i<row;i++) {
        	for(int j=1;j<col;j++) {
        		if(obstacleGrid[i][j] == 0)//非障碍物
        			obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
        		else
        			obstacleGrid[i][j] = 0;//当前位置是障碍物
        	}
        }
        
        return obstacleGrid[row-1][col-1];
    }
}
