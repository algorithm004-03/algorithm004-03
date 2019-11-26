#
# @lc app=leetcode id=455 lang=python3
#
# [455] Assign Cookies
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        s.sort()
        g.sort()
        cnt = 0
        for cookie in s:
            if cnt > len(g) - 1:
                break
            if cookie >= g[cnt]:
                cnt += 1
        return cnt
        
# @lc code=end

