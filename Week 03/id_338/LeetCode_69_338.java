/**
 * Created by leesen on 2019/10/31.
 */
public class LeetCode_69_338 {
    //时间复杂度：O(logN)，二分法的时间复杂度是对数级别的
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        long left = 1, right = x;  //****left最小取1,而不是下标值0, 防止乘法溢出定义long类型
        while (left <= right) {  //****因为舍弃小数,所以要<=
            long mid = left + (right - left) / 2;

            if (mid * mid > x) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return (int)right;  //类型转换下
    }

    //牛顿迭代法,
    public int mySqrt1(int x) {
        long r = x;
        while (r*r > x) {
            r = (r + x/r) /2;
        }
        return (int)r;
    }
}
