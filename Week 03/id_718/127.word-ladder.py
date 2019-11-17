#
# @lc app=leetcode id=127 lang=python3
#
# [127] Word Ladder
#

# @lc code=start
from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList = set(wordList)
        visited = set([beginWord])
        q = deque([beginWord])
        ret = 0
        while q:
            ret += 1
            for _ in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    return ret
                for w in self.generate_next_words(word, wordList):
                    if w not in visited:
                        q.append(w)
                        visited.add(w)
        return 0
    
    def generate_next_words(self, word, wordList):
        ret = []
        for i in range(len(word)):
            for c in 'abcdefghijklmnopqrstuvwxyz':
                next_word = word[:i] + c + word[i+1:]
                if next_word != word and next_word in wordList:
                    ret.append(next_word)
        return ret
# @lc code=end

