/*
 * 547. 朋友圈
 */

class UnionFind {
private:
    vector<int> parent;
    int count = 0;

public:
    UnionFind(int n) {
        count = n;
        parent = vector<int>(n, 0);
        for(int i=0; i<n; ++i)
            parent[i] = i;
    }

    int Find(int p) {
        if(p != parent[p])
            parent[p] = Find(parent[p]);
        return parent[p];
    }

    void Union(int p, int q) {
        int rootP = Find(p);
        int rootQ = Find(q);
        if(rootP != rootQ) {
            parent[rootQ] = rootP;
            count--;
        }     
    }

    int GetCount() {
        return count;
    }
};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int count = 0;
        UnionFind unionFind(M.size());

        for(int i=0; i<M.size(); ++i) {
            for(int j=0; j<M.size(); ++j) {
                if(M[i][j] == 1 && i != j)
                    unionFind.Union(i, j);
            }
        }

        return unionFind.GetCount();
    }
};