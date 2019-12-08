//Pow(x, n)

//解法1：分治递归	执行用时击败约99%
//思路：考虑两种情况：n为奇数/n为偶数
//			若n为奇数, 递归(x*x, n/2)还需要补乘一个x
//			若n为偶数, 递归(x*x, n/2)
//时间复杂度：O(logN)
//空间复杂度：O(logN)
//总结：相比起暴力解法n有多少就需要计算N次, 分治递归每次计算后n减半, 只需要计算logn次
public double myPow(double x, int n) {
	if (x == -1) {
		if ((n & 1) == 0) return 1;
		else return -1;
	}
	if (n > 0) return recur(x, n);
	else return 1/recur(x, n);
}

private double recur(double x, int n) {
	if (n == 0) return 1;
	if (n % 2 == 0) return recur(x*x, n/2);
	else return recur(x*x, n/2)*x;
}