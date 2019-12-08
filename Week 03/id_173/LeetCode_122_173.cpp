/*
 * 122. 买卖股票的最佳时机 II
 */

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxprofit = 0;
        
        for(int i=1; i<prices.size(); ++i) {
            if(prices[i] > prices[i-1])
                maxprofit += prices[i] - prices[i-1];
        }

        return maxprofit;
    }
};