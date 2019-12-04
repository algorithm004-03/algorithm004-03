# 第三周学习总结

## 遍历搜索

- 绝大多数情况下我们使用的搜索都是比较简单的暴力搜索，即将所有节点都遍历一次
- 如果这个数据结构是没有任何特点的普通的树或者图，我们要做的就是保证所有的点都遍历一次并且仅访问一次
- 对于节点的访问顺序不同可以分为 `深度优先(depth first search)` 和 `广度优先(breadth first search)`
- 还有其他的优先级不同的搜索方式可以定义，例如优先级优先

### 深度优先搜索

- 各种递归
- 在处理当前层时，访问当前node，将node加入到已访问的结点中
- 终止条件就是当前结点已经被访问过
- 下转就是进入到它的子结点中
  - 二叉树就是左孩子和右孩子
  - 图就是它联通的相邻结点
  - 多叉树是它的children，把所有的children遍历一次
- DFS递归写法

    ```python
    visited = set()
    def dfs(node, visited):
        # terminator
        if node in visited:
            # already visited
            return

        visited.add(node)
        # process current node here
        ...
        for next_node in node.chldren():
            if not next_node in visited:
                dfs(next_node, visited)
    ```

- DFS非递归写法，手动维护一个栈，模拟一个递归

    ```python
    def dfs(self, tree):
        if tree.root is Node:
            return []

        visited, stack = [], [tree.node]
        while stack:
            node = stack.pop()
            visited.add(node)

            process(node)
            nodes = generate_related_nodes(node)
            stack.push(nodes)
        # other processing work
        ...
    ```

### 广度优先搜索

- 用数组队列来进行遍历
- 在Java中更多用一个链表或者是双端队列(deque)来表示
- BFS代码

    ```python
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

        # other porcessing work
        ...
    ```

## 贪心算法

- 贪心算法(Greedy)是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法
- 贪心算法对每个子问题的解决方案都做出选择，不能回退
- 动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能

### 适用性

- 贪心算法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等
- 如果问题可以用贪心算法解决，那么一般是解决这个问题的最好办法
- 由于贪心算法的高效性以及其所求得的答案比较接近最优结果，贪心算法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题
- 一个问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解，这种子问题最优解称为最优子结构

## 最近重复性

- 最近重复性就是最近相似性，较远的相似性很多性质也会有很大不同
- 要找最近重复性才最有可能复用代码
- 最大公约数

## 学习方法上

- 改变自己的学习喜欢，不去死磕题目
- 五毒神掌重要的是五遍，每遍不要花太长时间
- 一定要去看高票代码和题解
