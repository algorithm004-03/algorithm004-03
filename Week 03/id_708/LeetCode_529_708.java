// dfs
// 仔细看条件，访问只有一轮：踩到地雷则退出，否则找出当前位置相邻的所有没有地雷的位置（注意：此时查找的是没有地雷的节点！）
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') board[row][col] = 'X';
        else findAdjacentBlankNode(board, row, col);

        return board;
    }
    
    private void findAdjacentBlankNode(char[][] board, int row, int col) {
        int bRow = board.length;
        int bCol = board[0].length;
        
        // 不是地雷，就分两种情况：周围有地雷；周围无地雷
        // 遍历九宫格
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int r = row+i, c = col+j;
                // 周围挖出来一颗地雷
                if (r >= 0 && c >= 0 && r < bRow && c < bCol && board[r][c] == 'M') {
                    count++;
                }
            }
        }

        if (count > 0) {
            board[row][col] = (char)('0' + count);
        } else {
            // 当前位置周围无地雷，继续遍历周围节点
            board[row][col] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int r = row+i, c = col+j;
                    // 周围挖出来一颗地雷
                    if (r >= 0 && c >= 0 && r < bRow && c < bCol && board[r][c] == 'E') {
                        findAdjacentBlankNode(board, r, c);
                    }
                }
            }
        }
    }
}