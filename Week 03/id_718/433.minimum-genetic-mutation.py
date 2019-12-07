#
# @lc app=leetcode id=433 lang=python3
#
# [433] Minimum Genetic Mutation
#

# @lc code=start
from collections import deque
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        ret = -1
        bank = set(bank)
        q = deque([start])
        visited = set([start])
        while q:
            ret += 1
            for _ in range(len(q)):
                word = q.popleft()
                if word == end:
                    return ret
                for nw in self.generate_next_words(word, bank):
                    if nw not in visited:
                        q.append(nw)
                        visited.add(nw)
        return -1
    
    def generate_next_words(self, word, bank):
        ret = []
        for i in range(len(word)):
            for c in 'AGCT':
                nw = word[:i] + c + word[i+1:]
                if nw != word and nw in bank:
                    ret.append(nw)
                    bank.remove(nw)
        return ret
# @lc code=end

