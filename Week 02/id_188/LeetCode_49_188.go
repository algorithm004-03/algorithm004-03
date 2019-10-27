/*
 * @lc app=leetcode.cn id=49 lang=golang
 *
 * [49] 字母异位词分组
 */

// @lc code=start
package leetCode

import (
	"sort"
	"strings"
)

func groupAnagrams(strs []string) [][]string {
	if len(strs) == 0 {
		return [][]string{}
	}
	ret, cache := make([][]string, 0, len(strs)), make(map[string][]string, len(strs))
	for _, value := range strs {
		arr := strings.Split(value, "")
		sort.Strings(arr)
		key := strings.Join(arr, "")
		cache[key] = append(cache[key], value)
	}
	for _, value := range cache {
		ret = append(ret, value)
	}
	return ret
}

// @lc code=end
