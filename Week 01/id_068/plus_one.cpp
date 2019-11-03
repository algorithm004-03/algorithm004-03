class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int len = digits.size();
        digits[len-1]++;
        for(int i = len-1; i > 0; i--) {
            if (digits[i] == 10) {
               digits[i-1]++;
               digits[i] = 0;
            }
        }
        if (digits[0] == 10) {
            digits.push_back(0);
            digits[0] = 1;
        }
        return digits;
    }
};
