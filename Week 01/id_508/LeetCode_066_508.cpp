class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size()-1;
        while(digits[n]==9&&n>0){
            digits[n--] = 0;
        }
        if(digits[n]!=9) digits[n] += 1;
        else {
            digits[0] = 1;
            digits.push_back(0);
        }
        return digits;
    }
};
