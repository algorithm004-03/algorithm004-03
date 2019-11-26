//1143. 最长公共子序列

//解法1：动态规划	执行用时：7ms
//思路：对于两个字符串的公共子序列, 存在以下几种情况
//		1.	S1 = "" S2 = 任意字符串 此时不存在公共子序列
//		2.  S1 = "A" S2 = 任意字符串 此时需要判断S2中是否存在S1, 只要存在公共子序列长度为1
//		3.  S1 = "...A" S2 = "........A" S1,S2长度不同, 但最后一位都是同一个字符串, 那么公共子序列长度至少为1
//			那么第三种情况就可以确定子问题为：S1, S2的子序列长度 = 1 + (S1, S2除去公共子序列"A"后剩余部分的公共子序列的长度)
//		那么状态方程为：
//			若S1, S2最后一位字符相同：dp[i][j] = 1 + dp[i - 1][j - 1]
//			若S1, S2最后一位不相同：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
//		明确了边界条件与状态方程, 程序就很好写了
//时间复杂度：O(m*n)
//空间复杂度：O(m*n)
//总结：通过比较了不同写法, 把字符串用数组缓存然后对数组操作比起直接操作字符串的效率要高出不少
//
public int longestCommonSubsequence(String text1, String text2) {
	if(text1.equals(text2)) return text1.length();
	char[] t1 = text1.toCharArray();
	char[] t2 = text2.toCharArray();
	int[][] dp = new int[t1.length + 1][t2.length + 1];
	for (int i = 0; i < t1.length; i++) {
		for (int j = 0; j < t2.length; j++) {
			if (t1[i] == t2[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
			else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
		}
	}
	return dp[dp.length - 1][dp[0].length - 1];
}