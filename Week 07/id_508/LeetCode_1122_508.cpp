class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
       unordered_map<int,int> table;
       for(auto i:arr1) {
            if(table.find(i)==table.end()) table[i] = 1;
            else table[i]+=1;
       }
        vector<int> result;
        for(auto i:arr2) {
            for(int j = 0;j<table[i];j++)
                result.push_back(i);
            table[i] = 0;
        }
        vector<int> tail;
        for (auto i:arr1) {
            if(table[i]!=0)
            tail.push_back(i);
        }
        sort(tail.begin(),tail.end());
        for(auto i:tail) result.push_back(i);
        return result;
    }
};
