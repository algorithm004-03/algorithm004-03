from typing import List
from collections import defaultdict
from collections import deque


class Trie:

    def __init__(self):
        self.root = {}
        self.end = '#'

    def insert(self, word):
        curr = self.root
        for c in word:
            curr = curr.setdefault(c, {})
        curr[self.end] = True

    def search(self, word):
        curr = self.root
        for c in word:
            curr = curr.get(c)
            if not curr:
                return False
        return curr.get(self.end)

    def startsWith(self, word):
        curr = self.root
        for c in word:
            curr = curr.get(c)
            if not curr:
                return False
        return True


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for word in words:
            trie.insert(word)

        rows = len(board)
        cols = len(board[0])
        res = set()

        def dfs(x, y, curr, node):
            if x < 0 or x >= cols or y < 0 or y >= rows \
                    or board[y][x] == '@' \
                    or board[y][x] not in node:
                return

            char = board[y][x]
            curr += char
            node = node[char]

            if trie.end in node:
                res.add(curr)

            board[y][x] = '@'
            dfs(x+1, y, curr, node)
            dfs(x, y+1, curr, node)
            dfs(x-1, y, curr, node)
            dfs(x, y-1, curr, node)
            board[y][x] = char

        for y in range(rows):
            for x in range(cols):
                dfs(x, y, "", trie.root)

        return list(res)