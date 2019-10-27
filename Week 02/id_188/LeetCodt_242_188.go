/*
 * @lc app=leetcode.cn id=242 lang=golang
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
package leetCode

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	var counter [26]int
	sRuneArray, tRuneArray := []rune(s), []rune(t)
	for index := 0; index < len(sRuneArray); index++ {
		counter[sRuneArray[index]-'a']++
		counter[tRuneArray[index]-'a']--
	}
	for _, value := range counter {
		if value != 0 {
			return false
		}
	}
	return true
}

// @lc code=end
