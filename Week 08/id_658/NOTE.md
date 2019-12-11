# 第八周学习总结

## 高级动态规划

### 动态规划

- 本质上还是寻找重复性（计算机指令集）
- 分治的过程中能够在中间每一步淘汰次优解就变成了动态规划
- 将一个复杂问题分解成各个简单的子问题（分治思想）
- 有一个最优子结构
- 很多时候状态本身可以进行顺推（从下到上往上推）`动态递推`

#### DP 顺推模板

```python
function DP():
    dp = [][] # 0. dp 状态的定义 一维情况、二维情况、三维情况

    # 1.本身是一个嵌套循环
    for i = 0 .. M {
        for j = 0 .. N {
            dp[i][j] = _Function(dp[i'][j']...) # 2.从之前的 dp 的状态，推到最新的 dp[i][j] 的状态
        }
    }
    return dp[M][N] # 3. dp[M][N] 反映最后的最终结果
```

- `0. dp 状态的定义` 需要把现实的问题定义成一个数组，里面保存状态
- `2. 状态转移方程` 类似 Fibonacci 数列 `dp[i] = dp[i - 1] + dp[i - 2]`，更多情况下是求最小值、累加累减或者是有一层小的循环从之前的 k 个状态中找出它的最值

### 动态规划的状态转移方程

#### 爬楼梯问题

- 本质上可以转换成 Fibonacci 问题
- 和硬币置换问题异曲同工（一次上一步上两步相当于每次用1面值2面值的硬币）
- 递归公式 `f(n) = f(n - 1) + f(n - 2), f(0) = 0, f(1) = 1`

#### 不同路径
  
- 递归公式 `f(x, y) = f(x - 1, y) + f(x, y - 1)`

#### 打家劫舍

- 不能偷连续的两个房子
- dp[i] 的状态表示打劫从 A[0] 到 A[i] 的房子最多可以获得多少钱 `max $ of robbing A[0 -> i]`
  - i 有可能被打劫，也可能没被打劫
  - `dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])`
- dp[i][0] 的状态表示打劫从 A[0] 到 A[i] 的房子最多可以获得多少钱，并且没打劫 num[i]
- dp[i][1] 的状态表示打劫从 A[0] 到 A[i] 的房子最多可以获得多少钱，并且打劫了 num[i]
  - `dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])`
  - `dp[i][1] = dp[i - 1][0] + nums[i]`

#### 最小路径和

- dp[i][j] 的状态表示：`minPath(A[i -> i][1 -> j])`
- `dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + A[i][j]`

#### 股票买卖

- [一个方法团灭6道股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/)
- dp[i][k][0 or 1] (i >= 0 && i <= n - 1, k >= 1 && k <= K)
  - i 为天数
  - k 为最多交易次数
  - [0, 1] 为是否持有股票
- 总状态数：`n * K * 2` 种

```python
for 0 <= i < n :
    for 1 <= k <= K :
        for s in {0, 1} :
            dp[i][k][s] = max(buy, sell, rest)
```

- 状态转移方程
  - `dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])`
    - max(选择 rest, 选择 sell)
    - 今天我没持有股票，有两种可能：
      1. 我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有股票
      2. 我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了
  - `dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])`
    - max(选择 rest, 选择 buy)
    - 今天我持有着股票，有两种可能：
      1. 我昨天就持有着股票，然后今天选择 rest， 所以我今天还持有着股票
      2. 我昨天本没有持有股票，但今天我选择 buy，所以今天我就持有股票了

### 动态规划进阶

#### 复杂度来源

- 状态拥有更多维度（二维、三维或者更多，甚至需要压缩）
- 状态方程更加复杂
- 本质上是内功、逻辑思维能力、数学能力

## 字符串

- Java 中字符串 String 是不可变的
- Java 中的 `x == y` 比较的是指向的内存地址，用 `x.equals(y)` 方法比较 x 和 y 的值是否相同，可以用 `x.equalsIgnoreCase(y)` 忽略大小写比较

### 字符串匹配算法

#### 暴力法 (brute force)

- 挨个比较所有的字符才知道目标字符串中是否包含子串

```java
public static int forceSearch(String txt, String pat) {
    int M = txt.length();
    int N = pat.length();
    for (int i = 0; i <= M - N; i++) {
        int j;
        for (j = 0; j < N; j++) {
            if (txt.charAt(i + j) != pat.charAt(j)) {
                break;
            }
        }
        if (j == N) {
            return i;
        }
        // 更加聪明？
        // 1. 预先判断子串是否相同 hash(txt.subString(i, M)) == hash(pat)
        // 2. KMP 已经匹配的片段的最大前缀和最大后缀的长度
    }
    return -1;
}
```

#### Rabin-Karp 算法

- 为了避免挨个字符对目标字符串和子串进行比较，我们可以尝试一次性判断两者是否相等
- 需要通过一个哈希函数算出子串的哈希值，然后将它和目标字符串中的子串的哈希值进行比较
- 思想：
  1. 假设子串 pat 的长度为 M，目标字符串 txt 的长度为 N
  2. 计算子串的 hash 值 hash_pat
  3. 计算目标字符串 txt 中每个长度为 M 的子串的 hash 值，共需要计算 `N - M + 1` 次
  4. 比较 hash 值：如果 hash 值不同，字符串必然不匹配；如果 hash 值相同，还需要使用朴素算法再次判断

```java
public final static int D = 256; // 每一位权重就是256的相应的次方
public final static int Q = 9997; // 防止 hash 值过大，每次 % 一个素数
static int RabinKarpSearch(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;

    for (i = 0; i < M; i++) {
        patHash = (D * patHash + pat.charAt(i)) % Q;
        txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }
    int highestPow = 1; // pow(256, M - 1)
    for (i = 0; i < M - 1; i++)
        highestPow - (highestPow * D) % Q;

    for (i = 0; i <= N - M; i++) { //枚举起点
        if (patHash == txtHash) {
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == M)
                return i;
        }
        if (i < N - M) {
            txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
            if (txtHash < 0)
                txtHash += Q;
        }
    }
    return -1;
}
```

#### KMP 算法

- Knuth-Morris-Pratt 的思想就是，当子串与目标字符串不匹配时，其实你已经知道了前面已经匹配成功那一部分的字符（包括子串与目标字符串）
- 利用这个已知信息，不要把`搜索位置`移回已经比较过的位置，而是继续把它向后移，这样就提高了效率
- [KMP 字符串匹配算法](https://www.bilibili.com/video/av11866460)
- [字符串匹配的 KMP 算法](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)
