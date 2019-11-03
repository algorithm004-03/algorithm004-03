class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> result;
        unordered_map<string,vector<string>> hash_map;
        for(auto iter:strs) {
            string str = iter;
            sort(str.begin(),str.end());
            hash_map[str].push_back(iter);
        }

        for(auto iter:hash_map) {
            result.push_back(iter.second);
        }
        return result;
    }
};
