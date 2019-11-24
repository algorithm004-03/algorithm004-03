class Solution(object):
    def findWords(self, board, words):
        """
        单词搜索2：https://leetcode-cn.com/problems/word-search-ii/

        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        def dfs(x, y, cur_word, cur_node, board):
            if '#' in cur_node:
                result.append(cur_word)
            tmp, board[y][x] = board[y][x], None
            for (dx, dy) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                _x, _y = x + dx, y + dy
                if 0 <= _x < col_size and 0 <= _y < row_size and board[_y][_x] and board[_y][_x] in cur_node:
                    dfs(_x, _y, cur_word + board[_y][_x], cur_node[board[_y][_x]], board)
            board[y][x] = tmp

        root = {}
        for word in words:
            node = root
            for w in word:
                node = node.setdefault(w, {})
            node['#'] = '#'

        result, col_size, row_size = [], len(board[0]), len(board)
        for n in range(col_size):
            for m in range(row_size):
                if board[m][n] in root:
                    dfs(n, m, board[m][n], root[board[m][n]], board)
        return set(result)
        







        

