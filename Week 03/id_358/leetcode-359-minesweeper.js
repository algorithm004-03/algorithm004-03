/** 使用BFS，在while循环里递归，可以不用借助于队列
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 * 1. 碰到M，改为x，输入board；
 * 2. 碰到E，遍历周围M个数 count，count>0,更新该位置为count，输出board，否则更新该位置为B，并遍历相邻8个位置。
 */
 var updateBoard = function (board, click) {
    const rows = board.length;
    const cols = board[0].length;
    const startRow = click[0];
    const startCol = click[1];
    // 记录左上，上，右上，左，右，左下，下，右下8个方向坐标，用于循环click周围8个相邻位置
    const dirs = [
        [-1, 1], [0, 1], [1, 1],
        [-1, 0], [1, 0],
        [-1, -1], [0, -1], [1, -1]
    ];
    // 用于记录应访问过的位置防止重复添加到递归的队列里
     const visited = [];
     for (let i = 0; i < rows; i++){
         visited[i] = [];
         for (let j = 0; j < cols; j++){
             visited[i][j] = false;
         }
     }
    const queue = [];
    queue.push(click);
    visited[startRow][startCol] = true;
    bfs(startRow, startCol);
    return board;
     function bfs(row, col) {
        // while (queue.length > 0) {
            debugger
            if (board[row][col] === 'M') {
                board[row][col] = 'X'
                return board;
            }
            if (board[row][col] === 'E') {
                const count = countSum(row, col);
                if (count > 0) {
                    board[row][col] = count + '';
                } else {
                    board[row][col] = 'B';
                    visited[row][col] = true;
                    for (let i = 0; i < 8; i++) {
                        let newRow = row + dirs[i][0];
                        let newCol = col + dirs[i][1];
                        if (isInBoard(newRow, newCol) && !visited[newRow][newCol]) {
                            if (board[newRow][newCol] === 'E') {
                                visited[newRow][newCol] = true;
                                // queue.push([newRow, newCol]) 
                                bfs(newRow, newCol);
                            } 
                            
                        }
                    }
                }
            } 
            
        // }
    };

    function countSum(row, col) {
        let count = 0;
        for (let i = 0; i < dirs.length; i++) {
            let newRow = row + dirs[i][0];
            let newCol = col + dirs[i][1];
            if (isInBoard(newRow, newCol) && board[newRow][newCol] === 'M') {
                count++;
            }
        }
        return count;
    }
    function isInBoard(row, col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return true;
        } else {
            return false;
        }
    }
};