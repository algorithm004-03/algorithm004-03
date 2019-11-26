/*
 * @lc app=leetcode.cn id=122 lang=csharp
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
public class Solution {
    public int MaxProfit(int[] prices) {
        int MaxProfit=0;
        for (int i = 1; i < prices.Length; i++)
        {
            if (prices[i]>prices[i-1])
            {
                MaxProfit += prices[i]-prices[i-1];
            }
        }
        return MaxProfit;
    }
}
// @lc code=end

