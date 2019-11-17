# NOTE

深度学习内容
Array, LinkedList, Stack (interface), Queue (interface), Deque - Double Ended Queue

了解内容
SkipList， Priority Queue (interface) - 多样实现方法

解题策略
1.	考虑暴力方法。 理清基本解题逻辑 为找重复子问题打基础
2.	找 最近 重复子问题。 
    数学推导法 - 从简单情况列举。 为什么？ 因为 计算机只能处理if else loop， 所以所有思路只能变成去找重复性


解题思想：
1.	左右夹逼 （从中间到两边）
2.	快慢指针  - 通过速度不同的多指针， 实现O（1）空间操作
3.  空间换时间， 升维  
    a. Deque (实现中间值的线性有序记录) 
    b. Dynamic programming aka 表格编程 （可预先记录计算过程中的中间值，随时取用）Deque的升维版本
4. 空间换时间的技巧
    a. 栈 - 具有最近相关性。 洋葱结构
    b. 队列 - 强调先来后到


学习方法
1. 5遍刷题法  
    过遍数 很重要
    看题解 做题 都要过遍数

2. 5分钟思考没思路直接看答案， 不需要发明创造



Deque 改写

Deque<String> deque = new LinkedList();
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



不熟悉java 简单源码分析

Queue source code anlysis

first in first out

Time Complexity
add, delete O(1)
find O(n)
Queue is top level interface

Supported Methods
Operation Category	Throw	    Return Value
Insert	            add()	    offer(e) false
Remove	            remove()	poll() null
Examine	            element()	peek() null

Priority Queue source code analysis

Unbounded
Based on Heap
Support custom element comparator upon construction

Time Complexity
add O(1)
get O(logN)
