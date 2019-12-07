class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> hash_map;
        int n = nums.size();
        vector<int> result;
        for( int i = 0;i<n;i++) {
            if(hash_map.find(nums[i])==hash_map.end())
                hash_map[target-nums[i]] = i;
            else {
                result.push_back(hash_map[nums[i]]);
                result.push_back(i);
                break;
            }
        }
        return result;
    }
};
