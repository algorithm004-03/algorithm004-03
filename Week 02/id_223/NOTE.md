# 学习总结
## Week 2
### 哈希表、映射、集合
#### Part1:
> 哈希表(Hash table)，也叫散列表，是根据关键码值(Key value)而直接进行访问的数据结构。 它通过把关键码值映射到表中一个位置来访问记录，以加快查找的 速度。
> 这个映射函数叫作散列函数(Hash Function)，存放记录的数组 叫作哈希表(或散列表)。

##### 哈希表
- 哈希表以时间换空间，记录每个key的位置
- 访问、查询和增删的时间复杂度为O(1)
- 当发生哈希冲突时（hash值相同），退化为链表记录这些冲突值（拉链式）

##### 映射、集合
- Map
    - 键值对数据
    - Key不能重复，Value可以
    - 支持 null键和 null值
    - new HashMap() / new TreeMap() 
    - map.set(key, value)
    - map.get(key)
    - map.has(key)
    - map.size()
    - map.clear()
- Set 
    - 数据是无序的(hashcode决定位置)
    - 数据不能重复
    - new HashSet() / new TreeSet() 
    - set.add(value)
    - set.delete(value)
    - set.hash(value)

#### Part2:
1. 利用Hash表解题：WordCount,字母异位词，2sum等


### 树、二叉树、二叉搜索树
#### Part1:
- 链表就是特殊化的树
- 树就是特殊化的图

###### 树结点(TreeNode)模板代码
```
Java
public class TreeNode {
  public int val;
  public TreeNode left, right;
  public TreeNode(int val) {
this.val = val; this.left = null; this.right = null;
} }

Python
class TreeNode:
def __init__(self, val):
self.val = val
self.left, self.right = None, None
```
###### 二叉树遍历
> 前中后是根据根的位置，然后左右
1. 前序(Pre-order):根-左-右 
1. 中序(In-order):左-根-右 
1. 后序(Post-order):左-右-根

##### 二叉搜索树-BST
1. 左子树上所有结点的值均小于它的根结点的值;
2. 右子树上所有结点的值均大于它的根结点的值;
3. 以此类推:左、右子树也分别为二叉搜索树。 (这就是重复性!)
4. 中序遍历后->升序排列

```
def preorder(self, root):
    if root: 
        self.traverse_path.append(root.val) 
        self.preorder(root.left) 
        self.preorder(root.right)
def inorder(self, root):
    if root:
        self.inorder(root.left) 
        self.traverse_path.append(root.val) 
        self.inorder(root.right)
def postorder(self, root):
    if root:
        self.postorder(root.left) 
        self.postorder(root.right) 
        self.traverse_path.append(root.val)
```



### 泛型递归、树的递归
#### Part1
- 递归 Recursion
    1. 从前有个山
    2. 山里有个庙
    3. 庙里有个和尚讲故事 
    4. 返回1
- 盗梦空间
    1. 向下进入到不同梦境中;向上又回到原来一层
    1. 通过声音同步回到上一层
    1. 每一层的环境和周围的人都是一份拷贝、
    1. 主角等几个人穿越不同层级的梦境(发生和携带变化)
- 递归模板
1. terminator - 递归终结条件
1. process logic in current level - 处理这一层逻辑
1. drill down - 处理下一层（找出重复子问题）
1. restore current stauts - 清理当前层留下的状态

```
Python 代码模版
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

```
Java 代码模版
public void recur(int level, int param) {
 // terminator
if (level > MAX_LEVEL) {
   // process result
    return; }
 // process current logic
 process(level, param);
 // drill down
 recur( level: level + 1, newParam);
 // restore current status
}
```
-  思维要点
    1. 不要人肉进行递归(最大误区)
    2. 找到最近最简方法，将其拆解成可重复解决的问题(重复子问题) 
    3. 数学归纳法思维

### 分治、回溯
#### 分治 Divide & Conquer

- 分治也是一种递归,不过在它递归的过程中,把一个问题划分为好几个子问题
- 代码模板
    - terminator
    - process(split your big problem)
    - drill down(subproblmes)
    - reverse states

#### 回溯 Backtracking

- 回溯法采用试错的思想,它尝试分步的去解决一个问题.在分步解决问题的过程中,当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候,它将取消上一步甚至上几步的计算,再通过其他的可能的分步解答再次尝试寻找问题的答案.
- 回溯法通常用最简单的递归方法来实现,在反复重复上述步骤后可能出现2种情况
    - 找到一种可能存在的正确答案
    - 在尝试了所有可能的分步方法后宣告该方法没有解
- 在最坏的情况下,回溯法会导致一次复杂度为指数时间的计算
  

