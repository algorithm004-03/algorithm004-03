// dp solution
class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        return _climbStairs(n, cache);
    }

    private int _climbStairs(int n, int[] cache) {
        if (n <= 2) return n;
        if (cache[n] != 0) return cache[n];
        cache[n] = _climbStairs(n-1, cache) + _climbStairs(n-2, cache);
        return cache[n];
    }
}