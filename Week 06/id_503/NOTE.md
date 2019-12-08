# 字典数（Trie）
* 又称**单词查找树**或**键树**，是一种树形结构
* 典型应用是用于**统计**和**排序大量的字符串**（但不仅限于字符串）
* 经常被搜索引擎系统用于文本**词频统计**
* 优点：最大限度地**减少无谓**的字符串比较，查询效率比哈希表高
* 基本性质
  * 结点本身不存完整单词
  * 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
  * 每个结点的所有子结点路径代表的字符都不相同
* 核心思想
  * 空间换时间
  * 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目
* 代码模板
    ```javascript
    /**
     * Initialize your data structure here.
     */
    class Trie {
        constructor() {
            this.root = new TrieNode();
        }
        /**
        * Inserts a word into the trie.
        * @param {string} word
        * @return {void}
        */
        insert(word) {
            let node = this.root;

            for (let c of word) {
                node = node.links[c] = node.links[c] || new TrieNode();
            }

            node.isEnd = true;
        }
        /**
        * Returns if the word is in the trie.
        * @param {string} word
        * @return {boolean}
        */
        search(word) {
            const node = this.searchNode(word);

            return !!(node && node.isEnd)
        }
        /**
        * Returns if there is any word in the trie that starts with the given prefix.
        * @param {string} prefix
        * @return {boolean}
        */
        startsWith(prefix) {
            return !!this.searchNode(prefix);
        }

        /**
        * Returns a TrieNode object if there is any word search ends in the trie, or returns null.
        * @param {string} word 
        * @returns {TrieNode}
        */
        searchNode(word) {
            if (!word) {
                return null;
            }

            let node = this.root;
            for (const c of word) {
                if (!(node = node.links[c])) {
                    return null;
                }
            }

            return node;
        }
    }

    /**
    * Node of a trie
    */
    class TrieNode {

        constructor() {
            this.links = {};
            this.isEnd = false;
        }
    }
    ```
# 并查集 （Disjoint Set）
* 适用场景：组团、配对问题
* 基本操作：
  * makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合
  * unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并
  * ﬁnd(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了
* 代码模板
  ```javascript
    class DisjointSet {
        count = 0;
        parent = [];

        /**
        * 
        * @param {number} n 
        */
        constructor(n) {
            this.count = n;
            this.parent = [];
            for (let i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        /**
        * 
        * @param {number} p 
        * @returns {number}
        */
        find(p) {
            let parent = this.parent;
            while (p !== parent[p]) {
                p = parent[p] = parent[parent[p]];
            }
            return p;
        }

        /**
        * 
        * @param {number} p 
        * @param {number} q 
        */
        union(p, q) {
            let rootP = find(p);
            let rootQ = find(q);
            if (rootP === rootQ) {
                return;
            }

            this.parent[rootP] = rootQ;
            count--;
        }
    }
  ```
# AVL 树
* 一种平衡二叉搜索数
* 发明者 G. M. **A**delson-**V**elsky 和 Evgenii **L**andis
* Balance Factor（平衡因子）： 是它的左子树的高度减去它的右子树的高度（有时相反）。 balance factor = {-1, 0, 1}
* 通过旋转操作来进行平衡（四种）
  * 左旋：子树形态：右右子树 —> 左旋
  * 右旋：子树形态：左左子树 —> 右旋
  * 左右旋：子树形态：左右子树 —> 左右旋
  * 右左旋：子树形态：右左子树 —> 右左旋
* 不足：结点需要存储额外信息且调整次数频繁

# 红黑树（Red-Black Tree)
* 是一种**近似平衡**的二叉搜索树（Binary Search Tree），它能够确保任何一 个结点的左右子树的**高度差小于两倍**。具体来说，红黑树是满足如下条件的二叉搜索树：
  * 每个结点要么是红色，要么是黑色
  * 根节点是黑色
  * 每个叶节点（NIL节点，空节点）是黑色的
  * 不能有相邻接的两个红色节点
  * 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点
* 关键性质：从根到叶子的最长的可能路径**不多于**最短的可能路径的**两倍**长

# AVL vs 红黑树
* **AVL trees** provide **faster lookups **than Red Black Trees **because** they are more **strictly balanced**.
* **Red Black Trees** provide **faster insertion and removal** operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
* **AVL trees** store **balance factors or heights** with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
* **Red Black Trees** are used in most of the language **libraries** 