# NOTE
# 【第二周学习总结】

## 【本周知识点】

本周进行了5-8节的学习，从数据结构转入到最新的算法学习，主要学习了如下的知识点。

- 哈希表、集合的实现原理，并针对其题目进行讲解

- 引入树的概念，介绍了二叉树二叉搜索树等结构，并进行实战
- 讲解了递归模板，与递归的基本阶梯思路，以及递归上剪枝的优化
- 从递归引入分治、回溯的算法思维，讲解了多道经典的题目

## 【本周学习总结】

### 【递归模板】

写递归代码需要明确其终止条件以及每一层控制量的含义，同时可以活学活用活改模板，模板有型但思维无疆。以下是老师给的递归模板

```java
public void recur(int level, int param) { 

  // terminator -- 递归终止条件
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic -- 处理当前层的业务逻辑
  process(level, param); 

  // drill down 	-- 进入下一层
  recur( level: level + 1, newParam); 

  // restore current status --如果使用了全局变量或公共变量，需要清理其使用痕迹，避免影响其他层。
 
}
```

【分治模板】

分治的思想就是以大化小，寻找重复单元，之后分分合合去进行计算。

```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator -- 终止条件
  if problem is None: 
	print_result 
	return 

  # prepare data -- 预处理数据，分解子问题
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems -- 分开解决每一个子问题
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result -- 合并最终子问题结果
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```




# 【源码总结】第二周-map（jdk1.8版本）

想了解hashmap，需要先了解java中的hash，在自顶向下的了解map这个数据结构。

## 【1】Object  所有对象的祖师爷

java中所有对象都是从Object来的，其规定了两个方法，一个是hashCode是计算对象地址的hash值，一个是equals方法，是比较对象是否相等，而运算符“==”比较的是类实例对象在JVM堆中分配内存的地址是否相同。

```java
//计算
public native int hashCode();
//比较内存地址是否一样
public boolean equals(Object obj) {
	return (this == obj);	
}

```

## 【2】String 不服从安排的少数党

由于Object中equals比较的是内存地址，不符合String的基本需求，所以重写了equals和hashcode方法，具体如下。equals主要用来比较内部字符是否每一个都相同，而hashcode则是给每个字符逐个hash后算总和，这样就会出现hashcode相同而equals不同的场景。

ps：hashcode计算过程中的乘子31的选择也是有一定依据的，感兴趣可参考【[这个链接](https://www.cnblogs.com/nullllun/archive/2018/01/25/8350178.html)】

```java
//String重写后的hashCode----哈希的实际过程
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;
       	//总计算式：s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        for (int i = 0; i < value.length; i++) {
            //【选31的原因】
            //		1、素数，冲突分布相对均匀
            //		2.JVM可优化  31 * i = (i << 5) - i
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
//String重写后的equals
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        //先判断长度是否一致
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            //逐个字符判断是否相等
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

## 【3】Map  所有哈希表的祖父

java中定义了Map这个接口，其主要定义了映射表的公共方法描述，基于它有很多具体的实现内，是映射表体系中的祖父级接口，核心方法如下：

```java
 	//当前映射表实际存放元素多少
	int size();
	//当前隐射表是否是空的
    boolean isEmpty();
	//当前映射表中是否包含key
    boolean containsKey(Object key);
	//当前映射表中是否包含value
    boolean containsValue(Object value);
	//获取键值为key对应的value
    V get(Object key);
	//放入键为key，值为value的键值对
    V put(K key, V value);
	//删除键为key的键值对
    V remove(Object key);
	//将另一个map全部导入当前map
    void putAll(Map<? extends K, ? extends V> m);
	//清理当前map中元素
    void clear();
	//获取当前map中所有的key集合
    Set<K> keySet();
	//获取当前map中所有的values集合
    Collection<V> values();
```

除了核心方法外，还定义了其内部类entry的结构和方法，entry作为键值对的容器，以数组加链表的方式存放在map中，具体如下

```java
 
interface Entry<K,V> {
    
    //获取当前entry节点的key
    K getKey();
    //获取当前entry节点的value
    V getValue();
    //设置当前节点的value
    V setValue(V value);
    //判断当前节点与o是否相同     
    boolean equals(Object o);
    //计算当前节点的hash值
    int hashCode();
    
    //获得一个通过key比较的比较器
     public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K,V>> comparingByKey() {
         return (Comparator<Map.Entry<K, V>> & Serializable)
             (c1, c2) -> c1.getKey().compareTo(c2.getKey());
     }
	//获取一个通过value比较的比较器
    public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
         return (Comparator<Map.Entry<K, V>> & Serializable)
             (c1, c2) -> c1.getValue().compareTo(c2.getValue());
     }

    //获取一个通过key比较的比较器
    public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
         Objects.requireNonNull(cmp);
         return (Comparator<Map.Entry<K, V>> & Serializable)
             (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
     }

     //获取一个通过value比较的比较器
     public static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
         Objects.requireNonNull(cmp);
         return (Comparator<Map.Entry<K, V>> & Serializable)
             (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
     }
 }
```



## 【4】AbstractMap  Map家族的领军人物

是map大家族中的公共基类，算是家族族长性质的人物，其通过自己定义的抽象方法entrySet方法，实现了大多数map中定义的接口方法，留下这个抽象方法和map中定义的内部类让其他具体实现类依照实际情况去实现。

```java
//自定义的抽象方法
public abstract Set<Entry<K,V>> entrySet();
//依赖entrySet方法，通过迭代遍历实现通用get方法
public V get(Object key) {
     Iterator<Entry<K,V>> i = entrySet().iterator();
     if (key==null) {
         while (i.hasNext()) {
             Entry<K,V> e = i.next();
             if (e.getKey()==null)
                 return e.getValue();
         }
     } else {
         while (i.hasNext()) {
             Entry<K,V> e = i.next();
             //比较遍历时节点的key是否与搜索的key一致判断
             if (key.equals(e.getKey()))
                 return e.getValue();
         }
     }
     return null;
 }
```

## 【5】hashMap   Map家族的明星选手

聊到hashmap，它可说的就多了，各式各样的明星光环。那就从源码上逐一拆解光环吧。

### 【5.1】常量介绍



```java
    //默认容器的初始容量
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
	//容器的最大容量
    static final int MAXIMUM_CAPACITY = 1 << 30;
	//容器默认的加载因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
	//链表节点转换为红黑树节点的阈值
    static final int TREEIFY_THRESHOLD = 8;
	//红黑树节点退化为链表节点的阈值
    static final int UNTREEIFY_THRESHOLD = 6;
	//转换为红黑树节点时table的最小长度
    static final int MIN_TREEIFY_CAPACITY = 64;
```



### 【5.2】属性介绍



```java
 	
 	transient Node<K,V>[] table;
   
    transient Set<Map.Entry<K,V>> entrySet;
    //实际存储的键值对的个数
    transient int size;
    //容器内被操作次数，用以迭代时控制变化的感知
    transient int modCount;
    //扩容触发阈值，当table == {}时，该值为初始容量（初始容量默认为16）；
    int threshold;
    //加载因子，代表了table的填充度有多少，默认是0.75（75%）
    final float loadFactor;

```



### 【5.3】内部类介绍

普通节点

```java
//继承map接口内的entry节点
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;		//hash值
    final K key;		//键
    V value;			//值
    Node<K,V> next;		//下一个节点

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }

    //调用内部存放对象的hashcode方法
    public final int hashCode() {
        //^（异或运算符）1^0 = 1 , 1^1 = 0 , 0^1 = 1 , 0^0 = 0
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
	
    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //分别比较key和value，全部相同才算相同
            if (Objects.equals(key, e.getKey()) &&
                Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
}
```

红黑树节点

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


        final TreeNode<K,V> root() {
            for (TreeNode<K,V> r = this, p;;) {
                if ((p = r.parent) == null)
                    return r;
                r = p;
            }
        }

		…………
            
}

```



### 【5.4】构造方法



```java
   //构造方法一   初始容量initialCapacity、加载因子loadFactor
   public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            //初始容量不可以为负数
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            //如果初始容量大于最大值，则直接设初始容量为容器最大值
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            //校验加载因子格式和范围
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
       	//依据初始容量计算阈值
        this.threshold = tableSizeFor(initialCapacity);
    }

	//返回大于输入参数且最近的2的整数次幂的数。比如10，则返回16
    static final int tableSizeFor(int cap) {
        //先来假设n的二进制为01xxx...xxx。
        int n = cap - 1;
		//对n右移1位：001xx...xxx，再位或：011xx...xxx
        n |= n >>> 1;
		//对n右移2为：00011...xxx，再位或：01111...xxx
        n |= n >>> 2;
        //对n右移4为：000001111...xxx，再位或：011111111...xxx
        n |= n >>> 4;
        //同理，有8个1，右移8位肯定会让后八位也为1。
        n |= n >>> 8;
		//同理，有16个1，右移16位肯定会让后16位也为1。
        n |= n >>> 16;
        //至此，由于java中int为四字节，也就是32位，可以确保原本最高位右边全为1，也就是此时n+1为其向上取的最接近的2的x次幂。
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
	
	//构造方法二 默认加载因子0.75
    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }
	//构造方法三 默认加载因子0.75
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }
	//构造方法四，通过map构造map
    public HashMap(Map<? extends K, ? extends V> m) {
        //设置加载因子为默认加载因子
        this.loadFactor = DEFAULT_LOAD_FACTOR;
		//将原map中元素导入构造的map中
        putMapEntries(m, false);
    }
	

    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
       //获取原hash表的元素数量
        int s = m.size();
        if (s > 0) {
            //如果数量为空
            if (table == null) { // pre-size
                //如果新表未分配空间，则进行分配空间
                //计算需要分配的空间容量大小
                float ft = ((float)s / loadFactor) + 1.0F;
                //依据边界判断实际分配容量大小
                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                         (int)ft : MAXIMUM_CAPACITY);
                if (t > threshold)
                    //计算扩容阈值
                    threshold = tableSizeFor(t);
            }
            else if (s > threshold)
                resize();//如果节点数量大于当前阈值，则扩容，参见5.5
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
                //copy节点，参见5.6
                putVal(hash(key), key, value, false, evict);
            }
        }
    }

```



### 【5.5】扩容机制

```java
//对容器进行扩容
final Node<K,V>[] resize() {
    //新建旧节点数组引用 -- 【oldTab】
    Node<K,V>[] oldTab = table;
    //获取旧节点数组的容量 -- 【oldCap】
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    //获取当前旧节点扩容时触发的阈值 -- 【oldThr】
    int oldThr = threshold;
    //设置扩容后新节点数组的容量【newCap】、扩容触发阈值【newThr】
    int newCap, newThr = 0;
    if (oldCap > 0) {
        if (oldCap >= MAXIMUM_CAPACITY) {
            //如果旧容量超出最大容量，则触发阈值设置为整数最大值，并直接返回原数组--不进行扩容
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            //【newCap】= 2 * 【oldCap】 
            //设置新节点容量为旧的节点数组的两倍，如果没超出最大容量且旧节点容量大于初始容量则阈值也加倍
            newThr = oldThr << 1; //【newThr】= 2 * 【oldThr】 
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
    Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    if (oldTab != null) {
        for (int j = 0; j < oldCap; ++j) {
            //对老table进行遍历
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                //遍历到的赋给e进行暂存，同时将老table对应项赋值为null
                oldTab[j] = null;
                if (e.next == null)//将不为空的元素复制到新table中
                	//等于是创建一个新的空table然后重新进行元素的put，这里的table长度是原table的两倍
                    newTab[e.hash & (newCap - 1)] = e;
                
                else if (e instanceof TreeNode)
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    Node<K,V> loHead = null, loTail = null;//用于保存put后不移位的链表
                    Node<K,V> hiHead = null, hiTail = null;//用于保存put后移位的链表
                    Node<K,V> next;
                    do {
                        next = e.next;
                        if ((e.hash & oldCap) == 0) {
                           //如果与的结果为0，表示不移位，将桶中的头结点添加到lohead和lotail中，往后如果桶中还有不移位的结点，就向tail继续添加
                            if (loTail == null)
                                //在后面遍历lohead和lotail保存到table中时，lohead用于保存头结点的位置，lotail用于判断是否到了末尾
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
                        //把不移位的结点添加到对应的链表数组中去
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        //把移位的结点添加到对应的链表数组中去
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
 


```



### 【5.6】节点插入

```java
 public V put(K key, V value) {
     return putVal(hash(key), key, value, false, true);
 }

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {

    Node<K,V>[] tab; Node<K,V> p; int n, i;
    // 初始化桶数组 table
    if ((tab = table) == null || (n = tab.length) == 0)
        //扩容方法
        n = (tab = resize()).length;
    // 当前key不存在，新建键值对加入
    if ((p = tab[i = (n - 1) & hash]) == null)

        tab[i] = newNode(hash, key, value, null);

    else {
        Node<K,V> e; K k;
        // 如果键的值以及节点 hash 等于链表中的第一个键值对节点时，则将 e 指向该键值对
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        //如果节点下引用数据结构为红黑树，调用红黑树插入法
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            // 链表结构，遍历
            for (int binCount = 0; ; ++binCount) {
                //不存在当前需要插入的节点  
                if ((e = p.next) == null) {
                    //新建一个节点插入
                    p.next = newNode(hash, key, value, null);
                    //链表长度超过或等于树化阙值（8），对链表进行树化
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                //需要插入的节点已经存在了
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)//1.onlyIfAbsent 判断
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



### 【5.7】节点查找



```java
   //获取元素，通过key
	public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
	//通过key计算hash值
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

   
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; //Entry数组
        Node<K,V> first, e; 
        int n; //数组长度
        K k;
        // 1. 定位键值对所在桶的位置（(n - 1) & hash 等价于对 length 取余）
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            //2.判断键值的hashcode相等，对象相等
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                // 3..如果 first 是 TreeNode 类型，则调用黑红树查找方法
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




  

