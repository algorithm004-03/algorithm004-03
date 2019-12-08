# -*- coding: utf-8 -*-
#
# @lc app=leetcode.cn id=283 lang=python
#
# [283] 移动零
#

# @lc code=start
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        #利用双指针，假设指针i,j，i指向数组最左边的0元素,j指向数组最左边的非0元素
        #每次只要swap i,j指向元素的值即可
        #遍历一次时间复杂度O(n)
        i = 0
        for j in range(len(nums)):
            if nums[j] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
            
# @lc code=end