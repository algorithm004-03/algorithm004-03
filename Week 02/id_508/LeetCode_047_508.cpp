class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> current;
        sort(nums.begin(),nums.end());
        recursePermuteUnique(nums,current,result);
        return result;
    }
    void recursePermuteUnique(vector<int>&nums, vector<int>& current, vector<vector<int>>& result) {
        if(nums.size() == current.size()) {
            vector<int> temp ;
            for(auto i:current) temp.push_back(nums[i]);
            result.push_back(temp);
            return;
        }
        vector<int> mute;

        for(int i=0;i<nums.size();i++) {
            if(!valid(current,i)) continue;
            if(!valid(mute,nums[i])) continue;

            current.push_back(i);
            //cout<<i<<endl;
            recursePermuteUnique(nums,current,result);
            current.pop_back();
            mute.push_back(nums[i]);

        }

    }
    bool valid(const vector<int>& current,int n) {
        for(auto iter:current) {
            if(iter==n) return false;
        }
        return true;
    }

};
