/*


dp 递推实现， 可以吧时间复杂度缩减到O(N)

假设递推从左往右进行，每一个数如果把它最左边的1去掉，那么剩下的数对应的1的个数已经计算出来了
且当前这个数的1个数就是剩下那个数1个数加1

 */


class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        int cnt = 1, i = 1;
        while (i <= num) {
            for (int j = 0; j < cnt && i <= num; j++) {
                dp[i] = dp[i - cnt] + 1; i++;
            }

            cnt = cnt << 1;
        }

        return dp;
    }
}
