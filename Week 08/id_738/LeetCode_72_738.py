class Solution(object):
    def minDistance(self, word1, word2):
        """
        编辑距离：https://leetcode-cn.com/problems/edit-distance/

        :type word1: str
        :type word2: str
        :rtype: int
        """
        # 定义dp[i][j]为word1[0...i]和word2[0...j]的最小变换距离
        # dp方程有如下情形：
        # 解释，如果两个单词最后一个字母相同，那么直接排除这2个字母，必然保证最短编辑距离不变
        # 如果最后一个字母不同，那么变成距离必定是word1删掉i或者word2删掉j或者同时删掉i,j形成的子串的最短编程距离+1
        # 1. if word1[i] == word2[j]: dp[i][j] = dp[i - 1][j - 1]
        # 2. if word1[i] != word2[j]: dp[i][j] = min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1)
        dp = [[i] * (len(word1) + 1) for i in range(len(word2) + 1)]
        for i in range(len(word1) + 1)[::-1]:
            dp[0][i] = i
        for i in range(1, len(word2) + 1):
            for j in range(1, len(word1) + 1):
                if word2[i - 1] == word1[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1)
        return dp[-1][-1]







