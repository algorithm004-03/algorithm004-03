# NOTE
## Week 3
### 深度优先搜索和广度优先搜索
#### Part 1
- 每个节点都要访问一次
- 每个节点仅仅要访问一次
```
DFS 代码 - 递归写法
visited = set()
def dfs(node, visited):
  if node in visited: # terminator
      # already visited
return
visited.add(node)
# process current node here.
...
for next_node in node.children(): if not next_node in visited:
        dfs(next node, visited)
```

```
非递归写法
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
	...
```

```
BFS 代码模板 - 广度优先
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
#### Part2
- 深度优先搜索（DFS）

在这个策略中，我们采用深度作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回根到达另一个分支。

深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为先序遍历，中序遍历和后序遍历。

- 广度优先搜索（BFS）

我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。


### 贪心算法
#### Part 1
> 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(即最有 利)的选择，从而希望导致结果是全局最好或最优的算法。
> 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不 能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行 选择，有回退功能。
- 贪心：当下做局部最优判断
- 回溯：能够回退
- 动态规划：最优判断 + 回退


### 二分查找
#### Part1
##### 二分查找的前提
1. 目标函数单调性(单调递增或者递减) y=x^2; 
1. 存在上下界(bounded)
1. 能够通过索引访问(index accessible)


```
代码模版
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
#### Part2
##### 半有序数组查找无序的地方
  

