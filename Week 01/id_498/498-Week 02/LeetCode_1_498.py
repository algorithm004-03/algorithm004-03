class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        len_nums = len(nums)
        for i in range(len_nums):
            for j in range(i + 1, len_nums):
                if nums[i] + nums[j] == target:
                    return [i, j]


s = Solution()
nums = [2, 7, 11, 15]
target = 9
print(s.twoSum(nums, target))
