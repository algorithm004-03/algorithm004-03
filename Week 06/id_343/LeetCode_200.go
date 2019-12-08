func numIslands(grid [][]byte) int {
    if grid == nil || len(grid) == 0{
        return 0
    }
    N := len(grid)
    M := len(grid[0])
    res := 0
    for i := 0;i<N;i++{
        for j := 0;j<M;j++{
            if grid[i][j] =='1'{
                res ++
                inflect(grid,i,j,N,M)
            }
        }
    }
    return res
}

func inflect(grid [][]byte,i,j,N,M int){
    if i<0 || i>=N ||j<0 ||j>=M||grid[i][j] != '1'{
        return 
    }
    grid[i][j] ='2'
    inflect(grid,i+1,j,N,M)
    inflect(grid,i-1,j,N,M)
    inflect(grid,i,j+1,N,M)
    inflect(grid,i,j-1,N,M)
    return 
}
