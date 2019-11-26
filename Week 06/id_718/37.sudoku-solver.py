#
# @lc app=leetcode id=37 lang=python3
#
# [37] Sudoku Solver
#

# @lc code=start
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = [set(range(1, 10)) for _ in range(9)]
        col = [set(range(1, 10)) for _ in range(9)]
        grid = [set(range(1, 10)) for _ in range(9)]
        empty = []
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    val = int(board[i][j])
                    row[i].remove(val)
                    col[j].remove(val)
                    grid[ (i // 3) * 3 + j // 3].remove(val)
                else:
                    empty.append((i,j))
        
        def backtrack(iter=0):
            if iter == len(empty): 
                return True
            i, j = empty[iter]
            g = (i // 3) * 3 + j // 3
            for val in row[i] & col[j] & grid[g]:
                row[i].remove(val); col[j].remove(val); grid[g].remove(val)
                board[i][j] = str(val)
                if backtrack(iter+1):
                    return True
                row[i].add(val); col[j].add(val); grid[g].add(val)
            return(False)

        backtrack()


'''
class Solution:
    def solveSudoku(self, board):
        def isValid(board, x, y):
            for i in range(9):
                if i != x and board[i][y] == board[x][y]:
                    return False
            for j in range(9):
                if j != y and board[x][j] == board[x][y]:
                    return False
            i = 3 * (x // 3)
            while i < 3 * (x // 3 + 1):
                j = 3 * (y // 3)
                while j < 3 * (y // 3 + 1):
                    if (i != x or j != y) and board[i][j] == board[x][y]:
                        return False
                    j += 1
                i += 1
            return True
        
        def solver(board):
            for i in range(9):
                for j in range(9):
                    if(board[i][j] == '.'):
                        for k in range(1,10):
                            board[i][j] = str(k)
                            if isValid(board, i, j) and solver(board):
                                return True
                            board[i][j] = '.'
                        return False
            return True
        solver(board)
'''
        
# @lc code=end

