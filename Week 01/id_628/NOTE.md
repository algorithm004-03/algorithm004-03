# NOTE
# NOTE
# 【学习总结】

​	第一周已经过去了，这周内容里面数据结构占大多比重，熟悉源码了解数据结构的基础实现成了这周最耗时间的地方，重新去认识了一遍底层的实现，并去细致的揣摩其内部的原因，预习周的感觉是转变，那这周的感觉就是踏实，很多以前看源码时候没注意到的问题，在群里小伙伴们的讨论中关注到了一些细节，收益匪浅。这周主要内容如下：

【视频方面】

​			超哥主要围绕线性表进行的讲解，对于计算机而言，本质上就是存储与计算的过程，而存储无非就是顺序存储和离散存储，顺序存储的底层就是数组，可以随机访问，而离散存储的本质就是链表可以充分利用碎片化的空间。各有优劣的同时也成为了数据结构的基石，所以第三节主要围绕这两种存储的特性以及相关的高频题目进行了讲解。

​		在数组和链表熟悉的基础上，讲解了栈和队列，跳表这些数据结构，然后分享了去查阅资料，看源码的方法，布置源码习题也旨在了解这些看似独立的数据结构，在底层大多是依托于数组或链表进行的封装。

【刷题总结】

由于时间原因，题目并没刷太多，在完成低保的情况下，发现了自己一些问题，记录出来以共勉。

1、对边界条件的忽视。

2、对问题场景未动笔动纸，只是脑子里面演练了过程，毕竟好记性不如烂笔头，何况记性也不好。

# 【作业地址】

第一周作业的地址，如下：



# 【源码分析】

### 【1】Queue 

在java中，Queue 属于JAVA自身容器体系的一种，以接口的形式存在，其除了继承基础的Collection接口方法外，自身定义了一些方法。规定了java内的队列具体应该实现什么方法

```java
 	/****Collection 中主要定义的方法****/
     int size();
     boolean isEmpty();
     boolean contains(Object o);
     Iterator<E> iterator();
     Object[] toArray();
     <T> T[] toArray(T[] a);
     boolean add(E e);
     boolean remove(Object o);
     boolean containsAll(Collection<?> c);
     boolean addAll(Collection<? extends E> c);
     boolean removeAll(Collection<?> c);
     boolean retainAll(Collection<?> c);
     void clear();
     boolean equals(Object o);
     int hashCode();

	/********Queue 中主要定义的方法**************/
    boolean add(E e);		//将元素插入队列，如果插入出错则返回异常
    boolean offer(E e);		//将元素插入队列，与add相比，在容量受限时应该使用这个
    E remove();    			//将队首的元素删除，队列为空则抛出异常
    E poll();    			//将队首的元素删除，队列为空则返回null
    E element();    		//获取队首元素，但不移除，队列为空则抛出异常
    E peek();    			//获取队首元素，但不移除，队列为空则返回null
```



### 【2】AbstractQueue

在Queue定义了这些方法后，为了方便使用和扩充，采用AbstractQueue作为其抽象的公共基类，实现了接口中的公共方法。其除了继承AbstractCollection实现的Collection接口中的公共方法外，AbstractQueue还基于offer、poll、peek实现了add、remove、element三个通用方法以及重写了 clear与addAll方法 ，而offer、poll、peek留给其具体实现子类进行实现，充分加强了扩展性。而上层调用者只需关注方法，无需关注其具体实现。

以下是AbstractQueue中利用peek实现element的方法。

```java
   public E element() {
        E x = peek();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }
```



### 【3】PriorityQueue



相比于Queue而言，PriorityQueue则是一个它的具体实现类，其公共方法使用继承的方式，继承了AbstractQueue（队列的公共基类）实现，而其内部通过维护了一个堆实现优先级队列，具体如下：

#### 【3.1】属性源码

```java

	//序列化与反序列化时使用的ID
	private static final long serialVersionUID = -7720805057305804111L;
	//默认的容量
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
	//队列中保存元素的数组（ps：堆在内存里面可以采用数组的方式存储）
    transient Object[] queue; // non-private to simplify nested class access
	//队列的大小
    private int size = 0;
	//比较器，通过比较器结果判断元素之间的权重大小关系
    private final Comparator<? super E> comparator;
	//队列被修改过的次数
    transient int modCount = 0; // non-private to simplify nested class access
```

#### 【3.2】方法源码

##### 3.2.1 构造方法

 核心采用如下构造方法，参数initialCapacity为设定队列容量，comparator指定队列内元素间比较使用的比较器

```java
 public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }
```



##### 3.2.2 扩容方法  

```java
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8; 
	
	private void grow(int minCapacity) {
     	//获取到原队列长度
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
     	//计算新队列长度，如果低于64则直接翻倍，如果元队列高于64，则扩展为原来1.5倍
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
     	//计算新队列长度是否大于数组最大值最大值
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        //新分配数组，并将原数组copy至新数组
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

##### 3.2.3   入堆操作  

在位置k插入元素x，通过将x提升到树的上方直到其大于或等于其父级或成为根，从而保持堆不变。

```java
   private void siftUp(int k, E x) {
        if (comparator != null)
            //如果没有配置比较器，则使用默认入堆方法
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            //获取k的父节点索引
            int parent = (k - 1) >>> 1;
            //获取k的父节点
            Object e = queue[parent];
            //判断当前节点是否大于父节点
            if (key.compareTo((E) e) >= 0)
                break;
            //和父节点交换
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



##### 3.2.4  入队方法 

```java
public boolean offer(E e) {
 
        //队列中不能插入空元素
        if (e == null)
            throw new NullPointerException();

        //记录队列修改操作数
        modCount++;
        int i = size;
 
        //数组大小不够，进行扩容
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
 
        //第一个元素，放在堆顶
        if (i == 0)
            queue[0] = e;
        else
 
        //否则调用siftUp函数从下往上调整堆
        siftUp(i, e);
        return true;

}
```



##### 3.2.5 堆中移除元素方法



```java
 private void siftDownUsingComparator(int k, E x) {
        //获取遍历最后的节点索引
        int half = size >>> 1;
        while (k < half) {
            //获取左子节点
            int child = (k << 1) + 1;
            Object c = queue[child];
            //获取右子节点
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)//获取最小子节点
                c = queue[child = right];
            
            //比较x与子节点大小
            if (comparator.compare(x, (E) c) <= 0)
                break;
            //讲子节点与父节点交换
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }
```



##### 3.2.6 出队方法 

```java
public E poll() {
        if (size == 0)
            return null;
 
        //获取最后一个节点索引
        int s = --size;
 
        //记录操作数
        modCount++;
 
        //获取头节点
        E result = (E) queue[0];
 
        //获取尾节点
        E x = (E) queue[s];
 
        //置空尾节点
        queue[s] = null;
 
        //堆中不止一个元素
        if (s != 0)
            siftDown(0, x);
        return result;

}
```





# 【代码改写】

 用 add first 或 add last 这套新的 API 改写 Deque 的代码 

```java
 	/*******************************
     * 
     *	 【改写之前代码】
     *
     *******************************/
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
    

    /*******************************
     * 
     *	 【改写之后代码】
     *	内容：
     *		push->addFirst
     *		peek->peekFirst
     *		pop->removeFirst
     *
     *******************************/
    public static void targetDemo(){
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
    } 
```






  


  

