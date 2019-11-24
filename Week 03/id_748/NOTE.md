# 深度优先搜索(DFS)
>从根节点出发，递归下去再回溯上来
>不撞南墙不回头，一条路走到黑
## 实现方法
1. 递归 
2. 栈
## 模版代码
### 递归写法
```
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
```
### 			dfs(next_node, visited)

非递归写法
```
def DFS(self, tree): 

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
```
# 	...

广度优先搜索(BFS)
>从根节点出发，一层一层的遍历
>地毯式搜索
## 实现方法
1. 数组
2. 队列
## 模版代码
```
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
```
	...


# 贪心算法
## 概念
* 贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。 
# 动态规划
## 概念
* 动态规划的本质不在于是递推或是递归，也不需要纠结是不是内存换时间
* 动态规划(dynamic programming)是运筹学的一个分支，是求解决策过程(decision process)最优化的数学方法
* 动态规划算法与分治法类似，其基本思想也是将待求解问题分解成若干个子问题，先求解子问题，然后从这些子问题的解得到原问题的解。与分治法不同的是，适合于用动态规划求解的问题，经分解得到子问题往往不是互相独立的
# 二分查找
## 概念
* 二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列
## 模版代码
```
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
```

