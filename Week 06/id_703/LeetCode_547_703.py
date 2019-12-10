#
# @lc app=leetcode.cn id=547 lang=python3
#
# [547] 朋友圈
#

# @lc code=start
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        p = [[i] for i in range(n)]
        ans = n
        for i, j in itertools.combinations(range(n), 2):
            if M[i][j] == 1 and p[i] is not p[j]:
                p[i] += p[j]
                for k in p[j]:
                    p[k] = p[i]
                ans -= 1
        return ans

# @lc code=end

