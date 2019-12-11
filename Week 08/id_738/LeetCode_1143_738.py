class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        最长公共子序列：https://leetcode-cn.com/problems/longest-common-subsequence/
        
        :type text1: str
        :type text2: str
        :rtype: int
        """
        # DP
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