/*
 * 541. 反转字符串 II
 */

class Solution {
public:
    string reverseStr(string s, int k) {
        int i = 0;

        while(2*k*(i+1) < s.size()) {
            reverse(s.begin()+2*k*i, s.begin()+2*k*i+k);
            i++;
        }

        if(s.size() - 2*k*i < k)
            reverse(s.begin()+2*k*i, s.end());
        else
            reverse(s.begin()+2*k*i, s.begin()+2*k*i+k);
        
        return s;
    }
};