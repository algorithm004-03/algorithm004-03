//8. 字符串转换整数

//解法1：暴力解法	执行用时：2ms
//思路：
//		1. startIdx指向第一个不为空格的字符, 起到trim()的作用
//		2. sign标识正负号, 且只能设置一次sign, 且进行计数后不能再出现正负号, 因此通过一个boolean参数进行记录
//		3. 如果第一个字符不是符号也不是数字, 那么就无法执行有效的转换, 直接break
//		4. 若res在累加途中, 大于Integer的最大/最小值, 那么就直接返回结果
public int myAtoi(String str) {
	if (str.length() == 0) return 0;
	char[] temp = str.toCharArray();
	int sign = 1;
	long res = 0;
	boolean flag = false;
	int startIdx = 0;
	//startIdx指向第一个不为空格的字符
	while (startIdx < str.length() && temp[startIdx] == ' ') {
		startIdx++;
	}
	//从startIdx开始遍历字符串
	for (int i = startIdx; i < temp.length; i++) {
		//如果遍历到的字符不是数字, 那么可能是符号位, 也可能是其他字符串
		if (temp[i] < '0' || temp[i] > '9') {
			if (temp[i] == '+' && !flag) { //设置符号位
				flag = true;
				continue;
			} else if (temp[i] == '-' && !flag) {
				sign = -1;
				flag = true;
				continue;
			} else {//如果是其他字符串, 那么直接break, res累加结束
				break;
			}
		}
		res = res * 10 + (temp[i] - '0');//累加res
		flag = true;//如果未设置符号位, 那么默认是为正数的, 此时如果累加途中遇到了符号位, 我们不能让它影响到此时累加的结果, 因此此处设置了flag=true
		if (res > Integer.MAX_VALUE) {
			if (sign == 1) return Integer.MAX_VALUE;
			else return Integer.MIN_VALUE;
		}
	}
	return (int)(res * sign);
}