
/**
 * 69. x 的平方根
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 四步刷题法：
 * 1. clarification
 * 计算并返回 x 的平方根，其中 x 是非负整数。只保留整数部分，也就是我们精确到整数位即可
 * 2. possible solution -> optimal(space / time)
 * 穷尽，几乎不可能（时间复杂度太高了）；二分查找不断逼近 log n；牛顿迭代法
 * 3. code
 * 4. test case
 *
 * @author jaryoung
 * @version 1.0 基本解法都是根据别人的方法改造而来，还需要多加练习
 */
public class LeetCode_69_593 {

    /**
     * 计算并返回 x 的平方根
     *
     * @param x 待开平方根的数据
     * @return x 的平方根
     */
    public int mySqrtByBinarySearch(int x) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        while (left < right) {
            long mid = (right + left + 1) >>> 1;
            long squareMid = mid * mid;
            if (squareMid == x) {
                return (int) mid;
            }
            if (squareMid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }


    public int mySqrtByNewtonIteration(int x) {
        double x0 = 1;
        double pre;
        while (true) {
            pre = x0;
            x0 = (x0 + x / x0) / 2;
            if (Math.abs(x0 - pre) < 1e-6) {
                return (int) x0;
            }
        }
    }

    public int mySqrtByNewtonIterationSecond(int x) {
        long x0 = x;
        while (x0 * x0 > x) {
            x0 = (x0 + x / x0) / 2;
        }
        return (int) x0;
    }

    public int mySqrtByNewtonIterationRecursion(int x) {
        if (x == 0) {
            return x;
        }
        return (int) (sqrt(x, x));
    }

    private double sqrt(double x, int a) {
        double result = (x + a / x) / 2;
        if (result - x == 0) {
            System.out.println("result _" + result + " x:" + x + " a " + a);
            return result;
        } else {
            return sqrt(result, a);
        }
    }

    public double mySqrtByBinarySearch(int x, int decimal) {
        Assert.that(decimal < 9, "The sqrt only support decimal < 9.");
        Assert.that(x < Integer.MAX_VALUE, "The sqrt only support decimal < Integer.MAX_VALUE.");
        if (Math.abs(x) == 0 || Math.abs(x) == 1) {
            return x;
        }
        double add = 1.0 / Math.pow(10, Math.min(decimal + 4, 16));
        double left = 0;
        double right = x;
        while (left < right) {
            double mid = left + (right - left + add) / 2.000;
            double squareMid = mid * mid;
            if (squareMid - x == 0) {
                BigDecimal bigDecimal = new BigDecimal(mid);
                return bigDecimal.setScale(decimal, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            if (squareMid < x) {
                left = mid + add;
            } else {
                right = mid - add;
            }
        }
        BigDecimal bigDecimal = new BigDecimal(left);
        return bigDecimal.setScale(decimal, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


}