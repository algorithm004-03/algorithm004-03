#include <vector>
#include <stack>
using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        stack<int> s;
        int sum = 0;
        int len = digits.size();
        int carry = 0;

        sum = digits[len-1] + 1;
        s.push(sum % 10);
        carry = (sum >= 10) ? 1 : 0;

        for (int i = len-2; i >= 0; i--) {
            sum = digits[i] + carry;

            s.push(sum % 10);
            carry = (sum >= 10) ? 1 : 0;
        }

        if (carry) {
            s.push(carry);
        }

        vector<int> result(s.size());
        int idx = 0;
        while (!s.empty()) {
            result[idx++] = s.top();
            s.pop();
        }

        return result;
    }
};