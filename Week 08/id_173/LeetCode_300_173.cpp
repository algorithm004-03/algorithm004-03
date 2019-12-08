/*
 * 300. 最长上升子序列
 */

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.empty())
            return 0;

        int end = 0;
        vector<int> temp;
        temp.push_back(nums[0]);

        for(int i=1; i<nums.size(); ++i) {
            if(nums[i] > temp[end]) {
                temp.push_back(nums[i]);
                end++;
            }
            else {
                int left=0, right=end;
                while(left < right) {
                    int mid = ((right-left)>>1) + left;
                    if(temp[mid] < nums[i])
                        left = mid+1;
                    else
                        right = mid;
                }
                temp[left] = nums[i];
            }
        }

        return end+1;
    }
};