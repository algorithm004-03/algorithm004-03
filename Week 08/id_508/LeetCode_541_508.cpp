class Solution {
public:
    void revStr(string &s ,int i, int j) {
        int left = i;
        int right = j;
        while(left<right) {
            s[left]^= s[right];
            s[right] ^= s[left];
            s[left++]^= s[right--];
        }
    }
    string reverseStr(string s, int k) {
        for(int i = 0;i<s.length();i+=2*k) {
            if((i+k)<s.length()) revStr(s,i,i+k-1);
            else revStr(s,i,s.length()-1);
        }
        return s;


    }
};
