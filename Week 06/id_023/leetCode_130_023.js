/**
@param {character[][]} board
@return {void} Do not return anything, modify board in-place instead.
*/

var solve = function (board) {
  let replaceList = [];
  let curBoard = board;
  for (let i = 0; i < curBoard.length; i++) {
    let curRow = curBoard[i];
    for (let j = 0; j < curRow.length; j++) {
      if (i === 0 || i === curBoard.length - 1 || j === 0 || j === curRow.length - 1) {
        renderOthers(curBoard, i, j)
      }
    }
  }

  // 递归替换四周的O
  function renderOthers(board, x, y) {
    if (x < board.length && x >= 0 && y >= 0 && y < board[0].length) {
      if (board[x][y] === 'O') {
        board[x][y] = '#'
        renderOthers(board, x - 1, y);
        renderOthers(board, x + 1, y);
        renderOthers(board, x, y - 1);
        renderOthers(board, x, y + 1);
      }
    }
  }

  // 将无关联的O替换成X，再将标记的#还原成不需要替换的O
  for (let i = 0; i < curBoard.length; i++) {
    for (let j = 0; j < curBoard[i].length; j++) {
      if (curBoard[i][j] === 'O') {
        curBoard[i][j] = 'X'
      } else if (curBoard[i][j] === '#') {
        curBoard[i][j] = 'O'
      }
    }
  }
};