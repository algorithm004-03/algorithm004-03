/*
从左到右迭代数组中元素，每一个元素迭代时候判断已经迭代的元素中有没有匹配的
判断是否匹配需要额外的哈希结构缓存已经迭代过的元素的数值和下标

向Hash中插入数值或者是触发了Rehash会带来一定开销，严格讲时间复杂度比O(n)高
 */


#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> val2idx(nums.size());

        val2idx[nums[0]] = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (val2idx.find(target - nums[i]) != val2idx.end()) {
                return vector<int> { val2idx[target - nums[i]], i };
            }

            val2idx[nums[i]] = i;
        }

        return vector<int> { 0, 0 };
    }
};