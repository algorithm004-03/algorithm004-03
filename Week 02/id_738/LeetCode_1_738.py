class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
       #暴力求解两重循环
        # for i in range(len(nums) - 1):
        #     k = target - nums[i]
        #     for j in range(i + 1, len(nums)):
        #         if nums[j] == k: return [i, j]
        
        #放入Hash表中,然后查找的时候就是O(1)复杂度，加上自身N个元素就是O(n)复杂度
        #python中的 map就是用hash表实现的
        reuslt = []
        d = {}
        for i in range(len(nums)):
            a = target - nums[i]
            if a in d:
                return [i, d[a]]
            d[nums[i]] = i
        return result
    
        #上面的同样方法的另一种编码方法
        # result = []
        # dictionary = {}
        # for i in range(len(nums)):
        #     a = target - nums[i]
        #     if nums[i] in dictionary:
        #         result = [i, dictionary[nums[i]]]
        #     dictionary[a] = i
        # return result
    