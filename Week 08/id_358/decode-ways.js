/**
 * @param {string} s
 * @return {number}
 * dp[i] : 从第i个字符开始的字符串的解码结果个数
 * if(s[i] === 0) return 0
 * if s[i] + s[i+1] <= 26, dp[i] = dp[i+1] + dp[i+2]
 * else dp[i] = dp[i+1]
 */
var numDecodings = function(s) {
    if(!s || s.length === 0) return 0;
    const n = s.length;
    const dp = new Array(n+1)
    dp[n] = 1;
    if(s[n-1] === '0') {
        dp[n-1] = 0
    } else {
        dp[n-1] = 1
    }
    for(let i = n-2; i >= 0; i--) {
        if (s[i] === '0') {
                dp[i] = 0;
                continue;
        }
        if(parseInt(s[i])*10 + parseInt(s[i+1]) <=26) {
            dp[i] = dp[i+1] + dp[i+2]
        } else {
            dp[i] = dp[i+1]
        }
    } 
    return dp[0]
};