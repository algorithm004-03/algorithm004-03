
//dfs with trimming branch. time out.
public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        if (amount <= 0) return 0;
        if (coins.Length <= 0) return -1;
        Helper(coins, amount, 0, 0);
        if (result >= Int32.MaxValue)
            result = -1;
        return result;
    }
    private int result = Int32.MaxValue;
    private void Helper(int[] coins, int amount, int currentAmount, int coinNumbers)
    {
        if (coinNumbers >= result)
            return;
        if (currentAmount > amount)
            return;
        if (currentAmount == amount)
            result = Math.Min(result, coinNumbers);

        foreach (var coin in coins)
        {
            Helper(coins, amount, currentAmount + coin, coinNumbers + 1);
        }
    }
}

//bfs with branch trimming. if not trimming branch, it would out of memory.
public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        if (amount <= 0) return 0;
        if (coins.Length <= 0) return -1;

        var queue = new Queue<int>();
        var amountVisited = new HashSet<int>();
        queue.Enqueue(0);
        int level = 0;
        while (queue.Count() > 0)
        {
            var count = queue.Count();
            while (count-- > 0)
            {
                var prevAmount = queue.Dequeue();
                foreach (var coin in coins)
                {
                    int curAmount = coin + prevAmount;
                    if (curAmount == amount)
                        return level + 1;
                    if (curAmount < amount && !amountVisited.Contains(curAmount))
                    {
                        queue.Enqueue(curAmount);
                        amountVisited.Add(curAmount);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}



//dp

public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        if (amount <= 0) return 0;
        if (coins.Length <= 0) return -1;

        var dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++)
        {
            dp[i] = Int32.MaxValue;
            foreach (var coin in coins)
            {
                if (coin <= i)
                    dp[i] = Math.Min(dp[i], dp[i - coin]);
            }
            dp[i] = dp[i] + 1;
        }
        if (dp[amount] < 0 || dp[amout] >= Int32.MaxValue)
            return -1;
        else
            return dp[amount];
    }
}


//dp loop coins first
public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        if (amount <= 0) return 0;
        if (coins.Length <= 0) return -1;

        var dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
        {
            dp[i] = amount + 1;
        }
        foreach (var coin in coins)
        {
            for (int i = 1; i <= amount; i++)
            {
                if (coin <= i)
                    dp[i] = Math.Min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] >= amount + 1)
            return -1;
        else
            return dp[amount];
    }
}