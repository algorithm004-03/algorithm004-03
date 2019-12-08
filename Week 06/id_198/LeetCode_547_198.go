package leetcode

type UF struct {
	parent []int
	count  int
}

func NewUF(n int) *UF {

	uf := &UF{parent: make([]int, n), count: n}
	for i := 0; i < n; i++ {

		uf.parent[i] = i
	}
	return uf
}

func (uf *UF) find(i int) int {
	if uf.parent[i] != i {

		uf.parent[i] = uf.find(uf.parent[i])
	}
	return uf.parent[i]
}

func (uf *UF) union(i, j int) {
	x := uf.find(i)
	y := uf.find(j)
	if x != y {
		uf.parent[x] = y
		uf.count = uf.count - 1
	}
}
func findCircleNum(M [][]int) int {

	if len(M) == 0 {

		return 0
	}
	l := len(M)
	uf := NewUF(l)
	for i := 0; i < l; i++ {
		for j := 0; j < l; j++ {
			if M[i][j] == 1 && i != j {
				uf.union(i, j)
			}
		}
	}
	return uf.count
}
