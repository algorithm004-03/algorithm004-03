class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        createUnion(M.size());
        for(int i=0;i<M.size();i++) {
            for(int j= i+1;j<M.size();j++) {
                if(M[i][j]) joinUnion(i,j);
            }
        }
        return count;
    };
    void createUnion(int n) {
        this->count = n;
        data = new int[n];
        for(int i = 0;i<n;i++) {
            data[i] = i;
        }
    };
    int findUnion(int n) {
        int temp = n;
        while(data[temp]!=temp) {
            temp = data[temp];
        }
        return temp;
    }
    void joinUnion(int a, int b) {
        int ap = findUnion(a);
        int bp = findUnion(b);
        if (ap == bp) return;
         data[bp] = ap;
        count--;
    }
private:
    int count ;
    int* data;
};
