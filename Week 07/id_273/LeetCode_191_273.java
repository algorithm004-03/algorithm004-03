//191. 位1的个数

//解法1：lowBit公式		执行用时：1ms
//思路：通过x & (-x)能够获取到x最低位的1, 不断减去x的最低位1, 并记录减去的次数, 直到x = 0
//时间复杂度：O(1) 因为最坏情况下也就只有32次计算
//空间复杂度：O(1)
//总结：获取最低位1公式：x & (-x)
public int hammingWeight(int n) {
	int count = 0;
	while (n != 0) {
		count++;
		int lowBit = n & (-n);
		n -= lowBit;
	}
	return count;
}

//解法2：按位&		执行用时：1ms
//思路：从x的最低位开始, 进行按位&操作, 
//		例如： i == 1  n = 1011  n&1 = 0001		
//			   i == 2  n = 1011  n&10 = 0010	
//			   i == 3  n = 1011  n&100 = 0 	该位不存在1
//			   i == 4  n = 1011  n&1000 = 1000	
public int hammingWeight(int n) {
	int count = 0;
	int mask = 1;
	for (int i = 0; i < 32; i++) {
		if ((n & mask) != 0) count++;
		mask <<= 1;
	}
	return count;
}

//解法3：按位&优化		执行用时：1ms
//思路：二进制中, x中的最低位1所在的位置在(x - 1)中总是0,
//		那么只需要进行x & (x - 1)就能够获得x抹去最低位1的二进制数
//		循环操作并记录抹去最低位1的次数, 直到x == 0
//总结：清零最低位1公式：x & (x - 1)
public int hammingWeight(int n) {
	int count = 0;
	while (n != 0) {
		count++;
		n &= (n - 1);
	}
	return count;
}


//解法4：余数判断	执行超时
//思路：判断x % 2 == 1 ？ 若true, 说明当前x存在1, x减去1后右移一位继续计算, 直到x == 0
//总结：x % 2 等同于 x & 1
//		x / 2 等同于 x >> 1
public int hammingWeight(int n) {
	int count = 0;
	while (n != 0) {
		if ((n & 1) != 0) { //x % 2 != 0
			n -= 1;
			count++;
		}
		n >>= 1;
	}
	return count;
}