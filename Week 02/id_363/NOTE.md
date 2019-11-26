# NOTE
### 学习总结
- 1.重要思想: 升维,空间换时间  
- 2.树的面试题的解法一般使用递归
- 3.递归和循环的效率其实差不多,使用递归的时候注意剪枝和重复计算
- 4.递归代码模板(重要)  递归终止条件 处理当前层逻辑 下探到下一层 清理当前层
- 5.递归三个思维要点: 1.不要人肉递归 2.找最近重复子问题 3.数学归纳法:假设n时成立，推到n+1时成立
- 6.分治和回溯的本质都是递归, 递归，分治，回溯都可以套用递归的模板，分治的模板需要在第三步和第四部之间加上"合并子结果"

### java 1.8 hashMap 分析
介绍： hashMap 实现了Map接口，允许null value 和null key，基本等同于hashTable,但是HashMap不是线程安全的。  
hashMap中get和put操作的时间复杂度是O(1).  

put方法：
```
public V put(K key, V value) {
     return putVal(hash(key), key, value, false, true);
}

// hash值的计算是： key的hash值的高低16位做异或操作
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
    // tab用来存储key-value,p是当前key应该在tab中存储的下标对应的node
    // n是tab数组的长度               
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    // tab 初始化
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    // 下标计算：(n - 1) & hash: hash值和数组的长度减去一做与操作
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        // e是p中存在和key一致的node ,k是p的key值
        Node<K,V> e; K k;
        // 判断p节点的key值是否和要存入的key值一致
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else if (p instanceof TreeNode)
            // 如果p是树形结构，那么把当前节点插入到树中
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            // 在链表中找到key值和要存入的key一致的node，如果不存在，那么新建一个node，加入到链表的末尾
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    // 如果链表长度等于TREEIFY_THRESHOLD=8, 将链表转换成树
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
        // 如果存在和key相同的node,将新的value值替换旧的value
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    // 如果当前tab中的数量大于threshold, 进行扩容处理
    // threshold = capacity * load factor
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}

// 链表转变成树结构
// 扩容

```