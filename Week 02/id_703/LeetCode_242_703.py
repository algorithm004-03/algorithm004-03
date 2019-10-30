#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
from typing import List

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sort_s = sorted(list(s))
        sort_t = sorted(list(t))
        return sort_s == sort_t

# if __name__ == "__main__":
#     s = "anagram"
#     t = "nagaram"
        
# @lc code=end

