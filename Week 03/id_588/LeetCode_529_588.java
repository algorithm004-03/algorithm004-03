/**
 * 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/description/
 */
public class LeetCode_529_588 {
    int[] dx = new int[]{1, -1, 1, 1, -1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        // 如果是地雷，就结束
        if ('M' == board[x][y]) {
            board[x][y] = 'X';
            return;
        }

        // 如果点击的是E（未挖出的方块）
        if ('E' == board[x][y]) {
            // 计算该方块周围的地雷个数
            int count = countBoom(board, x, y);
            // 如果地雷个数不为0，则在此方块内填上具体数字
            if (0 != count) {
                board[x][y] = (char)(count + '0');
            } else {
                // 如果此方块周围地雷个数为0，则此方块为B，并且对此方块周围的8个方块继续进行遍历
                board[x][y] = 'B';
                for (int i = 0; i < 8; i ++) {
                    int tempX = x + dx[i];
                    int tempY = y + dy[i];
                    if (tempX < 0 || tempX >= board.length || tempY < 0 || tempY >= board[0].length) {
                        continue;
                    }
                    dfs(board, tempX, tempY);
                }
            }
        }
    }

    // 计算某个点周围8个点的地雷个数
    public int countBoom(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i ++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX < 0 || tempX >= board.length || tempY < 0 || tempY >= board[0].length) {
                continue;
            }

            if ('M' == board[tempX][tempY]) {
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
