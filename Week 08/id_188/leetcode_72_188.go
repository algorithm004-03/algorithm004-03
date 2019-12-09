//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
// 示例 1:
//
// 输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释:
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2:
//
// 输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释:
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
// Related Topics 字符串 动态规划

//leetcode submit region begin(Prohibit modification and deletion)
package main

func minDistance(word1 string, word2 string) int {
	if len(word1) == 0 {
		return len(word2)
	}

	word1Len, word2Len := len(word1), len(word2)
	dp := make([][]int, word1Len+1)

	for index, _ := range dp {
		dp[index] = make([]int, word2Len+1)
		dp[index][0] = index
	}

	for index, _ := range dp[0] {
		dp[0][index] = index
	}

	for i := 1; i <= word1Len; i++ {
		for j := 1; j <= word2Len; j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = min(
					dp[i-1][j],
					dp[i][j-1],
					dp[i-1][j-1]) + 1
			}
		}
	}

	return dp[word1Len][word2Len]
}

func min(value1, value2, value3 int) int {
	ret := value1
	if ret > value2 {
		ret = value2
	}
	if ret > value3 {
		ret = value3
	}
	return ret
}

//leetcode submit region end(Prohibit modification and deletion)
