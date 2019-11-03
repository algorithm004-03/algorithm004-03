#   NOTE

# 学习总结

## 学习感想

直接上个脑图吧：

![KMIWwQ.png](https://s2.ax1x.com/2019/10/20/KMIWwQ.png)





## 改写代码

  ```java
/**
 * @author jaryoung
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        //  This push method is equivalent to {@link #addFirst}.
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        // This peek method is equivalent to {@link #peekFirst()}.
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            // This pop method is equivalent to {@link #removeFirst()}.
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
  ```



## 分析源码

### Queue

>  定义一个队列的操作的接口，也就是定义一组规范。

```java
public interface Queue<E> extends Collection<E> {
    
    // 插入操作，插入成功返回true，插入失败就抛出异常
    boolean add(E e);
  
    // 插入操作，插入成功返回true，插入失败返回false
    boolean offer(E e);

    // 检索并移除，删除成功返回true，删除失败抛出异常
    E remove();
  
    // 检索并移除，删除成功返回被删除的元素，如果队列为空返回null
    E poll();
 
    // 返回队头元素，存在则返回，不存在则抛出异常
    E element();
  
    // 返回队头元素，存在则返回，如果队列为空返回null
    E peek();
}
```



### Priority Queue

> <p>The <em>head</em> of this queue is the least element
> with respect to the specified ordering.  If multiple elements are
> tied for least value, the head is one of those elements -- ties are
> broken arbitrarily.  The queue retrieval operations {@code poll},
> {@code remove}, {@code peek}, and {@code element} access the
> element at the head of the queue.

大体意思，就是优先级越低越排前面，底层数据结构是一个小顶堆。

先来一张类图：

[![KnB0TH.md.png](https://s2.ax1x.com/2019/10/19/KnB0TH.md.png)](https://imgchr.com/i/KnB0TH)

从上面，我们可以看出PriorityQueue的继承关系。

再看看抽象的AbstractQueue如何根据Queue接口，定义了规范的使用，子类只要继承抽象的父类就能很方便去实现队列  **规范**。

```java
    public boolean add(E e) {
        if (offer(e))// 由子类自定义实现
            return true;
        else
            throw new IllegalStateException("Queue full");
    }

    public E remove() {
        E x = poll(); // 由子类自定义实现
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    public E element() {
        E x = peek(); // 由子类自定义实现
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        while (poll() != null)
            ;
    }

    public boolean addAll(Collection<? extends E> c) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
```

### 

### 分析 offer 方法

```java
	public boolean offer(E e) {
        int i = size;
				...
        if (i == 0)// 如果队列为0，直接放到队列头部
            queue[0] = e;
        else
            siftUp(i, e);// 根据规则规则防止合适的位置
        return true;
    }

    private void siftUp(int size, E e) {
        if (comparator != null) // 如果有自定义比较器，使用自定义比较器，否则使用默认
            siftUpUsingComparator(size, e);
        else
            siftUpComparable(size, e);
    }

    private void siftUpUsingComparator(int k, E x) {// k 位之前size的值，也是最后的位置，过来看看
        while (k > 0) {
            int parent = (k - 1) >>> 1; // 不断无符号右移1位
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)// 通过自定义比较器比较，>=0，表示x大于或者等于e，优先级越低，元素越靠前
                break;
            queue[k] = e; 
            k = parent; // 当前位置设置为父亲的位置，不断往上走
        }
        queue[k] = x;// 优先级非常低，上面的while循环会将k右移到0，当为0的时候，说明这个人优先级最低，能坐第一的位置。 
    }
```

### 分析poll方法

```java
    
		public E poll() {
        int s = --size;
				...
        E result = (E) queue[0]; // 从队列头部取元素
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

    private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }
		
		// 根据规则重新排序
		private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)// 优先级越低，越是往前排
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }
```

### debug 是个厉害角色

```java
/**
 * @author jaryoung
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(4,
                Comparator.comparing(item -> !item.equalsIgnoreCase("苹果")));
        priorityQueue.offer("华为P30");
        priorityQueue.offer("小米3");
        priorityQueue.offer("苹果");
        priorityQueue.offer("小米8");
        priorityQueue.offer("vivo");
        System.out.println("我真的不要 " + priorityQueue.poll());
    }
}
// 我真的不要 苹果
```

