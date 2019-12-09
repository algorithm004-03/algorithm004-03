# NOTE
算法训练营第八周
1 高级动态规划
  复习动态规划实现流程
  
  1）最小重复子问题
  2）定义dp状态转换
  3）推导定义dp方程
  4）根据dp方程代码实现。
  
  最短路径dp状态转换方程:
            
            //row 行数，col 列数
            dp[row][col] = obstacleGrid[row-1][col] + obstacleGrid[row][col-1];
  
  股票买卖dp方程:
  定义dp状态：dp(n,k,s) 
   			n是天数，k是允许交易的最大次数(1....k)，s是当前的持有状态(0=没有持有股票,1=持有股票) 
   			
  		  	for 状态1 in 状态1所有取值：
  		  		for 状态2 in 状态2所有取值：
  		  			for 状态3 in 状态3所有取值：
  		  				//dp[状态1][状态2][状态3] = 择优(选择1，选择2，.... 选择n)
  		 	 			 
  	  			dp[i][kk][0] = Math.max(dp[i-1][kk][0], dp[i-1][kk][1]+prices[i]);//第i天未持有股票的最大获利
          		dp[i][kk][1] = Math.max(dp[i-1][kk][1], dp[i-1][kk-1][0]-prices[i]);//第i天持有股票的最大获利
          		
2 字符串算法
    java/python :字符串不可变性，线程安全的。字符串的修改操作会产生一个新的字符串对象。
    C/c++:字符串可变性。
    字符串遍历
    字符串子串问题
    字符串匹配
         Rabin-Karp 缓存及特殊哈希算法
         KMP 通过计算prefix table方式加速向后移动
