# NOTE

* 名词对应

| 英文        | 中文 |
| ----------- | ---- |
| array       | 数组 |
| linked list | 链表 |
| skip list   | 跳表 |



### 复杂度分析

#### 数组时间复杂度

| 操作    | 复杂度 |
| ------- | ------ |
| prepend | O(1)   |
| apppend | O(1)   |
| lookup  | O(1)   |
| insert  | O(n)   |
| delete  | O(n)   |



#### 链表时间复杂度

| 方式    | 复杂度 |
| ------- | ------ |
| prepend | O(1)   |
| append  | O(1)   |
| lookup  | O(n)   |
| Insert  | O(1)   |
| delete  | O(1)   |



### 跳表

* 解决**链表**的 **随机访问** 复杂度高的问题



### 优化思想

* 空间换时间 (升级维度)



### 栈

* FILO 后进先出

* 什么样的问题可以用栈解决 -> **最近相关性**

### 队列

* FIFO 先进先出
* 广度搜索



---

### 数组的常见算法

* 遍历左右边界

```java
// 一维数组的坐标变换 i,j

// 遍历左右边界
int max = 0;
for (int i = 0; i < a.length - 1; i++) {
	for (int j = i + 1; j < a.length; i++) {
		// 可以自顶向下抽象: int area = getArea(i, j);
    int area = (j - i) * Math.min(a[i], a[j]);
		max = Math.max(area, max);
	}
}
```

* 左右双指针

```java
// 双指针左右夹逼
// 第一件事是排序 O(NlogN)

int i = 0; j = a.length - 1;
while (i < j) {
  if (条件) {
    // 操作
    i++;
  } else {
    // 操作
    j--;
  }
}


```



### 链表的常见算法

* 双指针

```java
// 初始化快慢指针
ListNode slow = head;
ListNode fast = head;
/**
 * 根据不同问题, 调整条件
 * 注意: 避免空指针
 */
while (slow != null && fast != null && fast.next != null) {
    slow = slow.next;           // move slow pointer one step each time
    fast = fast.next.next;      // move fast pointer two steps each time
    if (slow == fast) {         // change this condition to fit specific problem
        return true;
    }
}
return false;   // change return value to fit specific problem
```



### 改写

```java
//////////////////////改写前////////////////////////////////
Deque<String> deque = new LinkedList<>();

deque.push("a");
deque.push("b");
deque.push("c");

System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);

while (deque.size > 0) {
  System.out.println(deque.pop());
}

System.out.println(deque);


//////////////////////改写后////////////////////////////////
Deque<String> deque = new LinkedList<>();

deque.addFirst("a"); // push(e) -> addFirst(e)
deque.addFirst("b");
deque.addFirst("c");

System.out.println(deque);

String str = deque.peekFirst(); // peek() -> peekFirst()
System.out.println(str);
System.out.println(deque);

while (deque.size > 0) {
  System.out.println(deque.removeFirst()); // pop() -> removeFirst()
}

System.out.println(deque);

```

---

### 源码分析

#### PriorityQueue

* 参考: https://www.cnblogs.com/linghu-java/p/9467805.html
* 概念
  * 区别于FIFO(先进先出)的队列, 每次出队都是优先级值高的元素
  * 元素比较方法需要实现Comparator
  * 底层数据结构是 二叉堆
    * 堆是完全数
    * 堆中某节点的值总是不大于或者不小于其父节点的值
    * 最大堆 (大顶堆, 大根堆)
      * 父节点的值 >= 任何一个子节点的值
    * 最小堆 (小顶堆, 小根堆)
      * 父节点的值 <= 任何一个子节点的值
    * 实现方式
      * 树
      * 数组
  * PriorityQueue底层是数组实现
    * 左子树位置 2 * n - 1
    * 右子树位置 2 * (n - 1)  ->  2 * n - 2
    * 父亲节点位置  (n - 1) / 2

```java
// 底层存储, 默认大小
private static final int DEFAULT_INITIAL_CAPACITY = 11;
// 数组实现
private transient Object[] queue;
// 初始容量值
private int size = 0;
// 比较器, 后面需要客户端传入或元素实现这个接口
private final Comparator<? super E> comparator;
// 模数, 修改的次数
private transient int modCount = 0;


// 默认构造方法, 比较器为空, 则需要传入的元素, 实现Comparator接口
public PriorityQueue() {
		this(DEFAULT_INITIAL_CAPACITY, null);
}

// 指定容量
public PriorityQueue(int initialCapacity) {
    this(initialCapacity, null);
}

// 指定容量, 和比较器
public PriorityQueue( int initialCapacity, Comparator<? super E> comparator) {
    // 初始大小不允许小于1
    if (initialCapacity < 1)
        throw new IllegalArgumentException();
    // 使用指定初始大小创建数组
    this.queue = new Object[initialCapacity];
    // 初始化比较器
    this.comparator = comparator;
}


// 数组扩容
private void grow(int minCapacity) {
    // 如果最小容量 < 0, 则超出int取值范围, 抛出异常
    if (minCapacity < 0) // overflow
        throw new OutOfMemoryError();
    // 留存当前长度, 用于后面比较
    int oldCapacity = queue.length;
    // 如果当前队列长度小于64则扩容2倍, 否则扩容1.5倍
    int newCapacity = ((oldCapacity < 64)?
                       ((oldCapacity + 1) * 2):
                       ((oldCapacity / 2) * 3));
    // 如果扩容后的容量值 > int 取值范围, 则将newCapacity赋值为Integer.Max_VALUE
    if (newCapacity < 0) // overflow
        newCapacity = Integer. MAX_VALUE;
    // 如果扩容后, newCapacity小于最小需要的容量大小minCapacity, 则按找minCapacity长度进行扩容
    if (newCapacity < minCapacity)
        newCapacity = minCapacity;
    // 数组copy, 进行扩容
    queue = Arrays.copyOf(queue, newCapacity);
}


// 入队
public boolean offer(E e) {
		// 校验: 入队元素空, 则抛空指针异常
		if (e == null)
		    throw new NullPointerException();
		// 修改模数(版本)+1
		modCount++;
		// 记录当前队列中元素的个数
		int i = size ;
		// 如果当前元素个数大于等于队列底层数组的长度, 则进行扩容
		if (i >= queue .length)
		    grow(i + 1);
		// 元素个数+1
		size = i + 1;
		// 如果队列中没有元素, 则将元素e直接添加至根（数组小标0的位置）
		if (i == 0)
		    queue[0] = e;
		else
        // 否则调用siftUp方法, 将元素添加到尾部, 进行上移判断
		    siftUp(i, e);
		return true;
}






// 上移, x表示新插入元素, k表示新插入元素在数组的位置
private void siftUp(int k, E x) {
    // 如果比较器comparator不为空, 则调用siftUpUsingComparator方法进行上移操作
    if (comparator != null)
        siftUpUsingComparator(k, x);
    // 如果比较器comparator为空, 则调用siftUpComparable方法进行上移操作
    else
        siftUpComparable(k, x);
}


private void siftUpComparable(int k, E x) {
    // 比较器comparator为空, 需要插入的元素实现Comparable接口, 用于比较大小
    Comparable<? super E> key = (Comparable<? super E>) x;
    // k>0表示判断k不是根的情况下, 也就是元素x有父节点
    while (k > 0) {
        // 计算元素x的父节点位置[(n-1)/2]
        int parent = (k - 1) >>> 1;
        // 取出x的父亲e
        Object e = queue[parent];
        // 如果新增的元素k比其父亲e大, 则不需要"上移", 跳出循环结束
        if (key.compareTo((E) e) >= 0)
            break;
        // x比父亲小, 则需要进行"上移"
        // 交换元素x和父亲e的位置
        queue[k] = e;
        // 将新插入元素的位置k指向父亲的位置, 进行下一层循环
        k = parent;
    }
    // 找到新增元素x的合适位置k之后进行赋值
    queue[k] = key;
}

// 同上, 区别在于 使用元素实现的Comparator接口, 还是构造传入Comparator接口的实现类
private void siftUpUsingComparator(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (comparator .compare(x, (E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}


// 删除并返回队头的元, , 如果队列为空则抛出NoSuchElementException异常（该方法在AbstractQueue中）
public E remove() {
  E x = poll();
  if (x != null)
    return x;
  else
    throw new NoSuchElementException();
}

// 删除并返回队头的, 素, 如果队列为空则返回null
public E poll() {
  // 队列为空, 返回null
  if (size == 0)
    return null;
  // 队列元素个数-1
  int s = --size ;
  // 修改版本+1
  modCount++;
  // 队头的元素
  E result = (E) queue[0];
  // 队尾的元素
  E x = (E) queue[s];
  // 先将队尾赋值为null
  queue[s] = null;
  // 如果队列中不止队尾一个元素, 则调用siftDown方法进行"下移"操作
  if (s != 0)
    siftDown(0, x);
  return result;
}

// 上移, x表示队尾的元素, k表示被删除元素在数组的位置
private void siftDown(int k, E x) {
  // 如果比较器comparator不为空, 则调用siftDownUsingComparator方法进行下移操作
  if (comparator != null)
    siftDownUsingComparator(k, x);
  // 比较器comparator为空, 则调用siftDownComparable方法进行下移操作
  else
    siftDownComparable(k, x);
}

private void siftDownComparable(int k, E x) {
  // 比较器comparator为空, 需要插入的元素实现Comparable接口, 用于比较大小
  Comparable<? super E> key = (Comparable<? super E>)x;
  // 通过size/2找到一个没有叶子节点的元素
  int half = size >>> 1;        // loop while a non-leaf
  // 比较位置k和half, 如果k小于half, 则k位置的元素就不是叶子节点
  while (k < half) {
    // 找到根元素的左孩子的位置[2n+1]
    int child = (k << 1) + 1; // assume left child is least
    // 左孩子的元素
    Object c = queue[child];
    // 找到根元素的右孩子的位置[2(n+1)]
    int right = child + 1;
    // 如果左孩子大于右孩子, 则将c复制为右孩子的值, 这里也就是找出左右孩子哪个最小
    if (right < size &&
        ((Comparable<? super E>) c).compareTo((E) queue [right]) > 0)
      c = queue[child = right];
    // 如果队尾元素比根元素孩子都要小, 则不需"下移", 结束
    if (key.compareTo((E) c) <= 0)
      break; 
    // 队尾元素比根元素孩子都大, 则需要"下移"
    // 交换跟元素和孩子c的位置
    queue[k] = c;
    // 将根元素位置k指向最小孩子的位置, 进入下层循环
    k = child;
  }
  // 找到队尾元素x的合适位置k之后进行赋值
  queue[k] = key;
}

// 同上, 区别在于 使用元素实现的Comparator接口, 还是构造传入Comparator接口的实现类
private void siftDownUsingComparator(int k, E x) {
    int half = size >>> 1;
    while (k < half) {
        int child = (k << 1) + 1;
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            comparator.compare((E) c, (E) queue [right]) > 0)
            c = queue[child = right];
        if (comparator .compare(x, (E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = x;
}


```



#### ArrayDeque

* 参考: https://www.cnblogs.com/tstd/p/5112177.html

```java
// 存储方式为数组
private transient E[] elements;
// 头指针
private transient int head;
// 尾指针
private transient int tail;
// 最小的初始化容量大小，需要为2的n次幂
private static final int MIN_INITIAL_CAPACITY = 8;



// 默认构造, 初始容量是16
public ArrayDeque() {
  elements = (E[]) new Object[16];
}

// 指定初始容量的构造
public ArrayDeque( int numElements) {
  allocateElements(numElements);
}

// 传入一个集合, 分配空间并放置元素
public ArrayDeque(Collection<? extends E> c) {
  allocateElements(c.size());
  addAll(c);
}

// 分配合适容量大小的数组，确保初始容量是大于指定numElements的最小的2的n次幂
private void allocateElements(int numElements) {
  int initialCapacity = MIN_INITIAL_CAPACITY;
  // 找到大于指定容量的最小的2的n次幂
  // Find the best power of two to hold elements.
  // Tests "<=" because arrays aren't kept full.
  // 如果指定的容量小于初始容量8，则执行一下if中的逻辑操作
  if (numElements >= initialCapacity) {
    initialCapacity = numElements;
    initialCapacity |= (initialCapacity >>>  1);
    initialCapacity |= (initialCapacity >>>  2);
    initialCapacity |= (initialCapacity >>>  4);
    initialCapacity |= (initialCapacity >>>  8);
    initialCapacity |= (initialCapacity >>> 16);
    initialCapacity++;

    if (initialCapacity < 0)   // Too many elements, must back off
      initialCapacity >>>= 1; // Good luck allocating 2 ^ 30 elements
  }
  elements = (E[]) new Object[initialCapacity];
}



// 带异常处理的增加元素
public boolean add(E e) {
  // 调用addLast方法，将元素添加到队尾
  addLast(e);
  return true;
}


// 添加一个元素
public boolean offer(E e) {
  // 调用offerLast方法，将元素添加到队尾
  return offerLast(e);
}

// 在队尾添加一个元素
public boolean offerLast(E e) {
  // 调用addLast方法，将元素添加到队尾
  addLast(e);
  return true;
}

// 将元素添加到队尾
public void addLast(E e) {
  // 如果元素为null，咋抛出空指针异常
  if (e == null)
    throw new NullPointerException();
  // 将元素e放到数组的tail位置
  elements[tail ] = e;
  // 判断tail和head是否相等，如果相等则对数组进行扩容
  if ( (tail = (tail + 1) & ( elements.length - 1)) == head)
    // 进行两倍扩容
    doubleCapacity();
}


// 移除并返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
public E remove() {
  // 调用removeFirst方法，移除队头的元素
  return removeFirst();
}


public E removeFirst() {
  // 调用pollFirst方法，移除并返回队头的元素
  E x = pollFirst();
  // 如果队列为空，则抛出NoSuchElementException异常
  if (x == null)
    throw new NoSuchElementException();
  return x;
}

// 移除并返问队列头部的元素，如果队列为空，则返回null
public E poll() {
  // 调用pollFirst方法，移除并返回队头的元素
  return pollFirst();
}

public E pollFirst() {
  int h = head ;
  // 取出数组队头位置的元素
  E result = elements[h]; // Element is null if deque empty
  // 如果数组队头位置没有元素，则返回null值
  if (result == null)
    return null;
  // 将数组队头位置置空，也就是删除元素
  elements[h] = null;     // Must null out slot
  // 将head指针往前移动一个位置
  head = (h + 1) & (elements .length - 1);
  // 将队头元素返回
  return result;
}



// 返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
public E element() {
  // 调用getFirst方法，获取队头的元素
  return getFirst();
}

public E getFirst() {
  // 取得数组head位置的元素
  E x = elements[head ];
  // 如果数组head位置的元素为null，则抛出异常
  if (x == null)
    throw new NoSuchElementException();
  return x;
}

// 返回队列头部的元素，如果队列为空，则返回null
public E peek() {
  // 调用peekFirst方法，获取队头的元素
  return peekFirst();
}

public E peekFirst() {
  // 取得数组head位置的元素并返回
  return elements [head]; // elements[head] is null if deque empty
}
```



