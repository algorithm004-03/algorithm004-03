# NOTE

  

### DFS深度优先

#### 算法模板

##### python版递归写法

```python
visited = set()

def dfs(node, visited):
  # 终止条件: 已经访问过的, 就不再访问了
  if node in visited:
    return
  
  visited.add(node)

  # 对当前节点进行处理
	process(node)

  # 针对多叉树的操作
  for sub_node in node.children():
    if not sub_node in visited:
      dfs(sub_node, visited)

  # 针对二叉树的操作
  dfs(node.left, visited)
  dfs(node.right, visited)

```

##### Java版递归写法

```java
private Set<Node> visited = new HashSet<>(); // 定义已经访问过的数据集

public void dfs(Node node) {
  // 终止条件: 已经访问过的, 就不要再访问了
  if (visited.contains(node)) return;

  visited.add(node);

  // 对当前节点进行处理(如添加到结果集中)
  this.process(node);

  // 针对多叉树
  for (Node subNode : node.children()) {
    if (!visited.contains(subNode)) {
      dfs(subNode);
    }
  }

  // 针对二叉树
  dfs(node.left);
  dfs(node.right);
}
```

##### python版遍历(非递归)写法

* 需要手动维护一个栈

```python
def dfs(self, tree):
  if tree.root is None:
    return []
  
  # 定义访问过的集合 与 栈, 并初始化栈
  visited, stack = [], [tree.root]

  while stack:
    node = stack.pop() # 弹出栈顶元素
    visited.add(node) # 加入到访问记录

    # 处理当前节点(如添加到结果集中)
    process(node)
    sub_nodes = get_sub_nodes(node) # 获取子节点
    stack.push(sub_nodes) # 将子节点压入栈中

```

##### Java版遍历(非递归)写法

```java
public void dfs(Tree tree) {

  if (tree.root == null) return;

  // 定义访问记录结果集
  Set<Node> visited = new HashSet<>();
  // 定义栈, 并初始化栈
  Stack<Node> stack = new Stack<>();
	stack.push(tree.root);

  while (!stack.empty()) {
    Node node = stack.pop(); // 弹出栈顶元素
    visited.add(node); // 加入到访问记录

		// 处理当前节点(如添加到结果集中)
    process(node);
    List<Node> subNodes = getSubNodes(node); // 获取子节点
    // 放入到栈中
    for (Node subNode : subNodes) {
      if (visited.contains(subNode)) {
        stack.push();
      }
    }
  }
}
```



### BFS广度优先

#### 算法模板

##### python版本

```python
visited = set()

def bfs(graph, start, end):
	queue = []
  queue.append([start])
  visited.add(start)
  
  while queue:
    node = queue.pop()
    visited.add(node)
    # 处理当前节点
    process(node)
    sub_nodes = get_sub_nodes(node)
    queue.push(nodes)

```

##### java版本写法

```java
private Set<Node> visited = new HashSet<>(); // 定义已经访问过的数据集

public void bfs(Graph graph, Node start, Node end) {
	Queue<Node> queue = new LinkedList<>();
  queue.offer(start);
  visited.add(start);

  while (!queue.isEmpty()) {
    Node node = queue.poll();
    visited.add(node);

    // 处理当前节点
    process(node);
    List<Node> subNodes = this.getSubNodes(node);
    for (Node subNode : subNode) {
      if (!visited.contains(subNode)){
        queue.add(subNode);
      }
    }
  }
}
```



### 贪心算法

* 局部最优解
  * 每一步选择中, 寻找最优
* 通常不是全局最优解
* 与动态规划的区别

| 贪心         | 回溯     | 动态规划           |
| ------------ | -------- | ------------------ |
| 当下局部最优 | 能够回退 | 记录以前的运算结果 |

#### 贪心算法的适用条件

* 问题能够分解成子问题
* **子问题最优解** 能递推为 **全局最优解**
* 从后往前贪心, 或者从局部切入贪心





### 二分查找

#### 使用条件

* 目标函数的单调性 (单调递增或者递减)
* 存在上下界 (bounded)
* 能够沟通过索引访问 (index accessible)

#### 算法模板

##### python版本

```python
left, right = 0, len(array) - 1
while left <= right:
	mid = (left + right) / 2
  if array[mid] == target:
    # find the target!
    break or return result
  elif array[mid] < target:
    left = mid + 1
  else:
    right = mid + 1

```

#### 作业题

```java
    /*
    思路:
    时间复杂度 O(logN) 则意味着: 要使用二分查找了

    1 2 3 4 5 6 7 可以分成2种情况
        2 3 4 5 6 7 1
        6 7 1 2 3 4 5

        第一类 2 3 4 5 6 7 1 也就 nums[left] <= nums[mid] 2 <= 5
        	    这种情况下, 前半部分有序
            如果 nums[left] <= target < nums[mid], 则在前半部分查找, 否则后半部分

        第二类 6 7 1 2 3 4 5 也就是 nums[left] > nums[mid] 6 > 2
            这种情况下, 后半部分有序
            如果 nums[mid] < target <= nums[right], 则在后半部分查找, 否则前半部分

     */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = (right - left) / 2 + left; // 相当于 (right + left) / 2

            if (nums[mid] == target) return mid;

            // 前半部分有序, 包含mid
            if (nums[left] <= nums[mid]) {
                // target在前半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 后半部分有序
                // target 后半部分
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }


        }

        return -1;
    }

```

