/*
 * @lc app=leetcode.cn id=91 lang=javascript
 *
 * [91] 解码方法
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */var numDecodings = function(s) {
    if(s[0] == "0") return 0;
    let dp = [1, 1], len = s.length;
    for(let i=1; i < len; ++i) {
        if(s[i - 1] != "0") {
            let num = (s[i - 1] + s[i] | 0);
            if(num >= 1 && num <= 26) {
                dp[i + 1] = s[i] != "0"? dp[i - 1] + dp[i]: dp[i - 1];
            } else if(s[i] != "0") {
                dp[i + 1] = dp[i];
            } else {
                return 0;
            }
        } else if(s[i] != "0") {
            dp[i + 1] = dp[i];
        } else {
            return 0;
        }
    }
    return dp[len];
};
// @lc code=end

