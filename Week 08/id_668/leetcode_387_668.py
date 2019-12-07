#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: 387_first_unique_character_in_a_string.py
    @time: 2019/12/5 11:04
"""


class Solution(object):
    """
        给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

        案例:
        s = "leetcode"
        返回 0.

        s = "loveleetcode",
        返回 2.

        注意事项：您可以假定该字符串只包含小写字母。
    """

    def first_uniq_char(self, s):
        """
        :type s: str
        :rtype: int
        """
        counter = [0] * 26

        for e in s:
            counter[ord(e) - ord('a')] += 1

        for i in range(len(s)):
            if counter[ord(s[i]) - ord('a')] == 1:
                return i

        return -1
