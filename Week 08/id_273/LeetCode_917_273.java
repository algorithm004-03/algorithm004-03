//917. 仅仅反转字母

//解法1：暴力解法		执行用时：1ms
//思路：
public String reverseOnlyLetters(String S) {
	char[] arr = S.toCharArray();
	int i = 0, j = S.length() - 1;
	while (i < j) {
		while (i < j && !((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z'))) i++;
		while (i < j && !((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= 'A' && arr[j] <= 'Z'))) j--;
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		i++;
		j--;
	}
	return String.valueOf(arr);
}