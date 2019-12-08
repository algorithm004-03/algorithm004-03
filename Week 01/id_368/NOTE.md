# NOTE
Stack
先进后出
添加、删除皆为0(1)
Queue
先入先出
添加、删除皆为O(1)
Priority Queue
插入操作：O(1)
取出操作：O(logN) 按照元素的优先级取出
底层具体实现的数据结构较为多样和复杂：heap、bst、treap

思想：升维&空间换时间
Array：内存中一段连续的地址
时间复杂度：
插入、删除：O(n) 会有大量的System.arraycopy()操作
随机查找：O(1) 直接通过内存管理器找到地址
LinkedList
时间复杂度：
插入、删除：O(1)
随机访问：O(n)
Skip List
定义：在原始链表的基础上，增加多级索引

时间复杂度：O(logn)
空间复杂度：O(n)

  

