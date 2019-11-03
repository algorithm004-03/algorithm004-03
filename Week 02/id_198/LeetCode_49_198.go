package leetcode

import "sort"

func groupAnagrams(strs []string) [][]string {

	m := make(map[string][]string)
	for _, v := range strs {

		r := []rune(v)
		sort.SliceStable(r, func(i int, j int) bool {

			return r[i] > r[j]
		})
		order := string(r)
		m[order] = append(m[order], v)
	}
	var rt = [][]string{}
	for _, value := range m {

		rt = append(rt, value)
	}
	return rt
}
