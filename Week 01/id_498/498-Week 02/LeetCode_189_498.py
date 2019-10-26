class Solution:
    def rotate(self, nums, k):
        """
        Do not return anything, modify nums in-place instead.
        """
        nums[:] = nums[len(nums) - k % len(nums):] + nums[:len(nums) - k % len(nums)]
        return nums


s = Solution()
print(s.rotate([-1, -100, 3, 99], 2))
