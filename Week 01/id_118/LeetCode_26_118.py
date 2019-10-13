# Given a sorted array nums, remove the duplicates in-place such that each
# element appear only once and return the new length.
#
# Do not allocate extra space for another array, you must do this by
# modifying the input array in-place with O(1) extra memory.
#
# Example 1:
#
#
# Given nums = [1,1,2],
#
# Your function should return length = 2, with the first two elements of nums
# being 1 and 2 respectively.
#
# It doesn't matter what you leave beyond the returned length.
#
# Example 2:
#
#
# Given nums = [0,0,1,1,1,2,2,3,3,4],
#
# Your function should return length = 5, with the first five elements of
# nums being modified to 0, 1, 2, 3, and 4 respectively.
#
# It doesn't matter what values are set beyond the returned length.
#
#
# Clarification:
#
# Confused why the returned value is an integer but your answer is an array?
#
# Note that the input array is passed in by reference, which means
# modification to the input array will be known to the caller as well.
#
# Internally you can think of this:
#
#
# // nums is passed in by reference. (i.e., without making a copy)
# int len = removeDuplicates(nums);
#
# // any modification to nums in your function would be known by the caller.
# // using the length returned by your function, it prints the first len
# elements. for (int i = 0; i < len; i++) {     print(nums[i]); } Related
# Topics Array Two Pointers

# import type hint, otherwise IDE will report error
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # set a pointer _len
        # its index position is the len of new nums
        # nums[_len] serves as confirmation to accept unique value
        _len = 1
        # if nums is empty
        if len(nums) == 0:
            return 0
        # if nums is not empty
        for i in range(1, len(nums)):
            # nums[i-1] is the first unique value
            # if consecutive two elements are unique
            # nums[_len] will confirm nums[i] is a non-duplicate value
            # and accept it to the updated nums
            if nums[i] != nums[i - 1]:
                nums[_len] = nums[i]
                _len += 1
        return _len


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    arr = [1, 1, 2]
    sol = Solution()
    print(sol.removeDuplicates(arr))
