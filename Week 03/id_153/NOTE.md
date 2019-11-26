# 总结
1. DFS (深度优先搜索)
   常用栈
   * 递归写法
     ```javascript
     const visited = new Set();

     const dfs(node, visited) => {
       // 递归终止条件
       if (visited.includes(node)) {
         return;
       }
       visited.push(node);
       for (let next_node in node.children()) {
         if(!visited.includes(next_node)) {
           dfs(next_node, visited);
         }
       }
     }
     ```
     * 非递归写法
     ```javascript
     const dfs(tree) => {
       if (!tree.root) {
         return [];
       }
       let visited = new Set();
       let stack = [tree.root];

       while(stack) {
         let node = stack.pop();
         visited.push(node);

         process(node)
         nodes = generate_related_nodes(node);
         stack.push(nodes);
       }
       // other processing work
       // ...
     }
     ```
2. BFS (广度优先搜索)
   常用队列
   ```javascript
   const dfs = (graph, start, end) => {
     let queue = [];
     queue.push(start);
     let visited = new Set();
     visited.push(start)

     while(queue) {
       let node = queue.pop();
       visited.push(node);

       process(node);
       nodes = generate_related_nodes(node);
       queue.push(nodes);
     }
     // other processing work
     // ...
   }
   ```
3. 贪心算法
   * 在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

   * 与动态规划的不同之处在于它对每个子问题的解决方案都作出选择，不能回退，动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。
4. Binary Search (二分查找)
   使用二分查找是有条件的
   * 数组是有序的，单调递增或单调递减
   * 有边界(上下界)
   时间复杂度 O(logn)
   ```javascript
   const binarySearch = (array, target) => {
     let left = 0;
     let right = array.length - 1;
     while(left <= right) {
       let mid = parseInt((left + right) / 2, 10);
       if (array[mid] === target) {
         // find the target
         // break or return result
         return target;
       } else if (array[mid] < target) {
         left = mid + 1;
       } else {
         right = mid - 1;
       }
     }
   }
   ```