// https://leetcode-cn.com/problems/unique-paths/

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
    if(m <= 0 || n <= 0) return 0;
    var dp = [];
    for (var i = 0; i < n; i++) {
        dp[i] = [];
        dp[i][0] = 1;
    }
    for (var i = 0; i < m; i++) 
        dp[0][i] = 1;
    for (var i = 1; i < n; i++) {
        for (var j = 1; j < m; j++) 
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
    }
    return dp[n-1][m-1];
};

console.log(uniquePaths(3, 2));
console.log(uniquePaths(7, 3));