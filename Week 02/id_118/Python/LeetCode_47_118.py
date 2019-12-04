from typing import List


class Solution:
    """
    This solution follows strictly the generic recursion solution from the class
    Time Complexity: O(n^n) exponential
    Space Complexity: O(n)
    """

    def __init__(self):
        # initialize result in res, as a list of list
        self.res = []
        # initialize a helper vector
        self.used = []

    def _gen_perm(self, curr_level, max_level, nums, curr_p):
        # terminator
        if curr_level == max_level:
            # this is important to add a copy method,
            # otherwise it will be affected by the pop later
            # Assignment statements in Python do not copy objects,
            # they create bindings between a target and an object.
            self.res.append(curr_p.copy())
            return
        # process the current level
        for i in range(len(nums)):
            # if nums[i] is not used

            if not self.used[i]:
                # check if nums[i] is duplicated
                if (i > 0) and (not self.used[i - 1]) and (
                        nums[i] == nums[i - 1]):
                    continue

                curr_p.append(nums[i])
                self.used[i] = True

                # drill down
                self._gen_perm(curr_level + 1, max_level, nums, curr_p)

                # really important to reverse and reset global variables here
                curr_p.pop()
                self.used[i] = False
        return

    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return self.res

        self.used = [False] * len(nums)
        # current solution is []
        self._gen_perm(0, len(nums), sorted(nums), [])

        return self.res


if __name__ == '__main__':
    sol = Solution()
    res = sol.permute([3, 3, 0, 3])
    print(res)
    print(len(res))