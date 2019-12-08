class Solution(object):
    def rob(self, nums):
        """
        打家劫舍2: https://leetcode-cn.com/problems/house-robber-ii/description/

        :type nums: List[int]
        :rtype: int
        """
        # 打家劫舍1问题的比较复杂版，第一个房屋和最后一个房屋相连
        # 直接拆分成2个问题，简化成打家劫舍1问题
        # 1. 不偷盗第一个房子，求出最大金额
        # 2. 不偷盗最后一个房子，求出最大金额
        # 1和2的最大者为题解
        def f(rooms):
            a = b = 0
            for room in rooms:
                a, b = b, max(b, a + room)
            return max(a, b)
        return max(f(nums[1:]), f(nums[: -1])) if len(nums) != 1 else nums[0]


