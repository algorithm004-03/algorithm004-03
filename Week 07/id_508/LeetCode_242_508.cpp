class Solution {
public:
    bool isAnagram(string s, string t) {
        int counter[26];
        for(auto &i:counter) i = 0;
        for(auto i:s) counter[i-'a']++;
        for(auto i:t) counter[i-'a']--;
        for(auto i:counter) if(i!=0) return false;
        return true;
    }
};
