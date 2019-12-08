class Solution(object):
    def maxProduct(self, nums):
        """
        最大乘积子序列：https://leetcode-cn.com/problems/maximum-product-subarray/description/

        :type nums: List[int]
        :rtype: int
        """
        # DP
        # 1. 子问题分解：
        # 因为有负数乘积，所以有2种情况
        # 1.1 nums[i]为负数,因为负数会使最小值变大，最大值变小,所以:
        #           problem_max(i) = max(problem_min(i - 1) * nums[i], nums[i])
        # 1.2 nums[i]为正数:
        #           problem_max(i) = max(problem_max(i - 1) * nums[i], nums[i])
        # 1.3 所以这里要定义一个problem_min的问题：
        # nums[i]为负数: problem_min(i) = min(problem_max(i - 1) * nums[i], nums[i])
        # nums[i]为正数: problem_min(i) = min(problem_min(i - 1) * nums[i], nums[i])
        # 1. 定义状态: dp_min[i], dp_max[i]
        # 2. DP方程: 略，问题分解改成dp_min, dp_max表示即可
        # dp_min = [nums[0]] * len(nums)
        # dp_max = [nums[0]] * len(nums)
        # for i in range(1, len(nums)):
        #     if nums[i] < 0:
        #         dp_max[i] = max(dp_min[i - 1] * nums[i], nums[i])
        #         dp_min[i] = min(dp_max[i - 1] * nums[i], nums[i])
        #     else:
        #         dp_max[i] = max(dp_max[i - 1] * nums[i], nums[i])
        #         dp_min[i] = min(dp_min[i - 1] * nums[i], nums[i])
        # return max(dp_max)

        # 空间优化
        # 每次dp_min和dp_max都只需要最后一个值就可以推导出下一个值，所以只要2个变量来存储最大最小即可
        # dp_min变量永远比dp_max小，所以在nums[i]< 0 的时候，两者要互换下，才能正确得出dp_min[i]和dp_max[i]
        dp_min = nums[0]
        dp_max = nums[0]
        result = dp_max
        for i in range(1, len(nums)):
            if nums[i] < 0:
                dp_min, dp_max = dp_max, dp_min
            dp_max = max(dp_max * nums[i], nums[i])
            dp_min = min(dp_min * nums[i], nums[i])
            result = max(result, dp_max)
        return result
            












