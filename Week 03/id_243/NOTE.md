# Week 3 学习总结
## DFS & BFS
> 根据老师的python模板，手写了一个java的模板，不过还是unchecked的，待修改。感觉这部分最重要的就是对两种搜索算法的模板代码的理解和记忆，然后就是灵活运用。

链接：
* [DFS模板-python](https://shimo.im/docs/ddgwCccJQKxkrcTq/read)
* [BFS模板-python](https://shimo.im/docs/P8TqKHGKt3ytkYYd/read)

1. DFS (Depth First Search) 深度优先搜索

> 模板（递归）
```
//定义一个泛型
private List<Node> visited = new ArrayList<>();

//递归函数
private void dfs(Node node){

    //终止条件
    if(visited.contains(node)){
        return;
    }

    //当前层逻辑
    visited.add(node);

    //遍历当前节点的子节点
    for(Node childNode:node.children){
        if(!visited.contains(childNode)){
            dfs(childNode);
        }
    }

}
```
> 模板（栈）
```
// 手动维护一个栈
 // 手动维护一个栈
    void dfs(Node node){
        //如果根节点为空，则返回
        if(node == null){
            return;
        }

        //定义输出泛型
        List<Node> visited = new ArrayList<>();

        //手动维护一个栈，并初始化
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()){
            //当前节点出栈
            Node currentNode = stack.pop();
            //记录访问
            visited.add(currentNode);
            //执行逻辑
            process(currentNode);
            //
            for(Node childNode:currentNode.children){
                stack.push(childNode);
            }
        }

    }
```
2. BFS(Breadth First Search) 广度优先搜索
> 模板（队列）
```
private void bfs(Node root){
    //初始化队列
    Queue<Node> queue = new LinkedList<>();
    //当前数组
    List<Node> visited = new ArrayList<>();
    //初始化队列
    queue.add(root);
    //队列不为空
    while (!queue.isEmpty()){
        //取出队头
        Node currentNode = queue.poll();
        if(currentNode==null || visited.contains(currentNode)) continue;
        //记录访问
        visited.add(currentNode);
        //执行逻辑
        pocess(currentNode);
        //将当前的节点的子节点入队
        queue.addAll(currentNode.children);
        
    }
}
```
## 贪心算法（greedy algorithm）
### 定义
一种在每一步选择中都采取在当前状态下最好或最优（最有利）的选择，从而希望导致的结果时全局最好或最优的算法。
### 比较
1. 贪心算法对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前结果对当前进行选择，具有回退功能。
2. 对比：
* 贪心：当下做局部最优判断。
* 回溯：能够回退。
* 动态规划：最优判断+回退。
### 重点难点
> 动态规划的场景一般会有**期望值**，以及满足期望值所限制的**限制值**。

重点是证明场景可以用贪心算法：
* 贪心算法能够得到最优解；
* 可以从前往后、从后往前或局部切入进行贪心。
### 应用场景
* Huffman coding 霍夫曼编码
> 霍夫曼编码是一种十分有效的编码方法，广泛用于数据压缩中，其压缩率通常在 20%～90% 之间。
思想就是，将出现频率高的字符尽可能用比较短的编码转换，同时避免冲突。
* Prim和kruskua最小生成树
* Dijkstra单源最短路径算法
## 二分查找（Binary Search）
二分查找的前提：
1. 目标函数的单调性
2. 存在上下界
3. 能够通过索引访问
> 核心：分治思想。时间复杂度：O(logN)

使用场景：
1. 顺序表结构，如数组：如果使用链表的话，在查找时的时间复杂度高，当然，如果链表使用跳表等情况的话例外。
2. 针对的是**有序**的数据。
3. 数据量太小不适用：因为这个时候往往直接遍历即可。不过有个情况例外，当比较环节较麻烦，如两个长字符串进行比较时，为了减少比较环节的耗时，用二分查找更有优势。
4. 数据量太大不适用：因为底层是用数组，需要在内存开一个很长的连续空间。
5. 适用于静态数据，没有频繁的数据插入和删除操作。

### 二分查找模板
```
public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;

  while (low <= high) {
    int mid = (low + high) / 2;
    if (a[mid] == value) {
      return mid;
    } else if (a[mid] < value) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return -1;
}
```
> 代码中，为了避免在数据较大时，low+high大小会溢出，可以换种写法：`low + ((high - low) >> 1);`。

### 思考题：
> 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方。时间复杂度为O(logN)。

思路：取中间点mid，与左边界left进行比较，
若[left,mid]是有序的，即`nums[mid]>nums[left]`，则向右规约；
若[left,mid]不是有序的，即`nums[mid]<nums[left]`，则向左规约。








  

