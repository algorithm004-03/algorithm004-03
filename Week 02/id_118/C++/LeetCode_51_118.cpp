//
// Created by Isaac Zhou on 2019-10-27.
//

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class Solution {
private:
    // res stores the result
    vector<vector<string>> res;

    // create 3 vectors to check conflicts on all 3 directions
    // check conflict on col
    vector<bool> col;
    // check conflict on diagonal 1
    vector<bool> dia1;
    // check conflict on diagonal 2
    vector<bool> dia2;

    // curr_level, current recursion level, a.k.a current row index
    // n, number of Queens
    // for curr_index, the
    // row stores the Queen's position e.g. row[x]=y means on row x,
    // Q is placed at col y
    void genQueen(int curr_level, int n, vector<int> &row) {
        // step 1: Terminator
        if (curr_level == n) {
            // genBoard will print out based on the shape of a chess board
            res.push_back(genBoard(n, row));
            return;
        }

        // step 2: Process the current level logic
        for (int i = 0; i < n; ++i) {
            // try place curr_level row's Queen on col i
            // if col[i] is false, then there's no conflict on horizontally
            // for dia1, (curr_level, i) check curr_level + i, then there's no conflict on dia1
            // for dia2, (curr_level, i) check curr_level - i + (n - 1), then there's no conflict on dia2
            // for dia2, the reason use curr_level-i + (n-1) is to avoid negative index for vector
            if (!col[i] && !dia1[curr_level + i] && !dia2[curr_level - i + n - 1]) {
                // if there's no conflict, row[i] can place a queen
                row.push_back(i);
                col[i] = true;
                dia1[curr_level + i] = true;
                dia2[curr_level - i + n - 1] = true;
                // step 3: drill down
                genQueen(curr_level + 1, n, row);

                // step 4: reverse, clean and reset all the variables used on this level of recursion
                // so that they can be used for next level recursion
                row.pop_back();
                col[i] = false;
                dia1[curr_level + i] = false;
                dia2[curr_level - i + n - 1] = false;
            }
        }
        // return from the recursion
        return;
    }

    // genBoard to print out based on the board shape
    static vector<string> genBoard(int n, vector<int> &row) {
        assert(row.size() == n);
        vector<string> res_board(n, string(n, '.'));
        for (int i = 0; i < n; ++i) {
            res_board[i][row[i]] = 'Q';
        }
        return res_board;
    }

public:
    vector<vector<string>> solveNQueens(int n) {
        // initiate res
        res.clear();
        // edge case if n == 1, return {{"Q"}}
        if (n == 1) {
            return vector<vector<string>>{{"Q"}};
        }
        // edge cases, if n < 4 and n != 1, there's no solution
        if (n < 4 && n != 1) {
            return res;
        }
        // row to store Queen's position for the current level
        vector<int> row;

        // initialize the col conflict vector
        // initially there's no Queen, so no conflict anywhere
        col = vector<bool>(n, false);
        // there are 2n - 1 diagonals for each direction
        dia1 = vector<bool>(2 * n - 1, false);
        dia2 = vector<bool>(2 * n - 1, false);

        // call the Recursion
        genQueen(0, n, row);
        return res;
    }
};

int main() {
    int n = 4;
    vector<vector<string>> res = Solution().solveNQueens(n);
    for (int i = 0; i < res.size(); ++i) {
        cout << "Solution : " << i + 1 << endl;
        for (int j = 0; j < n; ++j) {
            cout << res[i][j] << endl;
        }
        cout << "------------------" << endl;
    }
    return 0;
}