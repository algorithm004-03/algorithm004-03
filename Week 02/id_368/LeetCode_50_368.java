public class LeetCode_50_368 {

    /*实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    https://leetcode-cn.com/problems/powx-n/*/

    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return pow(x, n);
    }

    public double pow (double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = pow(x, n/2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
