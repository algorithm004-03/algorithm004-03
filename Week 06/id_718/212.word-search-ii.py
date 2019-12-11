#
# @lc app=leetcode id=212 lang=python3
#
# [212] Word Search II
#

# @lc code=start
from collections import defaultdict
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
END_OF_WORD = '#'
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0]:
            return []
        if not words:
            return []
        # trie
        root = defaultdict()
        for word in words:
            node = root
            for c in word:
                node = node.setdefault(c, defaultdict())
            node[END_OF_WORD] = END_OF_WORD

        # search with a trie
        m, n = len(board), len(board[0])
        ret = set()
        for i in range(m):
            for j in range(n):
                if board[i][j] in root:
                    self._dfs(board, ret, i, j,'', root)
        return list(ret)
    
    def _dfs(self, board, ret, i, j, cur_word, cur_dict):
        m, n = len(board), len(board[0]) 
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]
        if END_OF_WORD in cur_dict:
            ret.add(cur_word)
        tmp, board[i][j] = board[i][j], '@'
        for k in range(4):
            x, y = i + dx[k], j + dy[k]
            if 0 <= x < m and 0 <= y < n and board[x][y] != '@' and board[x][y] in cur_dict:
                self._dfs(board, ret, x, y, cur_word, cur_dict)
        board[i][j] = tmp
# @lc code=end

