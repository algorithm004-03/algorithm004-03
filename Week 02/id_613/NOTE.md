# NOTE

### 可以用递归来解决的问题
1、可以分解成重复子问题
2、具有明确的终止条件
3、该问题和其子问题具有相同的解法

### 分治本质上也是一种递归

### 为什么很多题目可以用递归来解决
计算机语言只有if else, for, loop, recursion这几种
简单的指令，因此最后转化成这几种指令的时候，其实就是重复及
迭代

### 用递归来解决问题的思路
主要思路就是寻找其中的重复子问题

### 回溯，本质上也是一种递归的思想
回溯就是在向前解决问题的过程中，每一步往前都有岔路口，分出N种不同的路径，
然后在这一步不断的去试，发现当前路径不行的时候，就回到岔路口再走另外一条
路径，并最终求得正确答案

### 代码模板
泛型递归模板
```
def recursion(level, param1, param2...) {
    // 终止
    if (level > MAX_LEVEL) {
        process_result
        return 
    }
    
    // 处理当前逻辑
    process(level, data...)
    
    // 递归下一层
    recursion(level + 1, ...)
    
    // 清理当前层
    clean_up(level)
}
```

分治模板，比泛型递归多了一个合并结果的操作
其中子问题拆分 及 合并 结果需要经验，需要考究怎么拆分及合并更合理高效
```
def divide_conquer(problem, param1, param2...) {
    // 终止
    if problem is None:
        print_result
        return
        
    // prepare data
    data = prepare_data(problem)
    subproblems = split(problem,data)
    
    // 处理子问题
    subresult1 = divide_conquer(subproblems[0]...)    
    subresult2 = divide_conquer(subproblems[1]...)    
    subresult3 = divide_conquer(subproblems[2]...)
        
    // 合并
    result = process_result(subresult1, subresult2, subresult3...)
    
    // 清理当前层
    clear_up
}

```

