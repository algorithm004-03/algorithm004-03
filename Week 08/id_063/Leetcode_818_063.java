/*

Dp 递推

DP策略有点怪异

首先将位置一路A移动到离终点最近的位置，要么在终点左边，要么在终点右边
在终点左边时候，可能需要倒退k步然后再前进

假设target + 1 大于 m = 2^(n-1) 但是小于M = 2^(n)

dp(i)表示到i位置最少的操作个数

第一次一路A先走到左侧的情况下：
    steps1 = min { (n-1)   +   1   +     k           +   1  +   dp(target - [(2^(n-1) - 1) - (2^k-1)] ) }
             前n-1步   反向R一步   反向A k步       反向1步               子问题步数

    其中需要保证 k < n-1,  否则位置又回到一开始地方，没有意义

第一次一路A走到右侧的情况:
    直接掉头走，处理一个子问题即可

    steps2 =   n   +  1  +        dp(2^n - 1 - target)
             n个A   掉头一个R          子问题步数

 */


class Solution {

    private int[] dp;

    private boolean isPowSub1(int val) {
        val += 1;
        return ((val & (val - 1)) == 0);
    }

    private int getPowNum(int val) {
        val += 1;
        int pow = 0;
        while (val != 0) {
            pow++;
            val >>= 1;
        }

        return pow - 1;
    }

    private int solve(int target) {
        //System.out.println(target);

        if (target == 0 || dp[target] != 0) {
            return dp[target];
        }

        if (isPowSub1(target)) {
            dp[target] = getPowNum(target);
            return dp[target];
        }

        int rBound = 1;
        while (true) {
            if ((1<<rBound) - 1 > target)
                break;
            rBound++;
        }

        dp[target] = rBound + 1  + solve((1 << rBound) - 1 - target);
        for (int k = 0; k < rBound - 1; k++) {
            dp[target] = Math.min(dp[target], (rBound-1) + 1 + k + 1 + solve(target - (((1<<(rBound-1)) - 1) - ((1<<k)-1)) ));
        }

        return dp[target];
    }


    public int racecar(int target) {
        dp = new int[target + 1];
        return solve(target);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().racecar(2000));
    }
}
