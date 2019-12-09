package week08

/**
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import "strconv"

func numDecodings(s string) int {
	if len(s) == 0 || s[0] == '0' {
		return 0
	}
	magic := make([]int, len(s)+1)
	magic[0], magic[1] = 1, 1
	for i := 2; i < len(s)+1; i++ {
		if s[i-1] != '0' {
			magic[i] += magic[i-1]
		}
		if s[i-2] != '0' {
			if v, _ := strconv.Atoi(s[i-2:i]); v <= 26 {
				magic[i] += magic[i-2]
			}
		}
	}
	return magic[len(s)]
}