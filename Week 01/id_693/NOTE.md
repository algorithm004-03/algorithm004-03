## 第一周算法总结+源码分析+改写Deque代码

[TOC]

### 一、学习总结

##### 精华：

- 解题曲线：五毒神掌之少一掌
- 解题思路：重复点，重复规律
- 效率优化：升维，用空间换时间(典型的就有redis的跳表)
- 左右指针:左右边界向中间收敛
- 快慢指针：判断是否有环等
- 最新相关性问题：可以直接考虑用栈来解决


##### 知识点：

- 数组，链表、栈、队列、堆排


Leetcode：

- 链接(欢迎指正错误):<https://github.com/kyiln/algorithm004-03/tree/master/Week%2001/id_693>

##### 补充：

**1、刷题五步法：**

- 第一步：用5-15分钟对题目进行思考，想出头绪
  - 如果5-15分钟还没想出头绪，那么直接看答案，理解答案并背诵
- 第二步：关闭答案，自己写程序，直到测试通过
- 第三步：第二天对前一天的程序进行重新写
- 第四步：一周后对程序进行重新写
- 第五步：面试准备前半周或者一周，对题目进行重新写

**2、切题四件套：**

- 读懂题目，理解题目，和面试官做好足够的沟通，防止自己对题意误解
- 想出所有能想到的解法
  - 分析时间/空间复杂度
  - 选出最优解法
- 写程序
- 写测试样例进行测试

### 二、源码分析

#### 1、Queue源码

##### 继承关系

- 继承Collection、Iterable接口

##### 函数说明

```java
add(E e):boolean
	//添加元素
	//如果没有队列空间已满，抛出异常

offer(E e):boolean
	//添加元素
	//如果没有队列空间已满，进行扩容添加
	
remove():E
	//压出栈顶元素
	//如果队列为null，抛出异常
	
poll():E
	//压出栈顶元素
	//如果队列为null，返回null
	
element():E
	//检索栈顶元素
	//如果队列为null，抛出异常
	
peek():E
	//检索栈顶元素
	//如果队列为null，返回null
```

#### 2、Priority Deque源码

##### 继承关系

- 实现了Serializable、Queue、Collection、Iterable接口
- 实现了AbStractQueue、AbstractCollection抽象类



##### 属性说明

```java
//默认初始化大小
private static final intDEFAULT_INITIAL_CAPACITY = 11；
//用数组实现的二叉堆
private transient Object[] queue ;
//队列的元素数量
private int size = 0;
//比较器
private final Comparaotr<? super E> comparator;
//修改版本
private transient int modCount = 0;
```



##### 常用函数

1、offer	添加元素

```java
public boolean offer(E e) {
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        //如果队列size大于等于队列元素,则进行扩容
        //如果队列size小于64 则size * 2 + 2,否则扩容一半(size + size >> 1)
        grow(i + 1);
    size = i + 1;
    if (i == 0)
        //如果队列为null，直接添加元素
        queue[0] = e;
    else
        //函数插入尾部，并对其上浮判断
        siftUp(i, e);
    return true;
}
//上浮
private void siftUp(int k, E x) {
    //如果没有实现比较器则需要对插入的元素实现Comparaotr接口
    if (comparator != null)
        siftUpUsingComparator(k, x);
    else
        siftUpComparable(k, x);
}

private void siftUpComparable(int k, E x) {
    //比较器comparator为null，就需要对插入的元素实现Comparator接口，用于比较大小	
    Comparable<? super E> key = (Comparable<? super E>) x;
    //k判断是否是根，
    while (k > 0) {
        //计算元素x的父节点位置
        int parent = (k - 1) >>> 1;
        //取出x 的父节点
        Object e = queue[parent];
        //如果新增元素比父元素大或等于，则不用上浮，跳出循环
        if (key.compareTo((E) e) >= 0)
            break;
        //x比父亲小，需要进行上浮元素，和父元素进行交换，然后进入下一个循环，
        //直到k >= 父元素 或 为根节点
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;
}
```

2、remove 删除元素

```java
public boolean remove(Object o) {
    int i = indexOf(o);
    if (i == -1)
        return false;
    else {
        removeAt(i);
        return true;
    }
}
private E removeAt(int i) {
    // assert i >= 0 && i < size;
    modCount++;
    int s = --size;
    if (s == i)
        queue[i] = null;
    else {
        E moved = (E) queue[s];
        queue[s] = null;
        //从删除的元素位，开始下沉，原理类似上浮，
        //只是时会考虑左子节点和右子节点的大小，会把小的给左节点，挺有意思的
        siftDown(i, moved);
        //下沉后元素不变，就需要考虑元素的上浮。
        if (queue[i] == moved) {
            siftUp(i, moved);
            if (queue[i] != moved)
                return moved;
        }
    }
    return null;
}


```





### 三、改写Deque

##### LinkedList 

```java
Deque<String> deque = new LinkedList();
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

