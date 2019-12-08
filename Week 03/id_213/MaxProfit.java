//思路：题目前提是我们可以获取股票在整个阶段的价格，做出左右选择。
//     （1）当股票价格一直上涨我们可以不用考虑，直到价格最高，获取最高收益。
//     （2）我们需要选择在股票下降的前一天抛出，然后在第二天以较低价格买入，
//      (3)考虑到一个周期中有多次涨跌，我们用数组记录这些极点，用极大值的和减去极小值的和即为所求值/
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) 
                i++;
                valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
                peak = prices[i];
                maxProfit += peak - valley;
        }
        return maxProfit;
    }
}