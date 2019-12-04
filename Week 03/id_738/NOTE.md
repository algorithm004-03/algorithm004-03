# 第三周总结 + 分析解答二分查找半序数组最小值下标问题

## 第三周知识点总结

### 深度优先搜索、广度优先搜索的实现和特性

- 深度优先：
 - 如果一个题目，能分解成像一棵树一样的分叉，然后一直分叉下去，那么都可以归结到深度优先里面
- 广度优先：
 - 用于寻最短路径
- 深度优先搜索代码模板
 - 递归(N叉树)
 ```python
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
 ```
 - 非递归
 ```python
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
- 广度优先代码模板（链表，双端队列）
```python
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
### 贪心算法Greedy

>> 贪心算法是一种在每一步选择中都采取在当前状态下最好或者最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。
>> 贪心算法与动态规划的不通在于它对每个子问题的解决方案都作出选择，不能回退。
>> 动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

- 贪心、回溯、动态规划区别
 - 贪心：当下做局部最优判断
  - 贪心算法不会得到全局最优，但是，某些情况下可以。
   - 在某一步使用贪心算法，在全局加上搜索，递归或者全局规划
 - 回溯：能够回退
  - 动态规划：最优判断 + 回退
- 贪心算法解决可以解决一些最优化问题
 - 求图中的最小生成树
 - 求哈夫曼编码
 - 等
- 适用贪心算法的场景：(主要是能证明它是最优子结构)
 - 最优子结构：问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解

### 二分查找

- 二分查找的前提
 - 1.目标函数单调性（单调递增或者递减）
 - 2.存在上下界（bounded）
 - 3.能够通过索引访问（index accessible）
- 代码模板：(肌肉式记忆)
```pyton
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

## 第三周学习感想

本周学习了

1. 深度广度优先遍历，其实在之前的树遍历课程中就已经或多或少涉及了。只不过这里更加全面的介绍了算法，而且应用场景也不局限于二叉树了，还扩展到图，N叉树以及各种递归层层深入的程序中。

2. 贪心算法。严格来讲，应该说是贪心思想。一个问题要能使用贪心思想，那么肯定问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。另外，贪心并不代表蠢，有时候也是一种智慧的选择。比如5，10，15的找零问题，贪心的作出能用10找零就不用5这个决定，其实是很有智慧的。。

3. 二分查找，通过大量练习，完全记忆了二分查找的代码模板，并且在练习中，深刻体会了各种二分查找的变异形式。还是要记住这几个条件：

其中目标函数单调性是考验解题灵活变换的关键。不一定是非要整个数组单调递增或者递减，有时候一半数组单调递增或者递减也是可以的。

```
目标函数单调性（单调递增或者递减）
存在上下界（bounded）
能够通过索引访问（index accessible）
```

## 课后思考题：分析解答二分查找半序数组最小值下标问题
### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

问题和下面两个题目对比：
- [寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)
- [搜索旋转排序数组]https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

要将半有序数组重新排序，也就是找出半有序数组的中间无序的下标，此下标就是原有序数组的0下标。

所以问题就是找一个半有序数组中间无序的地方。

其实问题就是找`旋转排序数组中的最小值`，只不过是找出最小值的下标。

#### 解法

二分查找的三个条件：
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

题目2，3点都明显满足，第一点实质是要确定查找的值是在数组的左半部分或者右半部分。

对于一个半有序数组nums，要确定某个值是在左半部分或者右半部分，是有办法的，虽然不是简单的和有序数组一样判断mid(mid = (left + right) / 2)和target（目标值，这里是最小值）的大小即可。

所以该题目适合用二分查找解决。

- 问题转化为：如何判断待查找的数target（这里就是最小值）是在mid的左右哪一部分？

对于一个半有序数组，左右两部分，存在下面两种情况：（排除数组从头到尾都有序 和 数组大小为1 的情况）

1. 一部分是有序的，一部分是乱序的。很明显，数组的最小值肯定是落在无序部分。

2. 左右两部分都是有序的。很明显，mid 或者 mid + 1 或者 mid -1 中的最小者的下标就是我们要找的最小值下标。

- 问题转化为：如何判断两边都是有序的，如何判断mid左右部分哪一半边是无序的。

 - 对于左右两边都有序的情况，判断条件很明显：

1. nums[mid] > nums[mid + 1]
2. nums[mid] < nums[mid - 1] 

 - 对于左右两边有一边无序的情况：有序部分，肯定存在性质：最左边的数小于最右边的数。反之如果是乱序部分，那么最左边的数肯定大于最右边的数。

我们用原数组nums第一个数nums[0]和mid比较即可判断数组是左右两边哪边有序。

1. if nums[0] < nums[mid]，表示mid左边的数组有序，即最小值落在mid右边部分
2. elif nums[0] > nums[mid]，表示mid右边的数组有序，即最小值落在mid左边部分

所以分析到这里，我们只要利用上述方法，不断循环，直到：

1. if nums[mid + 1] < nums[mid]: return mid + 1
2. if nums[mid] < nums[mid - 1]: return mid
3. if nums[0] < nums[mid]: left = mid + 1
4. elif nums[0] > nums[mid]: right = mid - 1

记得排查特殊数组情况才可以用上面的逻辑：

1. nums有序
2. nums大小为0或者为1

#### 程序实现

```python
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None
        if len(nums) == 1 or nums[0] < nums[-1]:
            return nums[0]
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + ((right - left) >> 1)
            if nums[mid] > nums[mid + 1]:
                return mid + 1
            if nums[mid] < nums[mid - 1]:
                return mid
            if nums[0] > nums[mid]:
                right = mid - 1
            elif nums[0] < nums[mid]:
                left = mid + 1
```














  

