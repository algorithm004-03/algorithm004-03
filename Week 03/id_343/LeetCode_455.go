func findContentChildren(g []int, s []int) int {
    sort.Ints(g)
    sort.Ints(s)
    i, j, ret := 0, 0, 0
    
    for i < len(g) && j < len(s) {
        if s[j] >= g[i] {
            ret++
            i++
            j++
        } else {
            j++
        }
    }
    
    return ret
}
