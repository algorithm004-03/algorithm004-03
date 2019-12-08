# NOTE
总结：
1、定义：将复杂问题分解成简单的子问题，递归和分治的方式

共性：找到重复子问题
差异性：最优子结构，中途可以淘汰次优解

2、几个状态转移方程：
    
    
     ```
          a、股票问题
         base case：
          dp[-1][k][0] = dp[i][0][0] = 0
          dp[-1][k][1] = dp[i][0][1] = -infinity
          
          状态转移方程：
          dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
          dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
          ```
          
          b、编辑距离
          
          
          defdp(i, j):
          
          dp(i - 1, j - 1) #1
          
          dp(i, j - 1) #2
          
          dp(i - 1, j) #3
          
          c、打家劫舍
          dp[n] = MAX( dp[n-1], dp[n-2] + num )
          
          d、最长有效括号
          dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
          
          ```
         