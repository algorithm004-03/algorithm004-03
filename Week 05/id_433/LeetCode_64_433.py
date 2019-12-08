from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        for m in range(len(grid)):
            for n in range(len(grid[0])):
                if m > 0 and n > 0:
                    grid[m][n] += min(grid[m-1][n], grid[m][n-1])
                elif m == 0 and n > 0:
                    grid[m][n] += grid[m][n-1]
                elif m > 0 and n == 0:
                    grid[m][n] += grid[m-1][n]

        return grid[-1][-1]
