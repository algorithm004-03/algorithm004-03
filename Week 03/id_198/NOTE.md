# NOTE

## 学习总结

### 如何查找解

1. 分析问题适合的数据结构
2. 选定适合的1中数据结构的算法
3. 求解

## 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

该问题和[33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)的解法类似。
搜索旋转排序数组中，我的解法是优先确定有序部分（经过旋转的数组在使用二分法后，无论是左半部分还有右半部分，至少有一部分是有序的），判断是否目标值是否在有序部分，存在则继续在有序分查找，否则进入另一部分查找.
该题的同样，确定有序部分，若左半部分有序，则进入右半部分进入查找旋转点。
比较mid值和mid-1的值，
* 若nums[mid-1] > nums[mid]则mid为无序点
* 若nums[mid] > nums[mid+1]则mid+1为无序点

代码参考:

## 本周课程涉及编程模板

### 二分查找模板

```python
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

### DFS - Recursion
```python
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
```
### DFS - loop

```python
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

### BFS 

```python
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

## 阅读文章

- [Origin of Quake3's Fast InvSqrt() - Page 1](https://www.beyond3d.com/content/articles/8/)