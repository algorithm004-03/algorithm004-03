//
// Created by Isaac Zhou on 2019-10-26.
//

#include <iostream>
#include <vector>

using namespace std;


class Solution {

private:
    vector <vector<int>> res;

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
    vector <vector<int>> combine(int n, int k) {
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


class Solution2 {
/*
 * This solution is a more optimized one, it removed the unnecessary branches
 * */
private:
    vector <vector<int>> res;

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
        // here's an optimized tweak, no need to go to all the way to n
        // for the current level, there are only k - c.size() positions to be filled
        // hence the stop point is n - (k-c.size()) + 1
        for (int i = start; i <= n - (k-c.size()) + 1; ++i) {
            c.push_back(i);
            // drill down
            genComb(n, k, i + 1, c);
            // reverse and reset for the next recursion
            c.pop_back();
        }
        return;
    }

public:
    vector <vector<int>> combine(int n, int k) {
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
    vector <vector<int>> res = Solution().combine(7, 4);
    for (int i = 0; i < res.size(); ++i) {
        cout << "Solution 1" <<endl;
        for (int j = 0; j < res[i].size(); ++j) {
            cout << res[i][j] << " ";
        }
        cout << endl;
    }

    vector <vector<int>> res = Solution2().combine(7, 4);
    for (int i = 0; i < res.size(); ++i) {
        cout << "Solution 2" <<endl;
        for (int j = 0; j < res[i].size(); ++j) {
            cout << res[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}