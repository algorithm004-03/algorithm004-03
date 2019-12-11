# NOTE

#### 动态规划、状态转移方程

* 动态规划复习；
    * 递归：函数自己调用自己（Terminator， process drill down reverse state）
    * 分治（也会用递归）：分而治之。
    * 动态规划（Dynamic Programming，面试很多时候都是面的二维数组的模式的DP）：
        * 1：“Simplifying a complicated problem by breaking it down into simpler sub-problems”(in a recursive manner)
        * 2: Divide & Conquer（分治） + Optimal substructure（最优子结构）
        * 3：顺推形式：动态递推
* 多种情况的动态规划的状态转移方程串讲；
* 进阶版动态规划的习题；

* 感触
    * 1：人肉递归低效，且很累
    * 2：找到最近最简单的方法（最大公约数），将其拆解成可重复解决的问题
    * 3：数学归纳法思维
* 本质：寻找重复性 --> 计算机指令集

#### 在第 8 周学习总结中，写出不同路径 2 这道题目的状态转移方程。

* 复杂：
    * DP状态的定义，把现实的问题定义成一个数组，保存状态
    * 写出状态转移方程（斐波那契：dp[i] = dp[i - 1] + dp[i - 2]）
    * 
* 关键点
    * 动态规划和递归或者分治没有根本上的区别（关键是看有无最优的子结构）
    * 拥有共性：找到重复子问题。
    * 差异性：最优子结构、中途可以淘汰次优解。

DP顺推模板
```
function DP():
    dp = [][]#二维情况
    for i = 0 .. M {
        for j = 0 .. N {
            dp[i][j] = _Function(dp[i'][j']...)
        }
    }
    
    return dp[M][N]
```
#### DP创建的问题

* 1：爬楼梯问题，与硬币置换问题有异曲同工之处
    * 动态规划状态转移方程为：f(n)=f(n-1)+f(n-2), f(1)=1, f(0)=0
    * ![dbbc67876c52748717c53e44e829946c.png](en-resource://database/2544:1)  
* 2：不同路径问题
    * 状态转移方程为：f(x,y) = f(x-1, y) + f(x, y-1)
    * ![c126b26f3dcbda7219e88b2015f6eac2.png](en-resource://database/2546:1)
    
* 3：打家劫舍问题：
    * 状态转移方程：见下图
    * ![138ff5415244617a9802b447150f2cfa.png](en-resource://database/2548:1)

* 4：最小路径和：
    * 状态转移方程：见下图
    * ![d6fc34ffccdc5455f8830212013f4c5a.png](en-resource://database/2550:1)
    
* 5：买卖股票问题：
    * 状态转移方程的维度：1、天i；2、当前是否拥有股票（0或1）；3、最多只能交易次数k，当前交易次数。冷冻期和偷房子问题，只能相隔来偷。
    * ![ae523556877b77ca09022ffec57d1124.png](en-resource://database/2552:1)
    * 状态定义：dp[i][k][0 or 1](0 <= i <= n -1, 1 <= k <= K；总状态为：n * K * 2
    * 状态转移方程：见下图
    * ![aa86d4ae5d5cc5121391f9c4829cc6e4.png](en-resource://database/2554:1)
    * ![208c7aad4b037c785b6e9f8930a72bc1.png](en-resource://database/2556:1)
    
    * 模板代码：

```
for 0 <= i < n:
    for 1 <= k <= K:
        for s in {0, 1}:
            dp[i][k][s] = max(buy, sell, rest) #状态转移方程
```

    
#### 复杂度来源
* 1：状态拥有更多纬度（二维、三维、或者更多、甚至需要压缩）
* 2：状态方程更加复杂

本质：内功、逻辑思维、数学

#### 字符串算法

##### 基础知识
* Python 和 java的String是不可变的。新增或者减少时，是新生成一个String，c++则不一样，存在并发问题
* 遍历字符串，方法：调用库api

##### 字符串操作问题

##### 高级字符串算法
* 动态规划 和 字符串问题相结合
    * 最长子串、子序列问题
        * https://leetcode-cn.com/problems/longest-common-subsequence/
        * https://leetcode-cn.com/problems/edit-distance/

##### 字符串匹配算法

* 1：暴力法
* 2： Rabin-Karp算法
* 3：KMP算法
    * 思想：当子串与目标字符串不匹配时，其实你已经知道了前面已经成功那部分的字符（包括子串与目标字符串）。
    * 步骤：
        * 1：枚举出待匹配的字符串的所有前缀
        * 2：计算出最长前后缀公共列表
            * ![4e01e3181799100f37267c6f938c390d.png](en-resource://database/2579:1)
            *  ![e174c5739f57cbfe7978fd3b5829d42f.png](en-resource://database/2581:1)
        
        * 


  

