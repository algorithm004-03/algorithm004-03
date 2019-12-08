# NOTE
## 学习总结

1. 数组：[源码](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
   在内存中是连续的地址，访问时间非常快。
   插入(insert)操作O(n)：元素插入时，将插入的位置之后的元素全部向后移动一个位置，再放入该元素
   删除(delete)操作O(n)：元素删除时，拿出该元素，后面的元素都向前移一个位置
   不适合增加删除
   查看(lookup)O(1)

2. Linked List[源码](https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/) [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java)
   通过链表实现的空间不连续的结构
   增加(prepend、append)、删除(delete)操作、插入操作(insert)：O(1)的复杂度 newnode.next = Node.next, Node.next = newNode,
   查找(lookup)操作:O(n);

3. skip List(跳表)
   运用于Redis，为了补足链表的缺陷而设计出来的。加速的中心思想（升维，空间换时间）
   跳表查询的时间复杂度分析O(logn)
   n/2、n/4、n/8、第k级索引节点的个数就是n/(2^k)
   假设索引有h级，最高级的索引有2个结点。n/(2^h) = 2,从而求得h = log2(n) - 1

   跳表的空间复杂度分析O(n)：
   原始链表大小为n，每2个结点抽1个，每层索引的结点数：
        n/2、n/4，n/8,...,8,4,2
    原始俩表大小为n，每3个结点抽1个，每层索引的结点数：
        n/3、n/9，n/27,...,9,3,1
    空间复杂度O(n)
实际应用：
    1. [LRU Cache - Linked list](https://leetcode-cn.com/problems/lru-cache/)
    2. [Redis - Skip List](https://www.zhihu.com/question/20202931)

4. 栈
   stack： 先入后出；添加、删除O(1),查询O(n)
5. 队列
    Queue： 先入后出；添加、删除O(1),查询O(n)
    Deque： 添加、删除O(1),查询O(n)
    [Priority Queue](http://fuseyism.com/classpath/doc/java/util/PriorityQueue-source.html): 插入操作O(1),取出操作：O(logN)-按照元素的优先级取出，底层具体实现的数据结构较为多样和复杂：heap、bst、treap

## 源码分析

### Queue
   
    通过分析[Queue源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)学习到以下几点。
    1. Queue在java中定义为接口
    2. 它的方法有 
        add(E e)、offer(E e)、remove()、poll()、element()、peek()
        add、offer:用于添加元素
        remove: 删除队头元素,当要移除的元素为空时抛出异常
        poll: 删除队头元素,当要移除的元素为空时返回null
        element: 检索队头元素，为空时返回异常
        peek: 检索队头元素，为空时返回null
### PriorityQueue
    关于PriorityQUeue源码没看太懂，但是其手册内容关于这些方法的介绍看了一些
    通过分析[PriorityQueue](http://fuseyism.com/classpath/doc/java/util/PriorityQueue-source.html)学习到以下几点。
    1. PriorityQueue继承自AbstractQueue实现了Serializable定义的接口
    2. 它的方法有：
        add(E e)、clear()、comparator()、contains(Object c)、iterator()、offer()、remove(Object o)、spliterator()、toArray()、toArray(T[] a)
        add(E e):将指定的元素插入此优先级队列。
        clear():删除优先队列中的所有元素。
        comparator(): 返回用于对队列中的元素进行排序的比较器；如果此队列是根据其元素的自然顺序排序的，则返回null。
        contains(Object c): 判断队列中是否包含该元素，包含返回true
        iterator():返回一个迭代器用于对该队列中的所有元素进行迭代。
        offer(): 将制定的元素插入此优先队列。
        remove(): 从该队列中删除指定元素的单个实例（如果存在）。
        spliterator(): 在次队列的元素上创建一个fail-fasth和late-binding的spliterator(不明白什么意思)
        toArray(): 返回一个包含队列中所有元素的数组
        toArray(T[] a):返回一个包含队列中所有元素的数组

