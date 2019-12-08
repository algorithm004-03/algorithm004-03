# NOTE

### 1、状态转移方程总结
    爬楼梯：fn = f(n-1) + f(n - 2);
    不同路径：obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
    打家劫舍：dp[n] = MAX( dp[n-1], dp[n-2] + num )
    股票买卖：dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])，dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    编辑距离：min(dp[i - 1][j],dp[i][j - 1],dp[i - 1][j - 1]) + 1
    不同子序列： if (s.charAt(i - 1) == t.charAt(j - 1)) {
                              dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                          } else {
                              dp[i][j] = dp[i][j - 1];
                          }
    正则表达式：if (p.charAt(j) == '.') {
                              dp[i + 1][j + 1] = dp[i][j];
                          }
                          if (p.charAt(j) == s.charAt(i)) {
                              dp[i + 1][j + 1] = dp[i][j];
                          }
                          if (p.charAt(j) == '*') {
                              if (p.charAt(j-1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                                  dp[i + 1][j + 1] = dp[i + 1][j - 1];
                              } else {
                                  dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                              }
                          }
    
### 2、java 字符串比较
    String x = “abb”; String y = “abb”; 
    x == y  —-> false x.equals(y) —-> true 
    x.equalsIgnoreCase(y) —-> true
    字符串比较
    
    Rabin-Karp 算法的思想： 
    1.假设子串的长度为 M (pat)，目标字符串的长度为 N (txt) 
    2.计算子串的 hash 值 hash_pat 
    3.计算目标字符串txt中每个长度为 M 的子串的 hash 值（共需要计算 N-M+1次） 
    4.比较 hash 值：如果 hash 值不同，字符串必然不匹配; 如果 hash 值相同，还需要使用朴素算法再次判断

