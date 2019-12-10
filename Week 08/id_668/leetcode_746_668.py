#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: 746_min_cost_climbing_stairs.py
    @time: 2019/12/4 10:23
"""


class Solution(object):
    """
        数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
        每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
        您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

        示例 1:
        输入: cost = [10, 15, 20]
        输出: 15
        解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。

        示例 2:
        输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
        输出: 6
        解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。

        注意：
        cost 的长度将会在 [2, 1000]。
        每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
    """

    def min_cost_climbing_stairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int

        DP 自底向上的思考方式 从数组尾部向前思考
        以台阶为基本点思考：假设有n阶台阶，因为每次可以走一个台阶也可以走两个台阶，所以n阶走一步到达楼顶，n-1阶走两步到达楼顶。
        第n阶min_cost为自身值，第n-1阶min_cost也为自身值，第n-2阶min_cost等于其自身值+min(min_cost(n-1), min_cost(n))
        因此dp状态方程为：min_cost[i] = min(min_cost(i+1), min_cost(i+2)) + cost[i]
        dp方程为：dp[i] = min(dp[i+1], dp[i+2]) + dp[i]
        """
        if len(cost) == 0 or len(cost) == 1:  # cost=1相等于就一个台阶，因为可以跨两步直接跨过，所以能量值消耗为0
            return 0

        dp = cost

        for i in range(len(dp) - 3, -1, -1):
            dp[i] += min(dp[i + 1], dp[i + 2])

        return min(dp[0], dp[1])  # 这里比较dp[0], dp[1]是因为开始选择有两种，可以走一步，也可以走两步

    def min_cost_climbing_stairs2(self, cost):
        """
        :type cost: List[int]
        :rtype: int

        DP 自底向上的思考方式 从数组尾部向前思考
        以台阶能量消耗为基本思考点：因为可以走一步或者两步，
        因此第i阶台阶的能量消耗min_cost[i] = cost[i] + min(min_cost[i-1], min_cost[i-2])
        dp方程为：dp[i] = dp[i] + min(dp[i-1], dp[i-2])
        """
        if len(cost) == 0 or len(cost) == 1:
            return 0

        dp = cost

        for i in range(2, len(dp)):
            dp[i] += min(dp[i - 1], dp[i - 2])

        return min(dp[-2], dp[-1])  # 因为倒数第一个台阶、倒数第二个台阶都可以到达楼顶，因此最终比较这两个能量消耗值

    def min_cost_climbing_stairs3(self, cost):
        """
        :type cost: List[int]
        :rtype: int

        同样是dp思想，只是简化了代码的实现
        """
        a = b = 0

        for e in cost:
            print a, b
            a, b = b, min(a + e, b + e)

        return min(a, b)
