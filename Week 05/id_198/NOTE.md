# NOTE

- [ ] 什么样的问题适合DP？

## 回归

分治=>回溯=>递归=>动态规划

递归go代码模板：
```go
func recursion(level, param1, param2, ...): 
    //recursion terminator 
    if level > MAX_LEVEL{ 
	   //process_result 
	   return 
    }
    // process logic in current level 
    process(level, data...) 

    // drill down 
    recursion(level + 1, p1, ...)

    // reverse the current level status if needed
```

分治go代码模板
```go
func divideConquer(problem, param1, param2, ...): 
  // recursion terminator 
  if problem == nil: 
	// print_result 
	return 

  // prepare data 
  data = prepareData(problem) 
  subproblems = splitProblem(problem, data) 

  // conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  // process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  //revert the current level states
```

* [动态规划](https://en.wikipedia.org/wiki/Dynamic_programming)
* [MIT 动态规划课程最短路径算法](https://www.bilibili.com/video/av53233912?from=search&seid=2847395688604491997)
* [一个方法团灭 6 道股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/)