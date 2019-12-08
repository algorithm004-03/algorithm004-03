# NOTE

  

# 递归代码模板

### Python版本

```python
def recursion(level, param1, param2, ...):
  # 递归终结者 (终止条件)
  if level > MAX_LEVEL:
		process_result
    return

  # 当前层的逻辑处理
  process(level, data...)

  # 下探 (进入下层)
  self.recursion(level + 1, p1, ...)

  # 恢复当前层的状态, 如果需要的话
```

### java版本

```java
public void recur(int level, int param) {
  // 递归终结者 (终止条件)
  if (level > MAX_LEVEL) {
    // 逻辑处理
    return;
  }

  // 处理当前层的逻辑
  process(level, param);

  // 下探
  recur(level + 1, param);

  // 恢复当前层的状态, 如果需要的话
}
```



# 分治代码模板

## Python版本

```python
def divide_conquer(problem, param1, param2, ...):
  # 递归终结者 (终止条件)
  if problem is None:
    # 终止处理
    return

  # 处理&分割 数据
  data = prepare_data(problem)
  subproblems = split_problem(problem, data)
  
  # 治理数据
  subresult1 = self.divide_conquer(subproblem[0], p1, ...)
  subresult2 = self.divide_conquer(subproblem[1], p1, ...)
  subresult3 = self.divide_conquer(subproblem[2], p1, ...)
  
  # 处理&生成 最终结果
  result = process_result(subresult1, subresult2, subresult3)

  # 恢复当前层的状态, 如果需要的话
```

## java版本

```java
public void divideConquer(Object problem, int param1, int param2, ...) {
  // 递归终结者 (终止条件)
  if (problem == null) {
    // 终止处理
    return
  }

  // 分割问题
  data = this.prepareData(problem);
  subProblems = this.splitProblem(problem, data);

  // 治理
  subResult1 = this.divideConquer(subProblem[0], p1, ...);
  subResult2 = this.divideConquer(subProblem[0], p1, ...);
  subResult3 = this.divideConquer(subProblem[0], p1, ...);

  // 生成最终结果
  result = this.processResult(subResult1, subResult2, subResult3, ...);

  // 恢复当前层的状态, 如果需要的话
}
```



# 思考

* 人肉递归低效
* 找最近, 最简方法, 拆分成**可重复**的**子问题**

* 数学归纳法



# 动态规划

* 动态规划 与 递归/分治 没有根本上的区别 (关键看有无最优子结构)
* 共性: 找到**重复子问题**
* 差异: 最优子结构 中途可以淘汰次优解.    没有**最优解的比较**就是分治

* **需要缓存(状态存储)**
* **把次优的状态淘汰掉**



---

## 实战例题

### Fibonacci数列

#### 原始

```java
int fib(int n) {
  if (n <= 0) {
    return 0;
  } else if (n == 1) {
    return 1;
  } else {
    return fib(n - 1) + fib(n - 2);
  }
}
```

#### 记忆化搜索

```java
int fib(int n) {
  if (n <= 1) return n;
  if (memo[n] == 0) memo[n] = fib(n - 1) + fib(n - 2);
  return memo[n];
}
```

#### buttom up 自底向上

```java
int fib(int n) {
  if (n <= 1) return n;

  int[] a = new int[n];
	a[0] = 0;
	a[1] = 1;

  for (int i = 2; i <=n; i++) {
    a[i] = a[i - 1] + a[i - 2];
  }

  return a[n];
}
```



### 路径计数 count the path

* 二维棋盘, 从左上角走到右下角, 其中有障碍物
* 只能向右走或者向下走
* 拆解成子问题: 起始位(0, 0)有多少种走法 = (0, 1)走法总数 + (1, 0)走法总数
* 子问题是重复的, 符合动态规划思想

#### 分治

```java
/**
 * @param grid 棋盘 true可以走 false不能走(有障碍物)
 * @param row  行
 * @param col  列
 */
public int countPath(boolean[][] grid, int row, int col) {
  if (!validate(grid, row, col)) return 0;
  if (isAtEnd(grid, row, col)) return 1;
  return countPath(grid, row + 1, col) + countPath(grid, row, col + 1);
}
```

# 地推 buttom up 自底部向上

* 在End位(右下角), End的上面和左面, 只有一种走法
* 地推公式:
  * dp[i, j] = dp[i + 1, j] + dp[i, j + 1]

|  27  |  17  |  12  |  12  |  7   |  4   |  1   |  1   |
| :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |
|  10  |  5   |  X   |  5   |  3   |  3   |  X   |  1   |
|  5   |  5   |  2   |  2   |  X   |  3   |  3   |  1   |
|  X   |  3   |  X   |  2   |  1   |  X   |  2   |  1   |
|  7   |  3   |  X   |  1   |  1   |  1   |  1   |  1   |
|  4   |  3   |  3   |  X   |  X   |  0   |  X   |  1   |
|  1   |  X   |  3   |  2   |  1   |  X   |  2   |  1   |
|  1   |  1   |  1   |  1   |  1   |  1   |  1   | End  |



```python
if a[i, j] == '空地':
  dp[i, j] = dp[i + 1, j] + dp[i, j + 1]
else:
  dp[i, j] = 0
```



---

### 动态规划关键点

1. 最优子结构 **dp[n] = best_of(dp[n-1], dp[n-2], ...)**
2. 存储中间状态: **dp[i]**
3. 递归公式 (状态转移方程)
   1. 一维: dp[i] = dp[n-1] + dp[n-2]
   2. 二维: dp[i, j] = dp[i + 1, j] + dp[i+1, j]  (且判断a[i,j]是否是空地)



### 动态规划三部曲

1. 子问题
2. 状态定义
3. DP方程

