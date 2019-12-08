//709. 转换成小写字母

//解法1：ASCII码计算		执行用时：0ms
//思路：遍历所有字符, 如果它属于大写字符, 那么就加上小写字符与大写字符的ASCII码的差值
//时间复杂度：O(n)
//空间复杂度：O(n)
//总结：需要记住的是小写字符的ASCII码大于大写字符的ASCII码
public String toLowerCase(String str) {
	char[] temp = str.toCharArray();
	for (int i = 0; i < temp.length; i++) {
		if (temp[i] >= 'A' && temp[i] <= 'Z') {
			temp[i] += ('a' - 'A');
		}
	}
	return String.valueOf(temp);
}

//解法2：调用API	执行用时：0ms
public String toLowerCase(String str) {
	return str.toLowerCase();
}