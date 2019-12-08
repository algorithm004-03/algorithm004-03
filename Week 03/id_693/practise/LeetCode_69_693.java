package id_693.practise;

import org.junit.Assert;

/**
 * @Desc 69. x 的平方根 https://leetcode-cn.com/problems/sqrtx/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/03
 */
public class LeetCode_69_693 {
    //二分法:  返回left或right 都可以
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1;
        long right = x >> 1;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
                //不要死磕老师的视频上的解法，不然会浪费很多时间，不过也值得了。
                if (left * left > x) {
                    return (int) mid;
                }
            }
        }
        return (int) left;
    }

    //二分法:稍微有点绕，就是为了保证死循环，所以就有右边界+1;保证了mid*mid 肯定大于x
    public int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1;
        long right = (x >> 1) + 1;
        while (left < right) {
            long mid = left + ((right - left + 1) >> 1);
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    //牛顿迭代法
    public int mySqrt3(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + (x / r)) >>> 1;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        Assert.assertEquals(0, new LeetCode_69_693().mySqrt(0));
        Assert.assertEquals(1, new LeetCode_69_693().mySqrt(1));
        Assert.assertEquals(1, new LeetCode_69_693().mySqrt(3));
        Assert.assertEquals(2, new LeetCode_69_693().mySqrt(4));
        Assert.assertEquals(2, new LeetCode_69_693().mySqrt(6));
        Assert.assertEquals(2, new LeetCode_69_693().mySqrt(8));
        Assert.assertEquals(3, new LeetCode_69_693().mySqrt(9));
        Assert.assertEquals(3, new LeetCode_69_693().mySqrt(15));
        Assert.assertEquals(4, new LeetCode_69_693().mySqrt(16));
        Assert.assertEquals(5, new LeetCode_69_693().mySqrt(26));
        Assert.assertEquals(46339, new LeetCode_69_693().mySqrt(2147395599));
    }
}
