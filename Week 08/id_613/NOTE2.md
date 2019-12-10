# NOTE

# 字符串
## java、python、go里的string是immutable的
## c++里的string是mutable，如果要immutable，加const即可
## immutable是线程安全的

## 字符串比较
Java:
String x = "abb"
String y = "abb"

x == y --> false

x.equals(y) --> true
x.equalsIgnoreCase(y) --> true

## 字符串匹配算法
- 1、暴力法
- 2、Robin-Karp算法
- 3、KMP算法
- Robin-Karp和KMP算法都是在暴力法的基础上进行的优化或加速
  
### Rabin-Karp算法（在朴素算法的基础上增加了hash来做预判）
Rabin-Karp算法思想：
1、假设子串的长度为M(pat)，目标字符串的长度为N(txt)
2、计算子串的hash值hash_pat
3、计算目标字符串txt中每个长度为M的子串的hash值(共需要计算N-N+1次)
4、比较hash值：如果hash值不同，字符串必然不匹配；如果hash值相同，还需要使用朴素算法再次判断

### KMP算法
KMP算法思想：当子串与目标字符串不匹配时，其实你已经知道了前面已经匹配成功的那一部分字符，然后
设法利用这个已知信息，不要把"搜索位置"移回已经比较过的位置，继续把它向后移，这样就提高了效率。
#### 算法视频
https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171


课后了解：  
Boyer-Moore算法：  
http://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html  
Sunday算法：  
https://blog.csdn.net/u012505432/article/details/52210975


# 高级动态规划
## DP顺推模板
```python
function DP():
    dp = [][] # 二维情况
    
    for i = 0 .. M {
      for j = 0 .. N {
        dp[i][j] = _Function(dp[i'][j']...)
      }
    }
    
    return dp[M][N]
```

## DP解题思维方式
- 把问题抽象化
- 定义成状态（一维或多维状态），写出DP转移方程
- 套用模板，写出嵌套循环及DP方程

## 高阶DP复杂度来源
- 状态拥有更多维度（二维、三维、或者更多、甚至需要压缩）
- 状态方程更加复杂  
本质：内功、逻辑思维、数学

