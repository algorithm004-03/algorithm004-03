package leetcode.week2;

/**
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author eason.feng at 2019/10/27/0027 14:02
 **/
public class LeetCode_50_218 {

    public static void main(String[] args) {
        LeetCode_50_218 leetCode_50_218 = new LeetCode_50_218();
        double result = leetCode_50_218.myPow(10.0, 2);
        System.out.println(result);
    }
    public double myPow(double x, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return x;
        }

        double half = this.myPow(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        }
        else {
            return half * half;
        }
    }

    public double myPowBruceForce(double x, int n) {
        double res = 1.0;
        for (int i = 1; i <= n; i++) {
            res = res * x;
        }
        return res;
    }
}
