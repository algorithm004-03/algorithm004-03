# 第八周学习总结
## 动态规划、状态转移方程串讲
- 一定具有重复性，本质是寻找重复性
  - 1. 将一个问题分解成多个简单子问题
  - 2. 分治 + 最优子结构
  - 3. 顺推形式：动态递推
- DP递推模板
```java
function DP():
    // 第一步复杂的地方:如何将现实问题定义为一个N维数组？
    dp = [][] # 二维情况
    for i = 0..M {
        for j = 0..N {
            // 第二步复杂的地方:这个动态转移方程要怎么写？
            dp[i][j] = _Function(dp[i’][j’]...)
        }
    }
    return dp[M][N];
```

- 重要题目，一个方法团灭全部股票买卖问题
 - [股票买卖](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

## 高级动态规划
- 复杂度来源
  - 1. 状态拥有更多维度（二维、三维、或者更多甚至需要压缩）
  - 2. 状态方程更加复杂
- 本质：内功、逻辑思维、数学
- 国际编程比赛到最后都是动态规划压轴

## 字符串基础知识
- 可变与不可变
  - 不可变字符串
  - Python和Java的String是不可变的。
- 字符串比较
  - Java的常量池，equal方法

## 高级字符串算法
- 面试很多，实际算法也经常会用的
  - 动态规划和字符串相结合
    - 最长子串、子序列
    - 两个字符串的问题，建立二维dp状态，两个字符串长度 + 1 各为一维
      - [编辑距离](https://leetcode-cn.com/problems/edit-distance/)
      - [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
      - 最长子串（连续的子串, LeetCode没有题目）
        - dp[i][j] = dp[i-1][j-1] + 1 if s1[i-1] == s2[j-1] else dp[i][j] = 0
      - [最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
        - 暴力O(n^3)
        - 中间向两边扩张O(n^2)
        - 动态规划
      - [不同子序列](https://leetcode-cn.com/problems/distinct-subsequences/)

## 字符串匹配算法
- 暴力法
  - 代码
```python
def forceSearch(txt, par):
    m = len(txt)
    n = len(par)
    for i in range(m - n)：
        j = 0
        while j < n:
            if txt[i + j] != par[j]:
                break
            j += 1
        if j == n:
            return i
        # 更加聪明？ 
        # 1. 预先判断 hash(txt.substring(i, M)) == hash(pat)
        # 2. KMP 
    return -1
```

- Rabin-Karp算法
  - 基于暴力法，用子串的hash值进行判断子串是否可能一样，如果可能一样再用逐个比较字符串
    - 1. 假设子串长度为M(pat)，目标字符串的长度为N(txt)
    - 2. 计算子串的hash值hast_pat
    - 3. 计算目标字符串txt中每个长度为M的子串的hash值（共需要计算N-M+1次）（注意，如果用系统的hash函数，时间复杂度还是高，因为要逐个字符串弄出来计算hash值，如何找hash函数？）
    - 4. 比较hash值：如果hash值不相同，字符串必然不匹配；如果hash值相同，则进一步比较子字符串的每一位
  - Rabin-Karp 代码示例
```java
public final static int D = 256;  // 256进制
public final static int Q = 9997; // 最好是一个素数
static int RabinKarpSerach(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;
    for (i = 0; i < M; i++) {
        // 模上素数Q，防止数值过大溢出
        patHash = (D * patHash + pat.charAt(i)) % Q;
        txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }
    int highestPow = 1;
    // 计算出txtHash最高位字符的hash的权重：256的M-1次方 (记得每位都要模Q)
    for (i = 0; i < M - 1; i++) 
        highestPow = (highestPow * D) % Q;

    for (i = 0; i <= N - M; i++) { // 枚举起点
        if (patHash == txtHash) {
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == M)
                return i;
        }
        // 利用上一个txtHash计算下一个txtHash:
        // 逻辑是：将最高位(最左边)字符移除(即减去该位字符的值)，然后再加入最低位(活动窗口下一位)的字符值，就是新的txtHash值
        if (i < N - M) {
            txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
            // txtHash可能为负数，如果为负数，矫正为正数即可，这不影响Hash的效果，可以容忍
            if (txtHash < 0)
                txtHash += Q;
        }
    }
    return -1;
}
```

- KMP算法
  - 当子串与目标字符串不匹配时，其实你已经知道了前面已经匹配为成功那一部分的字符（包括子串与目标字符串）。
  - 以阮一峰的文章为例，当空格与D不匹配时，你其实已经知道前面六个字符是”ABCDAB”。KMP算法的想法是：设法利用这个已知信息，不要把”搜索位置”移回已经比较过的位置，继续把它向后移，这样就提高了效率
    - [KMP 字符串匹配算法视频](https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171)
    - [字符串匹配的 KMP 算法](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)
- 课后了解：
  - [Boyer-Moore算法](http://xn--https-ni33a//www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html)
  - [Sunday算法](https://blog.csdn.net/u012505432/article/details/52210975)


  













