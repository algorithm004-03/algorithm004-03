"""
第五课第一题：242. 有效的字母异位词
https://leetcode-cn.com/problems/valid-anagram/description/
"""
import collections

"""
解法一：
使用Python的Counter()
"""
class Solution_1:
    def isAnagram(self, s: str, t: str) -> bool:
        return collections.Counter(t) == collections.Counter(s)

"""
解法二：
排序比较
"""
class Solution_2:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)


"""
解法三：
使用字典存储字母出现的次数
"""


class Solution_3:
    def isAnagram(self, s: str, t: str) -> bool:
        dic = {}

        for i in s:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1

        for i in t:
            if i not in dic or dic[i] <= 0:
                return False
            dic[i] -= 1

        for i in dic:
            if dic[i] != 0:
                return False
        return True