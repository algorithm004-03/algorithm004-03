//66. 加一

//解法1：数组遍历
//思路：从个位的位置开始遍历数组, ++后%10若结果不等于0说明未进位, 直接返回结果即可,
//		若直到最高位取余的结果还等于0, 说明最高位一定进位, 该情况下数组中所有元素为0
//		返回一个新数组长度为源数组+1, 最高位array[0] = 1即可
//时间复杂度O(1)
//空间复杂度O(n)
//总结：重点关注需要重复做的事情, 该题的重复操作就是 + 1,然后判断是否需要进位
public int[] plusOne(int[] digits) {
	for(int i = digits.length - 1; i >= 0; i--) {
		if (++digits[i] % 10 != 0) return digits;
		digits[i] = 0;
	}
	digits = new int[digits.length + 1];
	digits[0] = 1;
	return digits;
}