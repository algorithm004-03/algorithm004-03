//69. x的平方根

//解法1：二分法
//思路：根据"一个数的平方根不大于其本身的一半"可以得知 x 的平方根位于0 ~ x/2 + 1之间, 因此只需要对该区间进行二分查找
//		若mid*mid > x, 则认为x的平方根位于mid右半部分,
//		若mid*mid <= x, 则认为x的平方根位于mid本身及其左半部分
//		当left >= right, 循环结束, 此时的left即为 x 的平方根
//时间复杂度O(logN)
//空间复杂度O(1)
//总结：要注意很多边界条件的判断, 该题很容易理解, 也很容易写错
public int mySqrt(int x) {
	long left = 0;
	long right = x/2 + 1;
	while (left < right) {
		long mid = (left + right + 1)/2;
		if (mid * mid > x) {
			right = mid - 1;
		} else {
			left = mid;
		}
	}
	return (int)left;
}

//解法2：牛顿迭代
//思路：不断迭代执行公式, 获取结果
//空间复杂度O(1)
//总结：基于数学公式实现, 背下该迭代公式即可：[X0 + (a/X0)]/2 , 因为效率非常高, 现实工程场景中, 涉及到根号计算也一般都采用牛顿迭代法。
public int mySqrt2(int x) {
	long num = x;
	while (num * num > x) {
		num = (num + x/num)/2;
	}
	return (int)num;
}




