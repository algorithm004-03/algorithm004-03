"""
第十四题：169. 求众数
https://leetcode-cn.com/problems/majority-element/
"""

"""
解法一：排序取中位数
"""
class Solution:
    def majorityElement(self,nums):
        nums.sort()
        return nums[len(nums)//2]