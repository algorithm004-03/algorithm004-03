class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        """
        二进制矩阵中的最短路径：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
        :type grid: List[List[int]]
        :rtype: int
        """
        # BFS
        n = len(grid)
        if grid[0][0] or grid[-1][-1]:
            return -1
        elif n <= 2:
            return n
        q = [(0, 0)]
        step = 0
        dx = [0, 0, 1, -1, 1, -1, 1, -1]
        dy = [1, -1, 0, 0, 1, -1, -1, 1]
        while q:
            step += 1
            l = []
            while q:
                l.append(q.pop())
            for i, j in l:
                for new_i, new_j in [(i - 1, j - 1), (i - 1, j), (i - 1, j + 1), (i, j - 1), (i, j + 1), (i + 1, j - 1),(i + 1, j), (i + 1, j + 1)]:
                    if new_j == new_i == n - 1:
                        return step + 1
                    if 0 <= new_i < n and 0 <= new_j < n and not grid[new_i][new_j]:
                        q.append((new_i, new_j))
                        grid[new_i][new_j] = 1
        return -1












