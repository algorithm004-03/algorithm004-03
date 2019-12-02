
type byteSlice []byte

func (b byteSlice) Len() int           { return len(b) }
func (b byteSlice) Less(i, j int) bool { return b[i] < b[j] }
func (b byteSlice) Swap(i, j int)      { b[i], b[j] = b[j], b[i] }

func GroupAnagrams(strs []string) [][]string {
	group := make(map[string][]string)
	for _, str := range strs {
		b := byteSlice(str)
		sort.Sort(b)
		key := string(b)
		group[key] = append(group[key], str)
	}

	var res [][]string
	for _, v := range group {
		res = append(res, v)
	}

	return res
}
