# 深度优先搜索 DFS（Depth First Search）
* 用的是**回溯思想**
* 非常适合用**递归**实现，或者说**借助栈**来实现
* 时间复杂度：O(E)；E 表示边的个数
* 空间复杂度：O(V)；V 表示节点个数
* 代码模板
	* 递归写法
	```javascript
	// 记录访问过的节点
	const visited = new Set();
	
	function dsf(node, visited) {
	
		if (!root) { // 结束条件
	        return;
	    }

	    if (visited.has(node)) { // 已经访问过，不做处理
	        return
	    }
	    visited.add(node);
	
	    // 处理当前节点逻辑
	    process(node)
	
	    for (child of node.children){ // 递归处理子节点
	        dsf(child, visited)
	    }
	}
	```
	* 非递归写法
	```javascript
	function dsf(root) {
	
	    if (!root) {
	        return;
	    }
	
	    const visited = new Set(); // 记录已经访问过的节点
	    let stack = [root] // 借助栈进行处理节点逻辑
	
	    while (stack.length) {
	        const node = stack.pop();
	        visited.add(node);
	
	        // 处理当前节点逻辑
	        process(node)
	
	        // 生成相关子节点，并过滤掉已经访问过的节点
	        const childNodes = generateChildNodes(node, visited);
	
	        // 子节点加入栈中进行下一次出栈处理
	        stack = stack.concat(childNodes);
	    }
	}
	```
# 广度优先搜 BFS（Breadth First Search）
* 用的是**层层推进的搜索策略**
* 非常适合**借助队列**来实现
* 时间复杂度：O(E)；E 表示边的个数
* 空间复杂度：O(V)；V 表示节点个数
* 代码模板
	* 写法1
	```javascript
	function bsf(root) {
	
	    if (!root) {
	        return;
	    }
	
	    const visited = new Set(); // 记录已经访问过的节点
	    let queue = [root] // 借助队列进行处理节点逻辑
	
	    while (queue.length) {
	        const node = queue.shift();
	        visited.add(node);
	
	        // 处理当前节点
	        process(node)
	
	        // 生成相关子节点，并过滤掉已经访问过的节点
	        const childNodes = generateChildNodes(node, visited);
	
	        // 子节点加入队列中进行下一次出队处理
	        queue = queue.concat(childNodes);
	    }
	}
	```
	* 写法2
	```javascript
	function bsf(root) {
	
	    if (!root) {
	        return;
	    }
	
	    const visited = new Set(); // 记录已经访问过的节点
	    let queue = [root] // 借助队列进行处理节点逻辑
	    
	    while (queue.length) {
	
			let nextQueue = []; // 下一次队列
	        for (let node of queue) { // 出队处理
	            visited.add(node);
	
	            // 处理当前节点
	            process(node)
	
	            // 生成相关子节点，并过滤掉已经访问过的节点
	            const subNodes = generateChildNodes(node, visited);

				nextQueue = nextQueue.concat(subNodes);
	        }

			// 作为下一次队列中进行出队处理
	        queue = nextQueue;
	    }
	}
	```

# 贪心算法（Greedy）
* 在**每一步**选择中都采取在**当前状态**下最好或最优的选择
* **希望**导致结果是**全局**最好或最优的算法（事实情况并非能够全局最优）
* 与动态规划比较
	* 贪心算法对子问题做出选择后，不能回退
	* 动态规划则会保存以前的运算结果，有回退功能
* 可以解决一些最优化问题
	* 求图中的最小生成树
	* 求哈夫曼编码
	* 可以当作辅助算法解决不特别精确的问题
* 一般不能解决工程问题
* 适用场景
	* 问题能够分解成子问题来解决
	* 子问题的最优解能递推到最终问题的最优解

# 二分查找（Binary Search）
* 前提
	* 目标函数单调性（单调递增或者递减）
	* 存在上下界（bounded）
	* 能够通过索引访问（index accessible)
* 时间复杂度是 O(logn)
* 代码模板
	```javascript
	function binarySearch(data, target) {
	
	    let left = 0;
	    let right = data.length - 1;
	
	    //找中间值，比较目标值，判断左查找还是右查找
	    while (left <= right) {
	        let mid = Math.floor((left + right) / 2);
	        if (data[mid] == target) {
	            return
	        }
	
	        if (data[mid] < target) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	}
	```