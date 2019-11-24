# NOTE

### 第九课 深度优先搜索、广度优先搜索的实现与特性
搜索/遍历：
1. 每个节点都访问到且仅访问一次
2. 对于节点的访问顺序也分为：深度优先Depth First、广度优先Breadth First、优先级优先Priority First等各种顺序

#### 深度优先搜索
在当前循环中不断下探到下一层递归, 直到最深。

```java
void dfs (TreeNode node) {
	if (node == null) return;
	dfs(node.left);
	dfs(node.right);
}
```

#### 广度优先搜索
类似水滴扩散的那种感觉

```java
Queue<TreeNode> queue = new LinkedList<>();

void bfs (TreeNode node) {
	while (!queue.isEmpty()) {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			if (queue.peek().left != null) queue.offer(queue.peek().left);
			if (queue.peek().right != null) queue.offer(queue.peek().right);
		}
	}
}

```

### 第十课 贪心算法的实现、特性
1. 贪心算法是采取当前状态下的最优解, 从而导致全局结果也为最优解的算法
2. 贪心算法与动态规划的不同在于, 它对每个子问题的解决方案都做出当前最优的选择, 不能回退。动态规划则会保存以前的运算结果, 并根据以前的结果来计算当前结果, 可以回退
3. 贪心法可以解决一些最优化问题, 如：求图的最小生成树, 哈弗曼树编码等, 但一般情况下, 贪心法并不能获得总体上的最优解
4. 若一个问题能够通过贪心法解决, 那么贪心法一定是解决该问题的最佳方案, 因为贪心法的高效性, 所以它常常被用作辅助算法


### 第十一课 二分查找

#### 二分查找的前提条件
1. 目标函数的单调性（单调递增/单调递减）, 也就是要求有序
2. 存在上下界
3. 能够通过索引访问

二分查找代码模版：
```java
int left = 0;
int right = arr.length - 1;
while (left < right) {
	int mid = (left + right)/2;
	if (arr[mid] == target) return result;
	else if (arr[mid] < target) left = mid + 1;
	else right = mid - 1;
}
```


