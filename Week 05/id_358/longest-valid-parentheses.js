/**
 * 设数组dp，初始化每个位置为0；下标为i处更新值为：以字符串下标i元素结尾的最长有效子字符串的长度
 * 有以下情况：形如 ....() 的字符串，dp[i] = dp[i-2] + 2 
 * 形如 .....)) 的字符串， 下标i-1为有效字符串的结尾，下标i为更大有效字符串结尾，设下标为i-1元素所在有效子字符串为sub，
 * sub的长度为dp[i-1], sub之前的有效字符串长度为 dp[i- dp[i-1] - 2]; 求和得 dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] -2]
 * @param {string} s
 * @return {number}
 */
// var longestValidParentheses = function(s) {
//     let max = 0;
//     let dp = new Array(s.length).fill(0)
//     for(let i = 1; i <s.length; i++ ){
//         if(s[i] === ')') {
//             if(s[i-1] === '(') {
//                 dp[i] = (i>=2 ? dp[i-2]: 0) + 2
//             }
//             else if(i-dp[i-1] > 0 && s[i-dp[i-1] -1] === '(') {
//                 dp[i] = dp[i-1] + ((i-dp[i-1] >=2) ? dp[i-dp[i-1] -2] : 0) +2
//             }
 
//              max = Math.max(dp[i], max)
//         }
       
//     }
//     return max;
// };

var longestValidParentheses = function(s) {
    var max = 0;
    var n = s.length;
    var dp = new Array(n).fill(0);
    for(var i = 1;i < n;i++){
       if(s[i] == ')'){
           // 右括号前边是左括号
           if(s[i-1] == '('){
               dp[i] = ( i >= 2 ? dp[i-2] : 0) + 2;
           }
           // 当前右括号前边是右括号，并且前一个合法子序列的前边是左括号和当前右括号组成一对，则最长子序列个数加2
           else if(i - dp[i-1] > 0 && s[i - dp[i-1] - 1] == '('){
               dp[i] = dp[i-1] + ( (i - dp[i-1] >= 2) ? dp[i - dp[i-1] - 2] : 0 ) + 2;
           }
            max = Math.max(max,dp[i]);
       }
    }
    return max;
};