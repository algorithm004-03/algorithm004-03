package id_313

import "strconv"

func robotSim(commands []int, obstacles [][]int) int {
	var ret = 0
	var dx = [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	var k = 0
	m := make(map[string]bool, len(obstacles))
	for i := 0; i < len(obstacles); i++ {
		key := strconv.Itoa(obstacles[i][0]) + "," + strconv.Itoa(obstacles[i][1])
		m[key] = true
	}
	x, y := 0, 0
	for _, command := range commands {
		if command == -1 {
			k = (k + 1) % 4
		} else if command == -2 {
			k = (k + 4 - 1) % 4
		} else {
			cur := dx[k]
			for i := 0; i < command; i++ {
				key := strconv.Itoa(x+cur[0]) + "," + strconv.Itoa(y+cur[1])
				_, ok := m[key]
				if ok {
					break
				}
				x += cur[0]
				y += cur[1]
			}
			ret = max(ret, x*x+y*y)
		}
	}
	return ret
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
