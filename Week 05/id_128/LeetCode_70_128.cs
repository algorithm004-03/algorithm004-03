
//fib
public class Solution
{
    public int ClimbStairs(int n)
    {
        if (n < 3) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++)
        {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}

//dp
public int ClimbStairs(int n)
{
    if (n <= 2) return n;
    var dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}