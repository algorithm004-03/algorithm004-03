#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start

from typing import List
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = defaultdict(list)
        # print(dic)
        for s in strs:
            _s = ''.join(sorted(s))
            dic[_s].append(s)

        return dic.values()


# @lc code=end

