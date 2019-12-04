class Solution(object):
    def solveSudoku(self, board):
        """
        解数独:https://leetcode-cn.com/problems/sudoku-solver/#/description

        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # 先将所有需要填充的格子找出来放到to_fill数组中
        to_fill = []
        # 计算出需要填充的格子可以填充的数字
        row = [set(range(1, 10)) for _ in range(9)]
        col = [set(range(1, 10)) for _ in range(9)]
        box = [set(range(1, 10)) for _ in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.': # 找出需要填充的格子
                    to_fill.append((i, j))
                else: # 已经有数字的格子，写入row, col, box
                    num = int(board[i][j])
                    row[i].remove(num)
                    col[j].remove(num)
                    box[i // 3 * 3 + j // 3].remove(num)
        # 上面初始化完毕，下面进行真正的递归填充判断
        def fill(n):
            if n == len(to_fill):
                return True
            i, j = to_fill[n]
            k = i //3 * 3 + j // 3
            # 循环num可以填充的数字
            for num in row[i] & col[j] & box[k]:
                board[i][j] = str(num)
                row[i].remove(num)
                col[j].remove(num)
                box[k].remove(num)
                if fill(n + 1):
                    return True
                row[i].add(num)
                col[j].add(num)
                box[k].add(num)
            return False
        fill(0)











