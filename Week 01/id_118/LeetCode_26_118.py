# import type hint, otherwise IDE will report error
from typing import List


class Solution1:
    """
    Solution 1: below is the most intuitive solution
    Use del function to do in-place deletion
    However this solution is not optimal as del itself has O(n) time complexity
    Also remember to check edge cases, empty list and list with only 1 element
    """

    def removeDuplicates(self, nums: List[int]) -> int:
        # handle the edge cases first
        # if nums is empty
        if len(nums) == 0:
            return 0
        # if nums only has 1 element
        if len(nums) == 1:
            return 1
        i = 1
        while i < len(nums):
            if nums[i - 1] == nums[i]:
                del nums[i]
            else:
                i += 1
        return i


class Solution2:
    """
    Solution 2: use a pointer to check if the next element is duplicated in the existing
    list
    """

    def removeDuplicates(self, nums: List[int]) -> int:
        # set a pointer _len
        # its final index position is the len of new nums
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


if __name__ == '__main__':
    arr = [1, 1, 2]

    sol1 = Solution1()
    print(sol1.removeDuplicates(arr))

    sol2 = Solution2()
    print(sol2.removeDuplicates(arr))
