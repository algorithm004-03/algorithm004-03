//125. 验证回文串

//解法1：暴力	执行用时：6ms
//思路：
public boolean isPalindrome(String s) {
	s = s.toLowerCase();
	char[] charArr = s.toCharArray();
	int i = 0;
	int j = charArr.length - 1;
	while (i < j) {
		while (i < j && !((charArr[i] >= '0' && charArr[i] <= '9') || (charArr[i] >= 'a' && charArr[i] <= 'z'))){
			i++;
		}
		while (i < j && !((charArr[j] >= '0' && charArr[j] <= '9') || (charArr[j] >= 'a' && charArr[j] <= 'z'))) {
			j--;
		}
		if (charArr[i++] != charArr[j--]) {
			return false;
		}
	}
	return true;
}