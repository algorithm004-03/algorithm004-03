#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: search_in_rorated_sorted_array.py
    @time: 2019/11/2 15:34
"""


class Solution(object):
    """
        假设按照升序排序的数组在预先未知的某个点上进行了旋转。
        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

        搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
        你可以假设数组中不存在重复的元素。
        你的算法时间复杂度必须是 O(log n) 级别。

        示例 1:
        输入: nums = [4,5,6,7,0,1,2], target = 0
        输出: 4

        示例 2:
        输入: nums = [4,5,6,7,0,1,2], target = 3
        输出: -1
    """

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int

        数组从任意位置劈开，至少有一半是有序的
        """
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) / 2

            if target == nums[mid]:
                return mid

            # 开始判断以mid为分界线的前段是否有序
            if nums[left] <= nums[mid]:
                if nums[left] <= target <= nums[mid]:
                    right = mid - 1
                else:
                    # target > nums[mid]
                    left = mid + 1
            else:
                if nums[mid] <= target <= nums[right]:
                    left = mid + 1
                else:
                    # target < nums[mid]
                    right = mid - 1

        return -1

    def search2(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int

        光头哥的代码，不容易理解
        """
        left, right = 0, len(nums) - 1

        while left < right:
            mid = left + (right - left) / 2

            if (nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]):
                left = mid + 1
            else:
                right = mid

        return left if target in nums[left:left + 1] else -1

    def search3(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int

        """
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) / 2

            if nums[mid] == target:
                return mid
            if nums[0] <= target < nums[mid] or target < nums[mid] < nums[0] or nums[mid] < nums[0] <= target:
                right = mid - 1
            else:
                left = mid + 1

        return -1

    def search4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int

        分析：
        1. 先用二分查找法找到数组中逆序的位置
        2. 以逆序的索引为界，将数组分解为两个有序的数组
        3. 对前半有序数组执行标准的二分查找target
        4. 若找到，则直接返回值；若没有找到则继续对后半有序数组执行标准的二分查找target
        5. 返回查找的结果

        时间复杂度：O(logN)包含二分查找逆序的位置，以及后面一次或两次的标准二分查找
        空间复杂度：O(1)
        """

        def bsearch(low, high):
            """
                标准的二分查找法
            """
            while low <= high:
                m = low + (high - low) / 2

                if nums[m] == target:
                    return m
                elif nums[m] < target:
                    low = m + 1
                else:
                    high = m - 1

            return -1

        left, right, mid, = 0, len(nums) - 1, 0

        while left <= right:
            mid = left + (right - left) / 2

            if nums[mid] < nums[0]:
                right = mid - 1
            else:
                left = mid + 1

        '''
            mid有可能是前半有序数组的最后一个元素的索引，也有可能是后半有序数组的第一个元素的索引
        '''
        _index = mid

        if mid < len(nums) - 1:
            # 获取后半有序数组的第一个元素的索引
            _index = mid if nums[mid] < nums[mid + 1] else mid + 1
        elif mid == len(nums) - 1:
            if mid >= 1 and nums[mid] > nums[0]:
                # 原数组是一个有序数组
                _index += 1
        else:
            # 原数组是一个空数组
            _index = 0

        res = bsearch(0, _index - 1)
        return res if res != -1 else bsearch(_index, len(nums) - 1)

