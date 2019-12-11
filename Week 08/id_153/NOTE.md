# 总结

## 高级动态规划
1. 递归 - 函数自己调用自己
2. 分治

* 人肉递归低效、很累
* 找到最近最简方法，将其拆解成可重复解决的问题
* 数学归纳法思维
* 寻找重复性 --> 计算机指令集

### DP 顺推模板
```python
function DP():
  dp = [][] // 二维情况

  for i = 0 .. M {
    for j = 0 .. N {
      dp[i][j] = _Function(dp[i'][j']...)
    }
  }
  return dp[M][N];
```

关键点
* 动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）
* 拥有共性：找到重复子问题
* 差异性：最优子结构、中途可以淘汰次优解

## 字符串匹配算法
1. 暴力法
   ```java
   public static int forcceSearch(String txt, String pat) {
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
       // 1. 预先判断 - hash(txt.substring(i, M)) == hash(pat)
       // 2. KMP
     }
     return -1;
   }
   ```
2. Rabin-Karp 算法
   * 假设子串的长度为 M(pat),目标字符串的长度为 N(txt)
   * 计算子串的 hash 值 hash_pat
   * 计算目标字符串 txt 中每个长度为 M 的子串的 hash 值 (共需要计算 N-M+1 次)
   * 比较 hash 值：如果 hash 值不同，字符串必然不匹配；如果 hash 值相同，还需要使用朴素算法再次判断
3. KMP 算法
   当子串与目标字符串不匹配时，其实你已经知道了前面已经陪陪成功那一部分的字符（包括子串与目标字符串）。KMP 算法的想法是，设法利用这个一直心系，不要把“搜索位置”一会已经比较过的位置，继续把它向后移，这样就提高了效率。