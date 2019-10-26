### 知识点
#### 一、数组、链表、跳表的基本实现和特性

##### 数组
特性：地址连续（需要加深对内存管理器的学习）、访问速度O(1)，随机插入和删除慢。常用：ArrayList，非线程安全的。
##### 链表
特性：地址可以不连续，随机查询慢，新增和删除快。LinkedList为双向链表。
* 单链表：tail的next为空。
* 循环链表：tail的next指向头。
##### 跳表
基于LinkedList的不足，SkipList做了补充。
特性：
* 通过增加索引的方式实现。
* 增加多级索引。
* 维护成本较高。且发生多次增加和删除索引后，可能导致索引是不工整的，可多多跨，或者少跨。
* 时间复杂度为O(logn)，空间复杂度为O(n)

通过SkipList的学习，可以得到如下2个重要优化算法的思想：
```
1：升维
2：空间换时间
```
##### 工程中的应用：

* LRU可用LinkedList实现。
* Redis的ZSET可用SkipList实现。


#### 二、栈和队列的基本实现和特性
##### 栈（Stack）
特性：先进后出。添加删除时间复杂度为O(1)，查询为O(n)。**不推荐使用，建议使用Deque**
##### 队列（Queue）
特性：先进先出。添加删除时间复杂度为O(1)，查询为O(n)。
##### 双端队列Deque（Double-End Queue）
特性：双端都可以进行添加和删除。添加删除时间复杂度为O(1)，查询为O(n)。
#### 栈队列作业一：使用新的API来重构之前的Deque的使用方式：
```
public static void main(String[] args) {   
        Deque<String> deque = new LinkedList<String>();
        deque.add("eason");
        deque.addFirst("easaon_frist");
        deque.addLast("eason_last");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        str = deque.peekFirst();
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}
```
执行结果如下：
```
[easaon_frist, eason, eason_last]
easaon_frist
[easaon_frist, eason, eason_last]
[easaon_frist, eason, eason_last]
easaon_frist
eason
eason_last
[]
```


tips:
常见数据结构的复杂度分析：
![3973f7c936f8bf325a61c28be45c0977.png](en-resource://database/2243:0)


##### 工程中的应用：

* Priority Queue（按照元素的优先级取出）
1. 特性：插入O(1)，取出操作O(logN))
2. PriorityQueue特征如下：

     *  基于Priority堆实现的无限队列
     * 非线程安全。
     * 优先级可通过Comparator来排序或者通过它们Comparable的自然顺序。插入非comparable对象，会抛出ClassCaseException。
     * 不允许null元素的存在。
     * head元素为最小元素。
     * 表现为一个平衡二顶堆。数据结构为一个平衡二叉树。
     * 时间复杂度见下表

| 时间复杂度 | 函数 |
| --- | --- |
| O(1) | peek、element、size |
| O(n)  | remove(object)、contains(object) |
| O(logN) | offer、poll、remove()、add |


#### 栈队列作业二PriorityQueue源码分析：
##### 1）属性分析：
```
/** * Priority queue represented as a balanced binary heap: the two
* children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
* priority queue is ordered by comparator, or by the elements'
* natural ordering, if comparator is null: For each node n in the
* heap and each descendant d of n, n <= d.  The element with the
* lowest value is in queue[0], assuming the queue is nonempty.
*/
transient Object[] queue; // non-private to simplify nested class access
```
优先级队列表现为一个平衡二顶对。队列默认为非空
```
/**
* The number of elements in the priority queue.
*/
private int size = 0;
/**
* The comparator, or null if priority queue uses elements'
* natural ordering.
*/
private final Comparator<? super E> comparator;
/**
* The number of times this priority queue has been
* <i>structurally modified</i>.  See AbstractList for gory details.
*/
transient int modCount = 0; // non-private to simplify nested class access
```
size为队列的大小，comparator为比较器，当元素使用自然序列时，属性为空。
```
private static final int DEFAULT_INITIAL_CAPACITY = 11;
```
在不指定大小时，默认的初识容量。
##### 2）核心方法分析：
* add(E e) 同 offer(E e)
* offer(E e)插入元素到priority queue：
往优先级队列中插入元素，如果队列满了，则进行扩容。插入操作必要的话是会导致堆元素调整的，以满足父节点总是小于等于子节点的要求。插入操作的时间复杂度为O(log(n));
通过siftUp方法来完成元素插入时的调整：siftUp(index, object)方法会升高待插入元素在树中的位置index，直到待插入的元素大于或等于它待插入位置的父节点，见如下代码：
```
private void siftUp(int k, E x) {
    if (comparator != null)   
        siftUpUsingComparator(k, x);
    else   
        siftUpComparable(k, x);
}

@SuppressWarnings("unchecked")
private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (key.compareTo((E) e) >= 0) {
            break;
        }
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;
}
@SuppressWarnings("unchecked")
private void siftUpUsingComparator(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (comparator.compare(x, (E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}
```
通过“int parent = (k - 1) >>> 1;”获取到当前要插入节点位置的父节点，比较父节点和待插入节点，如果待插入节点小于父节点，则将父节点插入到子节点的位置，然后在获取父节点的父节点循环上面的操作，直到待插入节点大于等于父节点，则在相应位置插入这个节点。最终保证代表优先级队列的平衡二叉树中，所有的子节点都大于它们的父节点，但同一层的子节点间并不需要维护大小关系。



### 总结：
通过本周的学习主要学习到了如下几点：

* 对基础数据结构：数组、链表、栈、队列有了一定的了解。还需要对一些常见的数据结构做进一步的学习。
* 对算法的分析方式基本掌握了，可归纳出如下几个步骤：
    * 1：拿到题目先分析清楚题目（一般暴力算法可以完成）。
    * 2：如果没有思路则看源码，或者完成后，查看官方及国际站上面的讨论，查找最优的方法。
* 学会了几种小工具，在日后的算法分析上会用的上：
    * 1：双指针法。收尾指针往中间汇聚。
    * 2：快慢指针法。可用于对数组的操作，可达到空间复杂度为O(1)的效果。
    * 3：尽可能的找到重复的片段，才是突破问题的关键。
    * 注意：在遇到问题时，能将上面的三种方法运用好才是需要日后算法锻炼时需要注意的地方。
