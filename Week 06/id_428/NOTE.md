# Week_06_学习总结

## 1、学习过程

​	1）字典树构建 2）后续练习题

## 2、本周学习内容（待细化）

​	1）字典树

	主要是递归的应用，其实这里是可以不使用递归的，但是为了简单起见，使用递归可以使得思路更加清晰。需要注意的一点是，使用连接代表字母，而不是使用结点代表字母；结点只是表示从root到该结点的之间组成的单词是否存在。

​	2）并查集

​	3）高级搜索

​	4）红黑树

​	5）AVL树

## 3、字典树

#### **概述：**

Trie是个简单但实用的数据结构，是一种树形结构，是一种哈希树的变种，相邻节点间的边代表一个字符，这样树的每条分支代表一则子串，而树的叶节点则代表完整的字符串。和普通树不同的地方是，相同的字符串前缀共享同一条分支。

例如：pool,prize,preview,prepare,produce,progress这些关键词的Tire树

![Trie Example](http://linux.thai.net/~thep/datrie/trie1.gif)

 

典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

它的优点是：利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。

 

#### **基本性质：**

- 根节点不包含字符，除根节点外每一个节点都只包含一个字符；
- 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串；
- 每个节点的所有子节点包含的字符都不相同。

 

#### **应用场景：**

字典数查找效率很高，时间复杂度是O(m)，m是要查找的单词中包含的字母的个数，但是会浪费大量存放空指针的存储空间，属于以空间换时间的算法。

##### **1、串快速检索**

给出N个单词组成的熟词表，以及一篇全用小写英文书写的文章，请你按最早出现的顺序写出所有不在熟词表中的生词。

##### **2、单词自动完成**

编辑代码时，输入字符，自动提示可能的关键字、变量或函数等信息。

##### **3、最长公共前缀**

对所有串建立字典树，对于两个串的最长公共前缀的长度即他们所在的结点的公共祖先个数，于是，问题就转化为最近公共祖先问题。

##### **4、串排序方面的应用**

给定N个互不相同的仅由一个单词构成的英文名，让你将他们按字典序从小到大输出用字典树进行排序，采用数组的方式创建字典树，这棵树的每个结点的所有儿子很显然地按照其字母大小排序。对这棵树进行先序遍历即可。

参考：https://www.cnblogs.com/Quincy/p/4898348.html

## 4、并查集

1 并查集介绍
1.给定N个元素； 
2.开始时每个元素位于独立的集合中（即该集合只包含当前元素），当它们之间具有某种关系的时候，按照一定顺序，将位于同一组的所有元素进行合并。 
3.利用并查集可以查找到某个元素位于哪一个组中，或者可以查找一共有多少个组。 
应用场景：当有一组集合，当这些集合具有某些关系时，就需要对这些集合进行合并。 
4.根据并查集：我们可以知道任意两个元素是否具有某种关系（如1和2是朋友，2和3是朋友，则1，2，3位于同一组，就可以知道1和3是否是朋友）。 
例如：当N=10时， 
（1）给定10个元素0，1，2，3，4，5，6，7，8，9； 
（2）开始时每个元素位于独立的集合中，则可以用一个数组，这些元素为数组的下标，因为每个元素位于独立的集合，也就表示刚开始时一共有N=10个集合，每个集合有一个元素，我们可以将数组初始化为-1，表示对应组里面只有一个元素。 

（3）若这些元素具有如下关系，有3个不相交的集合：{0，6，7，8} ，{1，4，9}，{2，3，5} 

（4）将这些集合里面的元素两两进行合并。 
例如0和6位于同一组，我们可以将并查集看成树状结构，让一个数作为孩子，让另一个数作为根，孩子里面存放父亲的下标。例如可以让0为根，6去做孩子，并且将下标为6的值加到下标为0的值上去，并让下标为6的位置存放0，则0里面存放的数据就变为-2（-1+（-1）=-2）； 
并且将两个数进行合并时，先要判断这两个数的根是否相同，如果相同说明已经在同一组里，就可以直接return；如果不相同，则让两个数的根进行合并（让一个数的根作为另一个数的根） 
例如：{0，6，7，8}位于同一个集合（或同一组）中，按照从前到后的顺序，先将0和6进行合并，因为0和6对应的值为-1，说明0和6已经是根，此时将两个根进行合并，让0去做6的根，则将6的值+=到0的值上去则0位置处的值为-2，然后6里存放0（也就是6里存放父亲的下标）。将{0,6,7,8}合并完成后数组里面的内容变为： 

将上面所有集合进行合并后，最终数组如下： 


2 查（查找一个数的根）
1.思路：对于数x，如果下标为x的里面存放的数据为m，若m小于0，说明当前位置x就是根，如果m大于0，再继续判断下标为m的数据是否为根，继续上面这个过程；（v是自定义的一个vector） 
2.代码：

size_t FindRoot(int x)
{
    int index = x;
    while (v[index] >= 0)
    {
        //说明还不是根，则继续查找它的内容存放的是否是根
        index = v[index];
    }
    return index;
}
1
2
3
4
5
6
7
8
9
10
3 并（将两个集合进行合并）
1.思路：首先判断这两个数的根是否相同，若相同说明已经在同一组里，就不用在合并，如果不相同，就将一个数的根加等到另一个数的根上去，并将该数存放根。 
2.代码：

void Union(int x1, int x2)
{
    //先判断两个数的根是否相同
    int root1 =  FindRoot(x1);
    int root2 = FindRoot(x2);
    if (root1 != root2)
    {
        //两个根不相同，让一个根去做另一个根的根
        v[root1] += v[root2];
        v[root2] = root1;
    }
}
1
2
3
4
5
6
7
8
9
10
11
12
4 若想知道合并完成后一共有多少个组
1.思路：遍历一遍数组，负数的个数就是根的个数（有多少个根，就有多少个组）。 
2.代码：

int GetCount()
{
    int num = 0;
    for (size_t i = 0; i < v.size(); ++i)
    {
        if (v[i] < 0)
        {
            ++num;
        }
    }
    return num;
}
1
2
3
4
5
6
7
8
9
10
11
12
5 并查集的使用场景
题目1.假设已知有n个人和m对好友关系（存于数组r），如果两个人是直接或间接的好友（好友的好友），则认为他们属于同一个朋友圈。请写程序求出这n个人里一共有多少个朋友圈。例如：n=5,m=3,r={{1,2},{2,3},{4,5}}，表示有5个人，1和2是好友，2和3是好友，则1，2，3属于同一个朋友圈，4，5属于另一个朋友圈。结果为两个朋友圈。

代码：

int friends(int n, int m, int r[][2])
{
      UnionFindSet ufs(n + 1);  //因为人的下标是从1开始，所以多开一个空间，将0给留着

      for (size_t i = 0; i < m; i++)
      {
           ufs.Union(r[i][0], r[i][1]);  //将第i对好友关系放进并查集里，因为好友关系是以两个两个为一对
      }
    
      return ufs.GetCount() - 1;   //因为第一个空间是多开的，而初始化值为-1
}
1
2
3
4
5
6
7
8
9
10
11
12
6 并查集的整体代码
#include<iostream>
#include<vector>
using namespace std;

class UnionFindSet
{
public:
    UnionFindSet(size_t n)
    {
        v.resize(n, -1);
    }

    void Union(int x1, int x2)
    {
        //先判断两个数的根是否相同
        int root1 = FindRoot(x1);
        int root2 = FindRoot(x2);
        if (root1 != root2)
        {
            //两个根不相同，让一个根去做另一个根的根
            v[root1] += v[root2];
            v[root2] = root1;
        }
    }
    
    //查找一个数的根
    size_t FindRoot(int x)
    {
        int index = x;
        while (v[index] >= 0)
        {
            //说明还不是根，则继续查找它的内容存放的是否是根
            index = v[index];
        }
        return index;
    }
    
    //获得组数，也就是有多少个分组
    int GetCount()
    {
        int num = 0;
        for (size_t i = 0; i < v.size(); ++i)
        {
            if (v[i] < 0)
            {
                ++num;
            }
        }
        return num;
    }

private:
    vector<int> v;
};
————————————————
原文链接：https://blog.csdn.net/xu1105775448/article/details/82077944

## 5、红黑树

红黑树是一棵自平衡的二叉搜索树，因此在学习红黑树之前，我们需要回顾一下之前所学的知识**二叉搜索树和平衡二叉树**。

###### **1.二叉搜索树**

二叉搜索树又叫二叉查找树或者二叉排序树，它首先是一个二叉树，而且必须满足下面的条件：

1）若左子树不空，则左子树上所有结点的值均小于它的根节点的值；

2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值

3）左、右子树也分别为二叉搜索树





![img](https:////upload-images.jianshu.io/upload_images/4314397-9588c432805a9570.png?imageMogr2/auto-orient/strip|imageView2/2/w/300/format/webp)

二叉搜索树示例

###### **2.平衡二叉树**

二叉搜索树解决了许多问题，比如可以快速的查找最大值和最小值，可以快速找到排名第几位的值，快速搜索和排序等等。但普通的二叉搜索树有可能出现极不平衡的情况（斜树），这样我们的时间复杂度就有可能退化成 O(N) 的情况。比如我们现在插入的数据是 [1,2,3,4,5,6,7] 转换为二叉树如下：



![img](https:////upload-images.jianshu.io/upload_images/4314397-2f1facc1bcfc501c.png?imageMogr2/auto-orient/strip|imageView2/2/w/709/format/webp)

斜树

由于普通的二叉搜索树会出现极不平衡的情况，那么我们就必须得想想办法了，这个时候平衡二叉树就能帮到我们了。什么是平衡二叉树？平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树（有别于AVL算法），且具有以下性质：它是一 棵空树或**它的左右两个子树的高度差的绝对值不超过1**，并且左右两个子树都是一棵平衡二叉树。

平衡二叉树有一个很重要的性质：左右两个子树的高度差的绝对值不超过1。那么解决方案就是如果二叉树的左右高度超过 1 ，我们就把当前树调整为一棵平衡二叉树。这就涉及到**左旋**、**右旋**、**先右旋再左旋**、**先左旋再右旋**。

**2.1 右旋：**
 



![img](https:////upload-images.jianshu.io/upload_images/4314397-318ca114772ad3fc.png?imageMogr2/auto-orient/strip|imageView2/2/w/986/format/webp)

右旋.png



```swift
   TreeNode<K, V> *R_Rotation(TreeNode<K, V> *pNode) {
        TreeNode<K, V> *left = pNode->left;
        TreeNode<K, V> *right = left->right;
        left->right = pNode;
        pNode->left = right;
        // 重新调整高度
        pNode->height = max(getHeight(pNode->left), getHeight(pNode->right)) + 1;
        left->height = max(getHeight(left->left), getHeight(left->right)) + 1;
        return left;
    }
```

**2.2 左旋：**
 



![img](https:////upload-images.jianshu.io/upload_images/4314397-f06bb1d69571eaf0.png?imageMogr2/auto-orient/strip|imageView2/2/w/944/format/webp)

左旋



```swift
  TreeNode<K, V> *L_Rotation(TreeNode<K, V> *pNode) {
        TreeNode<K, V> *right = pNode->right;
        TreeNode<K, V> *left = right->left;
        right->left = pNode;
        pNode->right = left;
        // 重新调整高度
        pNode->height = max(getHeight(pNode->left), getHeight(pNode->right)) + 1;
        right->height = max(getHeight(right->left), getHeight(right->right)) + 1;
        return right;
    }
```

**2.3 先右旋再左旋：**
 



![img](https:////upload-images.jianshu.io/upload_images/4314397-d86683fad715ce89.png?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp)

先右旋再左旋



```php
  TreeNode<K, V> *R_L_Rotation(TreeNode<K, V> *pNode) {
    pNode->right = R_Rotation(pNode->right);
    return L_Rotation(pNode);
  }
```

**2.4 先左旋再右旋：**
 



![img](https:////upload-images.jianshu.io/upload_images/4314397-fc689643c778438f.png?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp)

先左旋再右旋



```php
  TreeNode<K, V> *L_R_Rotation(TreeNode<K, V> *pNode) {
    pNode->left = L_Rotation(pNode->left);
    return R_Rotation(pNode);
  }
```

###### **3.红黑树**

红黑树用法就比较广了，比如 JDK 1.8 的 HashMap，TreeMap，C++ 中的 map 和 multimap 等等。红黑树学习起来还是有一点难度的，这时如果我们心中有 B 树就有助于理解它，如果没有 B 树也没有关系。

红黑树的特性:
 （1）每个节点或者是黑色，或者是红色。
 （2）根节点是黑色。
 （3）每个叶子节点（NIL）是黑色。 [注意：这里叶子节点，是指为空(NIL或NULL)的叶子节点！]
 （4）如果一个节点是红色的，则它的子节点必须是黑色的。
 （5）从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。





![img](https:////upload-images.jianshu.io/upload_images/4314397-a0bff7addb21cfe8.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/268/format/webp)

红黑树

假设我们现在要插入一个新的节点，如过插入的这个新的节点为黑色，那么必然会违反性质(5)，所以我们把新插入的点定义为红色的。但是如果插入的新节点为红色，就可能会违反性质(4) ，因此我们需要对其进行调整，使得整棵树依然满足红黑树的性质，也就是双红修正。接下来我们只要分情况分析就可以了：

1. 如果没有出现双红现象，父亲是黑色的不需要修正；
2. 叔叔是红色的 ，将叔叔和父亲染黑，然后爷爷染红；
3. 叔叔是黑色的，父亲是爷爷的左节点，且当前节点是其父节点的右孩子，将“父节点”作为“新的当前节点”，以“新的当前节点”为支点进行左旋。然后将“父节点”设为“黑色”，将“祖父节点”设为“红色”，以“祖父节点”为支点进行右旋；
4. 叔叔是黑色的，父亲是爷爷的左节点，且当前节点是其父节点的左孩子，将“父节点”设为“黑色”，将“祖父节点”设为“红色”，以“祖父节点”为支点进行右旋；
5. 叔叔是黑色的，父亲是爷爷的右节点，且当前节点是其父节点的左孩子，将“父节点”作为“新的当前节点”，以“新的当前节点”为支点进行右旋。然后将“父节点”设为“黑色”，将“祖父节点”设为“红色”，以“祖父节点”为支点进行左旋；
6. 叔叔是黑色的，父亲是爷爷的右节点，且当前节点是其父节点的右孩子，将“父节点”设为“黑色”，将“祖父节点”设为“红色”，以“祖父节点”为支点进行左旋；

上面的双红修正现象看似比较复杂，但实际上只有三种情况，一种是没有双红现象，另一种是父亲和叔叔都是红色的，最后一种是叔叔是黑色的。我们来画个实例看下：





![img](https:////upload-images.jianshu.io/upload_images/4314397-fae62fda145e9e35.png?imageMogr2/auto-orient/strip|imageView2/2/w/957/format/webp)



```php
void solveDoubleRed(TreeNode *pNode) {
        while (pNode->parent && pNode->parent->color == red) {// 情况 1
            TreeNode *uncle = brother(parent(pNode));

            if (getColor(uncle) == red) {// 情况2
                // 设置双亲和叔叔为黑色
                setColor(parent(pNode), black);
                setColor(uncle, black);
                // 指针回溯至爷爷
                pNode = parent(parent(pNode));
            } else {
                // 父亲是爷爷的左儿子
                if (parent(parent(pNode))->left = parent(pNode)) { // 情况 3 和 4
                    // 自己是父亲的右儿子
                    if (parent(pNode)->right == pNode) {
                        pNode = parent(pNode);
                        L_Rotation(pNode);
                    }
                    // 把我自己这边的红色节点挪到隔壁树上，但仍然不能违反性质 4 和 5
                    setColor(parent(pNode), black);
                    setColor(parent(parent(pNode)), red);
                    R_Rotation(parent(parent(pNode)));
                } else { // 情况 5 和 6
                    // 自己是父亲的左儿子
                    if (parent(pNode)->left == pNode) {
                        pNode = parent(pNode);
                        R_Rotation(pNode);
                    }
                    // 把我自己这边的红色节点挪到隔壁树上，但仍然不能违反性质 4 和 5
                    setColor(parent(pNode), black);
                    setColor(parent(parent(pNode)), red);
                    L_Rotation(parent(parent(pNode)));
                }
            }
        }

        // 根结点为黑色
        root->color = black;
    }
```

哎～好复杂这怎么记得住。如果要记住肯定不太可能而且费劲，接下来我们来分析下为什么要这么操作，还有没有更好的调整方法。我们所有的调整都是为了不违反性质4和性质5，假设我在左边的这个支树上新增了一个红色的节点，违反了性质4 。想法就是我把左支树上的一个红色节点，挪动右支树上去，这样就解决了我有两个连续红色节点的问题。但挪给右支树的过程中不能违反性质4和性质5，所以必须得考虑叔叔节点的颜色。



![img](https:////upload-images.jianshu.io/upload_images/4314397-1c1da607c0af9450.png?imageMogr2/auto-orient/strip|imageView2/2/w/1089/format/webp)



最后我们来看下红黑树的删除操作，红黑树的删除操作要比新增操作要复杂些，但总体来说都是出现问题就去解决问题。当我们移除的是一个红色节点，那么根本就不会影响我们的性质4和性质5，我们不需要调整，但倘若我们移除的是一个黑色的节点，这时肯定会违反我们的性质5，所以我们只需要调整移除黑色节点的情况。分情况讨论下：

1. 如果兄弟节点是红色的，把兄弟节点染黑，父节点染红，左/右旋父节点；

2. 如果兄弟节点是黑色的，并且两个侄子节点都是黑色的，将兄弟节点染红，指针回溯至父亲节点；

3. 如果兄弟节点是黑色，的并且远侄子是黑色的，近侄子是红色的，将进侄子染黑，兄弟染红，左/右旋兄弟节点，进入下面情况 4 ；

4. 如果兄弟节点是黑色的，并且远侄子是红色的，近侄子随意，将兄弟节点染成父亲节点的颜色，父亲节点染黑，远侄子染黑，左/右旋父亲节点。

   

   ![img](https:////upload-images.jianshu.io/upload_images/4314397-a46ca001a1a1a959.png?imageMogr2/auto-orient/strip|imageView2/2/w/1151/format/webp)

   

```php
void solveLostBlack(TreeNode *pNode) {
        while (pNode != root && getColor(pNode) == black) {
            if (left(parent(pNode)) == pNode) {
                TreeNode *sib = brother(pNode);
                if (getColor(sib) == red) {
                    setColor(sib, black);
                    setColor(parent(pNode), red);
                    L_Rotation(parent(pNode));
                    sib = brother(pNode);
                }

                if (getColor(left(sib)) == black && getColor(right(sib)) == black) {
                    setColor(sib, red);
                    pNode = parent(pNode);
                } else {
                    if (getColor(right(sib)) == black) {
                        setColor(left(sib), black);
                        setColor(sib, red);
                        R_Rotation(sib);
                        sib = brother(pNode);
                    }

                    setColor(sib, getColor(parent(pNode)));
                    setColor(parent(pNode), black);
                    setColor(right(sib), black);
                    L_Rotation(parent(pNode));
                    pNode = root;
                }
            } else {
                TreeNode *sib = brother(pNode);
                if (getColor(sib) == red) {
                    setColor(sib, black);
                    setColor(parent(pNode), red);
                    R_Rotation(parent(pNode));
                    sib = brother(pNode);
                }

                if (getColor(left(sib)) == black && getColor(right(sib)) == black) {
                    setColor(sib, red);
                    pNode = parent(pNode);
                } else {
                    if (getColor(left(sib)) == black) {
                        setColor(right(sib), black);
                        setColor(sib, red);
                        L_Rotation(sib);
                        sib = brother(pNode);
                    }

                    setColor(sib, getColor(parent(pNode)));
                    setColor(parent(pNode), black);
                    setColor(left(sib), black);
                    R_Rotation(parent(pNode));
                    pNode = root;
                }
            }
        }
        pNode->color = black;
    }
```

## 6、AVL树

平衡二叉搜索树
在二叉搜索树中，已经知道search、insert和remove等主要接口的运行时间均正比于树的高度。但是在最坏的情况下，二叉搜索树可能退化成列表，此时查找的效率会降至O(n)。因此，通常通过控制树高，来控制最坏情况下的时间复杂度。 
对于节点数目固定的BST，越是平衡，最坏情况下的查找速度越快，如下图所示： 


为了理解平衡二叉树，我们首先要理解几个主要概念，理想平衡与适度平衡以及如何进行等价变换让树更为平衡。

理想平衡与适度平衡 
节点数目固定时，兄弟子树高度越接近（平衡），全树的高度也将倾向于更低。包含n个节点的二叉树，高度不可能小于log2(n)（向上取整），当树的高度刚好为log2(n)时，称作理想二叉树。例如完全二叉树和满二叉树。 

但是大多数情况下，树不能满足完全二叉树的条件，因此要放宽平衡的标准。在渐进意义下，放松标准后的平衡性称为适度平衡（渐进的不超过O(logn)）。 我们称可以保持适度平衡的BST称为平衡二叉树（BBST），例如AVL树、红黑树等。

等价变换 
若两颗二叉搜索树的中序遍历序列是相同，则称他们是相互等价的，反之亦然。例如： 

总结出来，等价BST的特性即是： 
上下可变：联系关系不尽相同，承袭关系可能颠倒。左右不乱：中序遍历完全一致。

旋转调整 
实际上任何一组等价BST的相互转换，都可以认为是一系列的基本操作串接而成的。最基本的修复手段就是通过围绕节点的旋转，实现等价前提下的的局部拓扑调整。 
1、zig：顺时针旋转 

2、zag：逆时针旋转 

平衡二叉搜索树的适度平衡性，都是通过对树中每一局部增加某种限制条件来保证的。例如：AVL树中，兄弟节点高度相差不过1。除了适度平衡性，还有以下局部性： 
1、经过单次动态修改操作之后，至多只有O(log(n))处局部不在满足限制条件。 
2、在O(log(n))时间内，使这O(log(n))处局部（以至全树）重新满足限制条件。 
意味着，刚刚失去平衡的二叉搜索树，可以通过（一系列zig或zag，只在局部操作可以在常数时间内完成）变换，转换成一颗等价的平衡二叉搜索树。

AVL——BBST

首先给出所用的一些宏定义

 #define Balanced(x) ( stature( (x).lc ) == stature( (x).rc ) ) //理想平衡条件
 #define BalFac(x) ( stature( (x).lc ) - stature( (x).rc ) ) //平衡因子
 #define AvlBalanced(x) ( ( -2 < BalFac(x) ) && ( BalFac(x) < 2 ) ) //AVL平衡条件
 #define stature(p)((p)?(p)->height:-1)

 /******************************************************************************************
  * 在左、右孩子中取更高者
  * 在AVL平衡调整前，借此确定重构方案
    ******************************************************************************************/
 #define tallerChild(x) ( \
    stature( (x)->lc ) > stature( (x)->rc ) ? (x)->lc : ( /*左高*/ \
    stature( (x)->lc ) < stature( (x)->rc ) ? (x)->rc : ( /*右高*/ \
    IsLChild( * (x) ) ? (x)->lc : (x)->rc /*等高：与父亲x同侧者（zIg-zIg或zAg-zAg）优先*/ \
    ) \
    ) \
 )
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
定义及性质 
AVL树，即平衡因子受限的二叉搜索树_各节点的平衡因子的绝对值均不超过1。 
平衡因子：balFac(v)=height(lc(v))-height(rc(v)); 
接口定义如下（其中BST的定义参考二叉搜索树）：
 #include "BST/BST.h" //基于BST实现AVL树
 template <typename T> class AVL : public BST<T> { //由BST派生AVL树模板类
 public:
    BinNodePosi(T) insert ( const T& e ); //插入（重写）
    bool remove ( const T& e ); //删除（重写）
 // BST::search()等其余接口可直接沿用
 };
1
2
3
4
5
6
7
AVL树的平衡性 
收先要证明高度为h的AVL树至少包含fib(h+3)-1个节点。
证明： 
假设高度为h的AVL树，至少应该包含s(h)个节点。情况如下图所示： 

则，s(h)满足以下递推式： 
s(h)=s(h-1)+1+s(h-2) 
=>s(h)+1=s(h-1)+1+s(h-2)+1 
=>T(h)=T(h-1)+T(h-2)=fib(h+3) 
=>s(h)=fib(h+3)-1 
综上，高度为h的AVL树，至少包含fib(h+3)-1个节点。于是反过来包含n个节点的AVL树高度应为O(log(n))。

AVL树的失衡与重平衡 
AVL树经过插入、删除等动态修改操作，节点的高度可能发生变化，使得其不在满足AVL树的平衡条件。例如： 

AVL插入操作 
1、插入单旋 
v是p的右孩子，且p是g的右孩子，朝向一致。 

上图灰色部分表示插入节点（二选一），插入操作之后，同时可有多个失衡节点，但是最低者g不低于x的祖父。g经过单旋调整之后复衡，子树高度复原，更高的祖先也必然平衡，如下图所示（此处为zag旋转，还有对称情况）： 

2、插入双旋 
v是p的左孩子，p是g的右孩子，朝向不一致。 

与插入情况类似，同时可有多个失衡节点，但是最低者g不低于x的祖父。g经过双旋调整之后复衡，子树高度复原，更高的祖先也必然平衡， 
经过一次zig旋转和zag旋转之后结果如下（同样还有对称情况）： 

接口实现：

 template <typename T> BinNodePosi(T) AVL<T>::insert ( const T& e ) { //将关键码e插入AVL树中
    BinNodePosi(T) & x = search ( e ); if ( x ) return x; //确认目标节点不存在
    BinNodePosi(T) xx = x = new BinNode<T> ( e, _hot ); _size++; //创建新节点x
 // 此时，x的父亲_hot若增高，则其祖父有可能失衡
    for ( BinNodePosi(T) g = _hot; g; g = g->parent ) { //从x之父出发向上，逐层检查各代祖先g
       if ( !AvlBalanced ( *g ) ) { //一旦发现g失衡，则（采用“3 + 4”算法）使之复衡，并将子树
          FromParentTo ( *g ) = rotateAt ( tallerChild ( tallerChild ( g ) ) ); //重新接入原树
          break; //g复衡后，局部子树高度必然复原；其祖先亦必如此，故调整随即结束
       } else //否则（g依然平衡），只需简单地
          updateHeight ( g ); //更新其高度（注意：即便g未失衡，高度亦可能增加）
    } //至多只需一次调整；若果真做过调整，则全树高度必然复原
    return xx; //返回新节点位置
 } //无论e是否存在于原树中，总有AVL::insert(e)->data == e
1
2
3
4
5
6
7
8
9
10
11
12
13
14
效率：首先按照二叉搜索树的常规算法，在O(log(n))时间内插入新的节点x。由于原树是平衡的，最多检查O(log(n))就可以确定失衡节点的位置，为了恢复平衡，最多两次旋转（常数时间）就可以恢复。因此，AVL树的插入操作可以在O(log(n))时间内完成。

AVL树删除操作。 
与插入操作不同，在摘除节点之后，以及在之后的调整过程中，失衡的节点集始终至多含有一个节点。而且若该结点存在，则其高度必然与失衡前相同。如下图所示： 

失衡的节点g与之前的高度相同。 
重平衡操作： 
与插入操作同理，从_hot节点（删除节点的父节点）出发沿parent指针上行，经过O(log(n))时间就可以确定失衡节点g的位置。作为失衡节点g，在不包含被删除节点x的一侧，必然有一个非空孩子p，且p的高度至少为1。于是根据以下规则从p的两个孩子中选出节点v：若连个孩子不等高，v选择其中的更高者；否则选取v与p的同向者（v与p同为左孩子，或者同为右孩子）。 
1、单旋 
经过单旋调整之后，子树高度未必复原，更高祖先仍可能失衡（例如下图，T2下面的节点不存在时的情况）。 
为了让上图所示的二叉搜索树恢复平衡，我们只需要经过一次zig旋转（对称的情况类似），如下图（此时p的两个孩子同高，p选择同向者）结果： 

2、双旋 

3、失衡传播 
与插入操作不同，在删除节点之后，尽管可以通过单旋或者双旋调整使局部子树复衡，但是局部子树的高就全局而言，亦然可能再次失衡，例如下图： 

将这种由于底层失衡节点的重平衡而致使更高祖先失衡的情况，称为失衡传播。失衡传播的方向必然自底而上，在此过程的任一时刻，至多只有一个失衡节点；高层的某一个节点由失衡转为平衡，只能发生下层节点复衡之后。因此，最多需要O(log(n))次调整即可恢复。 
算法实现：


 template <typename T> bool AVL<T>::remove ( const T& e ) { //从AVL树中删除关键码e
    BinNodePosi(T) & x = search ( e ); if ( !x ) return false; //确认目标存在（留意_hot的设置）
    removeAt ( x, _hot ); _size--; //先按BST规则删除之（此后，原节点之父_hot及其祖先均可能失衡）
    for ( BinNodePosi(T) g = _hot; g; g = g->parent ) { //从_hot出发向上，逐层检查各代祖先g
       if ( !AvlBalanced ( *g ) ) //一旦发现g失衡，则（采用“3 + 4”算法）使之复衡，并将该子树联至
          g = FromParentTo ( *g ) = rotateAt ( tallerChild ( tallerChild ( g ) ) ); //原父亲
       updateHeight ( g ); //并更新其高度（注意：即便g未失衡，高度亦可能降低）
    } //可能需做Omega(logn)次调整——无论是否做过调整，全树高度均可能降低
    return true; //删除成功
 } //若目标节点存在且被删除，返回true；否则返回false
1
2
3
4
5
6
7
8
9
10
11
3+4重构算法及其实现 
对于上面所说的重平衡操作，如果采用旋转一步一步的完成将会显得很复杂，其实就如同拼魔方一样，我们可以将魔方打散然后合起来就可以而不是旋转。

假设g为最低的失衡节点，考察祖孙三代g~p~v，按照中序遍历次序，将其重命名为a、b、c。并且他们拥有互不相交的四颗（可能为空的）子树，按中序遍历次序命名为：T0、T1、T2、T3。合起来的中序遍历为{T0,a,T1,b,T2,c,T3}。我们最终得到的结果（正如魔方的六面相同一样）都如下图所示： 


实现如下：

/*******************
*按照“3+4”结构联结三个节点及其四颗子树，返回重组之后的局部子树根节点的位置
*子树根节点与上层节点之间的双向联结，均有上层调用者完成
**********************/
template<typename T>BinNodePosi(T) BST<T>::connect34(
BinNodePosi(T) a,BinNodePosi(T) b,BinNodePosi(T) c,
BinNodePosi(T) T0,BinNodePosi(T) T1,BinNodePosi(T) T2,BinNodePosi(T) T3)
{
    a->lc=T0; if(T0) T0->parent=a;
    a->rc=T1; if(T1) T1->parent=a; updateheight(a);
    c->lc=T2; if(T2) T2->parent=c;
    c->rc=T3; if(T3) T3->parent=c; updateheight(c);
    b->lc=a; a->parent=b;
    b->rc=c; c->parent=b; updateheight(b);
    return b;//子树新的根节点
}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
利用上述connect34()算法，可以按照不同的情况，完成重平衡算法：


 /******************************************************************************************
  * BST节点旋转变换统一算法（3节点 + 4子树），返回调整之后局部子树根节点的位置
  * 注意：尽管子树根会正确指向上层节点（如果存在），但反向的联接须由上层函数完成
    ******************************************************************************************/
 template <typename T> BinNodePosi(T) BST<T>::rotateAt ( BinNodePosi(T) v ) { //v为非空孙辈节点
    BinNodePosi(T) p = v->parent; BinNodePosi(T) g = p->parent; //视v、p和g相对位置分四种情况
    if ( IsLChild ( *p ) ) /* zig */
       if ( IsLChild ( *v ) ) { /* zig-zig */
          p->parent = g->parent; //向上联接
          return connect34 ( v, p, g, v->lc, v->rc, p->rc, g->rc );
       } else { /* zig-zag */
          v->parent = g->parent; //向上联接
          return connect34 ( p, v, g, p->lc, v->lc, v->rc, g->rc );
       }
    else  /* zag */
       if ( IsRChild ( *v ) ) { /* zag-zag */
          p->parent = g->parent; //向上联接
          return connect34 ( g, p, v, g->lc, p->lc, v->lc, v->rc );
       } else { /* zag-zig */
          v->parent = g->parent; //向上联接
          return connect34 ( g, v, p, g->lc, v->lc, v->rc, p->rc );
       }
 }
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
分析：为了调用connect34()，主要是要确定对应的三个节点四个子树，主要根据中序遍历序列确定。例如上面对应的情况（这里只列举zig-zig和zig-zag，其余情况类似）：

 


总结 
优点：无论查找、插入或删除，最坏的情况下的复杂度均为O(log(n))，O(n)的存储空间。 
缺点： 
1、借助高度或平衡因子，为此需要改造元素结构，或额外的封装（可以通过伸展树splay解决） 
2、单词动态调整后，全树的拓扑结构的变化量可能高达log(n)。插入与删除操作的变化量不对等，inert操作只许常数即可满足，remove操作则可能高达log(n)。（红黑树可以使得插入与删除操作的变化量都在常数内，即只需常数的时间就可恢复平衡）。
————————————————
原文链接：https://blog.csdn.net/xc13212777631/article/details/80760427