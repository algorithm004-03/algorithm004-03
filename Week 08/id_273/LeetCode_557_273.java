//557. 反转字符串中的单词III

//解法1：		执行用时：5ms
//思路：
public String reverseWords(String s) {
	char[] arr = s.toCharArray();
	int startIdx = 0;
	int endIdx = 0;
	while (endIdx < s.length()) {
		endIdx = startIdx;
		while (endIdx < s.length() && arr[endIdx] != ' ') {
			endIdx++;
		}
		reverse(arr, startIdx, endIdx - 1);
		startIdx = endIdx + 1;
	}
	return String.valueOf(arr);
}

private void reverse(char[] arr, int startIdx, int endIdx) {
	for (int i = startIdx, j = endIdx; i < j; i++, j--) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
}