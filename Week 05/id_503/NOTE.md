# 复习
* 递归代码模板
	```javascript
	function recursion(level, ...params) {
	    // 1. recursion terminator 递归终止条件
	    if (level > MAX_LEVEL) {
	        // 2. process result 处理结果
	        return;
	    }
	
	    // 3. process current logic 处理当前逻辑
	
	    // 4. drill down 递归处理下一层
	    recursion(level + 1, ...params);
	
	    // 5. restore current status if needed 如果需要，**还原当前状态**
	}
	```
* 分治代码模板
  ```javascript
  function divideConquer(problem, ...params) {
        // 递归终止条件
        if (!problem) {
            return
        }


        // 处理当前数据
        const data = prepareData(problem)
        // 拆分这问题
        const subProblems = splitProblem(problem, data)

        // 处理每个子问题结果 
        subResult1 = divideConquer(subProblems[0], params)
        subResult2 = divideConquer(subProblems[1], params)
        subResult3 = divideConquer(subProblems[2], params)
        // …

        // 将子问题结果处理为当前结果
        result = processResult(subResult1, subResult2, subResult3)

        // 如果需要，回复当前状态
    }
  ```

# 动态规定（Dynamic Programming)
* Wiki 定义： https://en.wikipedia.org/wiki/Dynamic_programming 
* “Simplifying a complicated problem by breaking it down into simpler sub-problems”（**in a recursive manner**）
* Divide & Conquer + Optimal substructure (分治 + 最优子结构)
* 关键点
    * **动态规划**和**递归**或者**分治**没有根本上的区别（关键看有无**最优的子结构**）
    * 共性：找到重复子问题 
    * 差异性：最优子结构、中途可以淘汰次优解
* 解题关键步骤
    1. 找出**最优子结构**：opt[n] = best_of(opt[n-1], opt[n-2], …)
    2. 储存**中间状态**：opt[i]
    3. 写出**递推公式**（美其名曰：状态转移方程或者 DP 方程）
        * eg.
          * Fib: opt[i] = opt[n-1] + opt[n-2] 
          * 二维路径：opt[i,j] = opt[i+1][j] + opt[i][j+1]（且判断a[i,j]是否空地）