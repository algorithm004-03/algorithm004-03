package week02

func groupAnagrams(strs []string) [][]string {

	group := make(map[string][]string)
	for _, e := range strs {

		// 将字符串转换为 map 的 key 值
		key := generateKey(e)

		group[key] = append(group[key], e)
	}

	// 将 map 统计的异位词转化切片
	res := make([][]string, 0, len(group))
	for _, v := range group {
		res = append(res, v)
	}

	return res
}

func generateKey(s string) string {
	r := make([]rune, 26)
	for _, e := range s {
		r[e-'a']++
	}

	return string(r)
}
