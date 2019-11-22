# NOTE

  

# 字典树(Trie)

## 性质

* 节点本身不存完整单词
* 从根节点到某一节点, 路径上经过的字符连接起来, 为该节点对应的字符串
* 每个节点的所有子节点路径代表的字符都不相同



### 核心思想

* 空间换时间
* 利用字符串公共前缀来降低查询时间的开销, 以达到提高效率的目的



## 代码实现

### Java版本

```java
class TrieNode {
  private TrieNode[] links;
  
  private final int R = 26;

  private boolean isEnd;

  public TrieNode() {
    links = new TrieNode[R];
  }

  public boolean containsKey(char ch) {
    // int asc2 = link[ch];
    // asc2 = asc2 - 'a';
    // return link[asc2] != null;
    // 简化上述过程
    return link[ch - 'a'] != null;
  }

  public TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  public void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }

  public void setEnd() {
		this.isEnd = true;
  }

  public boolean isEnd() {
    return isEnd;
  }
}

class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // 插入字符串
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char curr = word.charAt(i);
      if (!node.containsKey(curr)) {
        node.put(curr, new TrieNode());
      }
      node = node.get(curr);
    }
    node.setEnd();
  }

  // 搜索前缀,返回Node
  public TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char curr = word.charAt(i);
      if (node.containsKey(curr)) {
        node = node.get(curr);
      } else {
        return null;
      }
    }
    return node;
  }
  
  // 搜索
  public boolean search(String word) {
    TrieNode node = this.searchPrefix(word);
    return node != null && node.isEnd();
  }

}
```



# 并查集(Disjoint Set)

## 适用场景

* 组团 & 配对 -> 这2个个体是否在一个集合中
* group or not

## 基本操作

* makeSet(s): 建立一个新的并查集, 其中包含s个单元素集合
* unionSet(x, y): 把元素x和元素y所在的集合合并, 要求x和y所在的集合不相交, 如果相交和不合并
* find(x): 找到元素x所在的集合的代表, 该操作也可以用于判断两个元素是否位于同一个集合, 只要将他们各自的代表比较一下即可



## 代码实现

### Java版本

```java
class UnionFind {
  private int count = 0;
  private int[] parent;

  public UnionFind(int n) {
    count = n;
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i; // 并查集常见初始化方式
    }
  }

  public int find(int p) {
    while (p != parent[p]) { // parent[i] == i时,说明找到领头元素
      parent[p] = parent[parent[p]]; // 继续往上找, 以及路径压缩(见下示意图)
      p = parent[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) return;

    parent[rootP] = rootQ;
    count--;
  }

  /*
  路径压缩
  		  a                 a
       /                 /|\
  		b                 b c d
     /
    c
   /
  d
  */
}
```



## 实战例题



```java
/**
 * 使用并查集
 */
public int findCircleNum(int[][] M) {
  int n = M.length;
  UnionFind uf = new UnionFind(n);
  for (int i = 0; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
      if (M[i][j] == 1) {
        uf.unoin(i, j);
      }
    }
  }
  return uf.count;
}

class UnionFind {
  private int count = 0;
  private int[] parent;

  public UnionFind(int n) {
    count = n;
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  public int find(int p) {
    while (p != parent[p]) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) return;
    parent[rootP] = rootQ;
    count--;
  }
}


/**
 * 使用 DFS
 */
public int findCircleNumByBfs(int[][] M) {
  int[] visited = new int[M.length];
  int count = 0;
  for (int i = 0; i < M.length; i++) {
    if (visited[i] == 0) {
      dfs(M, visited, i);
      count++
    }
  }
  return count;
}

public void dfs(int[][] M, int[] visited, int i) {
  for (int j = 0; i < M.length; j++) {
    if(M[i][j] == 1 && visited[j] == 0) {
      visited[j] = 1;
      dfs(M, visited, j);
    }
  }
}
```





# 启发式搜索

## 估价函数

* 启发式函数: h(n), 用于评价那个节点最优可能是我们要找的节点, h(n)会返回一个实数, 表示节点n到目标节点路径的估计成本



### 代码模板

#### Python版本

```python
def AstarSearch(graph, start, end):
  pq = collections.priority_queue() # 优先级 -> 估价函数
  pq.append([start])
  visited.add(start)

  while pq:
    node = pq.pop()
    visited.add(node)

    process(node)
    nodes = generate_related_nodes(node)
		unvisited = [node for node in nodes if node not in visited]
    pq.push(unvisited)
```

