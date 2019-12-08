//buy and sale on each day when price is higher than prior day
public class Solution
{
    public int MaxProfit(int[] prices)
    {
        var profit = 0;
        for (int i = 1; i < prices.Length; i++)
        {
            if (prices[i - 1] < prices[i])
            {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}


//peak - valley
public class Solution
{
    public int MaxProfit(int[] prices)
    {
        if (prices.Length <= 1) return 0;
        var profit = 0;
        var valley = prices[0];
        var peak = prices[0];
        for (int i = 1; i < prices.Length; i++)
        {
            if (prices[i] > prices[i - 1])
            {
                peak = prices[i];
            }
            else
            {
                profit += peak - valley;
                valley = prices[i];
                peak = prices[i];
            }
        }
        profit += peak - valley;
        return profit;
    }
}