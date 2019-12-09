//7
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i = (int)digits.size() - 1; i >= 0; i--) 
		{
            if (digits[i] == 9) 
			{
                digits[i] = 0;
            }
            else
			{
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0)
		{
            digits.push_back(0);
            digits[0] = 1;
        }
        return digits;
    }
};