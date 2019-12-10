const water = '0'

var dx = []int{-1, 1, 0, 0}
var dy = []int{0, 0, -1, 1}

func NumIslands(grid [][]byte) int {
	return numIslands(grid)
}

func numIslands(grid [][]byte) int {
	height := len(grid)
	if height == 0 {
		return 0
	}

	width := len(grid[0])
	if width == 0 {
		return 0
	}

	cnt := 0
	for i := 0; i < width; i++ {
		for j := 0; j < height; j++ {
			cnt += searchIsland(grid, i, j, width, height)
		}
	}

	return cnt
}

func searchIsland(grid [][]byte, i, j, w, h int) int {
	if grid[j][i] == water {
		return 0
	}

	grid[j][i] = water
	for k := 0; k < len(dx); k++ {
		x, y := i+dx[k], j+dy[k]
		if x < 0 || x >= w || y < 0 || y >= h {
			continue
		}

		searchIsland(grid, x, y, w, h)
	}

	return 1
}
