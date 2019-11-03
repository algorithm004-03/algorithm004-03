func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordDict := make(map[string]struct{})
	for _, w := range wordList {
		wordDict[w] = struct{}{}
	}

	if _, ok := wordDict[endWord]; !ok {
		return 0
	}

	delete(wordDict, endWord)

	visited := make(map[string]struct{})
	begin := make(map[string]struct{})
	end := make(map[string]struct{})

	begin[beginWord] = struct{}{}
	end[endWord] = struct{}{}

	step := 2
	for len(begin) > 0 && len(end) > 0 {
		if len(end) < len(begin) {
			begin, end = end, begin
		}

		newBegin := make(map[string]struct{})
		for w, _ := range begin {
			chars := []rune(w)
			for i := 0; i < len(chars); i++ {
				origin := chars[i]
				for c := 'a'; c <= 'z'; c++ {
					chars[i] = c
					s := string(chars)
					if _, ok := end[s]; ok {
						return step
					}

					if _, ok := visited[s]; ok {
						continue
					}

					if _, ok := wordDict[s]; !ok {
						continue
					}

					visited[s] = struct{}{}
					newBegin[s] = struct{}{}
				}

				chars[i] = origin
			}
		}

		begin = newBegin
		step++
	}

	return 0
}