#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
from typing import List

# 法一: 两层for循环,时间复杂度O(n^2)
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         length = len(nums)
#         for i in range(0, length):
#             for j in range(i+1, length):
#                 if ((nums[i] + nums[j]) == target):
#                     return [i, j]
#         return []


    # """这样写更直观，遍历列表同时查字典"""
    # dct = {}
    # for i, n in enumerate(nums):
    #     if target - n in dct:
    #         return [dct[target - n], i]
    #     dct[n] = i

# 法二:  时间复杂度0(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) <= 1:
            return False

        dict = {}   # 新建空字典
        for key, value in enumerate(nums):
            # print(index, value)
            # 枚举nums, 如果空字典中有“目标值-整数”的差,则返回差在字典中的下标、整数的下标
            if target - value in dict:
                # print(dict)
                return [dict[target-value], key]
            else:
                # key和value交换后传入字典,使得可以通过value获得key的值
                dict[value] = key
                # print(dict)
        return [-1, -1]

    
# if __name__ == "__main__":
#     nums = [2,11,7,5,5]
#     target = 10
#     s = Solution()
#     w = s.twoSum(nums, target)
#     print(w)






        
# @lc code=end

