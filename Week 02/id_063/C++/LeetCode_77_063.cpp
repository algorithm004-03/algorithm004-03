/*
思路
递归算法练习
进行1层到n层的递归，每一层递归选择当前层对应的数字是否选择，当选择是的层数总和达到k时候生成一个结果并且进行回溯
*/

#include <vector>
using namespace std;

class Solution {
public:

    void dfs(vector<vector<int>>& result, vector<bool>& choice, int choice_num, int target_choice_num, int cur_level, int max_level) {
        if (cur_level == max_level) {
            return;
        }

        choice[cur_level] = false;
        dfs(result, choice, choice_num, target_choice_num, cur_level + 1, max_level);

        choice[cur_level] = true;
        if (choice_num+1 == target_choice_num) {
            vector<int> v;
            for (int i = 0; i <= cur_level; i++) {
                if (choice[i]) {
                    v.push_back(i+1);
                }
            }
            result.push_back(v);
        } else {
            dfs(result, choice, choice_num + 1, target_choice_num, cur_level + 1, max_level);
        }
    }

    vector<vector<int>> combine(int n, int k) {
        vector<bool> choice(n);
        vector<vector<int>> v;

        if (k == 0) {
            return v;
        }

        dfs(v, choice, 0, k, 0, n);
        return v;
    }
};