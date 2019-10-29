# 【198-week 01】学习总结

## Java Queue 和  Priority Queue源码分析

### 队列

> 队列（Queue），是一种基于先进先出（FIFO）策略的集合数据类型。

在java中，Queue接口继承与Collection接口（List,Set接口也继承与Collection）; 定义方法如下：

- add(offer):  插入元素, 若当前队列容量不足，add抛出IllegalStateException ，而offer返回false；其他行为等价；(若无边界队列，add和offer等价，如LinkedList)
- remove(poll): 获取并移除Queue头部元素，若当前队列为空，则remove前者抛出NoSuchElementException，poll返回null；其他行为等价；
- element(peek): 获取Queue头部元素（但不移除），element和peek的区别是，若当前队列为空，则前者抛出NoSuchElementException ，后者返回null；其他行为等价；

Queue的实现包括:

- ArrayBlockingQueue: 基于数组的有界阻塞队列
- ArrayDeque： 基于数组实现的可扩容双端对垒
- ConcurrentLinkedDeque： 基于双向链表的无边界并发安全的双端队列；在多线程环境中安全的插入，删除和访问
- ConcurrentLinkedQueue：基于双向链表的无边界并发安全的队列；在多线程环境中安全的插入，删除和访问
- DelayQueue：无边界的延迟阻塞队列
- LinkedBlockingDeque： 基于双向链表的阻塞双端队列，该队列容量可在初始化时指定
- LinkedBlockingQueue： 基于双向链表的阻塞队列，该队列容量可在初始化时指定
- LinkedList： 基于双向列表实现List和Deque接口，实现所有的list和双端队列的操作，并允许元素为null
- LinkedTransferQueue: 基于链表实现的传输队列（TransferQueue，一种阻塞队列）
- PriorityQueue： 优先队列（非线程安全）
- PriorityBlockingQueue：  阻塞优先队列（线程安全）
- SynchronousQueue：同步队列，一个阻塞队列，每个插入操作必须等待另一个线程进行相应的删除操作，反之亦然。

### 优先队列

Java 优先队列基于Priority Heap实现; 在创建优先级队列时，可以指定元素比较器(`java.util.Comparator`),若不指定将使用队列元素的默认比较器。实现说明：

- 插入元素不能为null
- 若为指定比较器，则插入元素必须实现java.util.Comparator接口
- 该队列为无界队列
- 非线程安全
- offer、poll、remove和add的时间复杂度为O(log(n)), 进行排序和查找
- remove(Object) and contains(Object)实现复杂度为O(n)
- peek、element、size时间复杂度为O(1)

## 【198-week 01】Java Deque API改写

原代码如下：

```java
Deque<String> deque = new LinkedList<>();
deque.push("a");
deque.push("b");
deque.push("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {

  System.out.println(deque.pop());
}
System.out.println(deque);
```

`addFirst`改写

```java
Deque<String> deque = new LinkedList<>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.element();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {

  System.out.println(deque.removeFirst());
}
System.out.println(deque);
```

`addLast`改写

```java
Deque<String> deque = new LinkedList<>();
deque.addLast("a");
deque.addLast("b");
deque.addLast("c");
System.out.println(deque);

String str = deque.getLast();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {

  System.out.println(deque.removeLast());
}
System.out.println(deque);
```
