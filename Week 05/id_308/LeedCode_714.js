/**
 * 题目： 买卖股票的最佳时机含手续费
 * 语言： JavaScript
 * 执行结果： 打败了7.35%的用户
 * 方法：动态规划
 * */



/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */
var maxProfit = function(prices, fee) {
    let len = prices.length;
    if(len < 2) return  0;

    prices[0] = [0,-prices[0]-fee];

    for(let i=1;i<prices.length;i++) {
        const temp0 = Math.max(prices[i-1][0],prices[i-1][1]+prices[i]);
        const temp1 = Math.max(prices[i-1][1],prices[i-1][0]-prices[i]-fee);

        prices[i] = [temp0,temp1];
    }

    return Math.max(prices[len-1][0],prices[len-1][1]);
};
