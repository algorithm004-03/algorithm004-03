class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int cache=INT_MAX,left_valid=0,right=0;
        int n = nums.size();
        while(right<n) {
            if((nums[right])!=cache) {
                cache = nums[right++];
                nums[left_valid++] = cache;
            } else right++;
        }
        return left_valid;
    }
};
