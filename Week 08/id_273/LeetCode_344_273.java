//344. 反转字符串

//解法1：	执行用时：1ms
//思路：
public void reverseString(char[] s) {
	for (int i = 0, j = s.length - 1; i < j; i++, j--) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
}