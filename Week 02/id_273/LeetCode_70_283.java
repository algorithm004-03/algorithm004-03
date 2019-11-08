//70. 爬楼梯

//通过规律可知该题的结果为斐波那契数列
//假设n = 1 ,只能选择跨一步,F(1) = 1
//	  n = 2 ,则只可能从台阶1跨1步,或者直接跨2步 F(2) = 2 
//	  n = 3 ,则只可能从台阶1跨2步,或者从台阶2跨1步 F(3) = F(2) + F(1)
//	  n = 4 ,则只可能从台阶2跨2步,或者从台阶3跨1步 F(4) = F(3) + F(2)
//	  ....	

//解法1：斐波那契数列递归
//思路：...
//时间复杂度O(2^n)
//总结：提交未通过,该方式也不必考虑了,且面试遇到斐波那契千万不能采用该递归方式 
public static int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		return climbStairs(n-1) + climbStairs(n-2);
}

//解法2：动态规划		执行用时击败100%
//思路：寻找重复子问题, F(3) = F(2) + F(1); F(4) = F(3) + F(2), 因此可以把每次的运算结果存储到数组
//时间复杂度O(n)
//空间复杂度O(n)
//总结：动态规划的方法需要寻找到程序运行的重复性, 方法如其名, 归纳程序动态运行的规律, 用更简单的方法解决问题。
public int climbStairs(int n) {
	if (n == 0 || n == 1 || n == 2) return n;
	int[] dp = new int[n];
	dp[0] = 1;
	dp[1] = 2;
	for (int i = 2; i < n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}
	return dp[n - 1];
}

//解法2.1 动态规划优化		执行用时击败100%
//思路：由于动态规划方法每次都只需要操作三个变量, 因此将数组赋值操作简化为变量之间的赋值操作
//时间复杂度O(n)
//空间复杂度O(1)
public int climbStairs(int n) {
	if (n == 0 || n == 1 || n == 2) return n;
	int temp1 = 1;
	int temp2 = 2;
	int result = 0;
	for (int i = 2; i < n; i++) {
		result = temp1 + temp2;
		temp1 = temp2;
		temp2 = result;
	}
	return result;
}

//解法3：记忆化递归		执行用时击败100%
//思路：把每一次递归的值在数组中缓存，最后返回数组中的第一个数即是结果
//时间复杂度O(n)
//空间复杂度O(n)
//总结：递归的优化手段也可以通过缓存...还是动态规划比较好理解,简单快速 
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int[] temp = new int[n - 2];
        return recur(n, n, temp);
    }

    private int recur(int n, int k, int[] temp) {
        if (k == 1 || k == 2) return k;
        else if (temp[n - k] != 0) return temp[n - k];
        else return temp[n - k] = recur(n, k - 1, temp) + recur(n, k - 2, temp);
    }
}
