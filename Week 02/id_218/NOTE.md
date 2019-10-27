### 知识点
#### 哈希表、映射、集合的实现与特性

#### 哈希表

* 又叫散列表，其中映射的函数叫散列函数，通过散列函数计算出来的数存放到数组，改数组叫做哈希表（散列表）
* 拉链式解决冲突链表
* HashMap的源码put和add的学习总结。微信群里和老师探讨，放到个人总结中。

https://shimo.im/docs/kkTgptvpQxj633Dk/read
https://shimo.im/docs/qhXjxtCyt8kgCkc6/read

* HashMap源码学习：
    * 构造函数
        
```
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

/** 
* Constructs an empty <tt>HashMap</tt> with the default initial capacity 
* (16) and the default load factor (0.75). 
*/
public HashMap() {    
    this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
}
/** 
* Constructs an empty <tt>HashMap</tt> with the specified initial 
* capacity and load factor. 
* 
* @param  initialCapacity the initial capacity 
* @param  loadFactor      the load factor 
* @throws IllegalArgumentException if the initial capacity is negative 
*         or the load factor is nonpositive 
*/
public HashMap(int initialCapacity, float loadFactor) {    
    if (initialCapacity < 0)        
            throw new IllegalArgumentException("Illegal initial capacity: "                                           + initialCapacity);    
    if (initialCapacity > MAXIMUM_CAPACITY)        
        initialCapacity = MAXIMUM_CAPACITY;    
    if (loadFactor <= 0 || Float.isNaN(loadFactor))        
        throw new IllegalArgumentException("Illegal load factor: "                                                                                      + loadFactor);    
    this.loadFactor = loadFactor;    
    this.threshold = tableSizeFor(initialCapacity);}
```
    
`tableSizeFor()` 的主要功能是返回一个比给定整数大且最接近的2的幂次方整数，如给定10，返回2的4次方16.
```
/** 
* Returns a power of two size for the given target capacity. 
*/
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

首先，`int n = cap -1`是为了防止cap已经是2的幂时，执行完后面的几条无符号右移操作之后，返回的capacity是这个cap的2倍，因为cap已经是2的幂了，就已经满足条件了。 如果不懂可以往下看完几个无符号移位后再回来看。
![e05b0e70196d0d9d005fb9fd8a42f5d6.png](en-resource://database/2351:1)
```
public HashMap(Map<? extends K, ? extends V> m) {    
    this.loadFactor = DEFAULT_LOAD_FACTOR;    
    putMapEntries(m, false);
}
/** 
* Implements Map.putAll and Map constructor 
* 
* @param m the map 
* @param evict false when initially constructing this map, else 
* true (relayed to method afterNodeInsertion). 
*/
final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {    
    int s = m.size();
    //当m中有元素时，则需将map中元素放入本HashMap实例对象里。
    if (s > 0) {        
        //判断table是否已经初始化，未初始化，则先初识创建一些变量。
        if (table == null) { // pre-size
            //根据待插入的map的size计算需要创建的HashMap的容量。
            float ft = ((float)s / loadFactor) + 1.0F;            
            int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                (int)ft : MAXIMUM_CAPACITY); 
            //把要创建的HashMap的容量存在threshold中
            if (t > threshold)                
                threshold = tableSizeFor(t);
        }
        //如果table初始化过，因为别的函数也会调用它，所以，有可能HashMap已经被初始化了。
        //判断待插入的map的size，如size大于threshold，则先进性resize()，进行扩容。
        else if (s > threshold)
            resize();
            //然后遍历带插入的map，将每一个Entry插入到本HashMap中。
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {            
                K key = e.getKey();            
                V value = e.getValue();
                //put(k, v)也是调用 putVal函数进行元素的插入。
                putVal(hash(key), key, value, false, evict);        
            }
        }}

//实际存储key，value的数组，只不过key，value被封装成Node了
transient Node<K,V>[] table;

//用于判断链表转到红黑树的阈值
static final int TREEIFY_THRESHOLD = 8;
//用于判断红黑树转到链表的阈值
static final int UNTREEIFY_THRESHOLD = 6;
```
如下为HashMap的内部结构图：
![f9207cb04c2356611aca73dc703b7406.png](en-resource://database/2353:1)
再回到putMapEntries函数中，如果table为null，那么这时就设置合适的threshold，如果不为空并且指定的map的size>threshold，那么就resize()。然后把指定的map的所有Key，Value，通过putVal添加到我们创建的新的map中。putVal中传入了个hash(key)，那我们就先来看看hash(key): 其中key 的 hash值的计算是通过hashCode()的高16位异或低16位实现的：(h = k.hashCode()) ^ (h >>> 16)

```
static final int hash(Object key) {    
    int h;    
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

异或运算：(h = key.hashCode()) ^ (h >>> 16)原 来 的 hashCode : 1111 1111 1111 1111 0100 1100 0000 1010

移位后的hashCode: 0000 0000 0000 0000 1111 1111 1111 1111
进行异或运算 结果：1111 1111 1111 1111 1011 0011 1111 0101
这样做的好处是，可以将hashcode高位和低位的值进行混合做异或运算，而且混合后，低位的信息中加入了高位的信息，这样高位的信息被变相的保留了下来。掺杂的元素多了，那么生成的hash值的随机性会增大。

```
    final Node<K,V>[] resize() {
        // 保存当前table
        Node<K,V>[] oldTab = table;
        // 保存当前table的容量
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // 保存当前阈值
        int oldThr = threshold;
        // 初始化新的table容量和阈值 
        int newCap, newThr = 0;
        /*
        1. resize（）函数在size　> threshold时被调用。oldCap大于 0 代表原来的 table 表非空，
           oldCap 为原表的大小，oldThr（threshold） 为 oldCap × load_factor
        */
        if (oldCap > 0) {
            // 若旧table容量已超过最大容量，更新阈值为Integer.MAX_VALUE（最大整形值），这样以后就不会自动扩容了。
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
             // 容量翻倍，使用左移，效率更高
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                // 阈值翻倍
                newThr = oldThr << 1; // double threshold
        }
        /*
        2. resize（）函数在table为空被调用。oldCap 小于等于 0 且 oldThr 大于0，代表用户创建了一个 HashMap，但是使用的构造函数为      
           HashMap(int initialCapacity, float loadFactor) 或 HashMap(int initialCapacity)
           或 HashMap(Map<? extends K, ? extends V> m)，导致 oldTab 为 null，oldCap 为0， oldThr 为用户指定的 HashMap的初始容量。
    　　*/
        else if (oldThr > 0) // initial capacity was placed in threshold
            //当table没初始化时，threshold持有初始容量。还记得threshold = tableSizeFor(t)么;
            newCap = oldThr;
        /*
        3. resize（）函数在table为空被调用。oldCap 小于等于 0 且 oldThr 等于0，用户调用 HashMap()构造函数创建的　HashMap，所有值均采用默认值，oldTab（Table）表为空，oldCap为0，oldThr等于0，
        */
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        // 新阈值为0
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        // 初始化table
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            // 把 oldTab 中的节点　reHash 到　newTab 中去
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    // 若节点是单个节点，直接在 newTab　中进行重定位
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    // 若节点是　TreeNode 节点，要进行 红黑树的 rehash　操作
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    // 若是链表，进行链表的 rehash　操作
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        // 将同一桶中的元素根据(e.hash & oldCap)是否为0进行分割（代码后有图解，可以回过头再来看），分成两个不同的链表，完成rehash
                        do {
                            next = e.next;
                            // 根据算法　e.hash & oldCap 判断节点位置rehash　后是否发生改变
                            //最高位==0，这是索引不变的链表。
                            if ((e.hash & oldCap) == 0) { 
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            //最高位==1 （这是索引发生改变的链表）
                            else {  
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {  // 原bucket位置的尾指针不为空(即还有node)  
                            loTail.next = null; // 链表最后得有个null
                            newTab[j] = loHead; // 链表头指针放在新桶的相同下标(j)处
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            // rehash　后节点新的位置一定为原来基础上加上　oldCap，具体解释看下图
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }}
```
因为使用的是2次幂的扩展(指长度扩为原来2倍)，所以，元素的位置要么是在原位置，要么是在原位置再移动2次幂的位置。

看下图可以明白这句话的意思，n为table的长度，图（a）表示扩容前的key1和key2两种key确定索引位置的示例，图（b）表示扩容后key1和key2两种key确定索引位置的示例，其中hash1是key1对应的哈希与高位运算结果。
![e39c893e654ce686c17c395a0da981c6.png](en-resource://database/2355:1)
元素在重新计算hash之后，因为n变为2倍，那么n-1的mask范围在高位多1bit(红色)，因此新的index就会发生这样的变化：
![da8767e7ddec419cd2b89599acdd9329.png](en-resource://database/2357:1)

因此，我们在扩充HashMap的时候，只需要看看原来的hash值新增的那个bit是1还是0就好了，是0的话索引没变，是1的话索引变成“原索引+oldCap”，可以看看下图为16扩充为32的resize示意图 ：
![30c9ecb3a2e5a72d40a78eb6ce696db1.png](en-resource://database/2359:1)

*  什么时候扩容：
    *  通过HashMap源码可以看到是在put操作时，即向容器中添加元素时，判断当前容器中元素的个数是否达到阈值（当前数组长度乘以加载因子的值）的时候，就要自动扩容了。
*  扩容（resize）：
    * 其实就是重新计算容量；而这个扩容是计算出所需容器的大小之后重新定义一个新的容器，将原来容器中的元素放入其中。

```

    //实现put和相关方法。
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //如果table为空或者长度为0，则resize()
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //确定插入table的位置，算法是(n - 1) & hash，在n为2的幂时，相当于取摸操作。
        ////找到key值对应的槽并且是第一个，直接加入
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        //在table的i位置发生碰撞，有两种情况，1、key值是一样的，替换value值，
        //2、key值不一样的有两种处理方式：2.1、存储在i位置的链表；2.2、存储在红黑树中
        else {
            Node<K,V> e; K k;
            //第一个node的hash值即为要加入元素的hash
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //2.2
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            //2.1
            else {
                //不是TreeNode,即为链表,遍历链表
                for (int binCount = 0; ; ++binCount) {
                ///链表的尾端也没有找到key值相同的节点，则生成一个新的Node,
                //并且判断链表的节点个数是不是到达转换成红黑树的上界达到，则转换成红黑树。
                    if ((e = p.next) == null) {
                         // 创建链表节点并插入尾部
                        p.next = newNode(hash, key, value, null);
                        ////超过了链表的设置长度8就转换成红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            //如果e不为空就替换旧的oldValue值
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```

* 注：hash 冲突发生的几种情况：
    * 1.两节点key 值相同（hash值一定相同），导致冲突；
    * 2.两节点key 值不同，由于 hash 函数的局限性导致hash 值相同，冲突；
    * 3.两节点key 值不同，hash 值不同，但 hash 值对数组长度取模后相同，冲突；

* 1.7和1.8的HashMap的不同点
    * JDK1.7用的是头插法，而JDK1.8及之后使用的都是尾插法
        
        JDK1.7是用单链表进行的纵向延伸，当采用头插法就是能够提高插入的效率，但是也会容易出现逆序且环形链表死循环问题。但是在JDK1.8之后是因为加入了红黑树使用尾插法，能够避免出现逆序且链表死循环的问题。

    * 扩容后数据存储位置的计算方式也不一样：
    
            1：在JDK1.7的时候是直接用hash值和需要扩容的二进制数进行&（这里就是为什么扩容的时候为啥一定必须是2的多少次幂的原因所在，因为如果只有2的n次幂的情况时最后一位二进制数才一定是1，这样能最大程度减少hash碰撞）（hash值 & length-1） 。
            2：而在JDK1.8的时候直接用了JDK1.7的时候计算的规律，也就是扩容前的原始位置+扩容的大小值=JDK1.8的计算方式，而不再是JDK1.7的那种异或的方法。但是这种方式就相当于只需要判断Hash值的新增参与运算的位是0还是1就直接迅速计算出了扩容后的储存方式。
            3：JDK1.7的时候使用的是数组+ 单链表的数据结构。但是在JDK1.8及之后时，使用的是数组+链表+红黑树的数据结构（当链表的深度达到8的时候，也就是默认阈值，就会自动扩容把链表转成红黑树的数据结构来把时间复杂度从O（N）变成O（logN）提高了效率）。

*  HashMap为什么是线程不安全的？
    *  put的时候导致的多线程数据不一致
        
            比如有两个线程A和B，首先A希望插入一个key-value对到HashMap中，首先计算记录所要落到的 hash桶的索引坐标，然后获取到该桶里面的链表头结点，此时线程A的时间片用完了，而此时线程B被调度得以执行，和线程A一样执行，只不过线程B成功将记录插到了桶里面，假设线程A插入的记录计算出来的 hash桶索引和线程B要插入的记录计算出来的 hash桶索引是一样的，那么当线程B成功插入之后，线程A再次被调度运行时，它依然持有过期的链表头但是它对此一无所知，以至于它认为它应该这样做，如此一来就覆盖了线程B插入的记录，这样线程B插入的记录就凭空消失了，造成了数据不一致的行为。

    *  resize而引起死循环

            这种情况发生在HashMap自动扩容时，当2个线程同时检测到元素个数超过 数组大小 × 负载因子。此时2个线程会在put()方法中调用了resize()，两个线程同时修改一个链表结构会产生一个循环链表（JDK1.7中，会出现resize前后元素顺序倒置的情况）。接下来再想通过get()获取某一个元素，就会出现死循环。

*  HashMap和HashTable的区别：HashMap和Hashtable都实现了Map接口，但决定用哪一个之前先要弄清楚它们之间的分别。主要的区别有：线程安全性，同步(synchronization)，以及速度。
    *  HashMap几乎可以等价于Hashtable，除了HashMap是非synchronized的，并可以接受null(HashMap可以接受为null的键值(key)和值(value)，而Hashtable则不行)。
    *  HashMap是非synchronized，而Hashtable是synchronized，这意味着Hashtable是线程安全的，多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。Java 5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。
    *  另一个区别是HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常。但这并不是一个一定发生的行为，要看JVM。这条同样也是Enumeration和Iterator的区别。
    *  由于Hashtable是线程安全的也是synchronized，所以在单线程环境下它比HashMap要慢。如果你不需要同步，只需要单一线程，那么使用HashMap性能要好过Hashtable。
    *  HashMap不能保证随着时间的推移Map中的元素次序是不变的。

待学习：https://tech.meituan.com/2016/06/24/java-hashmap.html

#### 树
* 源于对一维数据结构的升维而产生了树。BST的中序遍历是递增的。
* 二叉树：常见的BST，红黑树，AVL
    * 二叉搜索树：
        * 左子树的所有节点均小于它的根的值
        * 右子树的所有节点均大于它的根的值
        * 常见操作：https://visualgo.net/zh/bst?slide=1
    * 输的面试题解法一般都是递归，主要是因为树的数据结构决定，树只有左右节点。
* 遍历：前序，中序、后序（根在前 中 后的位置来决定）
* 树的操作：使用递归来实现。

#### 递归

* 向下进入到不同的层；向上又回到原来的一层；
* 递归栈，类似剥洋葱
* 递归模板：
    * 优先确定递归结束条件；
    * 处理当前层逻辑；
    * 调用到下一层（level + 1）
    * 可能清理当前层数据

* 思维要点
    * 不要人肉递归（最大误区）
    * 找最近重复子问题：找到最近最简单的方法，将其拆解成可重复解决的问题
    * 数学归纳法思维

#### 分治  回溯

分治、回溯是一种特殊或较为复杂的递归。

* 找重复性：
    * 最近重复性：分治/回溯
    * 最优重复性：即为动态规划

* 分治（Divide &  Conquer）：在递归时，将当前的一个问题化解成多个子问题。
* 回溯（BackTracking）： 采用试错的思想，它尝试分步的去解决问题。如果不能解决，则取消上一步，甚至是上几步的计算。
##### 分治模板

```
def divide_conquer(problem, param1, param2, ...): 
    # recursion terminator 
    if problem is None: 
        print_result 
        return 

    # prepare data 
    data = prepare_data(problem) 
    subproblems = split_problem(problem, data) 

    # conquer subproblems 
    subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
    subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
    subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
    …

    # process and generate the final result 
    result = process_result(subresult1, subresult2, subresult3, …)

    # revert the current level states
```

#### 总结
通过第二周的学习，使我了解和学习了如下基本技能，也在不断的训练自己使用：
* 递归解题大法：
    *   1 terminator 结束条件
    *   2 process 当前循环的逻辑
    *   3 drill down 进入到下一层（可能只需要一个，也可能需要两次进入，也可能是for循环进入）
    *   4 reverse states更新清理当前状态（一般回溯算法需要用到。）
* 不要人肉递归（最大误区），找到最小重复单元

