# NOTE

## dfs模板，多叉树递归写法
```
visited = set()
def dfs(node, visited):
    # terminator
    if node in visited:
        # already visited
        return
        
    # add to set
    visited.add(node)
    
    # process current node here
    ...
    
    # recursion
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited) 
``` 

## dfs模板，多叉树非递归写法，手工维护一个栈
```
def dfs(root):
    if root is None:
        return []
        
    visited, stack = [], [root]
    
    while stack:
        node = stack.pop()
        visited.add(node)
        
        process(node)
        
        nodes = generate_related_node(node)
        stack.push(nodes)
    
    # other process
    ...
```

## bfs模板, 队列
```
def bfs(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)
    
    while queue:
        node = queue.pop()
        visited.add(node)
        
        process(node)
        
        nodes = generate_related_nodes(node)
        queue.push(nodes)
        
    # other process work
    ...
```

# 贪心算法
## 适用贪心算法的场景
问题能分解为子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解
称为最优子结构

## 贪心算法和动态规划的不同
贪心算法对每个子问题都做出选择，且不能回退；动态规划会保存以前的运算结果，并根据以前的
计算结果对当前进行选择，有回退功能

## coin change可以用贪心法来解决的场景
大额的硬币是其他小额硬币面额的倍数，因此每一步选择小额的硬币不如选择较大面额的硬币，从
而具有最优子结构

## 贪心算法的难点
1、怎么证明题目可以用贪心法来解决
2、贪心算法有很多变种，可以从前到后贪心，也可以从后到前贪心，甚至需要预先做一些变换


# 二分法
## 能用二分查找的三个条件
1、目标函数单调性（单调递增或递减）
2、存在上下界（bounded）
3、能随机访问（index accessible）

## 二分查找模板
```
left, right = 0, array(length-1)
while (left <= right) {
    mid = (left + right) / 2
    if (array[mid] == target) {
        break or return result
    } else if (array[mid] < target) {
        left = mid + 1
    } else {
        right = mid - 1
    }
}
```