# 算法训练营学习
# 第三周
## 第九课
### 深度优先DFS
1. 主要针对树型数据结构,时间复杂度O(n),每个节点最多一次访问。
2. 模板:
```
递归算法:
visited = set()
def dfs(node, visited):
   # terminator 和递归形式一致
   if node in visited:
       #already visited
       return
   visited.add(node)
   # process current node here
   …
   for next_node in node.children():
       if not next_node in visited:
           dfs(next_node, visited)
非弟归算法(主要基于栈的方式实现):
 def DFS(self, tree):

    if tree.root is None:
        return []

    visited, stack = [], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)
        process(node)
        #获取Node的子节点
        nodes = generate_related_nodes(node)
        stack.push(nodes)

    # other processing work
    ...

```
### 广度优先BFS
1. 主要针对于树型结构,时间复杂度O(n),按层遍历,用于最短路径搜索。
2. 代码模板:
```
主要使用双端队列,或双端链表来处理。
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        # 获取node的所有子节点
        nodes = generate_related_nodes(node)
        queue.push(nodes)
    # other processing work
    ...
```
## 第十课
### 贪心算法Greedy
> 贪心算法是一种在每一步选择中都采取在当前状态下最好或者最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。
 贪心算法与动态规划的不通在于它对每个子问题的解决方案都作出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能
1. 贪心、动态规划区别
    - 贪心:当下每一个子问题都可以做局部最优判断,不能回退。只有在特殊情况下可以达到全局最优。
    - 动态归划: 在贪心的基础上记录了以前的运算结果,并根据以前结果对当前情况进行选择,有回退功能。
2. 贪心、动态规划使用的场景和特点
    - 贪心:求图中最小生成树、哈夫曼编码等。一般不适用处理工程和生活中的遇到的问题,但一旦能用贪心法求解,一般来讲均为最佳办法。
    - 贪心: 在解题时,需先证明 它是最优子结构。即问题能分解为子问题来处理,且子问题的最优解能推导最终问题最优解
    - 动态规划:后面课程再讲
## 第十一课
### 二分查找
1. 二分查找的前提
    - 目标函数存在单调性(这里可包含有规律的单调性)
    - 存在上下界
    - 能够通过索引|下标访问
2. 代码模板
```
left, right = 0, len(array) - 1
while left <= right:
    mid = (left + right) / 2
    if array[mid] == target:
        # find the target!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```
### 旋转排序数组学习
1. 前置条件 有序处均为升序。
2. 边界条件 注意阴险的数组长度为0或1。
3. 通用角法思路
    ```
    1、套上模板。
    2、判断需要调整的是左边界还是右边界。
    3、如何判断是调左边界还是右边界,引出下列几种思路

    ```
    - 穷举,算是暴力不?
    ```
    将左中右三个点,当作一条曲线,除退出条件外只会有四种可能。
    1.升、升,(根据目标与nums[mid]大小比较,调整左右界,超界-1)
    2.升、降,(根据目标落在前半段,right = mid;落在后半段的判断需要结合)
    3.降、升,(此情况,此二个元素即可获得结果)
    4.降、降,(此情况,已经达到边界收敛了,不应出现。)
    ```
    - 判断调整边界,先判断哪端有序
    ```
        先处理向前收缩
            1. 前半有序,且目标在前端。(left<target<mid)
            2. 前半无序(存在反转),且目标在前端。先用mid > right 表明前段有反转。(target < mid,或 target > left )
               此时判断条件里得加上升序这个隐藏条件,如果在上第一段上升,target>left>mid,如果在第二段上升,target<mid<left
        其余则向后收缩
            略
    ```
    - 第三种,异或运算。其实是在第二种基础上总结规律
    ```
        总结规律是 left < target,target<mid,mid<left三项,单数个为真时,向后收缩。
    ```
## 个人感悟
  - **课程学习计划问题**: 本周调整了计划,时间比上周多了3小时。差点走入误区。幸好直播讲解中指出。故再调整下周计划。
  - **练习问题**: 死磕所花费时间过多。五毒神掌,一个典型题目反复练习,比多个题目磕一次,效果要强上不少。
  - 团队问题: 定期"**叫醒**"服务。团队方面,有些愧于组员,相应的提醒提多了之后,组内都没有回应了!