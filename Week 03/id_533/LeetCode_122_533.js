// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

/**
 * @param {number[]} prices
 * @return {number}
 */
// 方法一
// 时间复杂度O(n) 空间复杂度O(1)
var maxProfit = function(prices) {
    var i = 0,
        valley = prices[0],
        peak = prices[0],
        maxprofit = 0;
    while (i < prices.length - 1) {
        while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
        valley = prices[i];
        while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
        peak = prices[i];
        maxprofit += peak - valley;
    }
    return maxprofit;
};

// 方法二
// 时间复杂度O(n) 空间复杂度O(1)
var maxProfit = function(prices) {
    var maxprofit = 0,
        length = prices.length - 1;
    for (var i = 0; i < length; i++) {
        if (prices[i + 1] > prices[i]) maxprofit += prices[i + 1] - prices[i]
    }
    return maxprofit;
};

console.log(maxProfit([7,1,5,3,6,4]));
console.log(maxProfit([7,6,4,3,1]));