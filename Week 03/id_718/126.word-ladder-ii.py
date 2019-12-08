#
# @lc app=leetcode id=126 lang=python3
#
# [126] Word Ladder II
#

# @lc code=start
from collections import deque
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        # BFS to save dict, DFS to print path
        dic = set(wordList)
        dic.add(beginWord)
        dist = {}
        self.bfs(endWord, beginWord, dic, dist)
        ret = []
        self.dfs(beginWord, endWord, dic, dist, [beginWord], ret)
        return ret
    
    def bfs(self, start, end, dic, dist):
        dist[start] = 0
        q = deque([start])
        while q:
            word = q.popleft()
            for next_word in self.generate_next_words(word, dic):
                if next_word not in dist:
                    dist[next_word] = dist[word] + 1
                    q.append(next_word)

    def generate_next_words(self, word, dic):
        ret = []
        for i in range(len(word)):
            for c in 'abcdefghijklmnopqrstuvwxyz':
                next_word = word[:i] + c + word[i+1:]
                if next_word != word and next_word in dic:
                    ret.append(next_word)
        return ret
    
    def dfs(self, start, end, dic, dist, path, ret):
        if start == end:
            ret.append(list(path))
            return
        
        for word in self.generate_next_words(start, dic):
            if dist[word] != dist[start] -  1:
                continue
            path.append(word)
            self.dfs(word, end, dic, dist, path, ret)
            path.pop()   
# @lc code=end

