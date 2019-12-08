package id_313

func findWords(board [][]byte, words []string) []string {
	result := make([]string, 0)

	m := len(board)
	if m == 0 {
		return result
	}

	n := len(board[0])
	if n == 0 {
		return result
	}

	trie := buildTrie(words)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			dfs(board, i, j, trie, &result)
		}
	}
	return result
}

type Trie struct {
	childs [26]*Trie
	word   string
}

func buildTrie(words []string) *Trie {
	root := new(Trie)
	for _, word := range words {
		cur := root
		for _, c := range word {
			idx := c - 'a'
			if cur.childs[idx] == nil {
				cur.childs[idx] = new(Trie)
			}
			cur = cur.childs[idx]
		}
		cur.word = word
	}
	return root
}

func dfs(board [][]byte, i, j int, trie *Trie, result *[]string) {
	c := board[i][j]
	if c == '#' || trie.childs[c-'a'] == nil {
		return
	}
	trie = trie.childs[c-'a']
	if len(trie.word) > 0 {
		*result = append(*result, trie.word)
		trie.word = ""
	}

	board[i][j] = '#'
	if i > 0 {
		dfs(board, i-1, j, trie, result)
	}
	if i < len(board)-1 {
		dfs(board, i+1, j, trie, result)
	}
	if j > 0 {
		dfs(board, i, j-1, trie, result)
	}

	if j < len(board[0])-1 {
		dfs(board, i, j+1, trie, result)
	}

	board[i][j] = c
}
