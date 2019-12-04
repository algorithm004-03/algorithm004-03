class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.nums = nums
        # nums = [] 为 False =》 not False 为 True
        if not self.nums:
            return 0
        i = 0
        for k in range(len(self.nums)):
            # 和三目运算符很像先算中间
            if True if k == 0 or self.nums[k] != self.nums[k - 1] else False:
                self.nums[i] = self.nums[k]
                i += 1
        return i


s = Solution()
print(s.removeDuplicates([1, 1, 2]))
