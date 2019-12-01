class Solution(object):
    def climbStairs(self, n):
        """
        爬楼梯问题：https://leetcode-cn.com/problems/climbing-stairs/description/

        :type n: int
        :rtype: int
        """

        # DP初始分析
        # 1.分解子问题:problem(i) = problem(i - 1) + problem(i - 2)
        # 2. 定义状态:dp[i]
        # 3. DP方程：dp[i] = dp[i - 1] + dp[i - 2]
        # dp = [0 for i in range(n)]
        # for i in range(n):
        #     if i >= 1:
        #         dp[i] += dp[i - 1]
        #     if i >= 2:
        #         dp[i] += dp[i - 2]
        # return dp[-1]
###################################################
        # DP优化空间
        # a, b = 1, 2
        # for i in range(1, n):
        #     a, b = b, a + b
        # return a
###################################################
        # 分治DFS
        # def dfs(cur):
        #     if cur == 0:
        #         self.result += 1
        #     elif cur > 0:
        #         dfs(cur - 1)
        #         dfs(cur - 2)
        
        # self.result = 0
        # dfs(n)
        # return self.result

###################################################
        # BFS
        # q = [0]
        # result = 0
        # while q:
        #     l = []
        #     while q:
        #         cur = q.pop()
        #         if cur == n:
        #             result += 1
        #         elif cur < n:
        #             l.append(cur)
        #     for cur in l:
        #         q.append(cur + 1)
        #         q.append(cur + 2)
        # return result
###################################################
        # 递归
        # if n == 1 or n == 2:
        #     return n
        # return self.climbStairs(n - 1) + self.climbStairs(n - 2)
###################################################
        # 从上往下递归
        # def climb(cur):
        #     if cur == n:
        #         return 1
        #     if cur > n:
        #         return 0
        #     return climb(cur + 1) + climb(cur + 2)
        # return climb(0)
###################################################

        # 从上往下递归-优化-存储中间状态
        # visited = [0 for i in range(n)]
        # def climb(cur):
        #     if cur == n:
        #         return 1
        #     if cur > n:
        #         return 0
        #     if visited[cur] > 0:
        #         return visited[cur]
        #     visited[cur] = climb(cur + 1) + climb(cur + 2)
        #     return visited[cur]
        # return climb(0)

###################################################
        # 扩展1：如果题目改为爬楼梯，但是：可以有1，2，3步走 (easy)
        if n <= 2:
            return n
        a, b, c = 1, 2, 4
        for i in range(3, n):
            tmp = a + b
            a = b
            b = c
            c += tmp
        return c

        # 扩展2：
        # 1. 可以有1，2，3步走 (easy)
        # 2. 相邻两步不能走一样，即：不能走1，1，1  / 1， 2， 2这样的步伐 (meduim)
        # 应该如何解答？
        

        