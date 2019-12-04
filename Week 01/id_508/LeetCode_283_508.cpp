class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int slow = 0;
        for(auto i:nums) {
            if(i!=0) {
                nums[slow++] = i;
            }
        }
        while(slow<nums.size()) {
            nums[slow++] = 0;
        }
    }
};
