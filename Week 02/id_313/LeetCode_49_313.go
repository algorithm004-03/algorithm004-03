package id313

import (
	"sort"
)

// 对数据进行排序然后再分组处理
func groupAnagrams(strs []string) [][]string {
	ret := make([][]string, 0)
	strMap := make(map[string]int, 0)
	for _, s := range strs {
		bs := []byte(s)
		sort.Slice(bs, func(i, j int) bool {
			return bs[i] < bs[j]
		})
		ss := string(bs)
		if index, ok := strMap[ss]; ok {
			ret[index] = append(ret[index], s)
		} else {
			strMap[ss] = len(ret)
			ret = append(ret, []string{s})
		}
	}
	return ret
}
