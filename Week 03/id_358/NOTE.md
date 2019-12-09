# [358-Week 03] 学习总结

##   第三周 第九课

本课学习了深度优先搜索（DFS）和广度优先搜索（BFS）的原理和实战解析。

### DFS 模板代码：

写法一：

```python
visited = set()
def dfs(node, visited):
	visited.add(node)
  # process current node here
  for next_node in node.children:
    if not next_node in visited:
      dfs(next_node, visited)
```



写法二：

```python
visited = set()
def dfs(node, visited):
  if node in visited: # terminator
    return
  visited.add(node)
  # process current node here
  for next_node in node.children:
    if not next_node in visited:
      dfs(next_node, visited)
```

> DFS还可以借助*栈*实现。

### BFS模板代码：

借助队列

```python
def bfs(graph, start, end):
	queue = []
  queue.add(start)
  visited.add(start)
  while queue:
    node = queue.pop()
    visited.add(node)
    nodes = generate_related_nodes(node)
    queue.push(nodes)

```

### 实战题解析

#### 1. 二叉树的层次遍历

该问题的关键是如何在遍历的过程中按层次归集结果。

解法1：BFS

解法2：DFS（每次访问时记录每个节点的层次）

#### 2. 括号生成

之前出现过的题目。这里可以用DFS完成。

#### 3. 岛屿数量问题

思路：“flood fill”，“洪水算法”。遍历棋盘，遇到0跳过，遇到1使用sink方法，DFS递归处理，将其周围相邻的1都变为0.返回操作次数1；最终统计操作次数的总数 = 岛屿数量。

## 第三周 第十课 贪心算法

本课学习了贪心算法的原理和实现。

### 定义：

每一步选择中都采取当前状态下最好的或最优的选择，从而希望导致全局的结果都是最优的。

### 与动态规划的区别：

对每个子问题的解决方法都做出选择。

贪心算法不能回退。

动态规划会保存之前的运算结果，并根据以前的结果对当前结果进行选择，有回退功能。

### 用途

可以解决一些最优化的问题：求图的最小生成树，求哈夫曼编码等。只要能证明每一步是最优，到最后也是最优的就行。

> 一般不会用来解决工程上或生活中的问题。因为往往都是比较低效的算法。
>
> 但可以作为解决问题的辅助方法。

### 实战题目解析

#### 1. 硬币组合

> 如果硬币可选集合固定，且数额满足整除关系，可以用贪心算法。（20，10，5，1）

使用贪心算法。

> 问题可以分解成子问题。子问题的最优解递推到最终问题的最优解。



#### 2. 分饼干问题

思路：优先满足胃口小的小朋友。两个数组排序后，用一个while循环。

#### 3. 最近卖股票的时机

解法一：贪心算法。

解法二：动态规划

> 此题其实换个角度想，只要后一天的价格比前一天搞，就可以低买高卖，把所有利润累加就得到最大利润。

#### 4. 跳跃游戏

```js
reachable = nums.length - 1
for(let i = nums.length -1; i >=0; i--) {
	if(nums[i] + i >= reachable) {
		reachable = i;
	}
}
if(reachable === 0){
	return true;
}
```

## 第三周 第十一课 二分查找法

本课学习了二分查找的实现，特性。

### 二分查找的前提

1. 目标函数具有单调性
2. 存在上下边界
3. 能够通过索引访问

### 代码模板：

```python
left, right = 0, len(array) - 1
while left <= right:
  mid = (left + right) / 2
  if arary[mid] === target:
    # find the result'
    return result;
  elif array[mid] < target:
    left = mid + 1
  else
  	right = mid - 1
```

### 实战题

#### 1. 实现求平方根的函数sqrt()

解法一： 二分

解法二：牛顿迭代法



### 2. 旋转数组

1. 暴力法： 数组还原成有序的Ologn
2. 二分查找（该问题符合使用二分查找的前提， 两个有序的数组）















