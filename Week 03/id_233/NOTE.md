# 233-Week 03 学习总结
## 知识点
### 1 搜索
- 搜索就是在树（图/状态集）中寻找特定节点
- 搜索的本质就是每个节点都要访问一次，且只访问一次
- 根据节点访问顺序不同可分为: 
    - 深度优先 DFS
    - 广度优先 BFS
```
//DFS 代码模版 递归实现
visited = set() 
def dfs(node, visited):
if node in visited: # terminator
	# already visited 
	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if not next_node in visited: 
			dfs(next_node, visited)
//DFS 代码模版 循环+栈实现
def dfs(self, tree): 
	if tree.root is None: 
		return [] 
	visited, stack = [], [tree.root]
	while stack: 
		node = stack.pop() 
		visited.add(node)
		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
//BFS 代码模版 循环+队列 实现
def BFS(graph, start, end):
	queue = [] 
	queue.append([start]) 
	visited.add(start)
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...
```
### 2 贪心算法 Greedy
- 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（最有利）的选择，从而希望导致结果是全局最好或最优的算法
- 对每个子问题的解决方案都做出最优选择，==***且不能回退！！！***==
- 贪心、回溯、动态比较
    - 贪心：当下局部最优判断
    - 回溯：能够回退
    - 动态规划：动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能
### 3 二分查找 BinarySearch
- 二分查找法又称折半查找法
- 二分查找前提
    - 目标函数单调性（单调递增或单调递减）***==有序(sorted)==***
    - 存在上下界 ***==（bounded）==***
    - 能够通过索引访问 ***==（index accessidle）==***
- [二分查找代码模版解读](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/)
```
//代码模版
left, right = 0, len(array) - 1
while left <= right:
    mid = (left + right) / 2
    if array[mid] == target:
        # find the target!!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
return -left-1//left>right的情况 

```