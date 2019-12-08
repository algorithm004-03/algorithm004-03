var A byte = 'a'
var Used byte = '*'
var	dx = []int{-1, 0, 1, 0}
var dy = []int{0, -1, 0, 1}

func findWords(board [][]byte, words []string) []string {
	var res []string
	h := len(board)
	if h == 0 {
		return res
	}

	w := len(board[0])
	if w == 0 {
		return res
	}

	root := initTrie(words)
	resMap := make(map[string]struct{})
	for i := 0; i < w; i++ {
		for j := 0; j < h; j++ {
			doFindWords(board, root, resMap, i, j, w, h)
		}
	}

	for k, _ := range resMap {
		res = append(res, k)
	}

	return res
}

func doFindWords(board [][]byte, node *TrieNode, resMap map[string]struct{}, x, y, w, h int) {
	if x < 0 || x >= w || y < 0 || y >= h {
		return
	}

	cur := board[y][x]
	if cur == Used {
		return
	}

	node = node.SearchNode(cur)
	if node == nil {
		return
	}

	if node.IsWord {
		resMap[node.Word] = struct{}{}
	}

	board[y][x] = Used
	for i := 0; i < len(dx); i++ {
		nx, ny := x+dx[i], y+dy[i]
		doFindWords(board, node, resMap, nx, ny, w, h)
	}

	board[y][x] = cur
}

func initTrie(words[] string) *TrieNode {
	t := NewTrieNode()
	for _, w := range words {
		t.Insert(w)
	}

	return t
}

type TrieNode struct {
	nodes  []*TrieNode
	IsWord bool
	Word   string
}

func NewTrieNode() *TrieNode {
	t := TrieNode{}
	t.nodes = make([]*TrieNode, 26)
	return &t
}

func (t *TrieNode) Insert(word string) {
	node := t
	for i := 0; i < len(word); i++ {
		idx := word[i] - A
		if node.nodes[idx] == nil {
			node.nodes[idx] = NewTrieNode()
		}

		node = node.nodes[idx]
	}

	node.IsWord = true
	node.Word = word
}

func (t *TrieNode) SearchNode(b byte) *TrieNode {
	return t.nodes[b - A]
}
