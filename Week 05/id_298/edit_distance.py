class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        n = len(word1)
        m = len(word2)

        dp = [[0] * (m + 1) for _ in range(n + 1)]

        # 初始化边界
        for i in range(1, n + 1):
            dp[i][0] = dp[i -1][0] + 1
        for j in range(1, m + 1):
            dp[0][j] = dp[0][j - 1] + 1

        # 动态递推： 自底向上
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j] , dp[i][j - 1] , dp[i -1][j - 1]) + 1
        return dp[-1][-1]

"""
       r  o  s
  [[0, 1, 2, 3],
 h [1, 1, 2, 3],
 o [2, 2, 2, 3],
 r [3, 3, 3, 3],
 s [4, 4, 4, 4],
 e [5, 5, 0, 0]]
 dp[i-1][j]  : 删除操作
 dp[i][j-1]  : 插入操作
 dp[i-1][j-1] --> d: 替换操作
                    当前            i-1,j       i,j-1    i-1,j-1
 i = 1, j = 1  h r  dp[1][1] = min(dp[0][1], dp[1][0], dp[0][0]) + 1 = min(1, 1, 0) + 1 = 1
 i = 1, j = 2  h o  dp[1][2] = min(dp[0][2], dp[1][1], dp[0][1]) + 1 = min(2, 1, 1) + 1 = 2
 i = 1, j = 3  h s  dp[1][3] = min(dp[0][3], dp[1][2], dp[0][2]) + 1 = min(3, 2, 2) + 1 = 3
 i = 2, j = 1  o r  dp[2][1] = min(dp[1][1], dp[2][0], dp[1][0]) + 1 = min(1, 2, 1) + 1 = 2
 i = 2, j = 2  o o  dp[2][2] = min(dp[1][2], dp[2][1], dp[1][1]) + 1 = min(2, 2, 1) + 1 = 2
 i = 2, j = 3  o s  dp[2][3] = min(dp[1][3], dp[2][2], dp[1][2]) + 1 = min(3, 2, 2) + 1 = 3
 i = 3, j = 1  r r  dp[3][1] = min(dp[2][1], dp[3][0], dp[2][0]) + 1 = min(2, 3, 2) + 1 = 3
 i = 3, j = 2  r o  dp[3][2] = min(dp[2][2], dp[3][1], dp[2][1]) + 1 = min(2, 3, 2) + 1 = 3
 i = 3, j = 3  r s  dp[3][3] = min(dp[2][3], dp[3][2], dp[2][2]) + 1 = min(3, 3, 2) + 1 = 3
 i = 4, j = 1  s r  dp[4][1] = min(dp[3][1], dp[4][0], dp[3][0]) + 1 = min(3, 4, 3) + 1 = 4
 i = 4, j = 2  s o  dp[4][2] = min(dp[3][2], dp[4][1], dp[3][1]) + 1 = min(3, 4, 3) + 1 = 4
 i = 4, j = 3  s s  dp[4][3] = min(dp[3][3], dp[4][2], dp[3][2]) + 1 = min(3, 4, 3) + 1 = 4
 i = 5, j = 1  e r  dp[5][1] = min(dp[4][1], dp[5][0], dp[4][0]) + 1 = min(4, 5, 4) + 1 = 5
 i = 5, j = 2  e o  dp[5][2] = min(dp[4][2], dp[5][1], dp[4][1]) + 1 = min(4, 5, 4) + 1 = 5
 i = 5, j = 3, e s  dp[5][3] = min(dp[4][3], dp[5][2], dp[4][2]) + 1 = min(4, 5, 4) + 1 = 5
"""
