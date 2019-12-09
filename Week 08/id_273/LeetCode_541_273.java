//541. 反转字符串II

//解法1：暴力	执行用时：1ms
//思路：
public String reverseStr(String s, int k) {
	char[] charArr = s.toCharArray();
	for (int i = 0; i < charArr.length; i += k * 2) {
		for (int m = i, n = Math.min(m + k - 1, charArr.length - 1); m < n; m++, n--) {
			char temp = charArr[m];
			charArr[m] = charArr[n];
			charArr[n] = temp;
		}
	}
	return String.valueOf(charArr);
}