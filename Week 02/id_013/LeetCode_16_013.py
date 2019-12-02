"""
第十六题：51. N皇后
https://leetcode-cn.com/problems/n-queens
"""

"""
解法：深度优先搜索
"""
class Solution:
    def solveNQueens(self,n):
        def DFS(queens,xy_diff,xy_sum):
            p = len(queens)
            if p == n:
                result.append(queens)
                return None
            for q in range(n):
                if q not in queens and p-q not in xy_diff and p+q not in xy_sum:
                    DFS(queens+[q],xy_diff+[p-q],xy_sum+[p+q])
        result = []
        DFS([],[],[])
        return [['.'*i + 'Q'+'.'*(n-i-1) for i in sol] for sol in result]