#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: word_search_22.py
    @time: 2019/11/23 14:44
"""


class Solution(object):
    def find_words(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]

        复杂度分析：
        1. 对words数组中的单词构建Trie树的操作，假定words数组长度为N，单词word的平均长度为k，则构建Trie树的时间复杂度为O(N * k)
        2. 假定board为m * n的网格，在其中寻找所有单词首字母的操作，其时间复杂度为O(m * n)
        3. 一个单词的dfs操作，除了word的首字母之外，其余剩下的k-1个字母都有上下左右四个位置的寻找操作，因此这里最坏的时间复杂度为O(4 ^ (k-1))
           即O(4 ^ k)

        最好情况时间复杂度：
        最好情况是board中不存在words数组中任何一个单词word的首字母，即dfs操作没有进去，则此时整个操作的时间复杂度为max(O(N * k), O(m * n))

        最坏情况时间复杂度：
        最坏情况是每个单词都满足Trie树查找且每个联通方向都比较到了最后，因此dfs的时间复杂度为O(4 ^ k)，所以整个操作的时间复杂度为
        max(O(N * k), O(m * n * 4 ^ k))

        分析：
        解决本体的宏观思路是：
        1. 对words中的所有word构建Trie树
        2. 对Trie树的第一层key，即所有word的首字母，在board中寻找起始点；若存在则进一步往下验证
        """
        # 构建Trie树，并将words数组中所有的word都装进Trie中
        root, end_of_word = {}, '#'

        for word in words:
            node = root

            for c in word:
                node = node.setdefault(c, {})

            node[end_of_word] = end_of_word

        # dfs
        def dfs(board, i, j, cur_word, cur_node):
            """
                board：二维网格，因为在dfs过程中有些位置已经被访问，所以board形态一直在变，因此需要当参数传递
                i, j：board的坐标
                cur_word：在四联通判断的过程中，当前已经形成的临时word
                cur_node：当前访问到的Trie树的结点

                思考：
                这类递归写法很特别，没有显示的terminator语句（return），而且通常都是用一个数据容器比如list、tuple
                来添加结果
            """
            cur_word += board[i][j]  # 这块是字符串的拼接，如果考虑优化，可使用join方法
            cur_node = cur_node[board[i][j]]

            if end_of_word in cur_node:
                result.add(cur_word)

            tmp, board[i][j] = board[i][j], '@'  # '@'标示已被访问过的位置

            for (dx, dy) in ((0, -1), (0, 1), (-1, 0), (1, 0)):
                x, y = i + dx, j + dy

                if 0 <= x < m and 0 <= y < n and board[x][y] != '@' and board[x][y] in cur_node:
                    # 二维坐标(x,y)合法，且该位置字符没有被访问过，且当前字符存在Trie树中
                    # 满足上述条件，则可继续往下查找
                    dfs(board, x, y, cur_word, cur_node)

            board[i][j] = tmp

        # 开始对二维网格board进行查找，root是一个字典对象，words数组中单词word的首字母均是root的key，
        # 因此这里从满足条件的首字母开始判断
        result, m, n = set(), len(board), len(board[0])  # result用set存储，去除在board找到的重复的word

        for i in range(m):
            for j in range(n):
                if board[i][j] in root:
                    dfs(board, i, j, '', root)

        return list(result)

