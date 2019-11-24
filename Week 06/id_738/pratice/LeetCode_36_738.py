class Solution(object):
    def isValidSudoku(self, board):
        """
        有效的数独: https://leetcode-cn.com/problems/valid-sudoku/submissions/
        
        :type board: List[List[str]]
        :rtype: bool
        """
        # 对所有元素进行遍历一遍
        # 对9行每一行的数字进行计数
        # 对9列每一列的数字进行计数
        # 对9个格子每个格子的数字进行计数
        # 如果上面3个计数任何一个计数数字>1则False
        # 计数方法用字典，三种计数每种计数需要9个字典存储
        row = [{} for _ in range(9)]
        col = [{} for _ in range(9)]
        box = [{} for _ in range(9)]
        for i in range(9): #行
            for j in range(9): #列
                num = board[i][j]
                if num == '.':
                    continue
                if num in row[i] or num in col[j] or num in box[i // 3 * 3 + j // 3]:
                    return False
                row[i][num] =  col[j][num] = box[i // 3 * 3 + j // 3][num] = 1
        return True
