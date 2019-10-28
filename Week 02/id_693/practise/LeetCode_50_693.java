package id_693.practise;

/**
 * @Desc 50. Pow(x, n)   https://leetcode-cn.com/problems/powx-n/   需要一点数学知识
 * @Auther 李雷(KyLin)
 * @Date 2019/10/27
 */
public class LeetCode_50_693 {
    //暴力：直接0(N)  但是后面n数字越大时间越长 （而且当n=-2147483648 会出现栈超出异常）
    public double myPow(double x, int n) {
        if (n < 0) return 1.0 / myPow(x, -n);
        double temp = 1.0;
        for (int i = 0; i < n; i++) {
            temp = x * temp;
        }
        return temp;
    }

    //分治迭代解法： x^n --> 2^10  -->2^5 --> 2^2 这里少一个就要多一个   （
    public double myPow2(double x, int n) {
        if (n < 0) {
            return 1.0 / fastPow2(x, -n);
            //return fastPow2(1 / x, -n);
        }
        return fastPow2(x, n);
    }

    public double fastPow2(double x, long n) {
        double temp = 1.0;
        for (long i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {//不等于偶数，那就多一个x
                temp = x * temp;
            }
            x *= x;
        }
        return temp;
    }


    //分治递归解法：
    public double myPow3(double x, int n) {
        if (n < 0) {
//          return 1.0 / fastPow2(x, -n);
            return fastPow3(1 / x, -n);
        }
        return fastPow3(x, n);

    }

    public double fastPow3(double x, long n) {
        if (n == 0) return 1.0;
        double temp = fastPow3(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }


    //分治递归解法(代码优化)：
    public double myPow4(double x, int n) {
        return n < 0 ? fastPow4(1 / x, -n) : fastPow4(x, n);

    }

    public double fastPow4(double x, long n) {
        if (n == 0) return 1.0;
        double temp = fastPow4(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    public static void main(String[] args) {
//        System.out.println(new LeetCode_50_693().myPow(2.00000, 10));
//        System.out.println(new LeetCode_50_693().myPow(2.10000, 3));
//        System.out.println(new LeetCode_50_693().myPow(2.00000, -2));
//        System.out.println(new LeetCode_50_693().myPow(0.44528, 0));
//        System.out.println(new LeetCode_50_693().myPow(0.00001, 2147483647));
//
//        System.out.println(new LeetCode_50_693().myPow2(2.00000, 10));
//        System.out.println(new LeetCode_50_693().myPow2(2.10000, 3));
        System.out.println(new LeetCode_50_693().myPow2(2.00000, -2));
//        System.out.println(new LeetCode_50_693().myPow2(0.44528, 0));
//        System.out.println(new LeetCode_50_693().myPow2(0.00001, 2147483647));

//        System.out.println(new LeetCode_50_693().myPow3(2.00000, 10));
//        System.out.println(new LeetCode_50_693().myPow3(2.10000, 3));
//        System.out.println(new LeetCode_50_693().myPow3(2.00000, -2));
//        System.out.println(new LeetCode_50_693().myPow3(0.44528, 0));
//        System.out.println(new LeetCode_50_693().myPow3(0.00001, 2147483647));
//        System.out.println(new LeetCode_50_693().myPow3(1.00000, -2147483648));
//        System.out.println(new LeetCode_50_693().myPow3(2.00000, -2));

//        System.out.println(new LeetCode_50_693().myPow4(2.00000, 10));
//        System.out.println(new LeetCode_50_693().myPow4(2.10000, 3));
//        System.out.println(new LeetCode_50_693().myPow4(2.00000, -2));
//        System.out.println(new LeetCode_50_693().myPow4(0.44528, 0));
//        System.out.println(new LeetCode_50_693().myPow4(0.00001, 2147483647));
//        System.out.println(new LeetCode_50_693().myPow4(1.00000, -2147483648));
//        System.out.println(new LeetCode_50_693().myPow4(2.00000, -2));
    }
}

/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

    示例 1:

    输入: 2.00000, 10
    输出: 1024.00000
    示例 2:

    输入: 2.10000, 3
    输出: 9.26100
    示例 3:

    输入: 2.00000, -2
    输出: 0.25000
    解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

    -100.0 < x < 100.0
    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */