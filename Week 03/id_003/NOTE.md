# NOTE

本周算法习题库：

第9课课后作业

* https://leetcode-cn.com/problems/word-ladder/description/
* https://leetcode-cn.com/problems/word-ladder-ii/description/
* https://leetcode-cn.com/problems/number-of-islands/
* https://leetcode-cn.com/problems/minesweeper/description/

第10课课后作业

* https://leetcode-cn.com/problems/lemonade-change/description/
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
* https://leetcode-cn.com/problems/assign-cookies/description/
* https://leetcode-cn.com/problems/walking-robot-simulation/description/
* https://leetcode-cn.com/problems/jump-game/ 
* https://leetcode-cn.com/problems/jump-game-ii/

第11课课后作业
* https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
* https://leetcode-cn.com/problems/search-a-2d-matrix/
* https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

## 第九课 深度优先搜索、广度优先搜索的实现和特性
**DFS（深度优先）代码模板-递归写法**
```
visited = set();
def dfs(nodes, visited);
    visited.add(nodes)
    #process current node here
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next node, visited)
```
**DFS代码模板-非递归写法**
```
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```
**BFS代码模板-非递归写法**

```
def BFS(graph, start, end):

	queue = [] 
	queue.append([start]) 
	visited.add(start)

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

**随堂练习**

用广度优先算法实现括号配对

**实战题目：**

[515. 在每个树行中找最大值 - 力扣（LeetCode）](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description)

思路总结：先套用模板，之后再处理每一层的逻辑即在每一层中比较最大值

```
var largestValues = function(root) {
    let res = [];
    let max = [];
    if (!root) return res;
    let queue = [];
    queue.push(root);
    while(queue.length > 0){
        // let cur = queue.shift();
        let nextQueue = [];
        let maxval = -Infinity;
        for (const item of queue) {
            item.val > maxval && (maxval = item.val)
            if (item.left) {
                nextQueue.push(item.left);
            }
            if (item.right) {
                nextQueue.push(item.right);
            }
            
        }
        max.push(maxval);
        queue = [...nextQueue];

    }
    return max;
};
```
  
[22. 括号生成 - 力扣（LeetCode）](https://leetcode-cn.com/problems/generate-parentheses/#/description)

思路总结：每个位置都可以是做括号或者右括号。但要满足相应的约束条件。
1. 左括号和右括号的个数为n个，
2. 在填入右括号的时候要保证已经填入的右括号的个数小于已经填入的左括号的个数

```
var generateParenthesis = function(n) {
    let res = [];
    backtrack(res,'',0,0,n);

    function backtrack(res,cur,open,close,max){
        if(cur.length == max*2) {
            res.push(cur);
            return;
        }
		//左括号的个数小于max，右括号的数量小于已使用的左括号
        if (open < max) backtrack(res,cur+'(',open+1,close,max);
        if (close < open) backtrack(res,cur+')',open,close+1,max);
    }
    return res;
    
};
```

  
[433. 最小基因变化 - 力扣（LeetCode）](https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description)

[102. 二叉树的层次遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description)


思路总结：进行dfs的时候顺便将层级信息记录下来，同时将层次信息插入到层相应的数组项中去

dfs
```
var levelOrder = function(root) {
    let result = [];
    if( !root ) return result;
    helper(root,0);
    function helper(node,level){
        //recursion terminator
        if (result.length==0) {
            result.push([]);
        }
        //process data
        !result[level] && (result[level]=[])//该层不存在的时候添加一个。
        result[level].push(node.val);
        

        if(node.left) helper(node.left,level+1);
        if(node.right) helper(node.right,level+1);

    }
    return result;
};
```
bfs
```
//使用队列记录下层次的信息,node记录下一层的结点
var levelOrder = function(root) {
    if (!root) {
        return [];
    }
    let result = [];
    let queue = []
    queue.push(root);

    while(queue.length >0){
        // let node = queue.shift()
        level = [];
        node = [];
        for (const item of queue) {
            level.push(item.val);
            if (item.left) node.push(item.left)
            if (item.right) node.push(item.right)
        }
        result.push(level)
        queue = [...node];
    }
	<!-- 
	//或者可以参考这个，先使用一个变量记录队列的size
		while (!queue.isEmpty()) {
		int count = queue.size();
		//外层循环为一层
		List<Integer> list = new ArrayList<>();
		while (count-- > 0) {
			//将当前元素的非空子节点压入栈
			Node cur = queue.poll();
			list.add(cur.val);
			for (Node node : cur.children) {
				if (node != null) {
					queue.add(node);
				}
			}
		}
		res.add(list);
	}

	 -->
    return result;
};
```
  
**homework**
* [529. 扫雷游戏 - 力扣（LeetCode）](https://leetcode-cn.com/problems/minesweeper/description/)
思路总结： 每一层为每一个格子周围的八个格子，所以每次递归的时候就是将这周围八个的信息扫描出来
```
	var updateBoard = function(board, click) {
	    let [x,y] = click;
	    if(board[x][y] == "M"){
	        board[x][y] = 'X';
	        return board;
	    }
	    function dfs(board,x,y){
	        let num =  getNum(board,x,y);
	        if(num == 0){
	            board[x][y] = 'B';
	        } else {
	            board[x][y] = num+'';
	            return board
	        }
	        for(let i = -1; i <= 1; i++){
	            for(let j = -1; j <= 1; j++){
	                if(x+i >= 0 && x+i < board.length && 
	                    y+j >= 0 && y<board[0].length && 
	                    board[x+i][y+j] == 'E'){
	                    board = dfs(board, x + i, y + j);
	                }
	            }
	        }
	        return board;
	    }
	    function getNum(board,x,y){
	        let num = 0;
	        for(let i = -1; i <= 1; i++){
	            for(let j = -1; j <= 1; j++){
	                if(x+i >= 0 && x+i < board.length && 
	                   y+j >= 0 && y<board[x].length && 
	                   board[x+i][y+j] == 'M'){
	                    num++
	                }
	            }
	        }
	        return num;
	    }
	
	    return dfs(board, x, y);

};
```
  
* [200. 岛屿数量 - 力扣（LeetCode）](https://leetcode-cn.com/problems/number-of-islands/)
  
思路一：
遇到陆地就把该陆地及该陆地周边的陆地夷为平地：

```

var numIslands = function(grid) {
	//上下左右
    const dx = [-1,1,0,0];
    const dy = [0,0,-1,1];
    let g = grid;
    let islands = 0;

    for (let i = 0; i < g.length; i++) {
        for (let j = 0; j < g[i].length; j++) {
            if (g[i][j]=='0') continue;//剪枝
            islands += sink(i,j);        
        }
    }
    return islands;

    function sink(i, j){
        if(g[i][j]=='0') return 0;

        //不为0的话就将该岛变为0
        g[i][j] = '0';

        for (let k = 0; k < dx.length; k++) {
            let x = i + dx[k], y = j + dy[k];
            
            if(x>=0 && x < g.length && y >= 0 && y < g[i].length){
                // console.log('k'+k,x,y,g[x][y]);
                if( g[x][y] == '0') continue;
                
                sink(x,y);
            }
        }
        return 1;
    }
    
};

```
* [126. 单词接龙 II - 力扣（LeetCode）](https://leetcode-cn.com/problems/word-ladder-ii/description/)
  
* [127. 单词接龙 - 力扣（LeetCode）](https://leetcode-cn.com/problems/word-ladder/description/) 
```
//未通过，待修改
var ladderLength = function(beginWord, endWord, wordList) {
    //记录单词长度，用作下一步的循环变量
    let l = beginWord.length;
    //创建字典，用于保存单词的通用状态。
    let allComboDict = {}
    let q = [];

    // getDic();
    for (const word of wordList) {
      for (let i = 0; i < l; i++) {
        let newWord = word.replace(word[i],'*');
        let tempList = allComboDict[newWord] || []
        tempList.push(word);
        allComboDict[newWord] = allComboDict[newWord]=tempList 
    }      
    }
    // console.log(allComboDict);
    
    // bfs();
    let visited = {};
    q.push([beginWord,1]);
    visited[beginWord] = true;

    while (q.length>0) {
        let node = q.shift();
        let level = node[1];
        let word = node[0];
        
        for (let i = 0; i < l; i++) {
            let newWord = word.replace(word[i],'*');

            // console.log(newWord,allComboDict);
            let mapList = (allComboDict[newWord] || []);
            for (const word of mapList) {
              
              if(word == endWord){
                console.log(level+1);
                return level+1;
              }
              
              if(! (word in visited)) {
                  visited[word] = true;
                  q.push([word,level+1]);
              }
            }
        }
    }
    return 0
};
```

  
## 二分查找代码模板
```
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

## 编程体会
1. 编程思路总结，采用自顶向下的编程方式编写算法时应关注如何将问题分步处理。之后再关注要解决每一个问题的核心是什么。
2. 使用递归时思想要抽象，不可人肉递归。抓好头和尾，抓好边界。