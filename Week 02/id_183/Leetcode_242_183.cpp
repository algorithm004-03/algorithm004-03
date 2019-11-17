/*
 * @lc app=leetcode id=242 lang=cpp
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length())
        {
        
            return false;
        }
        vector<int> alpha (26,0);
        for(int i = 0;i<s.size(); i++)
        {
            alpha[s[i]-'a'] ++;
            alpha[t[i]-'a'] --;
            //cout<<alpha[i]<<endl;
        }
        for(int i =0 ;i<26; i++)
            if(alpha[i]!=0)
                return false;
        return true;
    }
};
// @lc code=end

