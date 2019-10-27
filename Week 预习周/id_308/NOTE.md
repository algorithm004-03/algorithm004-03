<abbr style="display:block;font-size: 18px;color:orange;text-align: center;border-bottom: 1px dotted #999;">作业</abbr>


[数据结构脑图](http://naotu.baidu.com/file/6db9b3f894b01a952786cb0080454edc?token=4593bb918fca7f49)
[算法脑图](http://naotu.baidu.com/file/96ccd6e5b3e2a4e6724cff20cbfd7d97?token=57b2b51543403a71)

<abbr style="display:block;font-size: 18px;color:orange;text-align: center;border-bottom: 1px dotted #999;">笔记</abbr>

### 数据结构与算法总览

#### 如何系统的学习算法和数据结构

 - 注重预习
 - 课堂中一起思考、回答
 - 按照切题方法完成作业

#### 如何精通一个理论

 - Chunk it up 切碎知识点
    * 庖丁解牛
    * 脉络相连
 - Deliberate Practicing 刻意练习
 - Feedback 反馈

 #### 数据结构

 - 一维
    * 基础: 数组 array(String)、链表 linked list
    * 高级：栈 stack、队列 queue、双端队列 deque、 集合 Set、映射 map (hash or map),etc

 - 二维
    * 基础： 树 tree、图 graph
    * 高级： 二叉搜索树 binary search tree(red-black tree)、堆 heap、 并查集 disjoint set、字典树 trie,etc
 - 特殊
    * 位运算 Bitwise、布隆过滤器 BloomFilter
    * LRU Cache

#### 算法

 - if-else，switch -> branch
 - for,while loop -> iteration
 - 递归 Recursion（Divide & Conquer，Backtrace）
 - 搜索 Seach: 深度有限搜索 Depth first search,广度优先算法 Breadth first search,A*,etc
 - 动态规划 dynamic Programming
 - 二分查找 Binary Search
 - 贪心 Greedy
 - 数学 Math，几何 Geometry

 #### 刻意练习

 - 过遍数：（五毒神掌）
 - 练习缺陷、弱点的地方

#### Feedback
  
 - 即时反馈
 - 主动型反馈
    * 高手代码(Github,LeetCode,.etc.)
    * 第一视角直播
 - 被动型反馈
    * code review
    * 教练给反馈

#### 切题四件套

 - Clarification 保证理解清楚题目
 - Possible solution 所有可能的解法
    * compare(time/space) 最优解法
    * optimal(加强)
 - Coding(多写)
 - Test cases 测试用例


#### 五毒神掌

`刷题第一遍`
 - 5分钟： 读题+思考
 - 直接看解法： 多解法比较解法优劣
 - 背诵、默写好的解法

`刷题第二遍`
 - 马上默写 -> LeetCode提交
 - 多种解法比较、体会->优化

`刷题第三遍`
 - 隔天练习

`刷题第四遍`
 - 隔周练习

`刷题第五遍`
 - 面试前练习



### 时间复杂度和空间复杂度

#### 时间复杂度

 - O(1): Constant Complexity 常数复杂度
 - O(log n): Logarithmic Complexity 对数复杂度
 - O(n): Linear Complexity 线性时间复杂度
 - O(n^2): N square Complexity 平方
 - O(n^3): N cube Complexity 立方
 - O(2^n): Exponential Growth 指数
 - O(n!): Factorial 阶乘
 
#### Master Theorem

 - 二分查找: T(n) = T(n/2) + O(1)   ->   log(n)
 - 二叉树的遍历: T(n) = 2T(n/2) + O(1)  ->   O(n)
 - 在排好序的二维矩阵二分查找: T(n) = 2T(n/2) + O(log n)   -> O(n)
 - 归并排序: T(n) = 2T(n/2) + O(n)   -> O(n log n)
 
 - 二叉树前序/中序/后序遍历的时间复杂度: O(n)  -> n为总节点数
 - 图的遍历时间复杂度：O(n)  -> n为图的节点总数
 - 搜索算法DFS/BFS的时间复杂度: O(n)  -> n为搜索空间里的节点总数
 - 二分查找时间复杂度是: O(log n)
