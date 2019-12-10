package leetcode

func minDistance(word1 string, word2 string) int {

	if word1 == "" || word2 == "" {

		rt := len(word1) - len(word2)
		if rt < 0 {
			return -1 * rt
		}

		return rt
	}

}
