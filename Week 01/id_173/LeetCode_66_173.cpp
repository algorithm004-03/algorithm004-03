/* 
 * 66. 加一
 */

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int i = digits.size()-1;
        int carry = 0;

        do {
            int number = digits[i]+1;
            digits[i] = number%10;
            carry = number/10;
            i--;
        }while(i>=0 && carry>0);

        if(carry>0) {
            digits.insert(digits.begin(), 1);
        }

        return digits;
    }
};