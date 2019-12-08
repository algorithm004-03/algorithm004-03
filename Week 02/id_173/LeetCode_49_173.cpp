/*
 * 49. 字母异位词分组
 */

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, int> hashTable;

        for(auto str : strs) {
            string temp = str;
            sort(temp.begin(), temp.end());

            if(hashTable.count(temp))
                res[hashTable[temp]].push_back(str);
            else {
                hashTable[temp] = res.size();
                res.push_back(vector<string>({str}));
            }
        }

        return res;
    }
};