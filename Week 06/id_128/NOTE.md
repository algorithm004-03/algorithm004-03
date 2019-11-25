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

