class Solution(object):
    def coinChange(self, coins, amount):
        """
        零钱兑换:https://leetcode-cn.com/problems/coin-change/
        
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # DP,其实和爬楼梯一致，只是步伐为coins种而已
        # 1. 分治子问题:problem(n) = min(problem(n - k) for k in coins) + 1
        # 2. 状态定义:f[len(coins)]
        # 3. DP方程:f(n) = min(f(n - k) for k in coins) + 1
        Max = amount + 1
        dp = [Max for _ in range(Max)]
        dp[0] = 0
        for i in range(Max):
            for coin in coins:
                if i >= coin:
                    dp[i] = min(dp[i], dp[i - coin] + 1)
        return dp[-1] if dp[-1] < Max else -1


        # BFS
        # queue = [(0, amount)]
        # visited = set([])
        # while queue:
        #     level, cur = queue.pop(0)
        #     if cur == 0:
        #         return level
        #     for coin in coins:
        #         next_cur = cur - coin
        #         if next_cur >= 0 and next_cur not in visited:
        #             queue.append((level + 1, next_cur))
        #             visited.add(next_cur)
        # return -1
            
        
        
        
        # BFS
        # queue = [(0, amount)]
        # visited = set()
        # while queue:
        #     curs = []
        #     while queue:
        #         curs.append(queue.pop())
        #     for cur in curs:
        #         level, val = cur
        #         if val < 0:
        #             continue
        #         if val == 0:
        #             return level
        #         for coin in coins:
        #             new = val - coin
        #             if new not in visited:
        #                 queue.append((level + 1, val - coin))
        #                 visited.add(new)
        # return -1


        # BFS
        # if amount == 0:
        #     return 0
        # level = 0
        # q = [a for a in coins]
        # visited = set(q)
        # while q:
        #     level += 1
        #     l = []
        #     while q:
        #         a = q.pop()
        #         if a == amount:
        #             return level
        #         l.append(a)
        #     for a in l:
        #         for c in coins:
        #             new = a + c
        #             if new == amount:
        #                 return level + 1
        #             elif new < amount and new not in visited:
        #                 q.append(new)
        #                 visited.add(new)
        # return -1