class Solution(object):

    def __init__(self):
        self.result = []
        
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def sub(index, subset, n):
            if len(subset) == n:
                self.result.append(subset[:])
                return
            for i in range(index, len(nums)):
                num = nums[i]
                subset.append(num)
                sub(i + 1, subset, n)
                subset.pop()
        
        # nums.sort()
        for i in range(len(nums) + 1):
            sub(0, [], i)
        return self.result
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        