#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#

# @lc code=start
class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        count = collections.Counter(s)
        
        index = 0
        for ch in s:
            if count[ch] == 1:
                return index
            else:
                index += 1       
        return -1


# @lc code=end

