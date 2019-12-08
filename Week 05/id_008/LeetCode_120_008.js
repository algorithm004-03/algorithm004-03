/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
    var dp = triangle;
    for (var i = dp.length - 2; i >= 0; --i){
        for (var j = 0; j < dp[i].length; ++j){
            dp[i][j] += dp[i + 1][j] < dp[i + 1][j + 1] ? dp[i + 1][j] : dp[i + 1][j + 1];
        }
    }

    return dp[0][0];
};
