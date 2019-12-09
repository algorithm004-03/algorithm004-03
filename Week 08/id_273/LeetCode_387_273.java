//387. 字符串中的第一个唯一字符

//解法1：HashMap(数组)	执行用时：5ms
//思路：创建一个count数组用于记录字符串中每个字符出现的次数, 遍历字符串, 观察每一个字符对应count数组中的值是否为1
//时间复杂度：O(N)
//空间复杂度：O(N)
//总结：之所以转换字符数组是因为这样比起直接操作String更加高效
public int firstUniqChar(String s) {
	if (s == null || s.length() == 0) return -1;
	char[] temp = s.toCharArray();
	int[] count = new int[26];
	for (char c : temp) {
		count[c - 'a']++;
	}
	for (int i = 0; i < temp.length; i++) {
		if (count[temp[i] - 'a'] == 1) return i;
	}
	return -1;
}


//解法2：API		执行用时：25ms
//思路：遍历字符, 若当前字符‘c’与从后往前寻找到的字符‘c’index相同, 说明它是唯一字符
//时间复杂度：O(n^2) 
//空间复杂度：O(n)
public int firstUniqChar(String s) {
	char[] arr = s.toCharArray();
	for (int i = 0; i < s.length(); i++) {
		if (s.indexOf(arr[i]) == s.lastIndexOf(arr[i])) return i;
	}
	return -1;
}