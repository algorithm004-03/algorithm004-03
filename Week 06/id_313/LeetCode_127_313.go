package id_313

func ladderLength(beginWord string, endWord string, wordList []string) int {
	beginSet := make(map[string]bool)
	endSet := make(map[string]bool)
	wordListSet := make(map[string]bool)
	visited := make(map[string]bool)
	length := 1

	for _, v := range wordList {
		wordListSet[v] = true
	}

	if !wordListSet[endWord] {
		return 0
	}
	beginSet[beginWord] = true
	endSet[endWord] = true

	for len(beginSet) != 0 && len(endSet) != 0 {

		if len(beginSet) > len(endSet) {
			beginSet, endSet = endSet, beginSet
		}

		temp := make(map[string]bool, 0)
		for word := range beginSet {
			for i := 0; i < len(word); i++ {
				curr := []byte(word)
				old := word
				for j := 'a'; j <= 'z'; j++ {
					curr[i] = byte(j)
					word = string(curr)
					if endSet[word] {
						return length + 1
					}
					if !visited[word] && wordListSet[word] {
						temp[word] = true
						visited[word] = true
					}
				}
				word = old
			}
		}

		beginSet = temp
		length++
	}
	return 0
}
