package Week03;

/**
 * @Date 2019/10/30.
 * @see <a href="69">https://leetcode-cn.com/problems/sqrtx/submissions/</a>
 * x 的平方根
 */
public class LeetCode_69_558 {

    /**
     * 注意事项：
     * 1、数值越界  mid = left + ((right - left) / 2)
     *            square = mid * mid
     * 2、二分查找边界处理
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1;
        long right = x;
        while (left <= right) {
            long middle = left + ((right - left) / 2);
            if (middle * middle == x) {
                return (int) middle;
            } else if (middle * middle > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

}
