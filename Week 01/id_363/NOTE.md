### 学习总结
- 1.刷题方法：自己写/leetcode-cn.com 中看题解/leetcode.com中看discuss --> 至少五遍哟
- 2.第一次分析了源码(表示好开心),发现PriorityQueue的底层实现使用的就是堆。
- 3.最近重复子问题
- 4.重要思想：升维，时间换空间


### 分析源码
#### Queue :   
先进先出, 继承了Collection接口，Queue中元素的顺序可以是FIFO,也可以按照comparator来排序(priorityQueue),提供了两种格式的接口：抛异常和返回特殊值(比如null)  
抛异常：     add  element remove  
返回特殊值： offer peek poll  
网上查找为什么有两种格式的接口：有些Queue的实现，比如LinkedList，允许null值的存在，可能有时候需要通过是否抛异常来判断队列中没有值还是值是null。  
#### AbstractQueue 
抽象类，实现了Queue的接口，包含了一些基础实现
add: 调用offer，如果offer方法的返回值是false，抛出异常  
remove:调用poll，如果返回值是null，抛出异常  
element:调用peek方法，如果返回null，抛出异常  
addAll: 循环调用add方法  
clear:循环调用poll方法  
#### PriorityQueue
无界队列，是基于优先级堆来实现的，优先级队列中不允许null元素，同时优先级队列中的元素必须实现Comparator接口。  
PriorityQueue 不是线程安全的。  
时间复杂度分析： 入队和出队：O(logn)  删除和查看是否包含(remove/contains):O(n)  获取堆顶元素(peek)是O(1)  

属性分析：  
```
private static final int DEFAULT_INITIAL_CAPACITY = 11;
// 底层使用堆来实现
transient Object[] queue; 
private int size = 0;
private final Comparator<? super E> comparator;
transient int modCount = 0; 
```
方法分析：  
add: 底层调用offer方法  
offer: 
```
public boolean offer(E e) {
        if (e == null) throw new NullPointerException();
        modCount++;
        int i = size;
        // 扩容
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        // 添加元素
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // 如果oldCapacity < 64 增加一倍, 否则增加 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }
// 从下向上的堆化：默认使用小顶堆
private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }
```
poll:
```
// 把数据末尾放到堆顶，从上向下堆化
public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];
        E x = (E) queue[s]; // 获取数组末尾元素
        queue[s] = null;
        if (s != 0)
            siftDown(0, x); 
        return result;
    }
// 从上向下堆化
private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1; // 只循环非叶子节点
        while (k < half) {
            int child = (k << 1) + 1; // child是子节点最小值的下标，最开始假设left是做节点
            Object c = queue[child]; // 叶子节点中的最小值
            int right = child + 1;
            // 如果右节点比做节点小，那么child = right , c= queue[right]
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            // 如果当前节点的值比最小值小，那么满足小顶堆的条件，直接退出循环
            // 否则，把当前节点和最小值节点替换，继续一个循环的堆化
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }
```
removeAt:
```
// 还不太懂
private E removeAt(int i) {
        // assert i >= 0 && i < size;
        modCount++;
        int s = --size;
        if (s == i) // removed last element
            queue[i] = null;
        else {
            E moved = (E) queue[s];
            queue[s] = null;
            siftDown(i, moved);
            if (queue[i] == moved) {
                siftUp(i, moved);
                if (queue[i] != moved)
                    return moved;
            }
        }
        return null;
    }
```
### 改写Deque代码
#### 用add first 或 add last 新的api 改写Deque的代码
修改前代码：
```
public static void srcDemo(){

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
   }
```

修改后代码
```
Deque<String> deque = new LinkedList<>();
       deque.addFirst("a");
       deque.addFirst("b");
       deque.addFirst("c");

       System.out.println(deque);

       String str = deque.peekFirst();
       System.out.println(str);
       System.out.println(deque);

       while (deque.size() > 0) {
           System.out.println(deque.removeFirst());
       }

       System.out.println(deque);
```