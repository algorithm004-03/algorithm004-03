#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: 300_longest_increasing_subsequence.py
    @time: 2019/12/4 16:39
"""


class Solution(object):
    """
        给定一个无序的整数数组，找到其中最长上升子序列的长度。

        示例:
        输入: [10,9,2,5,3,7,101,18]
        输出: 4
        解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

        说明:
        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
        你算法的时间复杂度应该为 O(n2) 。
        进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

    """

    def length_of_lis(self, nums):
        """
        :type nums: List[int]
        :rtype: int

        DP 自底向上思考
        数组nums的i位置，能够形成从{0...i-1}的各个位置到i位置的多个子序列。
        dp[i]表示i位置的最长上升子序列的长度，0 <= j < i表示i位置之前的各个位置的最长上升子序列的长度，记作dp[j]。
        因此dp[i] = max(dp[i], dp[j] + 1 for j in range(i) if nums[j] < nums[i])。

        """
        if len(nums) == 0:
            return 0

        dp = [1] * len(nums)  # 所有元素置1，是因为每个元素至少可以单独成为子序列，此时长度都为1

        for i in range(len(nums)):
            for j in range(i):  # 依次查看从0位置至i位置与i位置形成的最长子序列的情况
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return max(dp)  # nums数组每个位置都求出该位置的最长上升子序列，然后取最大值即可

    def length_of_lis2(self, nums):
        """
        :type nums: List[int]
        :rtype: int

        子序列的共同特点是：它们的结尾是所有相同长度的"上升子序列"里面最小的。
        """

        if len(nums) < 2:
            return len(nums)

        # tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几，
        # tail数组一直是一个升序的数组且结尾元素是所有相同长度的上升子序列最小的
        # 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail = [nums[0]]

        for i in range(1, len(nums)):
            '''
                对于当前数字nums[i]，判断其值是否在tail数组升序的范围内；如果在其中，则替换其最小小于的元素，比如数组
                tail为[2,3,7,18]，这个时候nums[i]值为4，元素4在tail中，且4最小小于的元素为7，因此这里将7替换成4
                因此最终tail数组变为[2,3,4,18]。下面的二分法主要用于操作tail数组
            '''

            left, right = 0, len(tail)  # 因为有可能num比tail数组中的最后一个元素还要大，所以右边界应该设置为tail数组的长度

            while left < right:
                # 非标准二分查找
                # 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                mid = (left + right) >> 1

                if tail[mid] < nums[i]:
                    # 中位数肯定不是要找的数，把它写在分支的前面
                    left = mid + 1
                else:
                    right = mid

            if left == len(tail):
                tail.append(nums[i])
            else:
                # 因为【逻辑 1】，因此一定能找到第 1 个大于等于 nums[i] 的元素，因此无需再单独判断，直接更新即可
                # left位置的值是nums[i]最小小于的元素
                tail[left] = nums[i]

        return len(tail)
