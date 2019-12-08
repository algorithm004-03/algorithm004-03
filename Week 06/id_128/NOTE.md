# NOTE

  

avl vs red black tree

- avl stores balance factor on each node {-1, 0 , 1} 
- avl is more strictly balanced than red balck tree that a rebalance is trigger when the difference of height 
between two sub-trees of any node is 2 or -2, whereas red black tree performs rebalance when one of the sub-tree's height
is two times of the other one's.

1. avl provides faster lookup because they are more strictly balanced.
2. red black tree provides faster insertion and removal as fewer rotaions are done due to relatively relaxed balancing.
3. avl trees store balance factors or heights with each node, thus requires storage for an integer per node whereas red black tree requires only 1 bit of information per node.
4. red black trees are used in most of the language libraries like map, multimap, multiset in c++ where as avl trees are used in databases where faster retrivals are required.

public void BidirectionalBFS(graph, start,  end) {
        startQueue;
        endQueue;
        visited;
        startQueue.Enqueue(start);
        endQueue.Enqueue(end);
        
        while (!startQueue.IsEmpty() && !endQueue.IsEmpty()) {
        	// process the shorter queue
            if (endQueue.Count < startQueue.Count) {
                tempQueue = startQueue;
                startQueue = endQueue;
                endQueue = tempQueue;
            }
            temp;
            foreach (node in startQueue) {
            	visited.Add(node);
            	Process(node);
            	temp = GetAdjacentNodes(node);	
            }
            startQueue = temp;
            //process other stuff
        }
    }


字典树
典型应用是用于统计和排序大量的字符串（但不仅限于字符串），可最大限度地减少无谓的字符串比较，查询效率比哈希表高

基本性质：

节点本身不存完整的单词
从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
每个节点的所有子节点路径代表的字符都不相同

并查集
适用场景：组团、配对问题

基本操作：

makeSet(s)
unionSet(x, y)
find(x)




AVL树（即平衡二叉搜索树）的左子树的高度减去右子树的高度（即平衡因子）值的范围为{0, 1, -1}

通过四种旋转操作，可以让树保持平衡：

左旋
右旋
左右旋
右左旋
AVL的不足：

每个节点需要存储额外的信息(平衡因子)
调整次数比较频繁


红黑树是一种近似平衡的二叉搜索树，它能确保任何一个节点的左右子树的高度差小于两倍。

红黑树的特点是：

每个节点要么是红色，要么是黑色
根节点是黑色
每个叶子节点是黑色的
不能有相邻接的两个红色节点
在任一节点到其每个叶子的所有路径都包含相同数目的黑色节点