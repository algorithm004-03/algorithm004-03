
//double pointer or optimized brute force
public class Solution
{
    public int MaxProfit(int[] prices)
    {
        if (prices.Length <= 1) return 0;

        var minPrice = prices[0];
        var maxProfit = 0;
        for (int i = 1; i < prices.Length; i++)
        {
            minPrice = Math.Min(minPrice, prices[i]);
            maxProfit = Math.Max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}

//dp
public class Solution
{
    public int MaxProfit(int[] prices)
    {
        if (prices.Length <= 1) return 0;

        var dp = new int[prices.Length];
        dp[0] = 0;
        for (int i = 1; i < prices.Length; i++)
        {
            dp[i] = dp[i-1] + 
                    Math.Max(prices[i] - prices[i-1], 0);
        }
        return dp[prices.Length -1];
    }
}
