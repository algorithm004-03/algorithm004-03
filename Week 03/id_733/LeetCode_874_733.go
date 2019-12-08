const (
	turnLeft = -2
	turnRight = -1
)

func robotSim(commands []int, obstacles [][]int) int {
	dx := []int{0, 1, 0, -1}
	dy := []int{1, 0, -1, 0}

	obs := make(map[int64]struct{}, len(obstacles))
	for _, co := range obstacles {
		obs[getKey(co[0], co[1])] = struct{}{}
	}

	idx := 0
	x, y, maxDis := 0, 0, 0
	for _, c := range commands {
		switch c {
		case turnLeft:
			idx = (idx + 3) % 4

		case turnRight:
			idx = (idx + 1) % 4

		default:
			for c > 0 {
				nx, ny := x+dx[idx], y+dy[idx]
				if _, ok := obs[getKey(nx, ny)]; ok {
					break
				}

				c--
				x, y = nx, ny
			}

			dis := x*x + y*y
			if dis > maxDis {
				maxDis = dis
			}
		}
	}

	return maxDis
}

func getKey(x, y int) int64 {
	return (int64(x) + 30000) << 16 + int64(y) + 30000
}
