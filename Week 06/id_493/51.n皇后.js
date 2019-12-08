/*
 * @lc app=leetcode.cn id=51 lang=javascript
 *
 * [51] N皇后
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
                // 皇后的数量
                let queenNum = n;
                // 存放皇后和对应列的关系
                let placeMap = new Map();
                // 存放一共有多少种放法
                let count = 0;
                let result = [];
             
                // 放第curRow+1个皇后到curRow行
                function placeQueen(curRow) {
                    // curRow大于等于queenNum，说明所有皇后都放完了，是一种放法
                    if (curRow >= queenNum) {
                        count++;
                        let curResult = [];
                        for (let row = 0; row < queenNum; row++) {
                          let occupyCol = placeMap.get(row);
                          curResult.push('.'.repeat(occupyCol) + 'Q' + '.'.repeat(queenNum - occupyCol - 1));
                        }
                        result.push(curResult);
                        return;
                    }
                    // 把第n个皇后试图放到每一列上
                    for (let col = 0; col < queenNum; col++) {
                        // 检查是否可以放到第n列上
                        if (checkPosition(curRow, col)) {
                            // 可以放下的话，就存储皇后对应的列号，再接着放下一个皇后
                            placeMap.set(curRow, col);
                            placeQueen(curRow + 1);
                        }
                    }
                }
                function checkPosition(curRow, curCol) {
                    for (let i = 0; i < curRow; i++) {
                        // 检查n行，m列上，是否可以放皇后
                        let occupyCol = placeMap.get(i);
                        let row = i;
                        /***
                        * 1、在同一个行上。所有皇后都在不同的行上，无需判断这种情况
                        * 2、在同一个列上。curCol == occupyCol
                        * 3、在对角线上。判断条件是 列号减行号相同；occupyCol - i == curCol - curRow
                        * 4、在斜对角线上。判断条件是 列号加行号相同；occupyCol + i == curCol + curRow
                        ***/
                        if (curCol == occupyCol || (occupyCol - row == curCol - curRow) || (occupyCol + row == curCol + curRow)) {
                            return false;
                        }
                    }
                    return true;
                }
                   // 第一个皇后放第一行
                placeQueen(0);
                return result;
};
// @lc code=end

