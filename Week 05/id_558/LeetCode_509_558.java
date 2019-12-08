package Week04;

/**
 * @see <a href="509">https://leetcode-cn.com/problems/fibonacci-number/submissions/</a>
 * 斐波那契数
 */
public class LeetCode_509_558 {
    /**
     * 解法：
     * 1、递推
     * 2、递归（递归优化）
     */
    public int fib(int N) {
        return recursion(N, new int[N + 1]);
    }

    public int recursion(int n, int[] cache) {
        if (n <= 1) return n;
        if (cache[n] == 0) cache[n] = recursion(n - 1, cache) + recursion(n - 2, cache);
        return cache[n];
    }
}
