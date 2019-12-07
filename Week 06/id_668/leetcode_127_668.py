#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: word_ladder.py
    @time: 2019/11/21 15:14
"""
from collections import defaultdict


class Solution(object):
    """
        给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
        转换需遵循如下规则：
        每次转换只能改变一个字母。
        转换过程中的中间单词必须是字典中的单词。

        说明:
        如果不存在这样的转换序列，返回 0。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

        示例 1:
        输入:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]
        输出: 5
        解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
             返回它的长度 5。

        示例 2:
        输入:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]
        输出: 0
        解释: endWord "cog" 不在字典中，所以无法进行转换。
    """

    def ladder_length(self, begin_word, end_word, word_list):
        """
        :type begin_word: str
        :type end_word: str
        :type word_list: List[str]
        :rtype: int

        从beginword开始，寻找wordlist中与beginword单词相差一个字母的单词，获取到这些单词，然后再往下分别
        寻找与之相差一个字母的单词，直到首先找到endword。
        """
        if end_word not in word_list:
            return 0

        length = len(begin_word)
        all_combo_dict = defaultdict(list)

        for word in word_list:
            '''
                对每个单词，以通配符对应该单词的方式记录下来，比如hot单词，
                记录方式为{'*ot':['hot'], 'h*t':['hot'], 'ho*':['hot']}
                把所有的单词分别都统计出来
            '''
            for i in range(length):
                wildcard_word = '{0}*{1}'.format(word[:i], word[i + 1:])
                all_combo_dict[wildcard_word].append(word)

        '''
        构造的all_combo_dict类型如下
        all_combo_dict = {
            u'do*': [u'dot', u'dog'],
            u'h*t': [u'hot'],
            u'*ot': [u'hot', u'dot', u'lot'],
            u'd*t': [u'dot'],
            u'lo*': [u'lot', u'log'],
            u'ho*': [u'hot'],
            u'c*g': [u'cog'],
            u'l*g': [u'log'],
            u'd*g': [u'dog'],
            u'*og': [u'dog', u'log', u'cog'],
            u'co*': [u'cog'],
            u'l*t': [u'lot']
        }
        '''

        queue = [(begin_word, 1)]
        visited = {begin_word: True}

        while queue:
            current_word, level = queue.pop(0)

            # 对每个单词可能的通配符单词进行全部对比，比如hit，会分别对比*it, h*t, hi*
            for i in range(length):
                intermediate_word = current_word[:i] + "*" + current_word[i + 1:]

                for word in all_combo_dict[intermediate_word]:
                    if word == end_word:
                        return level + 1

                    # Otherwise, add it to the BFS Queue. Also mark it visited
                    if word not in visited:
                        visited[word] = True
                        queue.append((word, level + 1))

        return 0

    def ladder_length2(self, begin_word, end_word, word_list):
        """
        :type begin_word: str
        :type end_word: str
        :type word_list: List[str]
        :rtype: int

        国际站双向BFS
        """
        import string

        if begin_word == end_word:
            return 1

        if end_word not in word_list:
            return 0

        q1, q2 = {begin_word}, {end_word}  # Note: set not dict
        d = {b: 1 for b in word_list}  # either remove visted or hash
        steps = 1

        while q1 and q2:
            if len(q1) > len(q2):
                q1, q2 = q2, q1  # balance

            nq = set()

            for x in q1:
                for i in range(len(x)):
                    for t in string.ascii_lowercase:
                        if x[i] == t:
                            continue

                        y = x[:i] + t + x[i + 1:]

                        if y in q2:
                            return steps + 1

                        if d.get(y, 0):
                            d[y] = 0
                            nq.add(y)

            q1 = nq
            steps += 1

        return 0

