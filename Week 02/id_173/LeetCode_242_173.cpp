/*
 * 242. 有效的字母异位词
 */

class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size())
            return false;
        
        int hashTable[26] = {0};
        
        for(auto e : s)
            hashTable[e-'a']++;
        for(auto e : t) {
            if(--hashTable[e-'a'] < 0)
                return false;
        }

        return true;
    }
};