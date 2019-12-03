/*
 * @lc app=leetcode.cn id=547 lang=cpp
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
private:
    int count = 0;
    vector<int> parent;
    void init(int n) {
        count = n;
        parent.resize(count + 1);
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }

    int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    void _union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;
            count--;
        }
    }

public:
    int findCircleNum(vector<vector<int>>& M) {
        parent.clear();
        int n = M.size();
        init(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1)
                    _union(i, j);
            }
        }
        return count;
    }
};
// @lc code=end

