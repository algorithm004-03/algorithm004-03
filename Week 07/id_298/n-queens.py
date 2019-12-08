class Solution:
  def solveNQueens(self, n: int) -> List[List[str]]:
    result = []
    def _dfs(queens, pie, na):
      # 皇后的个数
      q = len(queens)
      # 递归终止条件
      if q == n:
        result.append(queens)
        return
      # 遍历每个皇后
      for queen in range(n):
        # pie是皇后前一个位置的组成，na是皇后后面一个位置的组成
        # 判断当前皇后是否在已经在 已放皇后的列，以放pie的pie中，已放na的na中
        if (queen not in queens) and (q - queen not in pie) and (q + queen not in na):
          _dfs(queens + [queen], pie + [q - queen], na + [q + queen])
    _dfs([], [], []) 
    return [['.' * i + 'Q' + '.' * (n - i - 1) for i in q] for q in result]
