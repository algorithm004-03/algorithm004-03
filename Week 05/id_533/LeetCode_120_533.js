// https://leetcode-cn.com/problems/triangle/

/**
 * @param {number[][]} triangle
 * @return {number}
 */
// dp状态定义为一维数组
// 时间复杂度O(n * m) 空间复杂度O(m)
var minimumTotal = function(triangle) {
    var n = triangle.length,
        dp =  triangle[n - 1];
    for (var i = n - 2; i >= 0; i--) {
        for (var j = 0; j < triangle[i].length; j++) {
            dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);
        }
    }
    return dp[0];
};

// dp状态复用triangle(不推荐)
// 时间复杂度O(n * m) 空间复杂度O(1)
var minimumTotal = function(triangle) {
    var n = triangle.length;
    for (var i = n - 2; i >= 0; i--) {
        for (var j = 0; j < triangle[i].length; j++) {
            triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1])
        }
    }
    return triangle[0][0];
};

var res = minimumTotal(
    [
        [2],
       [3,4],
      [6,5,7],
     [4,1,8,3]
   ]
)

console.log(res);