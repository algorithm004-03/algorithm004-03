package id_313

func numIslands(grid [][]byte) int {
	row := len(grid)
	if row == 0 {
		return 0
	}
	col := len(grid[0])

	x := make([]int, 0, row*col)
	y := make([]int, 0, row*col)
	var push = func(i, j int) {
		x = append(x, i)
		y = append(y, j)
		grid[i][j] = '0'
	}
	var pop = func() (int, int) {
		i := x[0]
		x = x[1:]
		j := y[0]
		y = y[1:]
		return i, j
	}
	var bfs = func(i, j int) int {
		if grid[i][j] == '0' {
			return 0
		}

		push(i, j)

		for len(x) > 0 {
			i, j = pop()
			// 当前坐标 四个方向
			if 0 <= i-1 && grid[i-1][j] == '1' {
				push(i-1, j)
			}
			if 0 <= j-1 && grid[i][j-1] == '1' {
				push(i, j-1)
			}
			if i+1 < row && grid[i+1][j] == '1' {
				push(i+1, j)
			}
			if j+1 < col && grid[i][j+1] == '1' {
				push(i, j+1)
			}
		}
		return 1
	}
	ret := 0
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			ret += bfs(i, j)
		}
	}
	return ret
}
