from typing import List
from collections import defaultdict


class Solution:
    def __init__(self):
        # 结果集
        self.result = set()
        self.end_of_word = '#'
        self.grid = [[0, 1], [-1, 0], [0, -1], [1, 0]]

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        # 特判
        if not board or not board[0] or not words or not words[0]:
            return []

        # 构建trie
        root = defaultdict()
        for word in words:
            # 字典树的根
            node = root
            for char in word:
                # 新的根生成新的字典
                node = node.setdefault(char, defaultdict())
            # 结束标志
            node[self.end_of_word] = self.end_of_word

        # board 代表
        board_xs, board_ys = len(board), len(board[0])
        for board_x in range(board_xs):
            for board_y in range(board_ys):
                # 如果board的元素在根里
                if board[board_x][board_y] in root:
                    # 就进行深度优先搜索,
                    self.DFS(board, board_xs, board_ys, board_x, board_y, '', root[board[board_x][board_y]])

        return list(self.result)

    def DFS(self, board_p, board_xs_p, board_ys_p, board_x_p, board_y_p, current_word, current_dict):
        # 每个字符拼成的单词
        current_word += board_p[board_x_p][board_y_p]
        # 如果结尾符在当前字典中
        if self.end_of_word in current_dict:
            # 把当前词放入结果集
            self.result.add(current_word)
        # 为了不让重复使用，把当前字符换掉。
        tmp, board_p[board_x_p][board_y_p] = board_p[board_x_p][board_y_p], '!'
        # 因为是四个方向
        for d in self.grid:
            # 前后左右的移动
            move_x, move_y = board_x_p + d[0], board_y_p + d[1]
            # 不能越界，不能是非字母，并且要在当前字典里
            if 0 <= move_x < board_xs_p and 0 <= move_y < board_ys_p and board_p[move_x][move_y] != '!' \
                    and board_p[move_x][move_y] in current_dict:
                self.DFS(board_p, board_xs_p, board_ys_p, move_x, move_y, current_word,
                         current_dict[board_p[move_x][move_y]])
        # 恢复
        board_p[board_x_p][board_y_p] = tmp


b = [['o', 'a', 'a', 'n'], ['e', 't', 'a', 'e'], ['i', 'h', 'k', 'r'], ['i', 'f', 'l', 'v']]
ws = ["oath", "pea", "eat", "rain"]
s = Solution()
print(s.findWords(b, ws))
