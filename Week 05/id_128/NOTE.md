# NOTE

public class Solution
{
    public int ClimbStairs(int n)
    {
        if(n==1 || n==2)
            return 1;
        if(n==3)
            return 3;
       
        var dp = new int[n+1, 4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i=4; i<=n; ++i) {
            dp[i][1] = dp[i-1][2]+dp[i-1][3];
            dp[i][2] = dp[i-2][1]+dp[i-2][3];
            dp[i][3] = dp[i-3][1]+dp[i-3][2];
        }
    
        return dp[n][1] + dp[n][2] + dp[n][3];
    }
}


DP 的一些技巧
1. top down 遇到困难的话， 可以尝试bottom up
2. 字符串变化问题 通常需要二维dp
3. 没有思路写dp状态转移方程时， brute force 可以帮助打开思路
4. 当找到子问题和状态但子问题无法合并为原始问题时，考虑增加一个状态或定义更严格的子问题并从所有子问题的解中找寻最佳结果作为原始问题的结论

DP 的思考过程
1. 尝试分解子问题
2. 找到涉及到的【状态】
3. 找到【选择】 
4. 写出不同的【选择】导致的【状态】变化的方程
