# NOTE
Week05学习总结

1.了解动态规划的实现以及关键点
   1)复习递归代码的模板(方法调用方法自身)
	
		public void recurise(int level, int param) {
			
			//1 recurisor terminator == 递归终结条件
			if(level> MAX_LEVEL)
				//process result == 处理递归终止的返回结果
				return;
			
			//2 process current level logic == 当前层逻辑处理
			process(level, param);
			
			//3 drill down == 调用自身，递归方法
			recurise(level:level+1,newParam)
			
			//4 restore current status == 按需要重置状态
			
			
		}
		
  
   2)复习分治代码模板(将复杂问题分解为重复子问题，然后合并执行结果)
   		
		def divide_conquer(problem, param1, param2, ...): 
			  # recursion terminator 
			  if problem is None: 
				print_result 
				return 
	
			  # prepare data 
			  data = prepare_data(problem) 
			  subproblems = split_problem(problem, data) 
			
			  # conquer subproblems 
			  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
			  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
			  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
			  …
			
			  # process and generate the final result 
			  result = process_result(subresult1, subresult2, subresult3, …)
				
			  # revert the current level states
   		
   3)动态规划定义
		通过将复杂的问题分解为递归的更简单的子问题来简化处理，思路是将问题分解为子问题然后递归地找到子问题的最优解来最佳地解决问题，即寻找最优子结构。
   		
   4)动态规划的步骤
   	 i) 寻找重复子问题
   	 ii) 定义动态规划状态
   	 iii) 推导动态规划方程  	
		

 2 代表性练习题
 	股票的买卖时机，该习题有一系列的衍生扩展，但是都可以套用相同模板:
 	动态规划 ：
 			定义dp状态：dp(n,k,s) 
 			n是天数，k是允许交易的最大次数(1....k)，s是当前的持有状态(0=没有持有股票,1=持有股票) 
 			
		  	for 状态1 in 状态1所有取值：
		  		for 状态2 in 状态2所有取值：
		  			for 状态3 in 状态3所有取值：
		  				//dp[状态1][状态2][状态3] = 择优(选择1，选择2，.... 选择n)
		 	 			 
	  			dp[i][kk][0] = Math.max(dp[i-1][kk][0], dp[i-1][kk][1]+prices[i]);//第i天未持有股票的最大获利
        		dp[i][kk][1] = Math.max(dp[i-1][kk][1], dp[i-1][kk-1][0]-prices[i]);//第i天持有股票的最大获利
	  
	  		