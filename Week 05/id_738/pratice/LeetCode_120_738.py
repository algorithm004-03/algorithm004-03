class Solution(object):
    def minimumTotal(self, triangle):
        """
        三角形的最小路径和:https://leetcode-cn.com/problems/triangle/description/

        :type triangle: List[List[int]]
        :rtype: int
        """
        # 递归,提交超时
        # def dfs(level, i, val):
        #     if level == len(triangle):
        #         self.max_result = min(self.max_result, val)
        #         return
        #     dfs(level + 1, i, val + triangle[level][i])
        #     dfs(level + 1, i + 1, val + triangle[level][i])

        # self.max_result = float('inf')
        # dfs(0, 0, 0)
        # return self.max_result
        
################################################################

        # DP
        # 1. 找重复性，分解子问题：problem(i, j) = problem(i, j + 1) + problem(i + 1, j + 1) + [i, j]
        # 2. 定义状态（数组）：f[i][j]
        # 3. 寻找DP方程：f[i, j] = min(f[i + 1, j] + f[i + 1, j + 1]) + triangle[i][j]
        m = len(triangle)
        n = len(triangle[-1])
        f = [[0] * i for i in range(1, m + 1)]
        f[-1] = triangle[-1][:]
        for i in range(m - 1)[::-1]:
            for j in range(len(triangle[i])):
                f[i][j] = min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j]
        return f[0][0]

################################################################

        # 三角形为等边三角形，即第n行有n个元素。
        # 求解每一行的值，只需要上一行的值即可
        # 所以可以构造一个n长度的数组，存储上一行的结果，并原地修改作为本行的结果即可
        f = triangle[-1][:]
        for i in range(m - 1)[::-1]:
            for j in range(i + 1):
                f[j] = min(f[j], f[j + 1]) + triangle[i][j]
        return f[0]