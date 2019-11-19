class Solution:
    #   暴力搜索
    def findMin(self, nums: List[int]) -> int:
        min_value = 99999999

        for value in nums:
            if value < min_value:
                min_value = value

        return min_value

    #   二分查找
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            if nums[left] >= nums[mid] >= nums[right]:
                return nums[right]
            elif nums[mid] > nums[right]:
                left = mid + 1
            elif nums[left] > nums[mid]:
                right = mid
            else:
                return nums[left]
        return nums[left]



