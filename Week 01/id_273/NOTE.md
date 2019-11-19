# NOTE

### 第三课 数组、链表、跳表的基本实现和特性

#### 数组特性：
* 关于ArrayList的总结：https://blog.csdn.net/weixin_43624024/article/details/102542495

#### LinkedList特性：
1. 众所周知, LinkedList的增/删时间复杂度为O(1), 但这只针对增加/删除的独立操作。一般我们在使用LinkedList时, 多数情况下可能是删除某个确定位置的节点, 此时就需要通过调用indexOf方法先获取到节点的下标, 再进行删除, 整个过程的时间复杂度是O(n)的。
2. 针对LinkedList检索的优化：升维（空间换时间）————跳表, 添加跨步索引
3. LinkedList的工程应用：LRUCache（链表+HashMap ———— LinkedHashMap）
* 关于LinkedList的总结：https://blog.csdn.net/weixin_43624024/article/details/102571442 
* 关于LRU的总结：https://blog.csdn.net/weixin_43624024/article/details/102587005

#### LinkedList的升维 ———— 跳表：
1. 在LinkedList的基础上进行升维, 添加了索引指针
2. 跳表增加的索引级数为logN个
3. 随机访问的时间复杂度由O(n)降到了O(logn)
4. 实际场景下使用跳表，会因为链表节点的增加/删除导致跳表索引不工整, 在每增加/删除一次节点都会导致索引更新一遍, 因此跳表的维护成本较高, 可使用在增/删操作不那么频繁, 且查询频繁的场景下。

### 第四课 栈，队列，优先队列，双端队列

#### 栈特性：
1. 先入后出
2. Java-Stack底层基于Vector实现
3. 增/删时间复杂度为O(1)
4. 查询时间复杂度O(n)
* 源码分析：https://blog.csdn.net/weixin_43624024/article/details/102635948


#### 队列特性：
1. 先入先出
2. 增/删时间复杂度为O(1)	
3. 查询时间复杂度O(n)
4. Queue不是class而是一个interface, Java中对Queue实现的Class有LinkedList, PriorityQueue等
* 源码分析：https://blog.csdn.net/weixin_43624024/article/details/102637229

#### 双端队列特性：
1. 在工程应用中一般不直接使用queue或stack, 而是采用deque双端队列
2. 插入删除时间复杂度O(1), 查询时间复杂度O(n)
3. 可以在首部push/pop, 也可以在尾部push/pop, LinkedList也实现了Deque的接口

#### 优先队列特性：
1. 插入操作O(1)
2. 增加删除操作：O(logN)-按照元素的优先级取出
3. 底层具体实现的数据结构较为多样和复杂, 可以用heap/bst/avl/treap
