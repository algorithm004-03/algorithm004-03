from collections import defaultdict


class Solution(object):
    """
    This solution uses collections' defaultdict
    """
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        wordSet = set([])
        for word in wordList:
            wordSet.add(word)

        letters = 'abcdefghijklmnopqrstuvwxyz'
        level = set([beginWord])

        parents = defaultdict(set)

        while level and endWord not in parents:
            next_level = defaultdict(set)
            for word in level:
                for i in range(len(beginWord)):
                    p1 = word[:i]
                    p2 = word[i + 1:]
                    for j in letters:
                        # accelerate 
                        if word[i] != j:
                            childWord = p1 + j + p2
                            if childWord in wordSet and childWord not in parents:
                                next_level[childWord].add(word)
            level = next_level
            parents.update(next_level)

        res = [[endWord]]
        while res and res[0][0] != beginWord:
            res = [[p] + r for r in res for p in parents[r[0]]]

        return res