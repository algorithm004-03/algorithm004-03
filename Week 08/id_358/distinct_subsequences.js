/** 不同的子序列
 * @param {string} s
 * @param {string} t
 * @return {number}
 * 动态规划

dp[i][j] 代表 T 前 i 字符串可以由 S j 字符串组成最多个数.
所以动态方程:
当 S[j] == T[i] , dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
当 S[j] != T[i] , dp[i][j] = dp[i][j-1]
二维数组中，S作为行，T作为列
初始化时，第一行都是1，表示空字符串的匹配个数都是1，第一列都是0，表示没有匹配的字符，
 */
var numDistinct = function(s, t) {
    const m = s.length;
    const n = t.length;
    const dp = []
    for (let i = 0; i <= n; i++) {
        dp[i] = new Array(m+1).fill(0)
    }
    // 初始化第一行
    for (let j = 0; j <= m; j++) {
        dp[0][j] = 1
    }
    for(let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            if(t[i-1] === s[j-1]) {
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1] // 
            } else {
                dp[i][j] = dp[i][j-1]
            }
        }
    }
    return dp[n][m]
};