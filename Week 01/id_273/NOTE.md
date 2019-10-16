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
关于LRU：https://blog.csdn.net/weixin_43624024/article/details/102587005

### 跳表特性：
1. 在linkedList的基础上进行了优化，添加了索引指针
2. 跳表增加的索引级数为logn个
3. 随机访问的时间复杂度由O(n)降到了O(logn)
4. 实际场景下使用跳表，会因为元素增加/删除导致其索引不工整，因此维护成本较高，每增加/删除一次导致索引都要更新一遍。