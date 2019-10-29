/*
 * 1. 两数之和
 */

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        unordered_map<int, int> hashTable;

        for(int i=0; i<nums.size(); ++i) {
            int diff = target-nums[i];
            if(hashTable.count(diff)) {
                res = {hashTable[diff], i};
                return res;
            }
            hashTable[nums[i]] = i;
        }

        return res;
    }
};