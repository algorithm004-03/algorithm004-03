from typing import *


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        """
        比46多了一个去重，每次添加就和上一个比较看是否相等
        """
        # 要去重，先排序
        nums.sort()
        res = []

        def backtrack(b_nums, b_list):
            # 出口
            if not b_nums:
                res.append(b_list)
                return
            for i in range(len(b_nums)):
                # 从第二项开始和上一项比看看是否相同，相同跳过
                if i > 0 and b_nums[i] == b_nums[i - 1]:
                    continue
                backtrack(b_nums[:i] + b_nums[i + 1:], b_list + [b_nums[i]])

        backtrack(nums, [])
        return res


s = Solution()
print(s.permuteUnique([1, 1, 2]))
