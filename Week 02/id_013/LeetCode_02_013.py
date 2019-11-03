"""
第二题：49. 字母异位词分组
https://leetcode-cn.com/problems/group-anagrams/
"""

# 有点难，参考官方解答多一点，:(
import collections

"""
解法一：
当且仅当它们的排序字符串相等时，两个字符串是字母异位词
"""
class Solution_1(object):
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return ans.values()

"""
解法二：
计数分类，当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
"""
class Solution_2:
    def groupAnagrams(strs):
        ans = collections.defaultdict(list)
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            ans[tuple(count)].append(s)
        return ans.values()