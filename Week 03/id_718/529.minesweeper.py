#
# @lc app=leetcode id=529 lang=python3
#
# [529] Minesweeper
#

# @lc code=start
class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        if not board or not board[0]:
            return board
        x, y = click
        if board[x][y] == "M":# dig into the mine, you can modify it directly and then return
            board[x][y] = "X"
            return board        
        m, n = len(board), len(board[0])
        visited = [[False for _ in range(n + 1)] for j in range(m + 1)]
        self.dfs(x, y, board, visited)
        return board

    def dfs(self, x0, y0, board, visited):
        if board[x0][y0] == "M" or visited[x0][y0]: 
            return
        m, n = len(board), len(board[0])
        visited[x0][y0] = True 
        mineCnt = 0  
        dx = (1, 1, -1, -1, 0, 0, -1, 1)
        dy = (1, 0, -1, 0, 1, -1, 1, -1)       
        for k in range(8):
            x = x0 + dx[k]
            y = y0 + dy[k]
            if 0 <= x < m and 0 <= y < n and board[x][y] == "M":
                mineCnt += 1
        
        if mineCnt > 0:
            board[x0][y0] = str(mineCnt) 
        else:
            board[x0][y0] = 'B'

            for k in range(8):
                x = x0 + dx[k]
                y = y0 + dy[k]
                if 0 <= x < m and 0 <= y < n and not visited[x][y]:
                    self.dfs(x, y, board, visited)
                        
# @lc code=end

