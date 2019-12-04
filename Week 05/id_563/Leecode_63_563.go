/**
* 这题也太难了
*/

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	if len(obstacleGrid) == 0 || len(obstacleGrid[0]) == 0{return 0}
	m, n   := len(obstacleGrid), len(obstacleGrid[0])
	opt    := make([][]int, m)
	for index, _ := range opt {
		opt[index] = make([]int, n)
	}
	if obstacleGrid[0][0] == 0 {opt[0][0] = 1}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if obstacleGrid[i][j] == 1{continue}
			if j > 0 {opt[i][j] += opt[i][j-1]}
			if i > 0 {opt[i][j] += opt[i-1][j]}
		}
	}

	return opt[m-1][n-1]
}