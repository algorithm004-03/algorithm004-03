//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串

//leetcode submit region begin(Prohibit modification and deletion)
package main

func lengthOfLastWord(s string) int {
	counter := 0
	for i := len(s) - 1; i >= 0; i-- {
		str := string(s[i])
		if str != " " {
			counter++
		}
		if counter > 0 && str == " " {
			break
		}
	}
	return counter
}

//leetcode submit region end(Prohibit modification and deletion)
