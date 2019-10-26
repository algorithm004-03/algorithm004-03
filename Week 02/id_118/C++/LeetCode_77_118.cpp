//
// Created by Isaac Zhou on 2019-10-26.
//

#include <iostream>
#include <vector>

using namespace std;


class Solution {

private:
    vector<vector<int>> res;

    // To solve C(n,k)
    // c stores the current solution
    // start to begin searching new element
    void genComb(int n, int k, int start, vector<int> &c) {
        // terminator
        if (c.size() == k) {
            res.push_back(c);
            return;
        }
        // process the current level
        for (int i = start; i <= n; ++i) {
            c.push_back(i);
            // drill down
            genComb(n, k, i + 1, c);
            // reverse and reset for the next recursion
            c.pop_back();
        }
        return;
    }

public:
    vector<vector<int>> combine(int n, int k) {
        res.clear();
        //edge cases: meaningless cases
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        vector<int> c;
        genComb(n, k, 1, c);
        return res;
    }
};

int main() {
    vector<vector<int>> res = Solution().combine(7, 4);
    for (int i = 0; i < res.size(); ++i) {
        for (int j = 0; j < res[i].size(); ++j) {
            cout << res[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}