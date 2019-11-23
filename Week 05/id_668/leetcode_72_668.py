#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: edit_distance.py
    @time: 2019/11/17 18:21
"""


class Solution(object):
    """
        给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
        你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符

        示例 1:
        输入: word1 = "horse", word2 = "ros"
        输出: 3
        解释:
        horse -> rorse (将 'h' 替换为 'r')
        rorse -> rose (删除 'r')
        rose -> ros (删除 'e')

        示例 2:
        输入: word1 = "intention", word2 = "execution"
        输出: 5
        解释:
        intention -> inention (删除 't')
        inention -> enention (将 'i' 替换为 'e')
        enention -> exention (将 'n' 替换为 'x')
        exention -> exection (将 'n' 替换为 'c')
        exection -> execution (插入 'u')
    """

    def min_distance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int

        国际站高票答案
        """
        m, n = len(word1), len(word2)
        dp = [list(range(n + 1))] + [[r + 1] + [0] * n for r in range(m)]

        print dp

        for i in range(m):
            for j in range(n):
                dp[i + 1][j + 1] = dp[i][j] if word1[i] == word2[j] else min(dp[i][j], dp[i + 1][j], dp[i][j + 1]) + 1
        return dp[m][n]

