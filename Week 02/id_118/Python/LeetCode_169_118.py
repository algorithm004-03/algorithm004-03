from typing import List


class Solution1:
    """
    Solution 1 use hashmap
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def majorityElement(self, nums: List[int]) -> int:
        count = {}
        for num in nums:
            if num in count:
                count[num] += 1
            else:
                count[num] = 1

        for num in count:
            if count[num] > (len(nums) / 2):
                return num


class Solution2:
    """
    Solution 2 use hashmap but with only 1 iteration
    """

    def majorityElement(self, nums: List[int]) -> int:
        count = {}
        for num in nums:
            if num in count:
                count[num] += 1
                if count[num] > (len(nums) // 2):
                    return num
            else:
                count[num] = 1


if __name__ == '__main__':
    sol1 = Solution1()
    sol2 = Solution2()
    print(sol1.majorityElement([2, 2, 1, 1, 1, 2, 2]))
    print(sol2.majorityElement([1, 1, 1, 2, 2]))
