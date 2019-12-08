func findCircleNum(M [][]int) int {
	n := len(M)
	if n == 0 || len(M[0]) != n {
		return 0
	}

	d := NewDisjointSet(n)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if M[i][j] == 1 {
				d.Union(i, j)
			}
		}
	}

	return d.SetCnt()
}

type DisjointSet struct {
	parents []int
	setCnt  int
}

func NewDisjointSet(n int) *DisjointSet {
	set := DisjointSet{}
	set.parents = make([]int, n)
	for i := range set.parents {
		set.parents[i] = i
	}

	set.setCnt = n
	return &set
}

func (d *DisjointSet) Union(p, q int) {
	rootP, rootQ := d.findRoot(p), d.findRoot(q)
	if rootP == rootQ {
		return
	}

	d.parents[rootQ] = rootP
	d.setCnt--
}

func (d *DisjointSet) SetCnt() int {
	return d.setCnt
}

func (d *DisjointSet) findRoot(p int) int {
	parent := d.parents[p]
	for parent != p {
		newParent := d.parents[parent]
		d.parents[p] = newParent
		p = parent
		parent = newParent
	}

	return parent
}
