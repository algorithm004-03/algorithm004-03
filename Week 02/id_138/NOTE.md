# NOTE
PART A Week2学习总结
1 相关数据结构：
	map/hashtable(哈希表) : 根据key直接进行访问的数据结构，通过散列函数将关键码和值映射到散列表的一个位置。insert/delete/search：平均时间复杂度O(1)
	set:底层是通过hashmap实现，不允许重复元素。
       树:   树是没有环的图，链表是特殊的树
      二叉树:前序遍历(根-左节点-右节点);中序遍历(左节点-根-右节点);后序遍历(左节点--右节点-根),通过递归或者栈循环遍历。
      二叉搜索树: 有序的二叉树，左子树的所有节点的值均小于根节点的值；右子树所有节点的值均大于根节点的值；其左右子树也都是有序的二叉    树。insert/delete/search：平均时间复杂度O(log(n)),最坏O(n)
    树的相关面试题一般都是通过递归解决，主要原因是节点的定义存在左右子树与问题重复性（自相似性）。
 2 递归
 	递归的模板：
 		1)process terminater:递归的终止条件
 		2)process logic in current level:当前逻辑处理
 		3)drill down:递归调用处理
 		4)reverse current level status :当前层状态回归  
     递归的思想：
        1)不要人肉进行递归，搞懂题意，多动手多画图，一步步分析。
        2)找到规律，即最近最简方法，拆解成可重复解决的问题。(自相似性重复子问题)
        3)数学归纳法思维。多写多锻炼。
  3 分治/回溯
      分治：将问题分解为若干子问题，类似的思想例如java的forkjoin，haddop的mapreduce
      分治模板:
          function divider(params...){
          		
          		#recursion terminator 
	          		if(..){
	          			...
	          		   return 
	          		}
          		
          		#prepare data
          			..to do...
          		
          		#conquer sumproblems 
          			subresult1 = divider(...)
          			subresult2 = divider(...)
          	   
          	   #process and generate final result 
          	   		result = process_result(subresult1,subresult2,...) 
          		
          		# revert the current level states
          			..to do
          }
            
            回溯 
            回溯的思想是通过不断的试错，尝试分步骤的解决问题。在此过程中一般会涉及到递归与剪枝  ，“回溯搜索”算法即“深度优先遍历 + 状态重置 + 剪枝”。通过画图，把回溯问题转换为树形结构。
            参考链接:https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/，多阅读几次有助于自己理解该类问题。      


PART B 我所理解的hashmap
1.hashmap定义及说明：public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable
由类定义可知，hashmap和AbstracMap都是map接口的实现，而同时hashmap又继承了抽象类AbstractMap。这个模式在jdk或者spring的世界中处处可见，抽象类与子类实现同样的接口。
hashmap是键值映射的一种实现，允许null键或者null值，但是非线程安全的。在多线程环境下调用put方法的扩张过程可能会形成环形链表的问题。初始值默认为16.每次扩展都是最接近当前size的下一个2的n次方值。
当然hashmap内部是通过一系列的位运算操作得到每次扩展的值的。如果要求在线程安全的环境下使用hashmap，推荐使用ConcurrentHashmap或者Collections.synchorizedMap(new HashMap())。此外，任何作为Hashmap键的对象，必须重写
equals()与hashcode（）方法；像我们平常使用的Integer/String都已经重写了该方法，因为key键是唯一的。
2.HashMap方法说明:
 1)构造函数
	HashMap()
	使用默认的初始容量（16）和默认的加载因子（0.75）构造一个空的HashMap。
	HashMap(int initialCapacity)
	构造一个具有指定初始容量和默认负载因子（0.75）的空HashMap。
	HashMap(int initialCapacity, float loadFactor)
	构造一个具有指定初始容量和负载因子的空HashMap。
	HashMap(Map<? extends K,? extends V> m)
	构造一个具有与指定Map相同的映射关系的新HashMap
 2)方法总结
	void clear()
	删除所有映射
	boolean	containsKey(Object key)
	如果此映射包含指定键的映射，则返回true。
	boolean	containsValue(Object value)
	如果此映射将一个或多个键映射到指定值，则返回true。
	Set<Map.Entry<K,V>>	entrySet()
	返回Set此映射中包含的映射的视图。
	V	get(Object key)
	返回指定键所映射的值，或者null此映射不包含该键的映射
	boolean	isEmpty()
	如果此映射不包含键值映射，则返回true。
	Set<K>	keySet()
	返回Set此映射中包含的键的视图。
	V	merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
	如果指定的键尚未与值关联或与null关联，请将其与给定的非null值关联。
	V	put(K key, V value)
	将指定值与该映射中的指定键相关联。
	void	putAll(Map<? extends K,? extends V> m)
	将所有映射从指定映射复制到此映射。
	V	putIfAbsent(K key, V value)
	如果指定键尚未与值关联（或映射到null），则将其与给定值关联并返回 null，否则返回当前值。
	V	remove(Object key)
	如果存在，则从此映射中删除指定键的映射。
	boolean	remove(Object key, Object value)
	仅当当前映射到指定值时，才删除指定键的条目。
	
 3）使用说明
	a)HashMap的遍历方式
	    Map<Integer,String> map = new HashMap();
		//遍历方式1
		Set<Entry<Integer,String>> set = map.entrySet();
		for(Entry<Integer,String> entry: set) {
			System.out.println(entry.getKey()+entry.getValue());
		}
		
		//遍历方式2
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			System.out.println(key+" "+map.get(key));
		}
		//遍历方式3
		Collection<String> values = map.values();
		for(String value: values) {
			System.out.println(value);
		}
		//遍历方式4 jdk1.8+
		map.forEach((key,value)->{
			System.out.println(key+value);
		});
4) put/get方法原理分析
	首先需要说明的是，HashMap底层是一个Entry<K,V>类型的数组，Entry可以是链表结构也可以是红黑树结构，取决于链表的长度。
    V put(K key,V value)该方法会返回key对应的原值，如果原值存在的话。
	put方法调用的是putVal，该方法是final方法，不可被重写。key的hash是通过key.hashCode^(hashCode>>>16)得到的,因为数组长度有限，
	为了让key的hashcode高位也参加运算所以先右移16bit，再与原hash值异或，这样能更好的发散hash映射。
	通过key定位到桶的位置（数组的下标）:index = (n-1)&hash;
	static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	得到index后，如果没有碰撞，就直接放入桶对应的位置；if ((p = tab[i = (n - 1) & hash]) == null)
															tab[i] = newNode(hash, key, value, null);
	如果有碰撞，（jdk8）就遍历链表插入=到链表尾部。在此过程中，会记录步长，如果步长=8就会转换为红黑树。
		if (p instanceof TreeNode)//如果已经是红黑树节点
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
		else {//记录步长
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
            }	
	如果size超过factor * capacity,就会resize()
		if (++size > threshold)
            resize();	
	resize()是map的size触发阀值时自动扩容到原容量的2倍。newCap = oldCap<<1;因为扩容是扩充的 2 倍，n-1 转换为二进制也就是高位变成了1，那么根据(n - 1) & hash 计算，如果 hash 高位是 1 那么新的 index 位置就是 oldIndex + 16，
	如果hash 的高位 是 0 ，那么 index 的位置就是原来的 oldIndex 的位置，这样直接判断高位就可以了，省去了重新计算hash。
	
	get方法原理分析
	public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
	getNode方法：
	根据key的hash值和key与桶对应位置的节点进行遍历匹配，key值相等hash值也相等的节点就是要找的节点。
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
  

