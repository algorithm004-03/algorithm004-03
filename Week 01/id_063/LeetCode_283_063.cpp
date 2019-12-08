#include <vector>
using namespace std;

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int idx_store = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i]) {
                nums[idx_store++] = nums[i];
            }
        }

        fill(nums.begin() + idx_store, nums.end(), 0);
    }
};