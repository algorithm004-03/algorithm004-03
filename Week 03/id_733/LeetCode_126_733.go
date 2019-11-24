func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	var res [][]string
	wordDict := make(map[string]struct{})
	for _, w := range wordList {
		wordDict[w] = struct{}{}
	}

	if _, ok := wordDict[endWord]; !ok {
		return res
	}

	delete(wordDict, endWord)

	visited := make(map[string]struct{})
	begin := make(map[string][][]string)
	end := make(map[string][][]string)
	flip := false

	begin[beginWord] = [][]string{{beginWord}}
	end[endWord] = [][]string {{endWord}}

	done := false
	for !done && len(begin) > 0 && len(end) > 0 {
		if len(end) < len(begin) {
			begin, end = end, begin
			flip = !flip
		}

		curVisited := make(map[string]struct{})
		newBegin := make(map[string][][]string)
		for word, beginPaths := range begin {
			chars := []rune(word)
			for i := 0; i < len(chars); i++ {
				origin := chars[i]
				for c := 'a'; c <= 'z'; c++ {
					chars[i] = c
					s:= string(chars)
					if endPath, ok := end[s]; ok {
						done = true
						addIntoFinalPaths(&res, beginPaths, endPath, flip)
					}

					if done {
						continue
					}

					if _, ok := wordDict[s]; !ok {
						continue
					}

					if _, ok := visited[s]; ok {
						continue
					}

					curVisited[s] = struct{}{}
					newBegin[s] = addIntoWordPaths(newBegin[s], beginPaths, s)
				}

				chars[i] = origin
			}
		}

		begin = newBegin
		for v, _ := range curVisited {
			visited[v] = struct{}{}
		}
	}

	return res
}

func addIntoWordPaths(wordPaths [][]string, paths [][]string, path string) [][]string {
	for _, ps := range paths {
		nps := make([]string, len(ps)+1)
		copy(nps, ps)
		nps[len(nps)-1] = path
		wordPaths = append(wordPaths, nps)
	}

	return wordPaths
}

func addIntoFinalPaths(finalPaths *[][]string,beginPaths, endPaths [][]string , flip bool) {
	if flip {
		beginPaths, endPaths = endPaths, beginPaths
	}

	for _, b := range beginPaths {
		for _, e := range endPaths {
			path := make([]string, len(b)+len(e))
			copy(path, b)
			i := len(path) - 1
			for _, p := range e {
				path[i] = p
				i--
			}

			*finalPaths = append(*finalPaths, path)
		}
	}
}
