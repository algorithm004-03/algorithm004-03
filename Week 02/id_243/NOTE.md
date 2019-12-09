# 学习总结
## 散列表
1. 散列表的定义
* 散列表，又称哈希表。
* 散列表用的是**数组**支持按照下标随机访问数据的特性，所以散列表其实就是数组的一种扩展，由数组演化而来。可以说，**如果没有数组，就没有散列表**。
2. 散列函数的设计原则
* 散列函数计算得到的散列值是一个非负整数；
* 如果 key1 = key2，那 hash(key1) == hash(key2)；
* 如果 key1 ≠ key2，那 hash(key1) ≠ hash(key2)。
> 设计再好的散列函数也没有办法完全避免散列冲突（hash寻址重复）
3. 散列冲突的解决
* 开放寻址法 - 小规模数据、装载因子不高的散列表
* 链表法/拉链法 - 普遍适用
> Java中的HashMap的实现就是利用链法表，而LinkedHashMap利用的是双向链表+散列表。
### HashMap小结
[HashMap脑图](https://github.com/eazonshaw/algorithm004-03/tree/master/Week%2002/id_243/HashMap的实现原理.png)

## 树
1. 树
> 非线性结构
* 高度：节点到叶子节点的最大路径
* 深度：根节点到某个节点所经历的路径数
* 层数：节点的深度+1
* 树的高度：根节点的高度
2. 二叉树
> 每个节点最多有两个节点（左节点、右节点）的树
* 完全二叉树，最后一层的叶子节点靠左排列，其它层完整
* 满二叉树，每个节点都有左右两个叶子节点
3. 二叉树的遍历
* 前序遍历（根左右）
* 中序遍历（左根右）
* 后续遍历（左右根）
> 以上遍历的时间复杂度均为O(n)，n为节点的个数
4. 二叉搜索树
* 中序遍历二叉查找树，可以输出有序的数据序列，所以二叉搜索树又称二叉排序树
> 参考java中优先队列的实现
* 最坏情况下，退化成链表，时间复杂度为O(N)
* 最好情况下，满二叉树，时间复杂度为O(logN)
### 重点掌握
三种遍历方式的实现，二叉搜索树的查找、插入、**删除**

# 递归
### 四部曲
- 终止条件
- 处理当前层逻辑
- 进入到下一层
- 清理当前层的环境
### python模板
```python
def recursion(level, param1, param2, ...): 
    # recursion terminator 
    if level > MAX_LEVEL: 
	   process_result 
	   return 

    # process logic in current level 
    process(level, data...) 

    # drill down 
    self.recursion(level + 1, p1, ...) 

    # reverse the current level status if needed
```
### java模板
```java
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
```
### 重点，拒绝人肉递归，多练多记










  

