package id_313

// 针对word中单个字母进行替换
//
func ladderLength(beginWord string, endWord string, wordList []string) int {
	ret := 0
	queue := make([]string, 0)
	queue = append(queue, beginWord)
	wordMap := make(map[string]bool)
	for _, word := range wordList {
		wordMap[word] = true
	}
	if !wordMap[endWord] {
		return 0
	}
	for len(queue) > 0 {
		ret++
		length := len(queue)
		for i := 0; i < length; i++ {
			beginWord := queue[0]
			queue = queue[1:]
			for k := 0; k < len(beginWord); k++ {
				current := []byte(beginWord)
				tmp := beginWord
				for j := 'a'; j <= 'z'; j++ {
					current[k] = byte(j)
					word := string(current)
					if wordMap[string(current)] {
						if endWord == word {
							return ret + 1
						}
						queue = append(queue, word)
						delete(wordMap, word)
					}
				}
				beginWord = tmp
			}

		}
	}
	return 0
}
