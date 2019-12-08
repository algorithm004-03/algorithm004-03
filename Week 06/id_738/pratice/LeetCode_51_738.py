class Solution(object):
    def solveNQueens(self, n):
        """
        N皇后：https://leetcode-cn.com/problems/n-queens
        
        :type n: int
        :rtype: List[List[str]]
        """
        # 分治，剪枝,精简写法(自己第N次不断练习，每次写法都不一样，后写出来的)
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

########################################################################################

        # 之前的写法
        def dfs(l, level, pie, na, su, size):
            if len(l) == size:
                self.result.append(l[:])
                return
            if level >= size:
                return
            
            for x in range(size):
                p = x + level
                n = x - level
                if p not in pie and n not in na and x not in su:
                    pie.append(p)
                    na.append(n)
                    su.append(x)
                    l.append(x)
                    dfs(l, level + 1, pie, na, su, size)
                    l.pop()
                    pie.pop()
                    na.pop()
                    su.pop()
        self.result = []
        dfs([], 0, [], [], [], n)
        print(self.result)
        # self.result转化成棋盘
        ana = []
        for a in self.result:
            r = ['.' * n] * n
            for i in range(len(a)):
                r[i] = r[i][:a[i]] + 'Q' + r[i][a[i] + 1:]
            ana.append(r)
        return ana
