package leetcode

func find(parents []int, i int) int {
	if parents[i] != i {

		parents[i] = find(parents, parents[i])
	}

	return parents[i]
}

func union(parents []int, x, y int) {
	xs := find(parents, x)
	ys := find(parents, y)
	if xs != ys {
		parents[ys] = xs
	}
}
func findCircleNum(M [][]int) int {

	if len(M) == 0 {

		return 0
	}
	l := len(M)
	parents := make([]int, l)
	for i := 0; i < l; i++ {
		parents[i] = i
		for j := 0; j < l; j++ {
			if M[i][j] == 1 && i != j {
				union(parents, i, j)
			}
		}
	}
	count := 0
	for i := 0; i < l; i++ {
		if parents[i] == i {

			count++
		}
	}
	return count
}
