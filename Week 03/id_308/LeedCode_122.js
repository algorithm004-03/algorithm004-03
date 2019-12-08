
/**
 * 题目： 买卖股票的最佳时机 II
 * 语言： JavaScript
 * 执行结果： 打败了70%的用户
 * 方法：贪心算法
 * */


/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let buy = null;
    let money = 0;
    for(let i = 0; i < prices.length;i++) {
        const curr = prices[i];
        const next = prices[i+1];

        if(buy !== null){
            if(!next || next <= curr ){
                money = money + (curr - buy);
                buy = null;
            }
        }else if(next && next > curr) {
            buy = prices[i];
        }
    }

    return money;
};
