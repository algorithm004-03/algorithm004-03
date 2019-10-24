# 笔记(更新中)

  

### Linked List

#### 各种操作的时间复杂度

|  操作   | 时间复杂度 |
| :-----: | :--------: |
| prepend |    O(1)    |
| append  |    O(1)    |
| lookup  |    O(n)    |
| insert  |    O(1)    |
| delete  |    O(1)    |

#### 链表的优化

**核心思想：升维思想，空间换时间**

解决方法：增加多级索引，log(2n)个索引

### Array

#### 各种操作的时间复杂度
|  操作   | 时间复杂度 |
| :-----: | :--------: |
| prepend |    O(1)    |
| append  |    O(1)    |
| lookup  |    O(1)    |
| insert  |    O(n)    |
| delete  |    O(n)    |

 

# 队列和栈的Python实现形式的思考

> 个人博客有总结过： https://kanghaov.com

## 队列

 队列 (queue) 是一种特殊的线性表，特殊之处在于它只允许在表的**前端（front）进行删除**操作，而在表的**后端（rear）进行插入**操作，和栈一样，队列是一种操作受限制的线性表。进行插入操作的端称为队尾，进行删除操作的端称为队头。 

```python
class Node(object):
    def __init__(self,elem,next=None):
        self.elem = elem #表示对应的元素值
        self.next=next #表示下一个链接的链点
class Queue(object):
    def __init__(self):
        self.head = None #头部链点为 None
        self.rear = None #尾部链点为 None
    def is_empty(self):
        return self.head is None #判断队列是否为空
    def enqueue(self, elem):
        p = Node(elem) #初始化一个新的点
        if self.is_empty():
            self.head = p #队列头部为新的链点
            self.rear = p #队列尾部为新的链点
        else:
            self.rear.next = p #队列尾部的后继是这个新的点
            self.rear =p #然后让队列尾部指针指向这个新的点
    def dequeue(self):
        if self.is_empty(): #判断队列是否为空
            print(&#039;Queue_is_empty&#039;) #若队列为空，则退出 dequeue 操作
        else:
            result = self.head.elem #result为队列头部元素
            self.head = self.head.next #改变队列头部指针位置
            return result #返回队列头部元素
    def peek(self):
        if self.is_empty(): #判断队列是否为空
            print(&#039;NOT_FOUND&#039;) #为空则返回 NOT_FOUND
        else:
            return self.head.elem #返回队列头部元素
    def print_queue(self):
        print(&quot;queue:&quot;)
        temp=self.head
        myqueue=[] #暂时存放队列数据
        while temp is not None:
            myqueue.append(temp.elem)
            temp=temp.next
        print(myqueue)
```



## 栈

 栈允许进行插入和删除操作的一端称为**栈顶(top)**，另一端为**栈底(bottom)**；**栈底固定，而栈顶浮动**；栈中元素个数为零时称为空栈。**插入一般称为进栈（PUSH），删除则称为退栈（POP）**。 

```python
class Stack(object):
    def __init__(self, limit=10):
        self.stack = [] #存放元素
        self.limit = limit #栈容量极限
    def push(self, data): #判断栈是否溢出
        if len(self.stack) &gt;= self.limit:
            print(&#039;StackOverflowError&#039;)
            pass
        self.stack.append(data)
    def pop(self):
        if self.stack:
            return self.stack.pop()
        else:
            raise IndexError(&#039;pop from an empty stack&#039;) #空栈不能被弹出
    def peek(self): #查看堆栈的最上面的元素
        if self.stack:
            return self.stack[-1]
    def is_empty(self): #判断栈是否为空
        return not bool(self.stack)
    def size(self): #返回栈的大小
        return len(self.stack)
```

