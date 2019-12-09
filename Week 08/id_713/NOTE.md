# NOTE





# 高级动态规划

## 常见DP题目和状态转移方程

### 爬楼梯问题

* 转换成斐波那契数列
* f(n) = f(n - 1) + f(n - 2), 其中 f(1) = 1, f(2) = 1

```python
# 朴素
def f(n):
  if n <= 1: return 1;
  return f(n - 1) + f(n - 2)

# 带缓存
def f(n):
  if n <= 1: return 1
  if n not in mem:
		mem[n] = f(n - 1) + f(n - 2)
  return mem[n]

def f(n):
  x, y = 1, 1
  for i in ranges (1, n):
    y, x = x + y, y
  return y
```



### 不同路径问题

* f(x, y) = f(x - 1, y) + f(x, y - 1)

```python
def (x, y):
  dp[[0] * (m + 1) for _ in range(n + 1)]
  dp[1][1] = 1
  for i in range(1, y + 1):
    for j in range(1, x + 1):
      dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
  return dp[y][x]
```



### 打家劫舍

* dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])

```python
dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
dp[i][1] = dp[i - 1][0]

```



### 最小路径和

* dp[i] [j]状态定义: minPath(A[1 -> i] [1 -> j])
* dp[i] [j] = min(dp[i - 1] [j], dp[i] [j - 1]) +A[i] [j] 



### 股票买卖

```python
dp[i][k][0 or 1]     0 <= i <= n-1, 1 <= k <= K
# i为天数
# k为最多交易次数
# [0, 1]是否持有股票
# 总状态数: n * K * 2种状态

for 0 <= i < n:
  for i <= k <= K:
    for s in [0, 1]:
      dp[i][k][s] = max(buy, sell, rest)
      
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
# 解释: 今天没有持有股票, 有2种可能
# 1.昨天就没有持有, 然后今天选择rest
# 2.昨天持有了股票, 今天卖掉了
dp[i][k][1] = max(dp[i-1[k][1]], dp[i-1][k-1][0] - prices[i])
# 解释: 今天持有股票, 有2种可能
# 1.昨天持有股票, 今天rest
# 2.昨天没有持有, 今天买入
```



---

## 复杂度来源

* 拥有更多维度
* dp方程复杂





### 爬楼梯变种

* 一次可以上  一级,二级,三级

```python
# 上一级, 上二级, 上三级
# 状态转移方程
a[i] = a[i - 1] + a[i - 2] + a[i -3]

a[0] = 1
a[1] = 2
a[2] = 3

for (int i = 2; i < n; i++) {
  a[i] = a[i - 1] + a[i - 2] + a[i - 3]
}

return a[n - 1]
```



### 编辑距离

```python
# 如果word1[i]与word2[j]相同, 显然dp[i][j] = dp[i - 1][j - 1]

# 如果word1[i]与word2[j], 不同那么dp[i][j]可以通过
#   1.在dp[i - 1][j - 1]的基础上做replace操作达到目的
#   2.在dp[i - 1][j]的基础上做insert操作达到目的
#   3.在dp[i][j - 1]的基础上做delete操作达到目的
# 取三者最小情况即可

```



