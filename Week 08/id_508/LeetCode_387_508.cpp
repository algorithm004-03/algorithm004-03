class Solution {
public:
    int firstUniqChar(string s) {
        int bin[26];
        for(auto &i:bin) i = 0;

        for(auto i:s) bin[i-'a'] +=1;
        for(int i=0;i<s.length();i++) {
            if(bin[s[i]-'a'] == 1) return i;
        }      
        return -1;
    }
};
