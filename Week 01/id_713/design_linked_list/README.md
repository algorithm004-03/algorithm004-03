### 设计单链表

* 参考英文站得出的总结



1. addAtHead和AddAtTail 其实就是addAtIndex的一种
2. addAtHead时, Node构造方法调用后, 可以直接赋值给head, 因为返回值就是new Head, 且构造方法里包含了指向后继节点的参数
3. 推荐使用sentinel哨兵节点



---

### 状态转移方程

* 添加元素

```java
toAdd.next = pred.next;
pred.next = toAdd;
```

* 删除元素

```java
// delete pred.next 
pred.next = pred.next.next;
```

* 获取元素

```java
// index steps needed 
// to move from sentinel node to wanted index
for(int i = 0; i < index + 1; ++i) curr = curr.next;
return curr.val;
```



---

### 设计双向链表

* 添加元素

```java
toAdd.prev = pred
toAdd.next = succ
pred.next = toAdd
succ.prev = toAdd
```

* 删除元素

```java
pred.next = succ;
succ.prev = pred;
```

* 获取元素

```java
// choose the fastest way: to move from the head
// or to move from the tail
ListNode curr = head;
if (index + 1 < size - index)
  for(int i = 0; i < index + 1; ++i) curr = curr.next;
else {
  curr = tail;
  for(int i = 0; i < size - index; ++i) curr = curr.prev;
}
```



---

### 算法

* 利用哨兵节点操作
* 双向链表, 首尾双端搜索, 可以用于解决LRU问题



