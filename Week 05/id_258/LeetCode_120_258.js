/*
 * @lc app=leetcode.cn id=120 lang=javascript
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {

    for(let i = triangle.length - 2; i >= 0; i--) {
        for(let j = 0; j < triangle[i].length; j++) {
            triangle[i][j] += Math.min(triangle[i+1][j], triangle[i+1][j+1]);
        }
    } 

    return triangle[0][0];
};
// @lc code=end

