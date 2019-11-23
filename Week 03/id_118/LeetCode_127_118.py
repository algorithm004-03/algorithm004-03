# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 10/31/2019
from collections import deque
from typing import List


class Solution1:
    """
    Brute Force: Will TLE
    """

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        queue = [(beginWord, 1)]
        visited = set()
        letters = "abcdefghijklmnopqrstuvwxyz"

        while queue:
            word, dist = queue.pop(0)

            if word == endWord:
                return dist

            for i in range(len(word)):
                for j in letters:
                    tmp = word[:i] + j + word[i + 1:]
                    if tmp not in visited and tmp in wordList:
                        visited.add(tmp)
                        queue.append([tmp, dist + 1])
        return 0


class Solution2:
    """
    This solution uses a hashmap to store all the state spaces
    Use more space for less time
    """

    def ladderLength(self, beginWord, endWord, wordList):
        """
        main method body
        :param beginWord: word to start
        :param endWord: target end word
        :param wordList: word lists
        :return: steps
        """
        if (not beginWord) or (not endWord) or (not wordList):
            return 0
        state_d = self._construct_dict(wordList)
        return self.bfs(beginWord, endWord, state_d)

    def _construct_dict(self, wordList):
        """
        convert wordList into a neighbor dictionary of list
        :param wordList:
        :return:
        """
        res = {}
        for w in wordList:
            for i in range(len(w)):
                tmp_word = w[:i] + "_" + w[i + 1:]
                res[tmp_word] = res.get(tmp_word, []) + [w]
        return res

    def bfs(self, beginWord, endWord, state_d):
        """
        bfs
        :param beginWord:
        :param endWord:
        :param state_d:
        :return:
        """
        queue, visited = deque([(beginWord, 1)]), set()
        while queue:
            word, steps = queue.popleft()
            if word == endWord:
                return steps
            if word not in visited:
                visited.add(word)
                for i in range(len(word)):
                    tmp_word = word[:i] + "_" + word[i + 1:]
                    neighbor_words = state_d.get(tmp_word, [])
                    for nw in neighbor_words:
                        if nw not in visited:
                            queue.append((nw, steps+1))
        return 0
