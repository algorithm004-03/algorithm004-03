public class LeetCode_63_568 {

	private int colNum;

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rowNum = obstacleGrid.length;
		int colNum = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		obstacleGrid[0][0] = 1;
		for (int i = 1; i < rowNum; i++) {
			obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
		}
		for (int i = 1; i < colNum; i++) {
			obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
		}
		for (int i = 1; i < rowNum; i++) {
			for (int j = 1; j < colNum; j++) {
				if (obstacleGrid[i][j] == 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}
		return obstacleGrid[rowNum-1][colNum-1];
	}
}
