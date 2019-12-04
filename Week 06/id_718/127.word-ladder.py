#
# @lc app=leetcode id=127 lang=python3
#
# [127] Word Ladder
#

# @lc code=start

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList = set(wordList)
        if endWord not in wordList: 
            return 0
        front, back = {beginWord}, {endWord}
        ret = 1 # notice : 1 here
        n = len(beginWord)
        while front:
            ret += 1
            next_front = set()
            for word in front:
                for i in range(n):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if c != word[i]:
                            nw = word[:i] + c + word[i+1:]
                            if nw in back:
                                return ret
                            if nw in wordList:  
                                next_front.add(nw)
                                wordList.remove(nw) # could also use Visited
            front = next_front
            if len(front) > len(back):
                front, back = back, front
        return 0

'''
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
'''
# @lc code=end

