class Solution:
  def numIslands(self, grid: List[List[str]]) -> int:
    self.f = {}
    if not grid:
      return 0

    rows = len(grid)
    cols = len(grid[0])

    for i in range(rows):
      for j in range(cols):
        # 如果当前元素为1，则看左上是否为1, 如果为1则union
        if grid[i][j] == '1':
          # (i - 1, y):前一个,左 (x, y - 1): 上一个,上
          for x, y in [(-1, 0), (0, -1)]:
            tmp_i = i + x
            tmp_j = j + y
            # 左，上为1则union
            if 0 <= tmp_i < rows and 0 <= tmp_j < cols and grid[tmp_i][tmp_j] == '1':
              union(tmp_i * cols + tmp_j, i * cols + j)

    result = set()
    for i in range(rows):
      for j in range(cols):
        # 遍历这个网格,如果当前元素为1则，则查找当前元素,并将结果添加到result
        if grid[i][j] == '1':
          result.add(self.find(i * cols + j))

    return len(result)

  def union(self, x, y):
    self.f[self.find(x)] = self.find(y)

  def find(self, x):
    self.f.setdefault(x, x)
    if self.f[x] != x:
      self.f[x] = self.find(self.f[x])
    return self.f[x]
