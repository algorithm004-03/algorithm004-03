# 学习总结
## 并查集
### 重点
```java
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
```
[并查集代码模板](https://shimo.im/docs/ydPCH33xDhK9YwWR/read)
### leetcode题目
* [547.朋友圈](https://leetcode-cn.com/problems/friend-circles/)
* [200.岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
* [130.被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)
## 双向BFS
> 其实就是BFS的加强版，为了提高效率，选取左右根节点同时进行BFS，直到相遇为止。
```java
//普通BFS模板（维护队列）
public void bfs(Node root){
    List<Node> visited = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()){
        Node currNode = queue.poll();
        if(currNode!=null){
            visited.add(currNode);
            queue.addAll(currNode.children);
        }
    }
}

//双向BFS（维护两个队列）
public void multiBfs(Node leftRoot,Node rightRoot){
    List<Node> visited = new ArrayList<>();
    Queue<Node> queue1 = new LinkedList<>();
    Queue<Node> queue2 = new LinkedList<>();
    queue1.offer(leftRoot);
    queue2.offer(rightRoot);
    while (!queue1.isEmpty() && !queue2.isEmpty()){
        signVisited(queue1,visited);
        signVisited(queue2,visited);
    }
}
private void signVisited(Queue<Node> queue,List<Node> visited){
    Node node = queue.poll();
    if(node!=null){
        if(!visited.contains(node)){
            visited.add(node);
        }
        for(Node n:node.children){
            queue.offer(n);
        }
    }
}
```
