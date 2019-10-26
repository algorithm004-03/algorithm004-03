from typing import List


class Solution1:
    """
    Brute force, use the two pointers technique to iterate thru the array
    Time complexity is O(n^2) due to nested loop
    """

    def two_sum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]


class Solution2:
    """
    for each number in nums, check if target - number is in nums
    Time complexity is not great in this solution as nums.index() also has
    a BigO of O(n), so this is also a nested for loop: -> O(n^2)
    """

    def two_sum(self, nums: List[int], target: int) -> List[int]:
        for num in nums:
            if ((target - num) in nums) and (nums.index(num) !=
                                             nums.index(target - num)):
                return [nums.index(num), nums.index(target - num)]


class Solution3:
    """
    Use enumerate to iterate both index and num
    Use a hash table (dict) to store {key: val} -> {num: index}
    """

    def two_sum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        # in this dictionary, the key is num, val is index
        # need to make sure the list is unique, duplicates will cause
        # hash conflicting
        for idx, num in enumerate(nums):
            # if target-num exists in d, return both indices
            if target - num in d:
                return [d[target - num], idx]
            else:
                d[num] = idx


test_nums = [2, 7, 11, 15]
test_target = 9


def test1():
    sol1 = Solution1()
    print(sol1.two_sum(test_nums, test_target))


def test2():
    sol2 = Solution2()
    print(sol2.two_sum(test_nums, test_target))


def test3():
    sol3 = Solution3()
    print(sol3.two_sum(test_nums, test_target))


if __name__ == '__main__':
    test1()
    test2()
    test3()
