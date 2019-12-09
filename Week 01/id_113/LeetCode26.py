class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        p, q = 0, 1
        while q < len(nums):
            if nums[p] != nums[q]:
                nums[p + 1] = nums[q]
                p += 1
            q += 1

        return p + 1
