package id_313

// 先bfs
// 再dfs
func findLadders(beginWord string, endWord string, words []string) [][]string {
	ret := make([][]string, 0)
	wordMap := make(map[string][]string, 0)
	isEnd := false
	cnt := 1
	// 删掉 beginword 减少循环
	for i, word := range words {
		if word == beginWord {
			words = append(words[:i], words[i+1:]...)
		}
	}
	var bfs func([]string, []string)
	bfs = func(words []string, nodes []string) {
		cnt++
		// 存储不可转换的数据
		newWords := make([]string, 0)
		// 存储可转换的 进行下一步bfs
		newNodes := make([]string, 0)
		for _, word := range words {
			isTransed := false
			for _, node := range nodes {
				if isTrans(word, node) {
					wordMap[node] = append(wordMap[node], word)
					isTransed = true
				}
			}
			if isTransed {
				newNodes = append(newNodes, word)
				if word == endWord {
					isEnd = true
				}
			} else {
				newWords = append(newWords, word)
			}
		}
		// 直到完成转换 或者 全部遍历完事
		if isEnd || len(newNodes) == 0 || len(newWords) == 0 {
			return
		}
		bfs(newWords, newNodes)
	}
	nodes := []string{beginWord}
	bfs(words, nodes)
	// 如果不可以转换 提前结束
	if !isEnd {
		return ret
	}
	path := make([]string, cnt)
	path[0] = beginWord
	var dfs func(int)
	dfs = func(index int) {
		if index == cnt {
			if path[index-1] == endWord {
				tmp := make([]string, cnt)
				copy(tmp, path)
				ret = append(ret, tmp)
			}
			return
		}
		prev := path[index-1]
		for _, word := range wordMap[prev] {
			path[index] = word
			dfs(index + 1)
		}
	}
	dfs(1)
	return ret
}

func isTrans(word, node string) bool {
	flag := false
	for i := range word {
		if word[i] != node[i] {
			if flag {
				return false
			}
			flag = true
		}
	}
	return true
}
