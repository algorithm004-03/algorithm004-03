# 总结

## 动态规划
动态递推，将复杂问题分解成简单子问题。本质上是递归问题、分治问题。  
动态规划和递归或者分治没有根本上的区别（关键看有无最优子结构）  
共性：找到重复子问题
差异性：最优子结构、中途可以淘汰次优解

## 感触
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维（抵制人肉递归的诱惑）
4. 寻找重复性

## 递归代码模板
```java
public void recur(int level, int param) { 

  // terminator 递归终止条件
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic 处理当前层逻辑
  process(level, param); 

  // drill down 递归
  recur( level: level + 1, newParam); 

  // restore current status 清除当前层状态
 
}
```

## 分治代码模板
```python
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
```