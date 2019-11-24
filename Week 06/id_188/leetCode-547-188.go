//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集

//leetcode submit region begin(Prohibit modification and deletion)
func findCircleNum(M [][]int) int {
	//  使用并查集
	u := NewUFS(len(M))
	for i := 0; i < len(M); i++ {
		for j := i + 1; j < len(M); j++ {
			if M[i][j] == 0 {
				continue
			}
			u.Union(i, j)
		}
	}
	//  查找朋友圈个数
	m := make(map[int]struct{})
	for i := 0; i < len(M); i++ {
		m[u.Find(i)] = struct{}{}
	}
	return len(m)
}

type UFS struct {
	s  []int
	sz []int
}

func NewUFS(n int) *UFS {
	s := make([]int, n)
	sz := make([]int, n)
	for i := 0; i < len(s); i++ {
		s[i] = i
		sz[i] = 1
	}
	return &UFS{s: s, sz: sz}
}

func (u *UFS) Find(n int) int {
	if n > len(u.s) || n < 0 {
		return -1
	}
	r, j := u.s[n], n
	for r != j {
		j = r
		r = u.s[j]
	}
	//  压缩路径
	p := 0
	for u.s[n] != n {
		p = u.s[n]
		u.s[n] = r
		n = p
	}
	return r
}

func (u *UFS) Union(i int, j int) {
	p := u.Find(i)
	q := u.Find(j)
	if p == q {
		return
	}
	if u.sz[p] < u.sz[q] {
		u.s[p] = q
		u.sz[q] += u.sz[p]
	} else {
		u.s[q] = p
		u.sz[p] += u.sz[q]
	}
}

//leetcode submit region end(Prohibit modification and deletion)
