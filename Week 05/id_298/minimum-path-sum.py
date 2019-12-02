class Solution:
  def minPathSum(self, grid: List[List[int]]) -> int:
    for i in range(len(grid)):
      for j in range(len(grid[0])):
        if i == j == 0:
          continue
        elif i == 0:
          grid[i][j] = grid[i][j - 1] + grid[i][j]
        elif j == 0:
          grid[i][j] = grid[i - 1][j] + grid[i][j]
        else:
          grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
    return grid[-1][-1]

"""
[
  [1, 3, 1],
  [1, 5, 1],
  [4, 2, 1],
]
每次只能向下或者向右移动一步
最小路径和
原地DP:
i == j == 0: 处理第一个元素
i == 0时，处理列元组，也就是向右走，当前元素等于上一列加上当前元素
j == 0时，处理行元素，也就是向下走，党员元素等于前一行加上当前元素
除此之外的情况：
递推方程 f(i, j) = min(f(i-1, j), f(i, (j-1)) + f(x, y)
从左边和上面两个元素中选一个最小的，加上当前元素
"""
