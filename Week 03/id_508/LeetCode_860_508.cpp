class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five = 0, ten = 0;
        bool res = true;
        for(auto i:bills) {
            if(i == 5) {
                five++;
            } else if(i == 10) {
                ten++;
                if(five>0) five--;
                else {
                    res = false;
                    break;
                }
            } else {
                if(ten&&five) {
                    ten--;
                    five--;
                } else if(five>=3) {
                    five-=3;
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

};
