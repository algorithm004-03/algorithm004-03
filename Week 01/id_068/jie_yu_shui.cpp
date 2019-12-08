class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int ans = 0;
        for(int i = 1; i < n-1; ++i) {
            int max_l = 0, max_r = 0;
            for(int j = 0; j <= i; ++j) {
                max_l = max(max_l, height[j]);
            }
            for(int j = i; j < n; ++j) {
                max_r = max(max_r, height[j]);
            }
            ans += (min(max_l, max_r) - height[i]);
        }
        return ans;
    }
};
