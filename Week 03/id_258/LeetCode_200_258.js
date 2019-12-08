/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    let count = 0;

    function depthSearch(x, y) {
        if (grid[x][y] === '1') {
            grid[x][y] = '0';
        } else {
            return
        }

        if (x < grid.length - 1) {
            depthSearch(x + 1, y);
        }

        if (y < grid[x].length - 1) {
            depthSearch(x, y + 1);
        }

        if (x > 0 && x < grid.length) {
            depthSearch(x - 1, y);
        }

        if (y > 0 && y < grid[x].length) {
            depthSearch(x, y - 1);
        }
    }

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] === '1') {
                count++;
                depthSearch(i, j);
            }
        }
    }

    return count;
};
// @lc code=end