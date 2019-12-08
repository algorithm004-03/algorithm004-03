class Solution {
public:
    int jump(vector<int>& nums) {
        int end=0;
        int cur=0;
        int maxPos = 0;
        int res =0;
        while(cur<nums.size()-1) {
            maxPos = max(maxPos,nums[cur]+cur);

            if(cur == end) {
                res++;
                end = maxPos;
            }
            cur++;
        }
        return res;
    }
};
