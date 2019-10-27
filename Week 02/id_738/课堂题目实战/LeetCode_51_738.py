class Solution(object):
    def solveNQueens(self, n):
        """
        N皇后：https://leetcode-cn.com/problems/n-queens/

        :type n: int
        :rtype: List[List[str]]
        """
        def dfs(pie, na, su, x, l, max_x):
            if x > max_x:
                self.result.append(l[:])
                return
            
            for y in range(max_x + 1):
                p = x + y
                n = y - x
                if p not in pie and n not in na and y not in su:
                    pie.append(p)
                    na.append(n)
                    su.append(y)
                    l.append([x, y])
                    dfs(pie, na, su, x + 1, l, max_x)
                    
                    pie.pop()
                    na.pop()
                    su.pop()
                    l.pop()
                    
                    
                    
                    
        self.result = []
        dfs([], [], [], 0, [], n - 1)
        final = []
        for ans in self.result:
            f = [''] * n
            for item in ans:
                x = item[0]
                y = item[1]
                f[x] = "." * y + "Q" + "." * (n - y - 1)
            final.append(f)
        return final

        


