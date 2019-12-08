class Solution(object):
    def solveNQueens(self, n):
        """
        n皇后：https://leetcode-cn.com/problems/n-queens/description/

        :type n: int
        :rtype: List[List[str]]
        """
        # 位运算解决
        self.res = []
        self.dfs(n, [], 0, 0, 0)
        f = '{:0' + str(n) + 'b}'
        return [[("{:0" + str(n) + "b}").format(b).replace('0','.').replace('1','Q') for b in l] for l in self.res]


        # 转化为输出矩阵
        # self.result = []
        # for i in range(len(self.res)):
        #     l = []
        #     for j in range(len(self.res[0])):
        #         s = ""
        #         for k in range(n):
        #             if self.res[i][j] & 1:
        #                 s = 'Q' + s
        #             else:
        #                 s = '.' + s
        #             self.res[i][j] >>= 1
        #         l.append(s)
        #     self.result.append(l)
        # return self.result

    def dfs(self, n, solution, col, pie, na):
        if n == len(solution):
            self.res.append(solution)
        bits = (~(col | pie | na)) & ((1 << n) - 1)
        while bits:
            p = bits & -bits
            bits &= (bits - 1)
            self.dfs(n, solution + [p], col | p, (pie | p) << 1, (na | p) >> 1)



        # 分治，剪枝
        result = []
        def dfs(solution, pie, na):
            row = len(solution)
            if row == n:
                result.append(solution)
                return
            for col in range(n):
                if col not in solution and col + row not in na and col - row not in pie:
                    dfs(solution + [col], pie + [col - row], na + [col + row])
        dfs([], [], [])
        return [ ['.' * i + 'Q' + '.' * (n - i - 1) for i in l ] for l in result]