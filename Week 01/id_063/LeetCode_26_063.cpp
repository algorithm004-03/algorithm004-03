#include <vector>
using namespace std;


class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }

        int curIdx = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] != nums[curIdx-1]) {
                nums[curIdx++] = nums[i];
            }
        }

        return curIdx;
    }
};