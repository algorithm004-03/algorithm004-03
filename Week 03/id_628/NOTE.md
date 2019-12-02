# 第三周总结

## 【本周知识点】

1、遍历--深度优先，广度优先

2、贪心-局部最优解求全局最优解

3、二分查找-牛顿 迭代法

## 【本周学习总结】

【代码模板】

1、DFS

递归模板

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

非递归模板

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



```java
//【数据结构算法之美】
boolean found = false; // 全局变量或者类成员变量

public void dfs(int s, int t) {
  found = false;
  boolean[] visited = new boolean[v];
  int[] prev = new int[v];
  for (int i = 0; i < v; ++i) {
    prev[i] = -1;
  }
  recurDfs(s, t, visited, prev);
  print(prev, s, t);
}

private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
  if (found == true) return;
  visited[w] = true;
  if (w == t) {
    found = true;
    return;
  }
  for (int i = 0; i < adj[w].size(); ++i) {
    int q = adj[w].get(i);
    if (!visited[q]) {
      prev[q] = w;
      recurDfs(q, t, visited, prev);
    }
  }
}
```

2、BFS

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



```java
//【数据结构算法之美】

public void bfs(int s, int t) {
  if (s == t) return;
  boolean[] visited = new boolean[v];
  visited[s]=true;
  Queue<Integer> queue = new LinkedList<>();
  queue.add(s);
  int[] prev = new int[v];
  for (int i = 0; i < v; ++i) {
    prev[i] = -1;
  }
  while (queue.size() != 0) {
    int w = queue.poll();
   for (int i = 0; i < adj[w].size(); ++i) {
      int q = adj[w].get(i);
      if (!visited[q]) {
        prev[q] = w;
        if (q == t) {
          print(prev, s, t);
          return;
        }
        visited[q] = true;
        queue.add(q);
      }
    }
  }
}

private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
  if (prev[t] != -1 && t != s) {
    print(prev, s, prev[t]);
  }
  System.out.print(t + " ");
}
```

3、二分

```python
//模板
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



```java
//【数据结构算法之美】
// 二分查找的递归实现
public int bsearch(int[] a, int n, int val) {
  return bsearchInternally(a, 0, n - 1, val);
}

private int bsearchInternally(int[] a, int low, int high, int value) {
  if (low > high) return -1;

  int mid =  low + ((high - low) >> 1);
  if (a[mid] == value) {
    return mid;
  } else if (a[mid] < value) {
    return bsearchInternally(a, mid+1, high, value);
  } else {
    return bsearchInternally(a, low, mid-1, value);
  }
}
```



## 【线下团建收获】

1、棋盘式题目补充棋盘方式进行降维解题的方法。

2、从数据结构与算法映射到计算机基本原理的收获

## 【学习总结作业题】

> 课后作业题目
>
> 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方 

原理

如果中间点在旋转点左边，则一定大于最后一个点。

如果中间点在旋转点右边，则一定小于最后一个点。

所以使用这个性质可以进行二分查找

即：

如果中间点mid值小于右边界值，则说明旋转点在中间点mid左边，接着在左边界和中间点间开始下一次二分。

如果中间点mid值大于右边界值，则说明旋转点在中间点mid右边，接着在中间点和右边界间开始下一次二分。



代码：

```java
public int search(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int mid = left + ((right - left) >> 1);

        if (nums[mid] < nums[right])
            right = mid;
        else
            left = mid + 1;
    }
    return nums[left];
}
```

