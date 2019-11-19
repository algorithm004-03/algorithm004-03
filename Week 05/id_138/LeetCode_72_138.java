/**
 * 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
思路:
编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法。
最简单的方法是检查所有可能的编辑序列，从中找出最短的一条。但这个序列总数可能达到指数级，但完全不需要这么多，因为我们只要找到距离最短的那条而不是所有可能的序列。
写的很好理解的方法:
https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-mian-shi-ti-xiang-jie-by-labuladong/
 * @author L
 *
 */
public class LeetCode_72_138 {
	public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];//# 返回 s1[0..i] 和 s2[0..j] 的最小编辑距离; dp 函数的 base case是 i,j 等于 -1，而数组索引至少是 0，所以 dp 数组会偏移一位。
        //dp[i-1][j-1] # 存储 s1[0..i] 和 s2[0..j] 的最小编辑距离
        for (int i=1;i<=m;i++) {
        	dp[i][0] = i;//word2为空，则操作为i
        }
        for(int j=1;j<=n;j++) {
        	dp[0][j] = j;//word1为空 则操作为j
        }
        //自底向上求解
        for(int i=1;i<=m;i++) {
        	for(int j=1;j<=n;j++) {
        		if(word1.charAt(i-1) == word2.charAt(j-1)) {//当前下标i j位置字符相同
        			dp[i][j] = dp[i-1][j-1];
        		}else {//当前下标i j 位置字符不相同
        			dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+1);
        		}
        	}
        }
        return dp[m][n];
    }
}
