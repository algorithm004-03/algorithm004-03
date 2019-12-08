class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1.0;
        double cur = x;
        for (int i = n; i > 0; i /= 2) {
            if (i % 2 == 1) {
                result = result * cur;
            }
            cur = cur * cur;
        }
        return result;
    }

    
    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        double result = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return result * result;
        }else {
            return result * result * x;
        }
    }
}