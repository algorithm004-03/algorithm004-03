/**
 * x的平方根
 * @author L
 *
 */
public class LeetCode_69_138 {
	/**
	 * 牛顿迭代法: r = (r+x/r)/2
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
        if(x==0)
        	return 0;
        long a = x;
        while(a*a>x) {
        	a = (a+x/a)/2;
        }
        return (int)a;
    }
	
	/**
	 *   二分法
	 * @param x
	 * @return
	 */
	public int mySqut2(int x) {
		long left = 0;
		long right = Integer.MAX_VALUE;
		while(left<right) {
			long mid = (left+right+1)>>>1;//无符号右移1即/2 取中间值
			long square = mid*mid;
			if(square > x) {
				right = mid-1;//向左收敛
			}else {
				left = mid;//向右收敛
			}
		}
		return (int)left;
	}
}
