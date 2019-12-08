class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.dx = [-1, 1, 0, 0]
        self.dy = [0, 0, -1, 1]
        self.end_of_words = "#"

        if not board or not board[0] or not words:
            return []

        self.result = set()

        root = dict()
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, dict())
            node[self.end_of_words] = self.end_of_words

        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, "", root)

        return list(self.result)

    def _dfs(self, board, i, j, cur_word, cur_dict):
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]

        if self.end_of_words in cur_dict:
            self.result.add(cur_word)
        tmp, board[i][j] = board[i][j], "@"

        for k in range(4):
            x, y = i + self.dx[k], j + self.dy[k]
            if 0 <= x < self.m and 0 <= y < self.n and board[x][y] != "@" and board[x][y] in cur_dict:
                self._dfs(board, x, y, cur_word, cur_dict)
        board[i][j] = tmp