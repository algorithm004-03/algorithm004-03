const (
	mine = 'M'
	empty = 'E'
	blank = 'B'
	bomb = 'X'
)

func updateBoard(board [][]byte, click []int) [][]byte {
	height := len(board)
	if height == 0 {
		return board
	}

	width := len(board[0])
	if width == 0 {
		return board
	}

	if len(click) != 2 {
		return board
	}

	x, y := click[1], click[0]
	if x < 0 || x >= width || y < 0 || y >= height {
		return board
	}

	if board[y][x] == mine {
		board[y][x] = bomb
		return board
	}

	spread(board, x, y, width, height)
	return board
}

func spread(board [][]byte, x, y, w, h int) {
	if board[y][x] != empty {
		return
	}

	xl := max(x-1, 0)
	xr := min(x+1, w-1)
	yu := max(y-1, 0)
	yd := min(y+1, h-1)

	cnt := 0
	for i := xl; i <= xr; i++ {
		for j := yu; j <= yd; j++ {
			if board[j][i] == mine {
				cnt++
			}
		}
	}

	if cnt > 0 {
		board[y][x] = byte('0' + cnt)
		return
	}

	board[y][x] = blank
	for i := xl; i <= xr; i++ {
		for j := yu; j <= yd; j++ {
			spread(board, i, j, w, h)
		}
	}
}

func max(x, y int) int {
	if x > y {
		return x
	}

	return y
}

func min(x, y int) int {
	if x > y {
		return y
	}

	return x
}
