class Solution {
public:
    bool canJump(vector<int>& nums) {
        int N = nums.size();
        int stop = N-1;
        int cur = stop-1;
        while(cur>=0) {
            if((stop - cur)<=nums[cur])
                stop = cur;
            cur--;
        }
        return stop==0?true:false;
    }
};
