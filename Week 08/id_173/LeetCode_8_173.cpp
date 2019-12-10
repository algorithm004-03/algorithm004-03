/*
 * 8. 字符串转换整数 (atoi)
 */

class Solution {
public:
    int myAtoi(string str) {
        if(str.empty()) return 0;

        int res=0, sign=1, index=0;

        while(index<str.size() && str[index]==' ')
            index++;
        
        if(str[index]=='+' || str[index]=='-') {
            sign = (str[index]=='+') ? 1 : -1;
            index++;
        }

        while(index < str.size()) {
            int digit = str[index] - '0';

            if(digit<0 || digit>9) break;

            if(res>INT_MAX/10 || res==INT_MAX/10 && digit>INT_MAX%10)
                return (sign==1) ? INT_MAX : INT_MIN;

            res = res*10 + digit;
            index++;
        }

        return res*sign;
    }
};