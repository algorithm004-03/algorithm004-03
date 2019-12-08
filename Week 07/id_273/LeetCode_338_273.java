//338. 比特位计数

//解法1：循环计数法		执行用时：3ms
//思路：遍历0 ~ n, 分别对各个数锁包含的1进行计数, 计数的方法可以参考191题
//时间复杂度：O(n * sizeOf(i))
//空间复杂度：O(n)
public int[] countBits(int num) {
	int[] res = new int[num + 1];
	for (int i = 1; i <= num; i++) {
		res[i] = countOne(i);
	}
	return res;
}

private int countOne(int i) {
	int count = 0;
	while (i != 0) {
		i = i & (i - 1);
		count++;
	}
	return count;
}

//解法2：动态规划		执行用时：1ms
//思路：递归公式：res[i] = res[i >> 1] + res[i & 1]
//		例如1001, 它的1的个数 = 前3位"100"所包含的1的个数 + 最后一位0或1所包含的1的个数
public int[] countBits(int num) {
	if (num == 0) return new int[]{0};
	int[] res = new int[num + 1];
	res[1] = 1;
	for (int i = 2; i <= num; i++) {
		res[i] = res[i >> 1] + res[i & 1];
	}
	return res;
}