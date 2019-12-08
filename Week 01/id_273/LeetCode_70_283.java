//70. 爬楼梯

//通过规律可知该题的结果为斐波那契数列

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

//解法2：动态规划
//思路：寻找重复子问题,N1=1,N2=2,N3=N1+N2,N4=N3+N2...,可以将计算过程转换为数组迭代
//		但目前还并不了解什么是动态规划...
//时间复杂度O(n)
//总结：观察重复子问题
public int climbStairs(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	if (n == 2) return 2;
	int[] temp = new int[n];
	temp[0] = 1;
	temp[1] = 2;
	
	for (int i = 2; i<n; i++) {
		temp[i] = temp[i-1] + temp[i-2];
	}
	return temp[n-1];
}

//解法3：记忆化递归
//思路：把每一次递归的值在数组中缓存，最后返回数组中的第一个数即是结果
//时间复杂度O(n)
//空间复杂度O(n)
//总结：递归的优化手段也可以通过缓存...还是动态规划比较好理解,简单快速 
class Solution {
    public static int climbStairs(int n) {
        int temp[] = new int[n-1];
        return climb(n, n, temp);
    }

    private static int climb(int k, int n, int temp[]) {
        if (k == 0) return 1;
        if (k == 1) return 1;
        if (temp[n-k] > 0) return temp[n-k];
        temp[n-k] = climb(k-1, n, temp) + climb(k-2, n, temp);
        return temp[n-k];
    }
}
