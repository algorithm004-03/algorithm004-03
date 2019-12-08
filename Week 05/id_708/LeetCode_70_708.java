// 迭代方式
class Solution {
    // f(1) = 1
    // f(2) = 2
    // f(n) = f(n-1) + f(n-2)
    public int climbStairs(int n) {
        if (n <= 1) return n;
        
        int i = 1, j = 2;
        while (n-- > 2) {
            int temp = j;
            j += i;
            i = temp;
        }
        return j;
    }
}

// class Solution {
//     // f(1) = 1
//     // f(2) = 2
//     // f(n) = f(n-1) + f(n-2)
//     public int climbStairs(int n) {
//         int[] dp = new int[n];
//         return _climbStairs(n, 0, dp);
//     }
    
//     // @params i 当前阶数
//     private int _climbStairs(int n, int i, int[] dp) {
//         if (i > n) return 0;
//         if (i == n) return 1;
//         if (dp[i] > 0) return dp[i];
//         dp[i] = _climbStairs(n, i+1, dp) + _climbStairs(n, i+2, dp);
//         return dp[i];
//     }
// }