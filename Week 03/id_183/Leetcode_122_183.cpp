/*
 * @lc app=leetcode id=122 lang=cpp
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        //每天都做买卖
        //assunmpt for the best option (always)
        int profit = 0;
        for(int i =1;i<prices.size();++i)
        {
            int tmp = prices[i] - prices[i-1];
            if(tmp > 0) profit += tmp;
        }
        return profit;
    }
};
// @lc code=end

