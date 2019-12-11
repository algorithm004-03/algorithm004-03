### 知识点
#### 深度优先搜索、广度优先搜索的实现和特性

#### 深度优先搜索

* 搜索-遍历
    * 每个节点仅仅要访问一次
    * 对于节点的访问顺序不限
        * 深度优先：DFS （1：递归实现，需要注意节点有没有被访问；2：使用栈来实现）
        * 广度优先：BFS（使用队列的方式+循环来实现）
        * 优先级优先（该类算法称为启发式搜索， 深度学习 ）

Todo：深度优先 广度优先 java版本模板

* floodfill思维方法。来源于算法题（题号200），找到一个岛，把自己及附近都夷为平地。（DFS）


#### 贪心算法（Greedy)

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划是会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心算法一遍是解决一些最优化问题。如：求图中的最小生成树，求哈夫曼编码等。但是，贪心算法一般不能得到我们所要求的答案。

* 贪心：当下做局部最优判断；
* 回溯：能够回退；
* 动态规划：最优判断 + 回退。


322 https://leetcode-cn.com/problems/coin-change/



#### 二分查找


* 前提
    * 目标函数单调性（单调递增或者递减）
    * 存在上下界（bounded）
    * 能给通过索引访问（index accessable）

* 代码模板
```
left, right = 0,  len(array)-1
while left <= right
    mid = (left + right) / 2
    if array[mid] == target:
        #find the target!!
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```

https://shimo.im/docs/hjQqRQkGgwd9g36J/read
![2b5cbfaa196f83c88185d95d4e16703f.png](en-resource://database/2483:0)

#### 总结

* 不断的复习和巩固了切题的四个步骤。其次，记住了很多类型的算法的对应模板。这块需要我日后反复记忆。才能帮助自己快速的解决问题。
*  使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
    * 1：按照二分查找，如果，array[mid + 1] > array[mid] 则 left = mid+1
    * 如果array[mid + 1] < array[mid] 则 mid +1 即为无序的地方。
