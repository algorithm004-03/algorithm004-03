# 第一周学习总结

经过一周的算法学习，感觉已经逐渐进入状态，最终要的是走出了从前学习的**误区**：刷题只刷一遍！ 老师在视频中反复提到刷题五毒神掌，在过遍数的同时，思考多种解法，没有思路一定要立刻看题解避免效率低下，并且要到国际站学习别人优秀的代码，再改进自己的代码，达到真正刻意练习的目的。

在刷题时要时刻记着**升维**、**空间换时间**的思想。比如跳表就是基于这个思想设计出来的，其通过增加索引的方式提高链表的查询速度。

下面先简单总结一下本周学习的几个基本数据结构。

## 数组

数组在内存中是一段连续的内存空间，所以它可以通过计算内存地址的方式来达到O(1)时间的随机查询速度，但正是因为其存储方式的限制，数组的插入删除操作的时间复杂度为O(n)，较为耗时。因为比如在数组头部插入一个新的元素，需要将数组内的元素全部后移一个位置再做插入操作；删除同理，需要将删除元素后面的所有元素前移一个位置。

数组各种操作的时间复杂度如下表所示：

| 操作 | 时间复杂度 |
:-:|:-:
| prepend | O(n) |
| append | O(1) |
| lookup | O(1) |
| insert | O(n) |
| delete | O(n) |


## 链表

链表是逻辑上连续的顺序表结构，它是一个个Node节点链接起来的，Node节点是由value：节点保存的数据、next：指向后继节点地址的指针组成的，双向链表则是在每个Node节点中包含一个prev：指向前继节点地址的指针。

| 操作 | 时间复杂度 |
:-:|:-:
| prepend | O(1) |
| append | O(1) |
| lookup | O(n) |
| insert | O(1) |
| delete | O(1) |

## 栈

栈是一个后进先出(LIFO)的结构可以由数组或链表实现，其对数据的操作是受限的，只能在数组或链表的一侧进行。因为栈的特殊性，只能对栈顶元素进行操作，所以其增加删除操作的时间复杂度均为O(1)。

## 队列

队列也是一个特殊的并且操作受限的线性表，它是一个(FIFO)的结构可以由数组或链表实现，队列只能在队头进行删除操作也就是出队操作，在队尾进行增加操作也就是入队操作。双向队列可以在队头和队尾进行出队和入队操作。

## 改写Deque操作代码

        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

## Java Queue 源码分析

Java中Queue是java.util包中的一个接口，定义了队列操作的一系列方法，并且每个方法有两种形式，一种当操作失败时抛出异常，另一种返回特殊值如null、false。

||Throws exception|Returns special value|
:-:|:-:|:-:
Insert|add(e)|offer(e)
Remove|remove()|poll()
Examine|element()|peek()

- boolean add(E e); 在队尾插入一个元素，如果队列容量不足则抛出异常
- boolean offer(E e); 在队尾插入一个元素，如果队列容量不足则返回false
- E remove(); 移除队头元素，如果队列为空则抛出异常。
- E poll(); 移除队头元素，如果队列为空则返回null。
- E element(); 查看队头元素，如果队列为空则抛出异常。
- E peek(); 查看队头元素，如果队列为空则返回null。

## Java PriorityQueue 源码分析

PriorityQueue是基于堆实现的，其内部的元素根据自然序排序，如果在构造函数中提供自定义的Comparator则会按照定义的方式排序。

PriorityQueue内部的元素保存在一个Object数组中，也就是说一个由数组实现的堆中。

PriorityQueue的查看操作的时间复杂度是O(1)，offer和poll操作的时间复杂度是O(log(n))。offer操作将元素插入至堆的尾部，然后进行上浮的堆化调整操作，poll操作，先将第一个元素保存留作返回，然后将最后一个元素放至队首的位置，再进行下沉的堆化操作。