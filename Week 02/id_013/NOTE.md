# NOTE

## 递归与调用栈

### 递归

- 伪代码：伪代码是对手问题的简要描述，看着像代码，但其实更接近自然语言。
- 递归只是让解决方案更清晰，并没有性能上的优势。有些情况下，使用循环的性能更好。正如《Stack Overfloe》上说的：‘如果使用循环，程序的性能可能会更高；如果使用递归，程序可能更容易理解，如何选择要看什么对你来说更重要。’

#### 基线条件和递归条件

编写函数时，必须告诉它何时停止调用。正因为如此，每个递归函数都有两个部分：基线条件(base case)和递归条件(recursive case)。递归条件指的是函数调用自己，而基线条件是函数不再调用自己，从而避免无限循环。
例如，编写一个倒计时函数：

```
def countdown(i):
    print(i)
    return countdown(i-1)

print(countdown(9))
```

这样编写程序会一直倒数下去，我们需要添加基线条件告诉函数何时停止递归。

```
def countdown(i):
    print(i)
    if i <= 1: #基线条件：递归退出的条件
        return
    else: #递归条件
        return countdown(i - 1)
```

### 栈

- 栈是一种**特殊的列表**，栈内的元素只能通过列表的一端访问，这一端称为**栈顶**。咖啡厅内的一摞盘子是现实世界中常见的栈的例子。只能从最上面取盘子，盘子洗净后，也只能摞在这一摞盘子的最上面。栈被称为一种**后入先出（LIFO，last-in-first-out）**的数据结构。
- 由于栈具有后入先出的特点，所以任何不在栈顶的元素都无法访问。为了得到栈底的元素，必须先拿掉上面的元素。
- 对栈的两种主要操作是将一个元素压入栈和将一个元素弹出栈。入栈使用push()方法，出栈使用pop()方法。下图演示了入栈和出栈的过程。
  ![https://essay-1256185664.cos.ap-guangzhou.myqcloud.com/%E5%8D%9A%E6%96%87%E9%85%8D%E5%9B%BE/%E7%AE%97%E6%B3%95%E7%B1%BB%E9%85%8D%E5%9B%BE/3bf1b51d-4582-4586-ba69-4d0e524040a5.jpg](https://essay-1256185664.cos.ap-guangzhou.myqcloud.com/%E5%8D%9A%E6%96%87%E9%85%8D%E5%9B%BE/%E7%AE%97%E6%B3%95%E7%B1%BB%E9%85%8D%E5%9B%BE/3bf1b51d-4582-4586-ba69-4d0e524040a5.jpg)
- 一个常用的操作是预览栈顶的元素。pop()方法虽然可以访问栈顶的元素，但是调用该方法后，栈顶元素也从栈中被永久性地删除了。peek()方法则只返回栈顶元素，而不删除它。
- 为了记录栈顶元素的位置，同时也为了标记哪里可以加入新元素，我们使用变量top，当向栈内压入元素时，该变量增大；从栈内弹出元素时，该变量减小。push()、pop()和peek()是栈的3个主要方法，但是栈还有其他方法和属性,如下表：

| Stack()   | 建立一个空的栈对象                 |
| --------- | ---------------------------------- |
| push()    | 把一个元素添加到栈的最顶层         |
| pop()     | 删除栈最顶层的元素，并返回这个元素 |
| peek()    | 返回最顶层的元素，并不删除它       |
| isEmpty() | 判断栈是否为空                     |
| size()    | 返回栈中元素的个数                 |

其中：push()、pop()和peek()是栈的3个主要方法。

操作示例：

| 操作        | 描述               |
| :---------- | :----------------- |
| s = []      | 创建一个栈         |
| s.append(x) | 往栈内添加一个元素 |
| s.pop()     | 在栈内删除一个元素 |
| not s       | 判断是否为空栈     |
| len(s)      | 获取栈内元素的数量 |
| s[-1]       | 获取栈顶的元素     |

使用Python中的列表对象：

```
class Stack: 
    """模拟栈""" 
    def __init__(self): 
        self.items = [] 

    def isEmpty(self): 
        return len(self.items)==0  

    def push(self, item): 
        self.items.append(item) 

    def pop(self): 
        return self.items.pop()  

    def peek(self): 
        if not self.isEmpty(): 
            return self.items[len(self.items)-1] 

    def size(self): 
        return len(self.items) 
```

#### 调用栈(call stack)

调用栈(call stack)是重要的编程概念，使用递归也必须理解这个概念。

简单例子：

```
def greet(name):
    print('Hello '+name+'!')
    greet2(name)
    print('getting ready to say bye...')
    bye()

def greet2(name):
    print('How are you '+name+'?')

def bye():
    print('ok!bye')

print(greet('kanghaov'))
                                                                                                                                                                                                                                                             t('Kanghaov'))
```

结果：

```
Hello kanghaov!
How are you kanghaov?
getting ready to say bye...
ok!bye
None
```

代码中可以看到当调用greet('kanghaov')时，计算机会为该函数分配一块内存，变量name被设置为kanghaov。接下来打印Hello kanghaov时，再调用greet2('kanghaov'),并同样的分配它一块内存。
计算机使用一个栈来表示这些内存块，其中第二快内存块位于第一块内存块的上面，当打印完：How are you kanghaov?，greet2()（位于栈顶）就被弹出。此时栈顶的内存为函数greet()，意味着我们返回到了函数greet()，这是非常重要的：**调用另一个函数时，当前函数暂停并处于未完成状态。该函数说有变量的值都还在内存中。**接着函数往下执行bye()函数，使用后被弹出，返回到greet()函数，结束。

**这个栈用于存储多个函数的变量，被称为调用栈**

#### 递归调用栈

递归函数

```
def fact(x):
    if x == 1:
        return x
    else:
        return x * fact(x-1)
```

每个栈都有自己的变量x。在同一个函数调用中不能访问另一个x的变量。

### 总结

- 递归指的是调用自己的函数
- 每个递归函数都有两个条件：基线条件、递归条件
- 栈有两种操作：压入和弹出
- 所有函数调用都进入调用栈
- 调用栈可能很长，这将占用大量内存。

  ## 树与递归

### Python中树的实现

**思路：**

1. 先定义一个节点 node 类，存储数据 data 和左子节点 left 以及 右子节点 right。
2. 再实现二叉树 binary_tree 的类，应至少有以下属性和函数： 属性：有一个根节点（root) , 它是 node 类。 函数：添加子节点 add ，返回父节点 get_parent，删除子节点 delete。

**1. 创建 Node 类**

创建一个 Node 的类，作为基础数据结构：链点，并初始化对应的内参。

具体实现代码如下：

```python
class Node(object):
    def __init__(self,item):
        self.item = item #表示对应的元素
        self.left=None #表示左子节点
        self.right=None #表示右子节点
    def __str__(self):
        return str(self.item)  #print 一个 Node 类时会打印 __str__ 的返回值
```

**2. 创建 Tree 类**

创建一个 Tree 的类，定义根节点。

具体实现代码如下：

```python
class Tree(object):
    def __init__(self):
        self.root=Node('root')  #根节点定义为 root 永不删除，作为哨兵使用。
```

**3. 添加 add 函数**

添加一个 add(item) 的函数，功能是添加子节点到树里面。

具体实现代码如下：

```python
    def add(self,item):
        node = Node(item)
        if self.root is None:  #如果二叉树为空，那么生成的二叉树最终为新插入树的点
            self.root = node
        else:
            q = [self.root] # 将q列表，添加二叉树的根节点
            while True:
                pop_node = q.pop(0)
                if pop_node.left is None: #左子树为空则将点添加到左子树
                    pop_node.left = node
                    return
                elif pop_node.right is None: #右子树为空则将点添加到右子树
                    pop_node.right = node
                    return
                else:
                    q.append(pop_node.left)
                    q.append(pop_node.right)
```

**4. 添加 get_parent 函数**

添加一个 get_parent(item) 函数，功能是找到 item 的父节点。

具体实现代码如下：

```python
    def get_parent(self, item):
        if self.root.item == item:
            return None  # 根节点没有父节点
        tmp = [self.root] # 将tmp列表，添加二叉树的根节点
        while tmp:
            pop_node = tmp.pop(0)
            if pop_node.left and pop_node.left.item == item: #某点的左子树为寻找的点
                return pop_node #返回某点，即为寻找点的父节点
            if pop_node.right and pop_node.right.item == item: #某点的右子树为寻找的点
                return pop_node #返回某点，即为寻找点的父节点
            if pop_node.left is not None: #添加tmp 元素
                tmp.append(pop_node.left)
            if pop_node.right is not None:
                tmp.append(pop_node.right)
        return None
```

 

**5. 添加 delete 函数**

添加一个 delete(item) 函数，功能是从二叉树中删除一个子节点。

```python
    def delete(self, item):
        if self.root is None:  # 如果根为空，就什么也不做
            return False
 
        parent = self.get_parent(item)
        if parent:
            del_node = parent.left if parent.left.item == item else parent.right  # 待删除节点
            if del_node.left is None:
                if parent.left.item == item:
                    parent.left = del_node.right
                else:
                    parent.right = del_node.right
                del del_node
                return True
            elif del_node.right is None:
                if parent.left.item == item:
                    parent.left = del_node.left
                else:
                    parent.right = del_node.left
                del del_node
                return True
            else:  # 左右子树都不为空
                tmp_pre = del_node
                tmp_next = del_node.right
                if tmp_next.left is None:
                    # 替代
                    tmp_pre.right = tmp_next.right
                    tmp_next.left = del_node.left
                    tmp_next.right = del_node.right
 
                else:
                    while tmp_next.left:  # 让tmp指向右子树的最后一个叶子
                        tmp_pre = tmp_next
                        tmp_next = tmp_next.left
                    # 替代
                    tmp_pre.left = tmp_next.right
                    tmp_next.left = del_node.left
                    tmp_next.right = del_node.right
                if parent.left.item == item:
                    parent.left = tmp_next
                else:
                    parent.right = tmp_next
                del del_node
                return True
        else:
            return False
```



### 树的递归遍历

#### 前序遍历

```python
def preoder(self, root):                                                      
        if root is None:                                                            
            return                                                                  
        else:                                                                                                                                  
            print root.data                                                        
            self.preoder(root.left)                          
            self.preoder(root.right)       


```

#### 中序遍历

```python
def midoder(self, root):                                                      
        if root is None:                                                            
            return                                                                  
        else:                                                                                                                                                                                          
            self.midoder(root.left) 
            print root.data                         
            self.midoder(root.right)  
```

#### 后序遍历

```python
def postoder(self, root):                                                      
        if root is None:                                                            
            return                                                                  
        else:                                                               
            self.postoder(root.left)                        
            self.postoder(root.right) 
            print root.data  
```





