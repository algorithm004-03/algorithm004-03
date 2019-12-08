func minPathSum(grid [][]int) int {
	rowCount, columnCount := len(grid), len(grid[0])

	d := make([][]int, rowCount)
	for i := range d {
		d[i] = make([]int, columnCount)
	}

	d[0][0] = grid[0][0]
	for c := 1; c < columnCount; c++ {
		d[0][c] = d[0][c-1] + grid[0][c]
	}
	for r := 1; r < rowCount; r++ {
		d[r][0] = d[r-1][0] + grid[r][0]
	}

	for r := 1; r < rowCount; r++ {
		for c := 1; c < columnCount; c++ {
			d[r][c] = min(d[r-1][c], d[r][c-1]) + grid[r][c]
		}
	}

	return d[rowCount-1][columnCount-1]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}