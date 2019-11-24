/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    var row = text1.length;
    var col = text2.length;
    var dp = new Array(row + 1).fill(0);

    for (var i = 0; i <= row; ++i){
        dp[i] = new Array(col + 1).fill(0);
    }

    for (var i = 1; i < row + 1; ++i){
        for(var r = 1; r < col + 1; ++r){
            if (text1[i - 1] === text2[r - 1]){
                dp[i][r] = dp[i - 1][r - 1] + 1;
            }
            else {
                dp[i][r] = (dp[i - 1][r] > dp[i][r - 1]) ? dp[i - 1][r] : dp[i][r - 1];
            }
        }
    }

    return dp[row][col];
};
