# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/3/2019
from collections import deque
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        count = 0
        # create a logic grid, initially all False
        check = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1" and not check[i][j]:
                    count += 1
                    self.helper(grid, check, i, j)
        return count

    def helper(self, grid, check, i, j):
        queue = deque([(i, j)])
        while queue:
            i, j = queue.popleft()
            if 0 <= i < len(grid) and 0 <= j < len(grid[0]) and grid[i][
                j] == "1" and not check[i][j]:
                check[i][j] = True
                queue.extend([(i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)])
