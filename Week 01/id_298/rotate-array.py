class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) < k:
            nums.reverse()
            k = k - len(nums)
            for idx in range(k):
                if idx < k // 2:
                    temp = nums[idx]
                    nums[idx] = nums[k - 1 - idx]
                    nums[k - 1 - idx] = temp

            for idx in range(k, len(nums)):
                if idx < (len(nums) + k) // 2:
                    temp = nums[idx]
                    nums[idx] = nums[(len(nums) - 1) - (idx - k)]
                    nums[(len(nums) - 1) - (idx - k)] = temp
        else:
            nums.reverse()
            for idx in range(k):
                if idx < k // 2:
                    temp = nums[idx]
                    nums[idx] = nums[k - 1 - idx]
                    nums[k - 1 - idx] = temp

            for idx in range(k, len(nums)):
                if idx < (len(nums) + k) // 2:
                    temp = nums[idx]
                    nums[idx] = nums[(len(nums) - 1) - (idx - k)]
                    nums[(len(nums) - 1) - (idx - k)] = temp
