# 学习总结
### Queue 和 PriorityQueue 的源码分析

#####  Queue（队列），是一种继承自Conlection接口先进先出的数据结构
+ boolean add(E e): 增加一个元素，如果队列已经满了，则会抛出IllegalStateException异常。

+ E element(): 返回队列头部的元素。 此方法与peek的不同之处仅在于，如果队列为空，将抛出NoSuchElementException异常。

+ boolean offer(E e): 添加一个元素并在添加成功时返回true，添加失败则返回false。此方法比add方法不同之处在于，add方法只能通过抛异常的方式相应添加元素失败。

+ E peek(): 返回队列头部的元素，如果此队列为空，不抛出异常返回null。

+ E poll(): 返回并删除队列头部的元素，如果队列为空，则返回null。

+ E remove(): 返回并删除队列头部的元素。 此方法与poll的不同之处仅在于，如果队列为空，将抛出NoSuchElementException异常。
#### PriorityQueue（优先队列）继承了AbstractQueue（继承了AbstractCollection接口并实现了Queue接口）
+ 优先队列不允许为空值。
+ 不支持不可比较的对象。
+ 优先队列的大小没有限制，可以指定初始值大小，在添加元素的时候，队列的大小会自动增加。
+ 优先队列是非线程安全的，因此java提供了PriorityBlockingQueue用于多线程环境。

###### 还有好多关于堆的没弄明白。

### Deque源代码：
```
Deque<String> deque = new LinkedList<String>();
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
### Deque.addFirst()改写：
```
Deque<String> deque = new LinkedList<String>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0) {
 System.out.println(deque.pop());
}
System.out.println(deque);
```
### Deque.addLast()改写：
```
Deque<String> deque = new LinkedList<String>();
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
---
### 第一周学习总结

1. 重新认识了数组、链表、跳表、栈、队列等数据结构，学习了他们的基本实现和特性。
2. 针对性的实践了这些数据结构的算法实现。
3. 逐渐熟练并掌握“五毒神掌”等“看家”本领。
  

