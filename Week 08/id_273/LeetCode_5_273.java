//5. 最长回文子串

//解法1：暴力法		执行超时
//思路：遍历获取所有子串, 并且判断该子串是否为回文串且尝试更新最大回文串, 由于判断回文串的方法遍历了整个回文串, 因此复杂度较高
//时间复杂度：O(n^3)
//空间复杂度：O(1)
public String longestPalindrome1(String s) {
	int len = s.length();
	if (len < 2) return s;
	int maxLen = 1;
	String res = s.substring(0, 1);
	for (int i = 1; i < len; i++) {
		for (int j = 0; j < i; j++) {
			String temp = s.substring(j, i + 1);
			if (isValid(temp) && temp.length() > maxLen) {
				maxLen = Math.max(maxLen, temp.length());
				res = temp;
			}
		}
	}
	return res;
}

private boolean isValid(String s) {
	for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
		if (s.charAt(i) != s.charAt(j)) return false;
	}
	return true;
}}

//解法2：DP		执行用时：54ms
//思路：创建一个二维DP用于存储子串S[left, right]是否为回文子串, 
//		每当判断了dp[i][j]=true, 确认当前子串为回文子串后, 尝试更新最大回文子串
//		这里判断是否为回文子串的细节是：
//			若当前子串的首尾字符相同, 且去掉首尾后子串长度小于等于1时, 可以确认该子串为回文子串, 例如：aba -> b
//			若当前子串的首尾字符相同, 且去掉收尾后子串长度大于1, 那么需要再判断去掉首尾的子串是否为回文子串
//		也因为此处判断回文串的方法时间复杂度为O(1), 使得DP比暴力解法复杂度少一维
//时间复杂度：O(m^2)	
//空间复杂度：O(m^2)		
public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2) return s;
	boolean[][] dp = new boolean[len][len];
	String res = s.substring(0,1);
	int maxLen = res.length();
	for (int right = 1; right < dp.length; right++) {
		for (int left = 0; left < right; left++) {
			if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
				dp[left][right] = true;
				if (right - left + 1 > maxLen) {
					maxLen = right - left + 1;
					res = s.substring(left, right + 1);
				}
			}
		}
	}
	return res;
}