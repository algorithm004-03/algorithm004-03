//151. 翻转字符串里的单词

//解法1：	执行用时：3ms
//思路：
public String reverseWords(String s) {
	char[] charArr = s.toCharArray();
	//reverse whole string
	reverse(charArr, 0, charArr.length - 1);
	int startIdx= 0;
	int endIdx = 0;
	while (startIdx < charArr.length) {
		startIdx = endIdx;
		while (startIdx < charArr.length && charArr[startIdx] == ' ') {
			startIdx++;
		}
		endIdx = startIdx;
		while (endIdx < charArr.length && charArr[endIdx] != ' ') {
			endIdx++;
		}
		reverse(charArr, startIdx, endIdx - 1);
	}
	return cleanBank(charArr);
}

private char[] reverse(char[] charArr, int start, int end) {
	for (int i = start, j = end; i < j; i++, j--) {
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
	}
	return charArr;
}

private String cleanBank(char[] charArr) {
	int i = 0, j = 0;
	while (j < charArr.length) {
		while (j < charArr.length && charArr[j] == ' ') {
			j++;
		}
		while (j < charArr.length && charArr[j] != ' ') {
			charArr[i++] = charArr[j++];
		}
		while (j < charArr.length && charArr[j] == ' ') {
			j++;
		}
		if (j < charArr.length) {
			charArr[i++] = ' ';
		}
	}
	return new String(charArr).substring(0, i);
}