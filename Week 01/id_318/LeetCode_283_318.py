# 283. Move Zeroes

class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        zero_pos = 0
        for i in xrange(len(nums)):
            if nums[i] != 0:
                nums[zero_pos], nums[i] = nums[i], nums[zero_pos]
                zero_pos += 1

if __name__ == '__main__':
    nums = [0,1,0,3,12]
    sol = Solution()
    res = sol.moveZeroes(nums)
    print(nums)

# output: [1, 3, 12, 0, 0]
