# NOTE
### Week 08
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题 3. 数学归纳法思维

##### 关键点
- 动态规划 和 递归或者分治 没有根本上的区别(关键看有无最优的子结构) 
- 拥有共性:找到重复子问题
- 差异性:最优子结构、中途可以淘汰次优解
```
分治代码模板
def divide_conquer(problem, param1, param2, ...): # recursion terminator
    if problem is None:
        print_result
        return
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...) subresult2 = self.divide_conquer(subproblems[1], p1, ...) subresult3 = self.divide_conquer(subproblems[2], p1, ...) ...
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...) # revert the current level states
```
常见dp问题：
- 爬楼梯
- 不同路径
- 打家劫舍
- 最小路径和
- 股票买卖
> Java:
String x = “abb”; String y = “abb”;
x == y —-> false
x.equals(y) —-> true
x.equalIgnoreCase --> true
  

