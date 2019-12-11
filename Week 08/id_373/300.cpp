class Solution {
public:
    int lengthOfLIS(vector<int> &nums) {
        int len = nums.size();
        if (len < 2) {
            return len;
        }

        vector<int> dp(len, 1);
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = dp[0];
        for (int k = 1; k < len; ++k) {
            res = max(res, dp[k]);
        }
        return res;
    }
};
