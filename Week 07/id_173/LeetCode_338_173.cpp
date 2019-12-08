/*
 * 338. 比特位计数
 */

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> dp(num+1, 0);

        for(int n=1; n<=num; ++n) {
            dp[n] = dp[n>>1] + (n&1);
        }

        return dp;
    }
};