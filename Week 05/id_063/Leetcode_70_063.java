/*
    思路 DP算法解决

    f(n) 表示n个台阶的爬法，可以通过前面的f(n-1) 和 f(n-2)推导出来
    最后一步要么走两步要么走一步，所以有简单递推公式如下
    f(n) = f(n-1) + f(n-2)
*/

public class Solution {
    public int climbStairs(int n) {
        int fn, fn_1, fn_2;

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        fn_1 = 2;
        fn_2 = 1;
        fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }

        return fn;
    }
}
