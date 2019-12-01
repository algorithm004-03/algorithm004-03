# NOTE

## 递归模板
```
    Python 代码模板
    def recursion(level, param1, param2, ...): 
        # recursion terminator 
        if level > MAX_LEVEL: 
        process_result 
        return 

        # process logic in current level 
        process(level, data...) 

        # drill down 
        self.recursion(level + 1, p1, ...) 

        # reverse the current level status if needed


    Java 代码模板
    public void recur(int level, int param) { 

    // terminator 
    if (level > MAX_LEVEL) { 
        // process result 
        return; 
    } 

    // process current logic 
    process(level, param); 

    // drill down 
    recur( level: level + 1, newParam); 

    // restore current status 
    
    }
```
## 分治模板
```
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
### 感触
1. 拒绝人肉递归
2. 找最近最简单方法，将其拆解为可重复解决的问题
3. 善用数学归纳法
   
本质： 寻找重复性

## dp == 动态递推 
1. 最优子结构
2. 存储中间状态
3. 递推公式 
  

