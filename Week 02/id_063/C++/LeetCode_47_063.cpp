/*
思路
跟普通的全排列没本质区别，增强的点在于递归过程中需要判断当前产生的新序列是不是已经产生过的，
如果判断到当前生成的序列已经出现过了，再继续递归下去只可能得到已经出现过的序列，
这种情况进行减枝回溯即可， 只需要保证每一层递归添加的元素数值不重复就可以保证不会产生重复序列
先对序列进行排序，在递归时候就能比较快发现重复， 因为递归时候每一层都是顺序从左到右找新的元素
如果从左到右迭代时候元素数值是有序的，那么只需要维护一个上一次迭代选择的数值，就可以快速知道当前待选择
的元素是不是和前面已经选择过的重复了
 */

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:

    void dfs(vector<vector<int>>& result, vector<int>& choice, vector<int>& path, vector<int>& nums, int cur_level, int max_level) {
        if (cur_level == max_level) {
            result.push_back(path);
            return;
        }

        bool first = true;
        int last_val = 0;
        for (int i = 0; i < choice.size(); i++) {
            if (choice[i] == 0) {
                if ( first || ((!first) && (last_val != nums[i])) ) {
                    choice[i] = 1;
                    path[cur_level] = nums[i];

                    dfs(result, choice, path, nums, cur_level + 1, max_level);

                    choice[i] = 0;
                }

                first = false;
                last_val = nums[i];
            }
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> choice(nums.size());
        vector<int> path(nums.size());

        sort(nums.begin(), nums.end());
        dfs(result, choice, path, nums, 0, nums.size());

        return result;
    }
};