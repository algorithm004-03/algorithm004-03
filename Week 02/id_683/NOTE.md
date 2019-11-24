# 第二周学习总结

## 递归

解决递归问题的思维

- 不要进行人肉递归
- 找到其重复性
- 数学归纳法

递归题目代码模板

1. 处理递归退出条件
2. 处理当前层逻辑
3. 进入下一层递归
4. 重置递归状态


    public void recur(int level, int param) { 

    // terminator 
    if (level > MAX_LEVEL) { 
        // process result 
        return; 
    } 

    // process current logic 
    process(level, param); 

    // drill down 
    recur( level: level + 1, newParam); 

    // restore current status 
    
    }

## 分治

分治问题可以说使一种特殊的递归，其核心一样在于找到问题的重复性，递归进行解决，所以分治的代码模板和递归的代码模板很相似

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

1. 处理递归结束条件
2. 准备数据，将大问题拆分为几个子问题
3. 递归处理几个子问题
4. 合并子问题返回数据
5. 重置状态


## HashMap分析

HashMap存储结构是基于数组+链表+红黑树，从源码看，它有一个一个非常重要的字段`Node<K,V>[] table;`，哈希桶数组。

    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash; // 表示Node在Hash桶中的索引位置
        final K key;
        V value;
        Node<K,V> next; // 链表的下一个Node

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
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
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

Node是HashMap的内部类，实现了Map.Entry接口，本质是一个映射(键值对)。

HashMap中的一些重要字段：

    // 容器内存储的键值对数量
    transient int size;
    transient int modCount;
    // 容纳键值对数量的阈值，当超过这个数量时会进行扩容，阈值等于哈希桶的容量×负载因子
    int threshold;
    // 负载因子
    final float loadFactor;

而且HashMap中哈希桶数组的默认大小使16，并且保证每次扩容后都是合数，而不是常规的使用素数，这是为了方便通过位运算做取模操作提高性能。

### get操作

1. 计算哈希值，找到哈希桶数组中对应位置
2. 先检查该位置上的链表或树的第一个元素的key是否相等
3. 如果key不相等则循环在该位置上的链表或红黑树中查找相等的key
4. 如果找到相等的key返回，如果未找到则返回null

### put操作

1. 第一步判断哈希桶数组是否已经初始化，如果没有则通过resize函数分配
2. 找到哈希桶数组中与Node元素key的hash值对应的位置，如果该位置为null则将元素放置在该位置
3. 如果找到哈希桶数组中对应位置不为null，则判断该位置的首个元素是否与key相等，如果相等则覆盖该元素
4. 如果发现首个元素类型为TreeNode(判断是否是红黑树),如果是，则通过树的插入方式插入该元素
5. 遍历该位置的链表，插入至链表中如果key存在则直接覆盖，如果链表长度超过8则将链表转化为红黑树
6. 插入成功后，如果size大于threshold则进行扩容