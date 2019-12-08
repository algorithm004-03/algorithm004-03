#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#

# @lc code=start
from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        class UnionFind:
            def __init__(self, n):
                self.count = n
                self.parent = [i for i in range(n)]
                self.rank = [1 for _ in range(n)]
            def get_count(self):
                return self.count
            def find(self, p):
                while p != self.parent[p]:
                    self.parent[p] = self.parent[self.parent[p]]
                    p = self.parent[p]
                return p
            def is_connected(self, p, q):
                return self.find(p) == self.find(q)
            def union(self, p, q):
                p_root = self.find(p)
                q_root = self.find(q)
                if p_root == q_root:
                    return
                if self.rank[p_root] > self.rank[q_root]:
                    self.parent[q_root] = p_root
                elif self.rank[p_root] < self.rank[q_root]:
                    self.parent[p_root] = q_root
                else:
                    self.parent[q_root] = p_root
                    self.rank[p_root] += 1
                self.count -= 1
            
        row = len(grid)
        if row == 0:
            return 0
        def get_index(x, y):
            return x * col + y
        
        col = len(grid[0])
        directions = [(1, 0), (0, 1)]
        dummy_node = row * col
        uf = UnionFind(dummy_node + 1)
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '0':
                    uf.union(get_index(i, j), dummy_node)
                if grid[i][j] == '1':
                    for direction in directions:
                        new_x = i + direction[0]
                        new_y = j + direction[1]
                        if new_x < row and new_y < col and grid[new_x][new_y] == '1':
                            uf.union(get_index(i, j), get_index(new_x, new_y))
        return uf.get_count() - 1
        

'''
def numIslands(self, grid: List[List[str]]) -> int:
        ret = 0
        if not grid:
            return ret
        directions = ((0,1), (0,-1), (1, 0), (-1, 0))
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    ret += 1
                    q = collections.deque([(i, j)])
                    while q:
                        x, y = q.popleft()
                        for d in directions:
                            nx, ny = x + d[0], y + d[1]
                            if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]) and grid[nx][ny] == '1':
                                grid[nx][ny] = '0'
                                q.append((nx, ny))
        return ret
'''

'''
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]: return 0
        M, N = len(grid), len(grid[0])
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
'''
# @lc code=end

