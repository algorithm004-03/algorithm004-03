from typing import List


class Solution1:
    """
    First solution is brute force
    """

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        Time complexity: O(n * k)
        """
        for _ in range(k):
            # the slice to be rotated is [-k:]
            # start with the last num in [-k:]
            prev = nums[-1]
            for i in range(len(nums)):
                # there are two steps:
                # 1. swap first element with prev
                # e.g. [7,2,3,4,5,6,1]
                # 2. loop thru to arrange the rest of the elements
                # to its original order
                # e.g. [7,1,3,4,5,6,2] => [7,1,2,4,5,6,3] =>...=>[7,1,2,3,4,5,6]
                nums[i], prev = prev, nums[i]

        print(nums)  # for testing


class Solution2:
    """
    A very Pythonic solution, with list slicing and pythonic swapping
    Be super careful with the edge cases
    Time complexity: O(n), as slicing a list will create new list
    Check https://github.com/python/cpython/blob/master/Objects/listobject.c
    line 473 to 493
    """

    def rotate(self, nums: List[int], k: int) -> None:
        # here k is updated as the mod of len(nums)
        # this will be used when k is greater than len(nums)
        # e.g. for array of 7, when k = 7 is the same as k = 0, or don't rotate
        # when k = 8 is the same as k = 1
        k %= len(nums)

        if (len(nums) <= 1) or (k == 0):
            # when the list is either empty or only has 1 element
            # or k % len(nums) == 0, don't move
            return

        nums[:k], nums[k:] = nums[-k:], nums[:-k]
        print(nums)


if __name__ == '__main__':
    # Create two test cases
    sol1 = Solution1()
    sol1.rotate([1, 2, 3, 4, 5, 6, 7], 3)
    sol2 = Solution2()
    sol2.rotate([1, 2, 3, 4, 5, 6, 7], 3)
