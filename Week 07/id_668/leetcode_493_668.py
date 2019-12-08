#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: 493_reverse_pairs.py
    @time: 2019/11/30 20:46
"""


class Solution(object):
    """
        给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
        你需要返回给定数组中的重要翻转对的数量。

        示例 1:
        输入: [1,3,2,3,1]
        输出: 2

        示例 2:
        输入: [2,4,3,5,1]
        输出: 3

        注意:
        给定数组的长度不会超过50000。
        输入数组中的所有数字都在32位整数的表示范围内。
    """

    def reverse_pairs(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        self.counter = 0
        self.merge_sort(nums, 0, len(nums) - 1)

        return self.counter

    def merge_sort(self, arr, left, right):
        if left >= right:
            return

        mid = (left + right) >> 1

        self.merge_sort(arr, left, mid)
        self.merge_sort(arr, mid + 1, right)
        self.merge(arr, left, mid, right)

    def merge(self, arr, left, mid, right):
        # 计算counter值
        l, r = left, mid + 1

        while l <= mid and r <= right:
            if arr[l] > 2 * arr[r]:
                self.counter += (mid + 1 - l)
                r += 1
            else:
                l += 1

        # 合并有序数组
        temp, i, j = [], left, mid + 1

        while i <= mid and j <= right:
            if arr[i] <= arr[j]:
                temp.append(arr[i])
                i += 1
            else:
                temp.append(arr[j])
                j += 1

        temp += arr[i: mid + 1]
        temp += arr[j: right + 1]
        arr[left: right + 1] = temp

        # 或直接使用sorted排序，不再需要合并有序数组的操作
        # arr[left: right + 1] = sorted(arr[left: right + 1])

