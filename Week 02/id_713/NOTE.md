# NOTE

### 哈希表(HashMap)  

#### 源码分析

* 参考: <https://www.cnblogs.com/tstd/p/5055286.html>

```java
/**
 * @param key 键
 * @param value 值
 * @return V 值(如果覆盖的话, 返回那个被覆盖的值)
 */
public V put(K key, V value) {
  // 对于key值为null, 调用putForNullKey方法处理
  if (key == null)
    return putForNullKey(value);
  // 使用key的hashCode计算key对应的hash值
  int hash = hash(key.hashCode());
  // 通过key的hash值查找在数组中的index位置
  int i = indexFor(hash, table.length );
  // 取出数组index位置的链表，遍历链表找查看是有已经存在相同的key
  for (Entry<K,V> e = table [i]; e != null; e = e. next) {
    Object k;
    // 通过对比hash值、key判断是否已经存在相同的key
    if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
      // 如果存在，取出当前key对应的value，供返回
      V oldValue = e. value;
      // 用新value替换之旧的value
      e. value = value;
      e.recordAccess( this);
      // 返回旧value，退出方法
      return oldValue;
    }
  }

  // 如果不存在相同的key
  // 修改版本+1
  modCount++;
  // 在数组i位置处添加一个新的链表节点
  addEntry(hash, key, value, i);
  // 没有相同key的情况，返回null
  return null;
}

/**
 * 增加一个k-v，hash组成的节点在数组内，同时可能会进行数组扩容。
 */
void addEntry( int hash, K key, V value, int bucketIndex) {
  // 下面两行行代码的逻辑是，创建一个新节点放到单向链表的头部，旧节点向后移
  // 取出索引bucketIndex位置处的链表节点，如果节点不存在那就是null，也就是说当数组该位置处还不曾存放过节点的时候，这个地方就是null，
  Entry<K,V> e = table[bucketIndex];
  // 创建一个节点，并放置在数组的bucketIndex索引位置处，并让新的节点的next指向原来的节点
  table[bucketIndex] = new Entry<K,V>(hash, key, value, e);
  // 如果当前HashMap中的元素已经到达了临界值，则将容量扩大2倍，并将size计数+1
  if (size ++ >= threshold)
    resize(2 * table.length );
}

private V putForNullKey(V value) {
  // 取出数组第1个位置（下标等于0）的节点，如果存在则覆盖不存在则新增，和上面的put一样不多讲，
  for (Entry<K,V> e = table [0]; e != null; e = e. next) {
    if (e.key == null) {
      V oldValue = e. value;
      e. value = value;
      e.recordAccess( this);
      return oldValue;
    }
  }
  modCount++;
  // 如果key等于null，则hash值等于0
  addEntry(0, null, value, 0);
  return null;
}


/**
	* 根据key删除元素
  */
public V remove(Object key) {
  Entry<K,V> e = removeEntryForKey(key);
  return (e == null ? null : e. value);
}

/**
	* 根据key删除链表节点
	*/
final Entry<K,V> removeEntryForKey(Object key) {
  // 计算key的hash值
  int hash = (key == null) ? 0 : hash(key.hashCode());
  // 根据hash值计算key在数组的索引位置
  int i = indexFor(hash, table.length );
  // 找到该索引出的第一个节点
  Entry<K,V> prev = table[i];
  Entry<K,V> e = prev;

  // 遍历链表（从链表第一个节点开始next），找出相同的key，
  while (e != null) {
    Entry<K,V> next = e. next;
    Object k;
    // 如果hash值和key都相等，则认为相等
    if (e.hash == hash &&
        ((k = e. key) == key || (key != null && key.equals(k)))) {
      // 修改版本+1
      modCount++;
      // 计数器减1
      size--;
      // 如果第一个就是要删除的节点（第一个节点没有上一个节点，所以要分开判断）
      if (prev == e)
        // 则将下一个节点放到table[i]位置（要删除的节点被覆盖）
        table[i] = next;
      else
        // 否则将上一个节点的next指向当要删除节点下一个（要删除节点被忽略，没有指向了）
        prev. next = next;
      e.recordRemoval( this);
      // 返回删除的节点内容
      return e;
    }
    // 保存当前节点为下次循环的上一个节点
    prev = e;
    // 下次循环
    e = next;
  }

  return e;
}
```



---



### 二叉树 前/中/后序遍历

| 遍历方式           | 顺序   | 应用场景                               |
| ------------------ | ------ | -------------------------------------- |
| 前序遍历(先序遍历) | 根左右 | 打印层及目录                           |
| 中序遍历           | 左根右 | 排序                                   |
| 后续遍历           | 左右根 | 统计文件夹大小, 中缀表达式->后缀表达式 |

#### 遍历算法

```java
public void preOrder(TreeNode root) { // 先序遍历, 中左右
  if (root == null) return; // 定义递归的终止条件

	System.out.println(root.val);
  preOrder(root.left);
	preOrder(root.right);
}

public void inOrder(TreeNode root) { // 中序遍历, 左中右, 其实只是调整关键3行的代码顺序即可
  if (root == null) return;

  inOrder(root.left);
  System.out.println(root.val);
	inOrder(root.right);
}


public void postOrder(TreeNode root) { // 后序遍历, 左右中, 其实只是调整关键3行的代码顺序即可
  if (root == null) return;

  postOrder(root.left);
	postOrder(root.right);
  System.out.println(root.val);
}

// 变种: 记录数据, 套路不变, 多传入一个参数List即可
public void inOrderHelper(List<Integer> list, TreeNode root) {
  if (root == null) return;

  inOrder(root.left);
  // System.out.println(root.val); 将打印改成记录即可
  list.add(root.val);
	inOrder(root.right);
}

```



### 递归

* 拆解成子问题, 最近最简方法, 也就是重复子问题
  * 如中序遍历二叉树, 只要针对第一个子树中序遍历, 递归会完成子树的子树的处理



### 算法模板

#### 递归算法模板

```java
public void helper(int level, Object... params) {
  // 递归终止条件
  if (level > MAX_LEVEL) {
    // 逻辑处理
    return;
  }

	// 在本层的逻辑处理
  process(level, params);

  // 下探(递归)
  this.helper(level + 1, params);
  
  // 存储更新当前状态, 如果需要的话
}
```



#### 统计词频

```java
public void cntChar(String str) {
	// 构建数组, 用于计数
  int[] arr = int[26];
 
  for (int i = 0; i < str.length(); i++) {
    // 因为 'a' 等于97, 所以可以把char量化成数字
    arr[str.charAt(i) - 'a']++;
  }
  // 最终数组arr就是, 字母的频次
}
```



