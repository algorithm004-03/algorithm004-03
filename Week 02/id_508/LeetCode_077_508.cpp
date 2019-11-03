class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> result;
        vector<int> status;
        combine(n,k,status,0,result);
        return result;

    }
    void combine(const int n, int k, vector<int>& status,int ii, vector<vector<int>>& result ) {
        if(0==k) {
            result.push_back(status);
            return;
        }
        for(int i=ii+1;i<=n;++i) {
            if(!valid(i,status)) continue;
            status.push_back(i);
            combine(n,k-1,status,i,result);
            status.pop_back();
        }
    }
    bool valid(int n, vector<int>& status) {
        for(auto i:status) {
            if(i==n) return false;
        }
        return true;
    }
};
