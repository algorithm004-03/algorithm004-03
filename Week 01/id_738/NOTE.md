# NOTE

### 周总结

本周是算法课堂的第一周。在本周里面，感受到了本门课的训练强度。按照覃超老师提供的五步刷题法建议，我对视频里面的实战题目，对全部课后题都按照五步刷题法的要求去完成。

1. 通过一周的训练，我对 数组/链表/栈/队列 的算法更加熟练了。也学习了一些解题的基本思路。大致有：

- 快慢指针法

- 左右指针夹逼法

- 递归法

- 空间换时间法

- 升维提升运行效率法

- 遇到最近相关性问题，可以直接考虑栈解决
  
2. 做题过遍数很重要，一道题做一次肯定不够，经过多次练习，会不对加深对题目的理解，以及这类题的理解。

3. 一道题目不要局限于一个解法，最基本的暴力法解决虽然看起来比较拙，但是它能够训练最基本的变成功力。而多思考其他方法，能够达到刻意训练洋葱降低编程时间复杂度的良好习惯。

4. 通过作业里面的源码分析，对Priority Queue的底层理解更加透彻了，也从源码学习到堆的操作技巧。

### 本周题目代码连接:

https://github.com/zhengxin12345/algorithm004-03/tree/master/Week%2001/id_738


---

### 改写Deque
```
Deque<String> deque = new LinkedList<String>();
//deque.push("a")
//deque.push("b")
//deque.push("c")

deque.addFirst("a"); 
deque.addFirst("b"); 
deque.addFirst("c"); 
System.out.println(deque);

//String str = deque.peek(); 
String str = deque.peekFirst(); 
System.out.println(str); 
System.out.println(deque);

while (deque.size() > 0) {
    //System.out.println(deque.pop()); 
    System.out.println(deque.removeFirst()); 
}
System.out.println(deque);
```

### 分析Queue源码
- 【[Queue源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)】
- 【[Queue文档](http://fuseyism.com/classpath/doc/java/util/Queue.html)】
- 通过上面的源码链接，我们可以看到
1. Queue只是一个接口，继承了Collection接口
2. Queue里面的元素使用了泛型，可为任意类型元素
3. 方法作用：
```
//往队列头部添加元素，如果成功返回True
//如果添加失败，抛出以下异常
//IllegalStateException : 此时队列容量满,添加不进去
//ClassCastException : 添加的元素类型和队列定义的泛型E不一致
//NullPointerException : 如果队列不允许加入null元素，但是add了一个Null元素
//IllegalArgumentException 如果待添加的元素自身的某些属性，阻止了该元素加入队列
boolean add(E e);  
//查找元素e是否在队列里面，如果是则返回True，否则返回False
boolean offer(E e); 
//返回并删除队列头部元素，如果队列为空抛出异常：NoSuchElementException
E remove();
//返回并删除队列头部元素，如果队列为空返回Null
E poll();
//返回队列头部元素(注意不删除)，如果队列为空抛出异常：NoSuchElementException
E element();
//返回队列头部元素(注意不删除)，如果队列为空返回Null
E peek();
```
4. 实现Queue的类
通过 【[Queue文档](http://fuseyism.com/classpath/doc/java/util/Queue.html)】,可以查阅到实现Queue的类有：
```
AbstractQueue<E>, ArrayBlockingQueue<E>, ArrayDeque<E>, ConcurrentLinkedQueue<E>, DelayQueue<E,extends,Delayed>, LinkedBlockingDeque<E>, LinkedBlockingQueue<E>, LinkedList<T>, PriorityBlockingQueue<E>, PriorityQueue<E>, SynchronousQueue<E>
```

### 分析Priority Queue源码
从【分析Queue源码】可以看到，PriorityQueue实现了Queue接口。
-【[PriorityQueue文档](http://fuseyism.com/classpath/doc/java/util/PriorityQueue.html)】
- 源码分析
1. 继承AbstractQueue类，实现Serializable接口，也就是说可被序列化
2. 提供了多种PriorityQueue的方式
PriorityQueue()：默认创建一个容量为11的空优先队列

PriorityQueue(Collection<? extends E> c)：初始化优先队列，并将集合c的元素添加到优先队列中

PriorityQueue(int cap)：初始化一个容量为cap的空优先队列

PriorityQueue(int cap, Comparator<? super E> comp)：初始化一个容量为cap的空优先队列，并指定队列元素的优先排列规则Comparator

public PriorityQueue(PriorityQueue<? extends E> c)：将参数的优先队列c的元素复制到该优先队列中，并且该优先队列的初始容量为1或者c的容量的1.1倍：
```
this(Math.max(1, (int) (1.1 * c.size())),
            (Comparator<? super E>)c.comparator());
```

public PriorityQueue(SortedSet<? extends E> c)：将SortedSet中的元素初始化到优先队列中，优先队列的Comparator为SortSet的Comparator，并且优先队列的容量为1或者SortedSet的1.1倍
```
this(Math.max(1, (int) (1.1 * c.size())),
           (Comparator<? super E>)c.comparator());
```
3. PriorityQueue实现了iterator方法
4. 其他普通的public这里就不赘述了，具体看doc文档
5. PriorityQueue的底层数据结构为数组：并且在初始化的时候已经固定了容量
```
this.storage = (E[]) new Object[cap];
```
5. PriorityQueue添加元素的时候，会比较队列已经存储的元素数量size和队列的大小queue.length，当队列 size >= queue.length的时候，会进行扩容

6. 对新加入队列的元素，会对元素进行比较，插入到合适的队列位置中。如果队列的comparator为null，则调用siftUpComparable否则调用siftUpUsingComparator
```
private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

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

7. 基本操作remove，add方法都依赖于siftUp或者siftDown操作

8. 下面重点关注siftUpComparable的底层实现：
```
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
这段代码的逻辑，明显看到，PriorityQueue的逻辑结构是一颗完全二叉树，而且是小顶堆（因此如果要变成大顶堆，要自己实现comparator.compare），而底层结构是一个数组。

siftUpComparable就是当前元素与父节点不断比较如果比父节点"小"就交换然后继续向上比较，否则停止比较的过程。

9. 有siftUp方法必然对应有siftDown方法：
```
private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }
```

这个方法就是从堆的第一个元素往下比较，如果比左右孩子节点的最小值大则与最小值交换，交换后继续向下比较，否则停止比较。

10. 分析了上面2个siftUp和siftDown方法，我们就可以来继续看队列的添加删除方法了

- add
追踪代码最后定位到实际代码是：
```
public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
```
所以add的操作就是：在处理完队列容量之后，对待加入的元素进行在最后一个位置进行siftUp操作，也就是说，将待加入的元素放到树的最后一个叶子节点位置，然后通过调整小顶堆，将元素挪动到合适的位置

- remove/poll：删除指定元素/移出队列第一个元素，原理相同。
```
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

同样,remove最后定位到removeAt方法，可以看到，小顶堆的基本操作：将第i个位置值替换为堆中最后个节点的值，然后将替换后的值，进行堆调整，堆的调整先向下调整，如果向下不需要调整则向上调整，最后重新形成一个合格的小顶堆。




















