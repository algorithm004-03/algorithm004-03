/*
思路
设序列数字个数为n
进行n层递归，每一层从剩余数字中从小到大选择一个数字，去掉选择的数字剩下的数字再进行下一层递归，
递归深度为n时候可以生成一种结果，所有路径遍历完，所有可能的结果也就得到了
 */

#include <vector>
using namespace std;

class Solution {
public:

    void dfs(vector<vector<int>>& result, vector<int>& choice, vector<int>& path, vector<int>& nums, int cur_level, int max_level) {
        if (cur_level == max_level) {
            result.push_back(path);
            return;
        }

        for (int i = 0; i < choice.size(); i++) {
            if (choice[i] == 0) {
                choice[i] = 1;
                path[cur_level] = nums[i];

                dfs(result, choice, path, nums, cur_level + 1, max_level);

                choice[i] = 0;
            }
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> choice(nums.size());
        vector<int> path(nums.size());
        dfs(result, choice, path, nums, 0, nums.size());

        return result;
    }
};