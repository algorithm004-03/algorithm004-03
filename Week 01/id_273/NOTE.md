# NOTE

## 第三课 数组、链表、跳表的基本实现和特性
### 数组特性：
1. 每当申请一个数组 实际上是在内存中开辟了一段连续的内存空间
2. 随机访问时间复杂度为O(1)
3. 增、删平均时间复杂度为O(n)
在Java中通过ArrayList进行动态数组的实现：
关于ArrayList的总结：https://blog.csdn.net/weixin_43624024/article/details/102542495

### LinkedList特性：
1. jdk1.7采用双向循环链表，jdk1.8采用双向链表
2. 增/删时间复杂度为O(1)，但值得一提的是：linkedList仅在增加/删除确定位置下的结点时，时间复杂度为O(1)。因为链表不存在实际下标，若要在指定位置增加或删除某个元素时，必需先通过O(n)的遍历确定node位置再进行操作
3. 优化：升维（空间换时间）————跳表
4. LinkedList的工程应用：LRUCache（链表+HashMap，也可以是LinkedHashMap）
关于LinkedList的总结：https://blog.csdn.net/weixin_43624024/article/details/102571442 
关于LRU的总结：https://blog.csdn.net/weixin_43624024/article/details/102587005

### 跳表特性：
1. 在linkedList的基础上进行了优化，添加了索引指针
2. 跳表增加的索引级数为logn个
3. 随机访问的时间复杂度由O(n)降到了O(logn)
4. 实际场景下使用跳表，会因为元素增加/删除导致其索引不工整，因此维护成本较高，每增加/删除一次导致索引都要更新一遍。

### 做题思路总结
首先考虑问题能不能通过暴力解法解决，若不行的话通过简单的情况分析重复子问题。

### 优化思路总结
升维/空间换时间

### 刷题思维
不求数量只求质量，一道题反复刷，理解题目背后的思想，学会举一反三

## 第四课 栈，队列，优先队列，双端队列
### 栈特性：
1. 先入后出。添加，删除时间复杂度为O(1)，查询时间复杂度O(n)
#### API
1. peek() 返回栈顶元素
2. pop() 删除并返回栈顶元素
3. push(E e) 添加至栈顶
源码分析：https://blog.csdn.net/weixin_43624024/article/details/102635948


### 队列特性：
1. 先入先出。添加，删除时间复杂度为O(1)，查询时间复杂度O(n)
2. Queue不是class而是一个interface
#### API
1. add() 添加
2. remove 删除并返回
3. element 返回
4. 同样的offer，poll，peek也分别为添加，删除，返回。区别在于错误处理时，前者会抛出异常，后者返回special value
源码分析：https://blog.csdn.net/weixin_43624024/article/details/102637229

### 双端队列特性：
在工程应用中一般不直接使用queue或stack，而是采用deque双端队列
1. 插入删除时间复杂度O(1)，查询时间复杂度O(n)
2. 可以在首部push/pop，也可以在尾部push/pop，LinkedList就实现了Deque的接口

### 优先队列特性：
1. 插入操作O(1)
2. 增加删除操作：O(logN)-按照元素的优先级取出
3. 底层具体实现的数据结构较为多样和复杂，可以用heap/bst/avl/treap






