# 第二周总结 + Java HashMap源码分析
## 第二周知识点总结
### 树、二叉树
- 链表这种数据结构，在查找的时候时间复杂度太高
  - 解决办法：升维。将链表描述成树/图
- 树的遍历
  - 前序
  - 中序
  - 后序
- 二叉搜索树
  - 也叫有序二叉树、排序二叉树，是指一棵空树或者具有下列性质的二叉树：
    - 左子树上所有节点都小于它的根节点的值
    - 右子树上所有节点都大于他的根节点的值
    - 以此类推：左右子树也分别是为二叉查找树。
  - 中序遍历：升序排列
  - 查询 / 插入 / 删除：O(logn)
  - 常见的操作：【[二叉搜索树操作Demo](https://visualgo.net/zh/bst)】
    - 搜索：从根部开始查找左右子树，循环到叶子节点。
    - 插入：往下搜索待插入节点，如果到了某个节点，应该往左/右搜索，但是它并没有左/右节点，那么表明，待插入节点应该插入到该节点的左/右子节点上
    - 删除：
     - 叶子节点：直接删除
     - 非叶子节点：取删除节点的(大于 / 小于)紧邻该节点的节点（一般取小于的那个节点），直接替换上去即可。如果替换上去的节点也不是叶子节点，那么该节点的子树直接移到该节点的父节点下。

### 递归
- 树的面试题解法一般都是递归
  - 递归就像盗梦空间的情景，每层下探，每层都有终结者，每层执行完任务都会回到上一层
  - Python的递归模板（重要）
```python
def recursion(level, parm1, parm2,….):
    #recursion teminator:递归终结者
    if level > MAX_LEVEL:
        process_result
        return
    
    # process logic in current level：处理当前逻辑
    process(level, data…)
    
    # drill down：下探到下一层
    self.recursion(level + 1, p1, …)
    # reverse the current level status if needed：清理本层的东西(非必须),可能会清理环境变量等

```
- 解递归要点：
  - 一定不要人肉进行递归（最大误区）
  - 找最近最简的方法，将其拆解成可重复解决的问题（寻找最近重复子问题）
  - 数学归纳法思维

### 分治
- 本质上就是递归，可以认为是递归的一个子分类。是一个特殊的递归
- 分治方法：
  - 找重复性
  - 将问题划分为子问题
  - 分治代码模板（和泛型递归差不多，只是最后多了一个组合操作）
```python
def divide_conquer(problem, param1, param2, ...): 
    # 递归终结者
    if problem is None: 
        print_result 
        return 
    # 处理当前逻辑：如何将问题切分成子问题
    data = prepare_data(problem) 
    subproblems = split_problem(problem, data) 
    # 调用本身，下探到下一层，解决更细节的子问题
    subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)
    …
    # 组装合并结果
    result = process_result(subresult1, subresult2, subresult3, …)
    # 清理一些现场的状态

```

### 回溯
- 百度解释
回溯法采用试错的思想，它尝试分布去解决一个问题。在分布解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确解答的时候，它将取消上一步甚至是上几部的计算，再通过其他的可能分布解答再次尝试寻找问题的答案。
- 本质
  - 不断的在每一层去试，试出最终的合格方案
  - 有一种归去来兮的感觉
- 典型用法
  - N皇后
  - 数独问题

## 第二周学习感想
这一周相比上一周，课程多了一点，课程里面的数据结构和算法也更加复杂了一些。

之前在课程之前，想起递归回溯分治，都感觉比较模糊，虽然有些题目经过慢慢调试还是能用递归实现，但是总是少了一点归纳的解题思路。

学习了本周课程之后，并且课后经过覃超老师布置的作业习题的大量练习，反复练习，我终于对这方面有了更加自信的把握。

1. 左右括号，电话号码数字键的问题，排列，组合等问题，其实都是一种问题，就是往格子里面选择填入一些可以填入的元素，然后将问题分解成各个格子的子问题，通过递归回溯解决即可
2. 类似爬楼梯，斐波那契数列，抛硬币问题等类似问题，其实就是一种问题，就是通过数学归纳思想，找出当前要求解的项和之前求解过的项的内在联系，建立递推式，然后利用递归进行求解即可
3. 树的各种操作遍历的练习，对递归的解题功力有很大提升。
4. 用迭代法去解递归的问题，其实就是画图，然后出栈入栈的一些过程实现而已
5. 解题时要有一种自顶向下的思想，不能纠结于细节，善于把问题分解成子问题，可重复子问题进行递归求解
6. 递归、分治的代码模板，必须牢记，在解题的时候，先写下来，然后一个一个填充，很好用

## Java HashMap源码解析（JDK1.8）
HashMap是Java的一个重要类，使用频率非常高，通过hash散列，快速定位到查找的元素位置，通过链表解决hash碰撞的问题。

下面通过源码，分析HashMap的容量，元素结构，hash散列，hash碰撞链表处理等细节。

- HashMap的容量
1. 哈希表的最大容量：2^30

```java
static final int MAXIMUM_CAPACITY = 1 << 30;
```

2. 哈希表的默认容量：2^4 = 16

```java
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
```

3. 默认的加载因子：0.75

```java
static final float DEFAULT_LOAD_FACTOR = 0.75f;
```

默认加载因子是用在resize的时候，用于计算下一次扩容的HashMap的容量(最大值不超过MAXIMUM_CAPACITY)，计算方法：

4. 如果我们创建HashMap并传入容量，那么初始的HashMap容量是多少？

```java
public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }
```

通过上面的源码，我们可以看到，我们即使传入initialCapacity，最后HashMap的容量也不一定是我们传入的值。此时HashMap的值通过tableSizeFor方法计算出来：

```java
static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
```

可以看到，`tableSizeFor通过我们传入的初始容量值，为我们重新计算出一个"符合"HashMap容量规则并且最接近我们传入的值的初始值，作为HashMap的初始容量`。

上面代码的算法解释：

```
先来分析有关n位操作部分：先来假设n的二进制为01xxx...xxx。接着

对n右移1位：001xx...xxx，再位或：011xx...xxx

对n右移2为：00011...xxx，再位或：01111...xxx

此时前面已经有四个1了，再右移4位且位或可得8个1

同理，有8个1，右移8位肯定会让后八位也为1。

综上可得，该算法让最高位的1后面的位全变为1。

最后再让结果n+1，即得到了2的整数次幂的值了。

现在回来看看第一条语句：

int n = cap - 1;

让cap-1再赋值给n的目的是另找到的目标值大于或等于原值。例如二进制1000，十进制数值为8。如果不对它减1而直接操作，将得到答案10000，即16。显然不是结果。减1后二进制为111，再进行操作则会得到原来的数值1000，即8。
```

5. HashMap的散列计算：通过4，我们很有理由想到，为什么HashMap要tableSizeFor我们指定的初始容量，且容量最终为2的幂次方呢？

我们跟踪put代码，到下面这个方法：

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict)
```

从方法体里面，我们会发现这一句：里面的tab

```java
if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
```

可以发现，对新加的元素，计算其hash值在table的位置是通过：`(n - 1) & hash`来完成的，这个到底是什么东西？和我们平时的数学运算有什么联系？

通过查阅资料，发现了个快速幂取模算法：该算法指出：`对2的倍数取模，只要将数与2的倍数-1做按位运算即可！`

而平时我们数学上的mod计算方法，效率太低了。而位运算的效率是超高的。

所以，HashMap在这里做了个"取巧"的优化：`将容量设置为2的幂次，这样就可以用位运算来代替mod运算，从而快速计算出待插入元素的key的hash值在table中的位置`

6. HashMap中元素的存储结构

从下面源码定义可知，里面每个元素有四个值：

元素的key的hash值、元素的key值、元素的值value、下个元素的指针

```java
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        //..........
    }
```

7. HashMap如何找到我们指定的元素？

代码定位到下面代码:

代码很清晰，通过取模运算定位到table的位置，如果table所在的位置里面的第一个元素first不是TreeNode类型（那么就是Node类型），那么简单通过判断 hash和key都是否相等即可查找到我们指定的元素。

```java
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```

8. 7中出现TreeNode？难道HashMap里面的元素还要另外一种形态？

直接定位TreeNode源码：代码很长....下面取出关键的元素示例

```java
    static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
        TreeNode<K,V> parent;  // red-black tree links
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;    // needed to unlink next upon deletion
        boolean red;
        TreeNode(int hash, K key, V val, Node<K,V> next) {
            super(hash, key, val, next);
        }

        /**
         * Returns root of tree containing this node.
         */
        final TreeNode<K,V> root() {
            for (TreeNode<K,V> r = this, p;;) {
                if ((p = r.parent) == null)
                    return r;
                r = p;
            }
        }
        //..............
    }
```

通过上面代码，无疑，这是一个二叉树节点的典型结构，而且是红黑树。

问题来了：为啥会出现这个红黑树的数据结构？用来干嘛？

我们通过定位代码TreeNode，发现了putVal方法里面有一段代码：

```java
for (int binCount = 0; ; ++binCount) {
    if ((e = p.next) == null) {
        p.next = newNode(hash, key, value, null);
        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
            treeifyBin(tab, hash);
        break;
    }
    if (e.hash == hash &&
        ((k = e.key) == key || (key != null && key.equals(k))))
        break;
    p = e;
}
```

可以看到，当判断链表中的节点个数>=TREEIFY_THRESHOLD，也就是8，会将链表中的节点转化为树结构(红黑树化)！

的确，如果链表节点太多，查找的速度会很慢，而树化后，查找的时间复杂度大大降低，这也是HashMap存储的一个优化。

9. 最后，让我们再看看最后一个问题：HashMap在resize的时候，是如何对链表进行的？

resize前面的容量判断等操作，前面已经解析过了，这里我们着重看resize是如何将旧的HashMap的元素移到新的HashMap里面的。

源码片段：

```java
table = newTab;
if (oldTab != null) {
    for (int j = 0; j < oldCap; ++j) {
        Node<K,V> e;
        if ((e = oldTab[j]) != null) {
            oldTab[j] = null;
            if (e.next == null)
                newTab[e.hash & (newCap - 1)] = e;
            else if (e instanceof TreeNode)
                ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
            else { // preserve order
                Node<K,V> loHead = null, loTail = null;
                Node<K,V> hiHead = null, hiTail = null;
                Node<K,V> next;
                do {
                    next = e.next;
                    if ((e.hash & oldCap) == 0) {
                        if (loTail == null)
                            loHead = e;
                        else
                            loTail.next = e;
                        loTail = e;
                    }
                    else {
                        if (hiTail == null)
                            hiHead = e;
                        else
                            hiTail.next = e;
                        hiTail = e;
                    }
                } while ((e = next) != null);
                if (loTail != null) {
                    loTail.next = null;
                    newTab[j] = loHead;
                }
                if (hiTail != null) {
                    hiTail.next = null;
                    newTab[j + oldCap] = hiHead;
                }
            }
        }
    }
}
```

树化移动这里不做解析，重点看链表的移动过程，问题转化为：如何复制链表到新链表中。

- `e.hash & oldCap`是什么？
由于oldCap必然是2的幂次，所以e.hash & oldCap的结果只有两种：0或者oldCap

- 所以，对于原来HashMap的桶里面的元素，一部分保留在原来的桶里面，一部分会被移动到下个位移为oldCap新的桶里面。这样就不需要针对新的容量的HashMap进行Hash计算。

- 为什么这样做就可以？
1. 原来计算HashMap的桶的位置的计算方法：(e.hash & n - 1)
2. 扩容后，将(e.hash & oldCap)值为oldCap的元素移到+oldCap的位置
3. newCap和oldCap都为2的幂次，也就是只有一位为1，其他位都为0
4. 所以，e.hash在老的HashMap(称为oldCap)的位置由oldCap的1所在位的右边位数决定。而e.hash在新的HashMap(称为newCap)的位置，按照(e.hash & n - 1)算，也是由newCap的1所在位的右边位数决定。由于oldCap的1的位置为newCap的1的位置的右边一位，所以newCap和oldCap的hash散列结果，区别只在于oldCap的1的位置。
5. 由4的分析，e.hash & oldCap为0表示e.hash在oldCap的1的位置的位的值为0，e.hash & oldCap为1表示e.hash在oldCap的1的位置的位的值为1。如果e.hash在oldCap的1的位置的位的值为0，那么在newCap用(e.hash & n - 1)计算，该位也是0，位置和原来一样。如果e.hash在oldCap的1的位置的位的值为1，那么在在newCap用(e.hash & n - 1)计算，该位就会为1，那么数值就会比之前多了一个oldCap。
6. 由5的分析，可以看出，这样做是可以的！

所以，HashMap为什么容量为2的幂次很关键。能够提高很多效能。





