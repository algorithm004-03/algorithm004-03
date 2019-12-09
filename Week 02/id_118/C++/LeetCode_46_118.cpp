//
// Created by Isaac Zhou on 2019-10-26.
//

#include <iostream>
#include <vector>
#include <cassert>
#include <unordered_map>

using namespace std;

class Solution {

private:
    // create a vector of vectors to store result
    vector <vector<int>> res;
    // create a helper vector to see if number is already used in permutation
    vector<bool> used;

    // Recursion method
    void genPerm(const <int> &nums, int index, vector<int> &p) {
        // terminator
        if (index == nums.size()) {
            res.push_back(p);
            return;
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (!used[i]) {
                // process the current logic
                // add nums[i] to p only if nums[i] is not used yet
                p.push_back(nums[i]);
                // update used[i] status
                used[i] = true;

                // drill down
                genPerm(nums, index + 1, p);

                // reverse, because we changed the p and used status
                // reset them
                p.pop_back();
                used[i] = false;
            }
        }
    }

public:
    vector <vector<int>> permute(vector<int> &nums) {
        // initialize res with empty
        res.clear();
        // edge case
        if (nums.size() == 0) {
            return res;
        }
        // create a vector p to store solution for each recursion
        vector<int> p;
        // initialize the helper vector used with all false
        used = vector<bool>(nums.size(), false);
        // start recursion
        genPerm(nums, 0, p);
        // return result
        return res;
    }
};

// test function
int main() {
    vector<int> nums = vector < int > {1, 2, 3, 4, 7};
    vector <vector<int>> res = Solution().permute(nums);
    for (int i = 0; i < res.size(); ++i) {
        for (int j = 0; j < res[i].size(); ++j) {
            cout << res[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}