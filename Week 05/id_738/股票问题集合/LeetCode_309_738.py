class Solution(object):
    def maxProfit(self, prices):
        """
        最佳买卖股票时期含冷冻期：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

        :type prices: List[int]
        :rtype: int
        """
        # DP
        # 1. 子问题分解:设dp[i] 为第i天股票的最大利润
        # 如果第i天没交易: dp[i] = dp[i - 1]
        # 如果第i天买入: dp[i]肯定不是最优解，忽略掉
        # 如果第i天卖出: dp[i] = max(dp[i - 1], prices[i] - prices[j] + dp[j - 2], ... , prices[i] - prices[3] + dp[1], prices[i] - prices[2] + dp[0]) { j = i - 1 }
        # dp[0] = 0
        # i == 1, dp[1] = max(dp[0], prices[1] - prices[0])
        # i == 2, dp[2] = max(dp[1], prices[2] - prices[1], prices[2] - prices[0])
        # 2. 状态定义: dp[i]
        # 3. DP方程:
        # i >= 3, dp[i] = max(dp[i - 1], prices[i] - prices[j] + dp[j - 2], ... , prices[i] - prices[3] + dp[1], prices[i] - prices[2] + dp[0]) { j = i - 1 }
        # i == 1, dp[1] = max(dp[0], prices[1] - prices[0])
        # i == 2, dp[2] = max(dp[1], prices[2] - prices[j], prices[2] - prices[j - 1]) { j = i - 1 }
        
        # if not prices:
        #     return 0
        # dp = [0 for _ in range(len(prices))]
        # for i in range(1, len(prices)):
        #     # DP方程第一个初始化就是dp[i - 1]
        #     dp[i] = dp[i - 1]
        #     for j in range(i):
        #         diff_price = prices[i] - prices[j]
        #         if j >= 2:
        #             dp[i] = max(dp[i], diff_price + dp[j - 2])
        #         else:
        #             dp[i] = max(dp[i], diff_price)
        # return dp[-1]

###############################################################################

        # 优化上述DP,在 for j in range(i) 的时候，每次都要重复计算很多 diff_price + dp[j - 2]
        # 可以优化成依赖上一次计算结果的max值

        # if not prices:
        #     return 0
        # dp = [0 for _ in range(len(prices))]
        # mi = float('inf')
        # for i in range(1, len(prices)):
        #     mi = min(mi, prices[i - 1] - dp[i - 3])
        #     if i == 1:
        #         dp[1] = max(dp[0], prices[1] - prices[0])
        #     elif i == 2:
        #         dp[2] = max(dp[1], prices[2] - prices[1], prices[2] - prices[0])
        #     else:
        #         dp[i] = max(dp[i - 1], prices[i] - mi)
        # return dp[-1]

###############################################################################

        # 空间优化:直接用一个长度为4的数组存储即可
        if not prices:
            return 0
        dp = [0] * 4
        mi = float('inf')
        r_i = -1 if len(prices) > 4 else len(prices) - 1
        for i in range(1, len(prices)):
            mi = min(mi, prices[i - 1] - dp[0])
            if i == 1:
                dp[1] = max(dp[0], prices[1] - prices[0])
            elif i == 2:
                dp[2] = max(dp[1], prices[2] - prices[1], prices[2] - prices[0])
            else:
                dp[3] = max(dp[2], prices[i] - mi)
                dp[0], dp[1], dp[2] = dp[1], dp[2], dp[3]
        return dp[r_i]

















