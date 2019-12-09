/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
    if (s === "") {
        return -1;
    }
    const repeatMap = {};
    for (let i = 0; i < s.length; i++) {
        if (repeatMap[s[i]]) {
            repeatMap[s[i]]++
            continue;
        }

        repeatMap[s[i]] = 1;
    }

    for (let i = 0; i < s.length; i++) {
        if (repeatMap[s[i]] === 1) {
            return i;
        }
    }

    return -1;
};


function DP() {
    let dp = [][] // ⼆维情况   
    for (let i = 0; i < M; i++ {
        for (let j = 0; j < N; j++) {
            dp[i][j] = _Function(dp[i’][j’]…)
        }
    }
    return dp[M][N];
}