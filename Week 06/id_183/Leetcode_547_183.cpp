/*
 * @lc app=leetcode id=547 lang=cpp
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
public:
    
    int rank[300];
    int p[300];
    int count;
    
    int find(int n) {
        while (p[n] != n) {
            n = p[n];
        }
        return p[n];
    }
    
    void unionN(int n1, int n2) {
        int np1 = find(n1);
        int np2 = find(n2);
        if (np1 == np2) return;
        if (rank[np1] > rank[np2]) {
            p[np2] = np1;
        } else {
            p[np1] = np2;
            rank[np2]++;
        }
        count--;
    }
    
    
    int findCircleNum(vector<vector<int>>& M) {
        int N = M.size();
        count = N;
        for (int i=0; i<N; i++) {
            p[i] = i;
            rank[i] = 1;
        }
        
        
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (M[i][j] == 1) {
                    unionN(i, j);
                }
            }
        }
        return count;
    }
};

// @lc code=end

