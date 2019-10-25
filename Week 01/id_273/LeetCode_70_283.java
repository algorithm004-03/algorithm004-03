//通过规律可知该题的结果为斐波那契数列

//尝试过采用最捞的递归解决 发现栈内存溢出
//时间复杂度O(2^n) 
public static int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		return climbStairs(n-1)+climbStairs(n-2);
}

//解法1 