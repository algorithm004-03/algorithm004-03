#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#

# @lc code=start
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]: return 0
        M, N = len(grid), len(grid[0])
        q = deque()
        res = 0
        for i in range(M):
            for j in range(N):
                if grid[i][j] == '1':
                    res += 1
                    self.sink(grid, i, j, M, N)
        return res

    def sink(self, grid, i, j, M, N):
        grid[i][j] = '0'
        q = deque([(i, j)])
        directions = ((0, 1), (0, -1), (1, 0), (-1, 0))
        while q:
            x, y = q.pop()
            for d in directions:
                nx, ny = x + d[0], y + d[1]
                if 0 <= nx < M and 0 <= ny < N and grid[nx][ny] == '1':
                    grid[nx][ny] = '0'
                    q.append((nx, ny))
        
# @lc code=end

