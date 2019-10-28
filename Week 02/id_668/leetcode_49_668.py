#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: group_anagram.py
    @time: 2019/10/22 08:00
"""
import collections


class Solution(object):
    """
        给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

        示例:
        输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
        输出:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]

        说明：
        所有输入均为小写字母。
        不考虑答案输出的顺序。

        总结：
        1. dict中的key必须是可哈希的
        2. 数字、字符串、tuple这些都是可哈希的，dict、list、set均不是可哈希的
        3. collections中的Counter计数效率不高
        4. g = collections.defaultdict(list)，常用这种字典结构直接赋值，比如g['a'].append(xxx)
        5. dict对象的values以集合的方式返回结果
    """

    def group_anagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]

        1. 先对每个字符串排序，排完序之后通过join生成新的字符串
        2. 作判断统计

        时间复杂度：O(nklogk)
        空间复杂度：O(nk)
        """
        d = {}

        for s in strs:
            '''
                sorted函数底层用的是快排，因此对于长度为k的字符串，sorted函数的时间复杂度为klogk
                总共有n个字符串，因此最终时间复杂度为O(nklogk)；空间使用上因为每个字符串都会排序然后
                生成数组再生成新的对象，此外还有额外的字典的开销，因此空间复杂度为O(nk)
            '''
            sort_s = ''.join(sorted(s))

            if sort_s not in d:
                d[sort_s] = []

            d[sort_s].append(s)

        return d.values()

    def group_anagrams2(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]

        1. 先对每个字符串排序，排完序之后通过tuple生成元组
        2. 作判断统计

        时间复杂度：O(nklogk)
        空间复杂度：O(nk)
        """
        d = {}

        for s in strs:
            tuple_s = tuple(sorted(s))

            if tuple_s not in d:
                d[tuple_s] = []

            d[tuple_s].append(s)

        return d.values()

    def group_anagrams3(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]

        当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
        使用python collections包中的defaultdict类

        时间复杂度：O(nklogk)
        空间复杂度：O(nk)
        """
        groups = collections.defaultdict(list)

        for s in strs:
            groups[tuple(sorted(s))].append(s)

        return groups.values()

    def group_anagrams4(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]

        当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
        将每个字符串用数组计数，然后将数组转成tuple结构，存入字典中

        时间复杂度：O(nk)
        空间复杂度：O(nk)
        """
        ans = collections.defaultdict(list)

        for s in strs:
            count = [0] * 26

            for c in s:
                '''
                    对字符串中的字符进行统计计数，然后再比较
                '''
                count[ord(c) - ord('a')] += 1

            ans[tuple(count)].append(s)

        return ans.values()

