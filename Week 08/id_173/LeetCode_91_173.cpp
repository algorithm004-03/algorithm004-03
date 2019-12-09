/*
 * 91. 解码方法
 */

class Solution {
public:
    int numDecodings(string s) {
        if(s[0] == '0')
            return 0;
        
        int prev=1, cur=1;

        for(int i=1; i<s.size(); ++i) {
            int temp = cur;

            if(s[i] == '0') {
                if(s[i-1] == '1' || s[i-1] == '2')
                    cur = prev;
                else
                    return 0;
            }
            else if(s[i-1] == '1' || (s[i-1]=='2' && s[i]>='1' && s[i]<='6'))
                cur = cur + prev;
            
            prev = temp;
        }

        return cur;
    }
};