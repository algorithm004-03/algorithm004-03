#include <vector>
#include <string>
#include <stdlib.h>
#include <iostream>
using namespace std;

class Solution {
public:

    void choice2slist(vector<int>& choice, vector<string>& v) {
        char* arr = new char[choice.size()];
        for (int i = 0; i < choice.size(); i++) {
            memset(arr, '.', choice.size() * sizeof(char));
            arr[choice[i]] = 'Q';
            v[i] = string(arr, choice.size());
        }


        delete[] arr;
    }

    void dfs(vector<vector<string>>& result, vector<int>& choice, vector<string>& print_info, int cur_level, int max_level) {
        if (cur_level == max_level) {
            choice2slist(choice, print_info);
            result.push_back(print_info);
        }

        int cur_j;
        for (cur_j = 0; cur_j < max_level; cur_j++) {

            bool conflict = false;
            for (int i = 0; i < cur_level; i++) {
                if (choice[i] == cur_j) {
                    conflict = true;
                    break;
                }

                if (abs(cur_level-i) == abs(cur_j - choice[i])) {
                    conflict = true;
                    break;
                }
            }

            if (conflict) {
                continue;
            }

            choice[cur_level] = cur_j;
            dfs(result, choice, print_info, cur_level + 1, max_level);
        }

    }

    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> v;
        vector<int> choice(n);
        vector<string> print_info(n);
        dfs(v, choice, print_info, 0, n);

        return v;
    }
};