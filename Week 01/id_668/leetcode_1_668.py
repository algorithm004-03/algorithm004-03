#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: two_sum.py
    @time: 2019/10/19 08:15
"""


class Solution(object):
    """
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
        并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

        示例:
        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]

        分析：寻找数组中两个不同位置的元素的和等于target的唯一解。这里首先想到的是两层枚举方法，因为是不同位置
        元素，所以i指针范围为0 ~ len(nums) - 2，指针j范围为i + 1 ~ len(nums) - 1。时间复杂度为O(n * n)，
        空间复杂度为O(1)。另一种方法是使用空间换时间的思想，引入哈希表结构，哈希表结构查找一个元素的时间复杂度为
        O(1)，所以能够提升运算效率。因此这种方式的时间复杂度为O(n)，空间复杂度为O(n)。
    """

    def two_sum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]

        时间复杂度：O(n * n)
        空间复杂度：O(1)
        """
        _len = len(nums)

        for i in range(_len - 1):
            for j in range(i + 1, _len):
                if nums[i] + nums[j] == target:
                    return [i, j]

        return []

    def two_sum2(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]

        空间换时间
        时间复杂度：O(n)
        空间复杂度：O(n)
        """
        _dict = {}

        for k, v in enumerate(nums):
            val = target - v

            if val in _dict:
                return [_dict[val], k]

            _dict[v] = k

        return []

