class Solution(object):
    def numIslands(self, grid):
        """
        岛屿数量：https://leetcode-cn.com/problems/number-of-islands/
        
        :type grid: List[List[str]]
        :rtype: int
        """
        # 导弹轰炸法，每遇到一个岛屿，dfs法炸平整个岛
        # 到最后看看用了几个导弹就是有几个岛屿
        def dfs(x, y):
            if grid[x][y] == '0':
                return 0
            grid[x][y] = '0'
            for i in range(len(dx)):
                new_x, new_y = x + dx[i], y + dy[i]
                if 0 <= new_x < len(grid) and 0 <= new_y < len(grid[0]):
                    dfs(new_x, new_y)
            return 1
        dx = [-1, 1, 0, 0]
        dy = [0 ,0 ,-1, 1]
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1': 
                    islands += dfs(i, j)
        return islands

        