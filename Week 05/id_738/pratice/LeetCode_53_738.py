class Solution(object):
    def maxSubArray(self, nums):
        """
        最大子序和：https://leetcode-cn.com/problems/maximum-subarray/

        :type nums: List[int]
        :rtype: int
        """
        # DP
        # 定义problem(i)表示以nums[i]为结尾的最大子串值
        # 1. 切分子问题：problem(i) = max(problem(i - 1) + nums[i], nums[i])
        # 2. 定义状态数组：a[n],n为nums的长度，存储每个以i为结尾的最大子串值
        # 3. 推导DP方程：a[i] = max(a[i - 1] + nums[i], num[i])
        # 4. 最终结果就是a数组里面的最大值
        
        # a = [0] * len(nums)
        # a[0] = nums[0]
        # for i in range(1, len(nums)):
        #     a[i] = max(a[i - 1] + nums[i], nums[i])
        # return max(a)

############################################################  

        # DP存储空间优化：
        # 我们只要求最大值，所以只用一个变量存储当前最大值即可
        # 其实不必存储所有的a[i]，对于a[i]处理，我们只需要存储最近一个a[i]值即可
        result = nums[0]
        nearest_a = nums[0]
        for i in range(1, len(nums)):
            nearest_a = max(nearest_a + nums[i], nums[i])
            result = max(nearest_a, result)
        return result



