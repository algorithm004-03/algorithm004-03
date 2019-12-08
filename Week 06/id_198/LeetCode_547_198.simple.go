package leetcode

func find(parent []int, i int) int {
	if parent[i] != i {

		parent[i] = find(parent, parent[i])
	}

	return parent[i]
}

func union(parent []int, i, j int) {
	x := find(parent, i)
	y := find(parent, j)
	if x != y {
		parent[y] = x
	}
}
func findCircleNum(M [][]int) int {

	if len(M) == 0 {

		return 0
	}
	l := len(M)
	parent := make([]int, l)
	for i := 0; i < l; i++ {
		parent[i] = i
	}
	for i := 0; i < l; i++ {
		for j := 0; j < l; j++ {
			if M[i][j] == 1 && i != j {
				union(parent, i, j)
			}
		}
	}
	count := 0
	for i := 0; i < l; i++ {
		if parent[i] == i {

			count++
		}
	}
	return count
}
