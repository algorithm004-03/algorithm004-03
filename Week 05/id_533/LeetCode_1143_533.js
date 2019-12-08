// https://leetcode-cn.com/problems/longest-common-subsequence/

/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    if (!text1.length || !text2.length) return 0
    var dp = [],
        m = text1.length,
        n = text2.length;
    for (var i = 0; i < n; i++) {
        dp[i] = []
        dp[i][0] = text2[i] === text1[0] ? 1 : (i === 0 ? 0 : dp[i - 1][0]);
    }
    for (var i = 0; i < m; i++) {
        dp[0][i] = text1[i] === text2[0] ? 1 : (i === 0 ? 0 : dp[0][i - 1]);
    }
    for (var i = 1; i < n; i++) {
        for (var j = 1; j < m; j++) {
            if (text2[i] === text1[j]) 
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
    }
    return dp[n - 1][m - 1];
};

console.log(longestCommonSubsequence('abcde', 'ace'));