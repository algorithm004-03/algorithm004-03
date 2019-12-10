#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: 72_edit_distance.py
    @time: 2019/12/04 22:21
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

        DP 自底向上思考
        解决两个单词之间的问题，主要的思路是：
            1. 一个单词当作行，另一个单词当作列，这样就构建了一个二维数组，然后在这个二维数组框架中进行思考
            2. 通常从两个单词的尾部元素开始向前进行思考、递推，这也是DP自底向上的思考方式

        题意说明word1可经过插入、删除、替换字符的方式转换成word2，然后求最少的转换次数。
        DP状态转义：dp[i][j]表示word1中从头到i位置形成的字符串sub_word1与word2中从头到j位置形成的字符串
        sub_word2之间的编辑距离。分别从两个单词的尾字符开始向前比较，如果两个字符（假设ch1、ch2）相同，
        则两个单词的编辑距离dp[i][j]=dp[i-1][j-1]，因为两个字符已经相同，不需要任何方式的转换。
        如果两个字符不同，则对于word1来说有三种处理方式，1.将ch1替换成ch2，此时编辑距离dp[i][j] = dp[i-1][j-1] + 1，
        1表示替换的一次操作；2.将ch1删除，此时编辑距离dp[i][j] = dp[i-1][j] + 1；3.在ch1尾部插入ch2，此时编辑距离
        dp[i][j] = dp[i][j-1] + 1；这三种方式均可使得word1更接近word2一步，因为求最小转换路径，因此
        dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1。
        因此DP状态方程为：dp[i][j] = dp[i-1][j-1] if ch1 = ch2 else min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1

        谨记：
        1. 编辑距离比较的是两个从头到当前位置的子字符串的编辑距离，不是当前字符的编辑距离
        2. dp[i][j]表示word1中从头到i位置形成的字符串sub_word1与word2中从头到j位置形成的字符串sub_word2之间的编辑距离
        3. word1、word2当前比较的位置分别为i、j；dp[i-1][j-1]表示i位置字符替换成j位置字符的操作；dp[i-1][j]表示i位置字符
        删除操作；dp[i][j-1]表示i位置后面插入j位置元素的操作
        """
        m, n = len(word1), len(word2)  # 选定word1表示行数，word2表示列数
        dp = [[0] * (n + 1) for _ in range(m + 1)]  # 因为要考虑到其中一个单词为空的情况，因此这里创建多一行多一列的dp二维数组

        # 第一行 空字符串word1变换成word2
        for j in range(1, n + 1):
            dp[0][j] = dp[0][j - 1] + 1

        # 第一列 word1变换成空字符串word2
        for i in range(1, m + 1):
            dp[i][0] = dp[i - 1][0] + 1

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:  # 因为二维举证是从1位置开始，而单词还是从0位置开始，因此单词索引的操作要分别-1
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1

        return dp[-1][-1]
