# 233-Week 01 学习总结
### 学习内容
- 数组、链表、跳表、栈、队列、双端队列、优先队列
- 阅读每个数据结构的 java 实现
- 做题 leetCode

### 牢记师傅的话
- 做题最大误区是只做一遍题
- 优化思想：升维即空间换时间

### [Week 01 学习笔记链接](https://mubu.com/doc/x1I3Q84PQ0) 

### 改写Deque的代码
```
public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("f1");
        deque.addFirst("f2");
        deque.addLast("l1");
        deque.addLast("l2");
        deque.addFirst("f3");
        System.out.println(deque);
        System.out.println(deque.peekFirst());
        System.out.println(deque.getLast());

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
```
## Queue 源码分析
- 先进先出 first in fist out (FIFO)
### 时间复杂度
- 添加、删除皆为O(1)，数据无序查询为O(n)
#### Queue是所有队列的顶级接口，定义了6个方法

操作 | 抛出异常 | 返回特定值
---|---|---
Insert | add() | offer(e) false
Remove | remove() | poll() null
Examine | element() | peek() null
```
public interface Queue<E> extends Collection<E> {
    //向队列中插入一个元素，并返回true
    //如果队列已满，抛出IllegalStateException异常
    boolean add(E e);
    //向队列中插入一个元素，并返回true
    //如果队列已满，返回false
    boolean offer(E e);
    //取出队列头部的元素，并从队列中移除
    //队列为空，抛出NoSuchElementException异常
    E remove();
    //取出队列头部的元素，并从队列中移除
    //队列为空，返回null
    E poll();
    //取出队列头部的元素，但并不移除
    //如果队列为空，抛出NoSuchElementException异常
    E element();
    //取出队列头部的元素，但并不移除
    //队列为空，返回null
    E peek();
}
```
## Priority Queue 源码分析
- 优先级队列，是0个或多个元素的集合，集合中的每个元素都有一个权重值，每次出队都弹出优先级最大或最小的元素。
- 底层实现的数据结构较为多样和复杂：heap、bst（二叉搜索树）、treap
### 时间复杂度
- 添加 O(1)；取出 O(logN)
### 成员变量
```
// 默认容量
private static final int DEFAULT_INITIAL_CAPACITY = 11;
// 存储元素的地方 
transient Object[] queue;
// 元素个数
private int size = 0;
// 比较器,在优先级队列中，也有两种方式比较元素，一种是元素的自然顺序，一种是通过比较器来比较
private final Comparator<? super E> comparator;
// 修改次数 修改次数，有这个属性表示PriorityQueue也是fast-fail的
transient int modCount = 0;
```
- queue[n] 的孩子节点是 queue[2*n+1] 和 queue[2*(n+1)]
### 构造函数
- PriorityQueue的构造函数大致分为两类，一种是确定数组初始化大小和Comparator，另一种是由Collection对象构造
```
public PriorityQueue(Collection<? extends E> c) {
    if (c instanceof SortedSet<?>) {
        SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
        this.comparator = (Comparator<? super E>) ss.comparator();
        initElementsFromCollection(ss);
    }
    else if (c instanceof PriorityQueue<?>) {
        PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
        this.comparator = (Comparator<? super E>) pq.comparator();
        initFromPriorityQueue(pq);
    }
    else {
        this.comparator = null;
        initFromCollection(c);
    }
}
```
- SortedSet和PriorityQueue这两种在构造的时候可以获取Comparator（也可能获取不到，因为是自然排序），其余的都是直接构造，如果这个对象没有实现Comparable接口，那么在使用的时候就会产生一个==ClassCastException==

### 入队
> 入队有两个方法，add(E e)和offer(E e)，两者是一致的，add(E e)也是调用的offer(E e)。

```
public boolean add(E e) {
    return offer(e);
}

public boolean offer(E e) {
    // 不支持null元素
    if (e == null)
        throw new NullPointerException();
    modCount++;
    // 取size
    int i = size;
    // 元素个数达到最大容量了，扩容
    if (i >= queue.length)
        grow(i + 1);
    // 元素个数加1
    size = i + 1;
    // 如果还没有元素
    // 直接插入到数组第一个位置
    // 这里跟我们之前讲堆不一样了
    // java里面是从0开始的
    // 我们说的堆是从1开始的
    if (i == 0)
        queue[0] = e;
    else
        // 否则，插入元素到数组size的位置，也就是最后一个元素的下一位
        // 注意这里的size不是数组大小，而是元素个数
        // 然后，再做自下而上的堆化
        siftUp(i, e);
    return true;
}

private void siftUp(int k, E x) {
    // 根据是否有比较器，使用不同的方法
    if (comparator != null)
        siftUpUsingComparator(k, x);
    else
        siftUpComparable(k, x);
}

@SuppressWarnings("unchecked")
private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        // 找到父节点的位置
        // 因为元素是从0开始的，所以减1之后再除以2
        int parent = (k - 1) >>> 1;
        // 父节点的值
        Object e = queue[parent];
        // 比较插入的元素与父节点的值
        // 如果比父节点大，则跳出循环
        // 否则交换位置
        if (key.compareTo((E) e) >= 0)
            break;
        // 与父节点交换位置
        queue[k] = e;
        // 现在插入的元素位置移到了父节点的位置
        // 继续与父节点再比较
        k = parent;
    }
    // 最后找到应该插入的位置，放入元素
    queue[k] = key;
}
```
### 出队
> 出队有两个方法，remove()和poll()，remove()也是调用的poll()，只是没有元素的时候抛出异常。

```
public E remove() {
    // 调用poll弹出队首元素
    E x = poll();
    if (x != null)
        // 有元素就返回弹出的元素
        return x;
    else
        // 没有元素就抛出异常
        throw new NoSuchElementException();
}

@SuppressWarnings("unchecked")
public E poll() {
    // 如果size为0，说明没有元素
    if (size == 0)
        return null;
    // 弹出元素，元素个数减1
    int s = --size;
    modCount++;
    // 队列首元素
    E result = (E) queue[0];
    // 队列末元素
    E x = (E) queue[s];
    // 将队列末元素删除
    queue[s] = null;
    // 如果弹出元素后还有元素
    if (s != 0)
        // 将队列末元素移到队列首
        // 再做自上而下的堆化
        siftDown(0, x);
    // 返回弹出的元素
    return result;
}

private void siftDown(int k, E x) {
    // 根据是否有比较器，选择不同的方法
    if (comparator != null)
        siftDownUsingComparator(k, x);
    else
        siftDownComparable(k, x);
}

@SuppressWarnings("unchecked")
private void siftDownComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>)x;
    // 只需要比较一半就行了，因为叶子节点占了一半的元素
    int half = size >>> 1;        // loop while a non-leaf
    while (k < half) {
        // 寻找子节点的位置，这里加1是因为元素从0号位置开始
        int child = (k << 1) + 1; // assume left child is least
        // 左子节点的值
        Object c = queue[child];
        // 右子节点的位置
        int right = child + 1;
        if (right < size &&
            ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            // 左右节点取其小者
            c = queue[child = right];
        // 如果比子节点都小，则结束
        if (key.compareTo((E) c) <= 0)
            break;
        // 如果比最小的子节点大，则交换位置
        queue[k] = c;
        // 指针移到最小子节点的位置继续往下比较
        k = child;
    }
    // 找到正确的位置，放入元素
    queue[k] = key;
}
```
### 扩容
1. 当数组比较小（小于64）的时候每次扩容容量翻倍；
2. 当数组比较大的时候每次扩容只增加一半的容量
```
private void grow(int minCapacity) {
    // 旧容量
    int oldCapacity = queue.length;
    // Double size if small; else grow by 50%
    // 旧容量小于64时，容量翻倍
    // 旧容量大于等于64，容量只增加旧容量的一半
    int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                     (oldCapacity + 2) :
                                     (oldCapacity >> 1));
    // overflow-conscious code
    // 检查是否溢出
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
        
    // 创建出一个新容量大小的新数组并把旧数组元素拷贝过去
    queue = Arrays.copyOf(queue, newCapacity);
}

private static int hugeCapacity(int minCapacity) {
    if (minCapacity < 0) // overflow
        throw new OutOfMemoryError();
    return (minCapacity > MAX_ARRAY_SIZE) ?
        Integer.MAX_VALUE :
        MAX_ARRAY_SIZE;
}
```
### 取队首元素
> 取队首元素有两个方法，element()和peek()，element()也是调用的peek()，只是没取到元素时抛出异常

1. 如果有元素就取下标0的元素
2. 如果没有元素就返回null，element()抛出异常

```
public E element() {
    E x = peek();
    if (x != null)
        return x;
    else
        throw new NoSuchElementException();
}
public E peek() {
    return (size == 0) ? null : (E) queue[0];
}
```