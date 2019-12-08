/**
 * 题目： 三角形最小路径和
 * 语言： JavaScript
 * 执行结果： 打败了66.38%的用户
 * 方法：动态规划
 * */

/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
    const len =  triangle.length;

    if(len === 0) return 0;
    if(len === 1) return Math.min(...triangle[0]);

    const dp = triangle;
    for(let j=len-2;j>=0;j--) {
        for(let i=0;i<dp[j].length;i++) {
            dp[j][i] = dp[j][i] + Math.min(dp[j+1][i],dp[j+1][i+1]);
        }
    }

    return dp[0][0];
};