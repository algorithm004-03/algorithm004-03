/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var min = Infinity;
    var max = 0;
    var len = prices.length;

    for(var i = 0; i < prices.length; ++i){
        if (prices[i] <= min) {
            min = min < prices[i] ? min : prices[i];
        }
        else {
            max = prices[i] - min > max ? prices[i] - min : max;
        }
    }

    return max;
};
