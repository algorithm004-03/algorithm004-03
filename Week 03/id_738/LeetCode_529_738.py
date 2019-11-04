class Solution(object):
    def updateBoard(self, board, click):
        """
        扫雷游戏：https://leetcode-cn.com/problems/minesweeper/solution/cyan-du-you-xian-sou-suo-jie-jue-by-cailfbit/

        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        # 点击地雷--显示X，返回；
        # 点空方块--若周围有地雷，显示数字n，返回；
        # 点空方块--若周围没有地雷，显示空白‘B’，并递归显示相连的’M‘方块；
        # 不需要考虑其余input；
        # => 如果一个方块显示数字，则不再递归其相邻节点
        
        def dfs(x, y):
            if board[x][y] != 'E' and board[x][y] != 'M':
                return
            if board[x][y] == 'M':
                if x == click[0] and y == click[1]:
                    board[x][y] = 'X'
                return
            else:
                board[x][y] = 0
                for i in range(len(dx)):
                    new_x = x + dx[i]
                    new_y = y + dy[i]
                    if 0 <= new_x < len(board) and 0 <= new_y < len(board[0]):
                        if board[new_x][new_y] == 'M' or board[new_x][new_y] == 'X':
                            board[x][y] += 1
                if board[x][y] == 0:
                    board[x][y] = 'B'
                else:
                    board[x][y] = str(board[x][y])
                    return
            for i in range(len(dx)):
                new_x = x + dx[i]
                new_y = y + dy[i]
                if 0 <= new_x < len(board) and 0 <= new_y < len(board[0]):
                    # if board[new_x][new_y] == 'M' or board[new_x][new_y] == 'E':
                        dfs(new_x, new_y)
                    
            
        dx = [1, -1, 0, 0, 1, -1, -1, 1]
        dy = [0, 0, -1, 1, -1, 1, -1, 1]
        x = click[0]
        y = click[1]
        dfs(x, y)
        return board