/**
 * 题目： 买卖股票的最佳时机 II
 * 语言： JavaScript
 * 执行结果： 打败了60.78%的用户
 * 方法：动态规划
 * */


/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    const len = prices.length;
    if(len < 2) return 0;
    prices[0] = [0,-prices[0]];

    for(let i=1;i<len;i++) {
        const temp0 = Math.max(prices[i-1][0],prices[i-1][1]+prices[i]);
        const temp1 = Math.max(prices[i-1][1],prices[i-1][0]-prices[i]);
        prices[i] = [temp0,temp1];
    }

    return Math.max(prices[len-1][0],prices[len-1][1]);
};