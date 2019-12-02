# [358-Week 05] 学习总结 

## 第五周 第十二课

本周学习了动态规划的解题思路和实战题解析。

首先，通过回顾了之前学习的递归和分治的思路，发现动态规划有相似的地方。

相似处：

* 1 人脑递归很累，避免人肉递归
* 找到最近最简fangf-->重复解决
* 利用数学桂腊飞

### 动态规划的特点：

定义：接近分治，递归

比较：

1. 与递归，分治没有本质的区别

2. 共性都是找问题的重复子问题
3. 差异：动态规划是找到问题的最优子结构，中途可以淘汰次优解。

## 实战题解析

### 1. Fibonacci数列

1. 递归 O(2^n)

2. 利用缓存，缓存已经计算过的结果 O(n)

3. 动态规划 bottom up

   ```js
   a[0] = 0, a[1] = 1;
   for(let i = 2; i< n; i++) {
   	a[n] = a[i-1] + a[i-2]
   }
   return a[n]
   ```

   > 一般通过递推的方式，归纳一般规律；竞赛中选手为了求快，会直接写for循环递推。

### 2. count the paths计算路径

1. paths(start, end) = 

   paths(A, end) + paths(B, end) = 

   paths(D, end) + paths(C,end) + ....

   分治 + 递归

2. 递推 Bottom up

   用二维数组存储到大（i，j）的路径数量

   递推得出状态转移方程（DP方程）：opt[i,j] = opt[i+1, j] + opt[i, j+1]

   完整解法： 

   ```js
   if(a[i, j] === '空地') {
   	opt[i, j] = opt[i+1, j] + opt[i, j+1]
   } else {
     opt[i, j] = 0
   }
   ```

   

> DP 关键点：
>
> 1. 求最优子结构的过程： opt[n] = best of opt[n-1], opt[n-2] .....,借助于数组
> 2. 储存中间状态opt[i]
> 3.  归纳递推公式



### 3. 最长公共子序列问题

1. 暴力法：

   从text1 构造所有可能的子字符串与text2一一对比

2. 动态规划：利用二维数组递推

DP方程： 

如果两个字符串s1,s2最后一个字符不相等，最长公共子序列LCS 为Max(LCS[s1-1, s2], LCS[s1,s2-1])

如果s1,s2最后一个字符串想到，则LCS[s1,s2] = LCS[s1-1, s2-2] + 1



> 5 easy steps to DP
>
> 1. Define subproblems
> 2. Guess part of solutions
> 3. Relate subproblems' solutions
> 4. Recurse & memoize or build DP table (bottom -up)
> 5. Solve original problem

### 4. 三角形最小路径和问题

1. 分治法。会超时 O(2^n)

2. DP O(n^2)

   由一般性递推DP方程。此问题类比之前的棋盘上的路径问题。从起点到终点的路径，之前的问题求路径数量，此问题求最小路径和。同样需用从底向上，借助于数组存储中间状态。

   可以看出：使用二维数组sub[i,j],记录本层i，j位置到终点最小路径和，可以得到：

   sub[i,j] = min(sub[i+1, i], sub[i+1], j+1) + a[i,j]

   最终sub[0,0] 是最终解。

   此题要求不使用额外空间，可以在原数组的基础上更新值。

### 5. 打家劫舍问题

回顾下DP求解问题的步骤：

1. 分析子问题
2. 状态定义
3. DP方程

使用数组，a[i]表示 0....i 天 能偷到的最大金额。问题结果a[n-1]

首先比较容易想到，需要增加一维数组表示i天偷还是不偷

```[0
a[i][0,1] : 0 表示不偷，1 偷
a[i][0] = Max(a[i-1][0]， a[i-1][1])
a[i][0] = a[i-1][0] + nums[i]
```

后又可以进一步改进，使用一维数组就足够，改变下状态定义，思路一致 

a[i] : 0 ... i 天且num[i] 必偷的最大值

a[i] = Max(a[i-1], a[i-2] + nums[i])



### 6 股票买卖问题

一个通用DP解决一系列问题

[参考链接](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/)



 