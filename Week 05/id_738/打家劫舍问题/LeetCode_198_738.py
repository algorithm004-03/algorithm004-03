class Solution(object):
    def rob(self, nums):
        """
        打家劫舍: https://leetcode-cn.com/problems/house-robber/

        :type nums: List[int]
        :rtype: int
        """
        # DP初始解答问题：
        # 1. 分解子问题: dp[i]表示第i间房屋偷盗后目前的偷到的最高金额
        # 如果定义: dp[i] = dp[i - 1] + nums[i]，会发现题意不允许相邻两个房子被盗窃，用如果用这个方程表示的话，我们不知道i-1个房子是否已经被盗窃了，如果被盗窃了这个方程就不可用，如果没被盗窃这个方程就可用
        # 故而，需要都一个维度来表示i-1房子是否被盗窃，所以我们开启第二个维度来表示第i个房子是否被盗窃
        # 定义: dp[i][0]表示第i个房子没有被盗窃，，dp[i][1]表示第i个房子已经被盗窃
        # 那么子问题变化为：
        # dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        # dp[i][1] = dp[i - 1][0] + nums[i]
        # 2. 定义状态: dp[i][j] {j=0,1, i=0...len(nums) - 1}
        # 3. dp方程

        # if not nums:
        #     return 0
        # dp = [[0,0] for _ in range(len(nums))]
        # dp[0][1] = nums[0]
        # for i in range(1, len(nums)):
        #     dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        #     dp[i][1] = dp[i - 1][0] + nums[i]
        # return max(dp[-1])
################################################################
        # 上述DP解法需要定义二维数组
        # 这里我们做空间优化，把它简化为一维数组
        # 问题转化：原题求解可以转化为，max(每个房屋必偷的最大金额)
        # 所以我们定义状态: dp[i]为第i个房屋必偷的最大金额
        # dp方程： dp[i] = max(dp[i - 1] + 0, dp[i - 2] + nums[i], ....  , dp[1] + nums[i], dp[0] + nums[i])
        # 很明显，dp[i] <= dp[i - 1]
        # 所以： dp[i] = max(dp[i - 1] + 0, dp[i - 2] + nums[i])

        # if not nums:
        #     return 0
        # # 这里做技术优化，设定dp[0]为0，dp[1]为真正对应nums[0]的房屋，这样就不用判断dp长度是否大于等于2了
        # dp = [0 for _ in range(len(nums) + 1)]
        # dp[0] = 0
        # dp[1] = nums[0]
        # for i in range(2, len(nums) + 1):
        #     dp[i] = max(dp[i - 1] + 0, dp[i - 2] + nums[i - 1])
        # # 因为a[i - 2]必然是小于a[i]的，所以只需在最后return的时候，取a[i -1]和a[i]的最小值就行了。
        # return max(dp[-1], dp[-2])
################################################################
        # 由上面的优化，我们看到，其实我们只需2个状态，来存储第 i - 1和第 i - 2个房屋的状态
        # 那么空间变量还可以优化：只定义2个变量即可
        a = b = 0
        for num in nums:
            a, b = b, max(b, a + num)
        return max(a, b)





################################################################

################################################################








