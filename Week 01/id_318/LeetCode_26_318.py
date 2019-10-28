# 26. Remove Duplicates from Sorted Array

class Solution:
    def removeDuplicates(self, nums):
        if len(nums) == 0:
            return 0
        res = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i-1]:
                nums[res] = nums[i]
                res += 1
        return res

if __name__ == '__main__':
    nums = [1,1,2,3,4,4,4,4,5,5,5,6,7,7,8,8,8,8,8,8,9,9,9]
    sol = Solution()
    res = sol.removeDuplicates(nums)
    print(res)

# output: 9
