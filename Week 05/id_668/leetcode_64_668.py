#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: miminum_path_sum.py
    @time: 2019/11/17 08:36
"""


class Solution(object):
    """
        给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
        说明：每次只能向下或者向右移动一步。

        示例:
        输入:
        [
          [1,3,1],
          [1,5,1],
          [4,2,1]
        ]
        输出: 7
        解释: 因为路径 1→3→1→1→1 的总和最小。
    """

    def min_path_sum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int

        DP步骤：
        1. 重复性（分治）：自底向上思考，min_sum(i, j) = min(min_sum(i-1, j), min_sum(i, j-1)) + grid(i, j)
        2. 定义dp数组，dp=grid
        3. dp方程：dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + dp[i][j]
        """
        dp = grid

        for m in range(1, len(dp[0])):  # 对矩形框的第一行依次求和
            dp[0][m] += dp[0][m - 1]

        for n in range(1, len(dp)):  # 对矩形框的最左边一列依次求和
            dp[n][0] += dp[n - 1][0]

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                dp[i][j] += min(dp[i - 1][j], dp[i][j - 1])

        return dp[-1][-1]

    def min_path_sum2(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int

        递归，自行向下的思考，min_sum(i, j) = min(min_sum(i+1, j), min_sum(i, j+1)) + grid(i, j)
        """
        import sys

        def helper(i, j):
            if i == len(grid) or j == len(grid[0]):  # 表示取值已经超出矩阵边框，因为求最小值，所以这里与最大值进行比较，即可得出原位置的值
                return sys.maxint

            if i == len(grid) - 1 and j == len(grid[0]) - 1:
                return grid[i][j]

            return grid[i][j] + min(helper(i + 1, j), helper(i, j + 1))

        return helper(0, 0)

