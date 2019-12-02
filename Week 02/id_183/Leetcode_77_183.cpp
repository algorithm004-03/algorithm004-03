/*
 * @lc app=leetcode id=77 lang=cpp
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
private:
    vector<vector<int>> res;

    void dfs(int n, int k, int start, vector<int> &path) {
        if (path.size() == k) {
            res.push_back(path);
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; ++i) {
            path.push_back(i);
            dfs(n, k, i + 1, path);
            path.pop_back();

        }
    }

public:
    vector<vector<int>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        vector<int> path;
        dfs(n, k, 1, path);
        return res;
    }
};
// @lc code=end

