func findCircleNum(M [][]int) int {
    if len(M) <= 1 {
        return len(M)
    }
    
    count := 0
    visited := make([]bool, len(M))
    
    for i, _ := range M {
        if visited[i] == false {
            BFS(M, visited, i)
            count++
        }
    }
    
    return count
}

func BFS(M [][]int, visited []bool, c int) {
    q := make([]int, 0)
    q = append(q, c)
    visited[c] = true
    
    for len(q) > 0 {
        c = q[0]
        q = q[1:]
        
        for i := 0; i < len(M); i++ {
            if M[c][i] == 1 && visited[i] == false {
                visited[i] = true
                q = append(q, i)
            }
        }
    }
}
