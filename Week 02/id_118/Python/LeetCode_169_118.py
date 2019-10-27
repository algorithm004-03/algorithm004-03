from typing import List


class Solution:
    """
    Solution 1 use hashmap
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


if __name__ == '__main__':
    sol = Solution()
    print(sol.majorityElement([2, 2, 1, 1, 1, 2, 2]))
