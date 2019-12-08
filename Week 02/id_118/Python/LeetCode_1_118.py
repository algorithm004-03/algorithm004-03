from typing import List


class Solution1:
    """
    Brute force
    """

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]


class Solution2:
    """
    Hashmap with two loops
    """

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # store all numbers in a hashtable
        temp = {}
        for num in nums:
            temp[num] = target - num
        # for each num in temp, if they exist in nums
        # and they are not used twice
        for i in range(len(nums)):
            if temp[nums[i]] in nums and i != nums.index(temp[nums[i]]):
                return [i, nums.index(temp[nums[i]])]


class Solution3:
    """
    Hashmap with only one loop
    """

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # store all numbers in a hashtable
        temp = {}
        # use enumerate function to iterate both index and num simultaneously
        for idx, num in enumerate(nums):
            if num in temp:
                return [temp[num], idx]
            else:
                temp[target - num] = idx


def test1():
    sol = Solution1()
    nums = [2, 8, 11, 15, 7]
    target = 9
    print(sol.twoSum(nums, target))


def test2():
    sol = Solution2()
    nums = [2, 8, 11, 15, 7]
    target = 9
    print(sol.twoSum(nums, target))


def test3():
    sol = Solution3()
    nums = [2, 8, 11, 15, 7]
    target = 9
    print(sol.twoSum(nums, target))


if __name__ == '__main__':
    test1()
    test2()
    test3()
