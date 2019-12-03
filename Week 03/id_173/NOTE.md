# 一、深度优先搜索（DFS）
### 1. 代码模板
##### （1）递归写法
```python
visited = set()
def dfs(node, visited):
	# 终止条件
	if node in visited:
		return
	
	# 处理当前层
	visited.add(node)
	...
	
	# 下探到下一层
	for next_node in node.children():
		if not next_node in visited:
			dfs(next_node, visited)
```
##### （2）非递归写法
```python
def DFS(self, tree): # 借助栈
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

# 二、广度优先搜索（BFS）
### 1. 代码模板
```python
def BFS(graph, start, end): # 借助队列
	queue = []
	queue.append([start])
	visited.add(start)
	
	while queue:
		node = queue.pop()
		visited.add(node)
		
		process(node)
		
		nodes = generate_related_nodes(node)
		queue.push(nodes)
```

# 三、贪心算法（Greedy）
### 1. 概述
　　贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。<br>
　　**贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。而动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。**<br>
　　贪心算法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等，然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。<br>
　　一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。<br>

### 2. 适应场所
　　所要求解的问题能够分解成子问题来解决，并且子问题的最优解能递推到最终问题的最优解（这一点有时候需要证明）。<br>

# 四、二分查找（Binary Search）
### 1. 前提条件
- 目标函数具有单调性
- 存在上下界
- 能够通过索引访问

### 2. 代码模板
```python
left, right = 0, len(array) - 1

while left <= right:
	mid = (left + right) / 2
	
	if array[mid] == target:
		break or return result
	elif array[mid] < target:
		left = mid + 1
	else:
		right = mid - 1
```

# 五、使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方。
```C++
class Solution {
public:
    int findDisorderedPos(vector<int>& nums) {
        int left=0, right=nums.size()-1;

        //情况一：无旋转，即全有序数组，不存在无序的地方，返回-1
        if(nums[0] < nums[right])
            return -1;

        //情况二：有旋转，即半有序数组，存在无序的地方，返回无序地方的后一个位置
        while(left <= right) {
            int mid = left + (right - left) / 2;

            //(1) 找到了无序的地方
            if(nums[mid] > nums[mid+1]) //如果mid为无序地方的前一个位置，那么返回mid+1（如：3 4 [5] 1 2）
                return mid+1;
            if(nums[mid] < nums[mid-1]) //如果mid为无序地方的后一个位置，那么返回mid（如：4 5 [1] 2 3）
                return mid;

            //(2) 未找到无序的地方
            if(nums[mid] > nums[0]) //如果 nums[mid] > nums[0] ，则无序的地方在后半段
                left = mid + 1;
            else //否则，无序的地方在前半段
                right = mid - 1;
        }

        return -1;
    }
};
```
