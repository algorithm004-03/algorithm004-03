/*
 * @lc app=leetcode id=300 lang=cpp
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
public:
    int lengthOfLIS(vector<int> &nums) {
        int len = nums.size();
        if (len < 2) {
            return len;
        }

        vector<int> tail;
        tail.push_back(nums[0]);
        // tail 结尾的那个索引
        int end = 0;

        for (int i = 1; i < len; ++i) {
            if (nums[i] > tail[end]) {
                tail.push_back(nums[i]);
                end++;
            } else {
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        return end + 1;
    }
};



// @lc code=end

