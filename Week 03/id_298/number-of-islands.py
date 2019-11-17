class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        # 定义当前位置的搜索方向
        directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]

        m = len(grid)
        if m == 0:
            return 0

        n = len(grid[0])
        marked = [[False for _ in range(n)] for _ in range(m)]

        # 统计岛的个数
        count = 0
        
        # 对网格进行深度优先搜索
        def _dfs(grid, i, j, m, n, marked):
            marked[i][j] = True
            for direction in directions:
                new_i = i + direction[0]
                new_j = j + direction[1]
                if 0 <= new_i < m and 0 <= new_j < n and not marked[new_i][new_j] and grid[new_i][new_j] == '1':
                    _dfs(grid, new_i, new_j, m, n, marked)

        # 网格搜索: 从第一个格子进行深度优先搜索
        for i in range(m):
            for j in range(n):
                # 是没被访问过的陆地则使用深度优先搜索进行标记 
                if not marked[i][j] and grid[i][j] == '1':
                    count += 1
                    _dfs(grid, i, j, m, n, marked)
        return count

