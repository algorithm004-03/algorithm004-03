# 第一周学习总结

## 数组

- 申请数组时，计算机实际上是在内从中开辟了一段连续内存地址，每一个地址可以通过内存管理器访问
- 数组的访问时间快，访问任一元素的时间复杂度为常数级的**O(1)**
- 数组插入元素时，需要先进行元素的移动，所以时间复杂度为线性的**O(n)**
- 数组在删除元素后，需要将剩余的元素进行移动，所以时间复杂度也是**O(n)**

## 链表

- 元素由 `value` 和 `next` 构成，`next` 指向下一个元素
- 每一个元素一般有一个 `Node` 类来定义，有一个 `next` 指针的为单链表，存在 `next` 和 `prev` 指针的为双向链表
    例如 LinkedList

    ```java
    class LinkedList {
        Node head;
        class Node {
            int value;
            Node next;
            Node(int d) {
                value = d;
            }
        }
    }
    ```

- 头指针一般用 `Head` 表示，尾指针用 `Tail` 表示, 一般情况下尾指针的 `next` 指向 *Null* ，若尾指针 `Tail` 指向 `Head`则叫做循环链表
- 链表的插入是将前一个节点的 `next` 指向要插入的 `Node` 并将此 `Node` 的 `next` 指向下一个节点，该操作的时间复杂度为**O(1)**
- 链表的删除可以视为插入的逆操作，将前一个节点的 `next` 指向要删除的节点的 `next` 指向的节点，该操作的时间复杂度为**O(1)**
- 随机访问链表中元素的时间复杂度为**O(n)**

## 跳表

- 优化链表查找的线性时间复杂度
- 两个重要思想 **升维** 和 **空间换时间**
- 对链表进行升维优化
  - 增加头尾指针，方便查找头尾附近的元素
  - 升维，多添加一些指针，例如中间指针
- 添加索引
  - 第一级索引：第一个指针指向头指针，之后指向 `next + 1` 的位置，即每次跨越两个元素
  - 第二级索引：在第一级索引的基础上乘以二，即每次跨越四个元素
  - 多级索引：增加 `log2n` 个多级索引
- 跳表中查询任意数据的时间复杂度为**O(logn)**，空间复杂度为**O(n)**

## 栈、队列、双端队列

### 栈

- Stack
- 后进先出 `Last in - First out (LIFO)`
- 添加与删除的时间复杂度均为**O(1)**，查找的时间复杂度为**O(n)**
- Java 中的实现是一个类，继承自 `Vector`

### 队列

- Queue
- 先进先出 `First in - First out (FIFO)`
- 添加与删除的时间复杂度均为**O(1)**，查找的时间复杂度为**O(n)**
- Java 中是一个接口，有多种实现

### 双端队列

- Deque，Double - End Queue
- 一个 `Stack` 和 `Queue` 的结合体，可以在队列前端和尾端进行 `push` 和 `pop` 操作
- 添加与删除的时间复杂度均为**O(1)**，查找的时间复杂度为**O(n)**
- Java 中是一个接口

## 优先队列

- Priority Queue
- 定义的一种抽象数据结构，可以有多种实现
- 插入操作的时间复杂度为**O(1)**
- 取出操作的时间复杂度为**O(logn)**，按照元素的优先级取出
- 底层具体实现的数据结构较为多样和复杂
  - heap，也是可以多种实现的堆
  - bst，`binary search tree` 二叉搜索树
  - treap
- Java 中的实现是 `PriorityQueue` 类，继承自 `AbstractQueue`，实现了 `Queue` 接口
  - 通过 `compartor()` 函数来定义优先级

## 解题总结

### 步骤

1. 读题后5~10分钟想解题办法（实在想不出来直接去看解析）
2. 把所有解法列出来实现，找到最优解
3. 做完后看别人的解题思路和结果，可以切换到 LeetCode 国际站再解一遍题并看一遍讨论
4. 刷五遍题

### 思想

- 升维思想
- 空间换时间
- 找重复子，例如 Fibonacci 列表问题
- 快慢指针（环形链表）

### 技巧

- 一些常用的解题代码要记住
- 用两个队列实现栈，用两个栈实现队列
- 滑动窗口 `Sliding Window` 问题，用一个双端队列处理

## 总结

- 一些算法题还是第一时间没有使用响应数据结构解题的意识，还需要自己多去练习并刻意的培养习惯
- 有一些题少考虑了一些边界情况，需要注意
- 多拿笔在纸上画一下，有助于理清思路
- 还需要多去看看视频中提到的相关源码

## 作业

- 用add first或add last这套新的API改写Deque的代码
  
    ```java
    /**
     * Before
     */
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

    /**
     * After
     */
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
