# 第六周总结

## 字典树

字典树，即Trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串，所以经常被搜索引擎系统用于文本词频统计。

它的优点：最大限度的减少无谓的字符串比较，查询效率比哈希表高。

### 基本性质

1. 节点本身不存完整单词。
2. 从根节点到某一节点，路径上经过的字符串连接起来，为该节点对应的字符串。
3. 每个节点的所有子节点路径代表的字符都不相同。

### 核心思想

Trie树的核心思想是空间换时间

利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

## 并查集

使用场景

- 组团、配对问题
- Group or Not
  
## 双向BFS模板

    public T doubleSideBFS(args) {

        Set<> beginSet, endSet;
        Set<> visited;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            
            // 扩散步数小的边
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set nextSpreadSet;
            while () {

                // process 
                // ...
                visited.add(node);
                nodes = generateRelatedNodes();
                nextSpreadSet.add(nodes);

            }
            beginSet = nextSpreadSet;
        }

    }

## 红黑树

红黑树是一种近似平衡二叉树，它能确保任何一个节点的左右子树的高度差小于2倍。具体来说，红黑树是满足如下条件的二叉树：

- 每个节点要么是红色，要么使黑色
- 根节点是黑色
- 每个叶节点（NIL节点、空节点）是黑色的。
- 不能有相邻的两个红色节点。
- 从任一节点到其每个叶子节点的所有路径都包含相同数目的黑色节点