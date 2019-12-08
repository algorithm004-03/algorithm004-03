# NOTE

# Trie树
1、节点本身不存完整单词
2、从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
3、每个节点的所有子节点路径代表的字符都不相同

## Trie树的基本性质
1、节点本身不存完整单词
2、从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
3、每个节点的所有子节点路径代表的字符都不相同

# 并查集
## 并查集解决的问题
1、组团、配对的问题：在现实中，你需要很快的判断两个个体是不是在一个集合当中

## 并查集基本操作
1、makeSet(s)：建立一个新的并查集，其中包含s个单元素集合
2、unionSet(x,y)：把元素x和元素y所在的集合合并，要求x和y所在的集合互不相交，如果相交则不合并
3、find(x)：找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了

# AVL和红黑树
## 二叉搜索树保证性能的关键
1、保证二维维度 --> 左右子树结点平衡(recursively)
2、Banlanced

## AVL树
AVL树
1、发明者G.M.Adelson-Velsky和Evgenii Landis
2、Balanced Factor(平衡因子)
是它的左子树的高度减去它的右子树的高度（有时相反）
balance factor = {-1, 0, 1}
3、通过旋转操作来进行平衡（四种）
4、https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree

### AVL的四种旋转操作
1、左旋
2、右旋
3、左右旋
4、右左旋

### AVL的旋转
AVL的旋转
1、右右子树 --> 左旋
2、左左子树 --> 右旋
3、先左子树，后右子树 --> 左右旋
4、先右子树，后左子树 --> 右左旋

参考动画
https://zhuanlan.zhihu.com/p/63272157https://zhuanlan.zhihu.com/p/63272157

旋转的图示
https://en.wikipedia.org/wiki/Tree_rotation#/media/File:Tree_Rebalancing.gif

### AVL总结
AVL总结
1、平衡二叉搜索树
2、每个结点存balance factor = {-1, 0, 1}
3、四种旋转操作

不足：结点需要存储额外信息，且调整次数频繁
因此需要引入其他的"近似平衡二叉树"，不需要每次都非常严格的保持-1, 0, 1的平衡因子，从而提高整个树维护的效率


## 红黑树
Red-black Tree
红黑树是一种近似平衡的二叉搜索树，它能够确保任何一个结点的左右子树的高度差小于两倍。满足如下条件：
1）每个结点要么是红色，要么是黑色
2）根节点是黑色
3）每个叶结点 （NIL结点，空结点）是黑色，都是空结点
4）不能有相邻的两个红色结点
5）从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点

## AVL和红黑树对比
AVL和红黑树对比
1、AVL Trees provide faster lookup than Red-Black Trees because they are more strictly balanced.
2、Red-Black Trees provide faster insertion and removal operations than AVL Trees as fewer rotations are done due to relatively relaxed balancing.
3、AVL Trees store balance factors or heights with each node, thus requires storage for an integer per node whereas Red-Black Tree requires only 1bit (red or black) of information per node.
4、Red-Black Trees are used in most of the language libraries like map, multimap, multiset in C++ whereas AVL Trees are used in databases where faster retrievals are required.


