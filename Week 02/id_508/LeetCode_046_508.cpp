class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> state;
        recursePermute(nums.size(),result,state,0,nums);
        return result;
    }
    void recursePermute(const int N,vector<vector<int>>&result,vector<int>& state,int count,vector<int>& nums) {
        if(state.size()==N) {
            result.push_back(state);
            return;
        }
        for(auto i:nums) {
            bool flag = true;
            for(auto j:state) {
                if(j==i) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                state.push_back(i);
                recursePermute(N,result,state,count+1,nums);
                state.pop_back();
            }
        }
    }
};
