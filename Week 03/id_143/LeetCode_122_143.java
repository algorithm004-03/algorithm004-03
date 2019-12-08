/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int preNum = prices[0];
        int result = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] > preNum){
                result += (prices[i] - preNum);
            }
            preNum = prices[i];

        }
        return result;
    }
}
// @lc code=end