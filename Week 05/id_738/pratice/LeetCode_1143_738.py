class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        最长公共子序列：https://leetcode-cn.com/problems/longest-common-subsequence/

        :type text1: str
        :type text2: str
        :rtype: int
        """
        # DP
        # 先初始化第一行和第一列的值
        # 再用DP方程求解其他元素的值
        # 最后一个元素的值就是答案
        # m = len(text1)
        # n = len(text2)
        # dp = [[0] * n for _ in range(m)]
        # # 初始化二维数组第一行和第一列
        # for i in range(m):
        #     if text1[i] == text2[0]:
        #         for j in range(i, m):
        #             dp[j][0] = 1
        #         break
        #     else:
        #         dp[i][0] = 0
        
        # for i in range(n):
        #     if text2[i] == text1[0]:
        #         for j in range(i, n):
        #             dp[0][j] = 1
        #         break
        #     else:
        #         dp[0][i] = 0

        # for i in range(1, m):
        #     for j in range(1, n):
        #         if text1[i] == text2[j]:
        #             dp[i][j] = dp[i - 1][j - 1] + 1
        #         else:
        #             dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
        # return dp[-1][-1]

###############################################################################

        # 上面的DP，初始化的时候比较冗长，
        # 根据DP递推公式，我们可以假设两个字符串最前面都有一个"什么都不是"的字符，和任意字符都不是同一个字符串。
        # 那么dp数组大小为 (m + 1) * (n + 1),其中第0行和第0列全部都为0（因为第一个字符不等于任意一个字符）
        # 所以可以简化为：
        m = len(text1)
        n = len(text2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
        return dp[-1][-1]

###############################################################################

        # 暴力法，提交超时，字符串小的时候没问题
        # 找出text1的所有子序列
        # q = [text1]
        # while q:
        #     l = []
        #     while q:
        #         s = q.pop()
        #         # 如果是子序列则return
        #         i = 0
        #         for j in range(len(text2)):
        #             if s[i] == text2[j]:
        #                 i += 1
        #             if i == len(s):
        #                 return i
        #         l.append(s)
        #     for s in l:
        #         for i in range(len(s)):
        #             new_s = s[:i] + s[i + 1:]
        #             if new_s and new_s not in q:
        #                 q.append(new_s)
        # return 0