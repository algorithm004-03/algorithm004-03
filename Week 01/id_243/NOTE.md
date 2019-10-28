# 第一周学习总结
## homework
#### 用 add first 或 add last 这套新的 API 改写 Deque 的代码
```java
/**
 * 改写deque示例代码
 */
public class OverriteDequeDemo {
    public static void main(String[] args) {
        //初始化队列
        Deque<String> deque = new LinkedList<>();
        //入队
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        //队尾
        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);
        //出队
        while (!deque.isEmpty()){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
```
#### 分析 Queue 和 Priority Queue 的源码
> jdk：1.8
##### Queue接口的方法

| Throws exception  | Returns special value |
|---|---|
|add|offer|
|remove|poll|
|element|peek|

##### 基于链表LinkedList的实现

1. 新增
> add方法等同于addLast方法，add是基于List的实现，addLast是基于deque的实现。实现逻辑主要是将当前元素e标记置为链表的last节点。
```java
public boolean add(E e) {
    //此处将元素e标记为tail
    linkLast(e);
    return true;
}
```
2. 删除
> remove方法等同于removeFirst方法。实现逻辑是释放链表的first节点。
```
public E remove() {
    return removeFirst();
}
public E removeFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return unlinkFirst(f);
}
private E unlinkFirst(Node<E> f) {
    //默认f就是first节点且不为空，因为在removeFirst已经验证过且抛异常了
    // assert f == first && f != null;
    //将first节点的item置空且next指针置空，有助于gc
    final E element = f.item;
    final Node<E> next = f.next;
    f.item = null;
    f.next = null; // help GC
    //将first节点置为next指针
    first = next;
    //若next指针为空的话，last节点也置空，否则将next的prev指针置空，这里才是彻彻底底与原来的first节点say bye bye~
    if (next == null)
        last = null;
    else
        next.prev = null;
    size--;
    modCount++;
    return element;
}
```
3. 取第一个元素
> 比较简单，就是取fist节点的item。
```java
public E element() {
    return getFirst();
}
public E getFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return f.item;
}
```
##### 基于PriorityQueue的实现
###### 优先级队列 PriorityQueue 的实现原理
* Java中PriorityQueue通过二叉小顶堆实现，，可以用一棵完全二叉树表示。
* 优先队列的作用是能保证每次取出的元素都是队列中权值最小的。元素大小的评判可以通过元素本身的自然顺序（natural ordering），也可以通过构造时传入的比较器comparator。
> 小顶堆：任意一个非叶子节点的权值，都不大于其左右子节点的权值。

> 实验环境：https://visualgo.net/zh/heap

初始化数组：
```
/**
 * Priority queue represented as a balanced binary heap: the two
 * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
 * priority queue is ordered by comparator, or by the elements'
 * natural ordering, if comparator is null: For each node n in the
 * heap and each descendant d of n, n <= d.  The element with the
 * lowest value is in queue[0], assuming the queue is nonempty.
 */
transient Object[] queue;
```
父子节点的编号之间有如下关系：
* leftNo = parentNo * 2 + 1
* rightNo = parentNo * 2 + 2
* parentNo = (nodeNo - 1) / 2

++(后续)mark：对堆和树的内容不够了解，留个疑问？后续分析优先队列的实现算法++


