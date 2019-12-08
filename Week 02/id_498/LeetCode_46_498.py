from typing import *


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        """
        都是已有的元素，也不增加也不减少，用回溯不停的挪位置
        """
        res = []

        def backtrack(b_nums, b_list):
            # 出口
            # b_nums 会越来越小
            if not b_nums:
                res.append(b_list)
                return
            for i in range(len(b_nums)):
                # 永远缺 i
                # b_nums = b_nums[:i] + b_nums[i + 1:]
                backtrack(b_nums[:i] + b_nums[i + 1:], b_list + [b_nums[i]])

        backtrack(nums, [])
        return res


s = Solution()
print(s.permute([1, 2, 3]))
