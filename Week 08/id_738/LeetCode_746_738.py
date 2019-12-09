class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        使用最小花费爬楼梯：https://leetcode-cn.com/problems/min-cost-climbing-stairs/

        :type cost: List[int]
        :rtype: int
        """
        # dp表示到这级楼梯需要耗费的体力
        dp = [0 for _ in range(len(cost) + 1)]
        # 由于开始可以站在第0或者第1级楼梯，所以初始化为0（不需要走）
        dp[0] = dp[1] = 0
        for i in range(2, len(cost) + 1):
            dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        return dp[-1]


################################################
        # 空间压缩
        # dp表示到这级楼梯需要耗费的体力
        dp = [0 for _ in range(len(cost) + 1)]
        # 由于开始可以站在第0或者第1级楼梯，所以初始化为0（不需要走）
        a = b = 0
        for i in range(2, len(cost) + 1):
            a, b = b, min(b + cost[i - 1], a + cost[i - 2])
        return b


