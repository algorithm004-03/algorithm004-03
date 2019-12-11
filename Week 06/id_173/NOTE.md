## 一、字典集
#### 1. 概述
　　字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
#### 2. 性质
- 结点本身不存完整单词
- 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
- 每个结点的所有子结点路径代表的字符都不相同
#### 3. 核心思想
　　Trie 树的核心思想是用空间换取时间，利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
#### 4. 代码实现
```c++
class Trie {
private:
    Trie* links[26];
    bool end;

public:
    Trie() {
        memset(links, NULL, sizeof(links));
        end = false;
    }
    
    void insert(string word) {
        Trie* node = this;
        for(char ch : word) {
            if(node->links[ch-'a'] == NULL)
                node->links[ch-'a'] = new Trie();
            node = node->links[ch-'a'];
        }
        node->end = true;
    }
    
    bool search(string word) {
        Trie* node = this;
        for(char ch : word) {
            if(node->links[ch-'a'] == NULL)
                return false;
            node = node->links[ch-'a'];
        }
        return node->end;
    }
    
    bool startsWith(string prefix) {
        Trie* node = this;
        for(char ch : prefix) {
            if(node->links[ch-'a'] == NULL)
                return false;
            node = node->links[ch-'a'];
        }
        return true;
    }
};
```

## 二、并查集
#### 1. 基本操作
- makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合
- unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并
- find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了
#### 2. 使用场景
　　组团、配对问题
#### 3. 模板
```C++
class UnionFind {
private:
    vector<int> parent;
    int count = 0;

public:
    UnionFind(int n) {
        count = n;
        parent = vector<int>(n, 0);
        for(int i=0; i<n; ++i)
            parent[i] = i;
    }

    int Find(int p) {
        if(p != parent[p])
            parent[p] = Find(parent[p]);
        return parent[p];
    }

    void Union(int p, int q) {
        int rootP = Find(p);
        int rootQ = Find(q);
        if(rootP != rootQ) {
            parent[rootQ] = rootP;
            count--;
        }     
    }
};
```

## 三、AVL 树
#### 1. 概述
　　AVL 树，即**平衡二叉搜索树**，它的出现是为了解决二叉搜索树退化为单支时而导致搜索时间复杂度变为`O(n)`的问题，而它之所以能够解决是因为它能保证整棵树一直处于平衡的状态。
#### 2. 平衡因子
　　每一个结点的平衡因子等于其左子树的高度减去其右子树的高度（有时相反），取值有 -1，0，1。
#### 3. 保证平衡的方法：旋转
- 左左型 -> 右旋
- 右右型 -> 左旋
- 左右型 -> 先左旋，再右旋
- 右左型 -> 先右旋，再左旋

## 四、红黑树
#### 1. 概述
　　红黑树是一种**近似平衡的二叉搜索树**，它能够确保任何一个结点的左右子树高度差小于两倍。
#### 2. 结构特点
- 每个结点要么是红色，要么是黑色
- 根节点是黑色
- 每个叶节点（NIL节点，空节点）是黑色的
- 不能有相邻接的两个红色节点
- 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点
#### 3. 性质
　　从根到叶子节点最长的可能路径不多于最短的可能路径的两倍长。
