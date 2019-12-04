func totalNQueens(n int) int {
	if n <= 0 {
		return 0
	}

	size := (1 << uint(n)) - 1
	return countNQueens(n, size, 0, 0, 0, 0)
}

func countNQueens(n, size, row, col, leftSlash, rightSlash int) int {
	if row >= n {
		return 1
	}

	poses := (^(col | leftSlash | rightSlash)) & size
	cnt := 0
	for poses != 0 {
		pos := poses & (-poses)
		cnt += countNQueens(n, size, row+1, col|pos, (leftSlash|pos)<<1, (rightSlash|pos)>>1)
		poses = poses & (poses - 1)
	}

	return cnt
}
