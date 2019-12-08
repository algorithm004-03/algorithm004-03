/*
 * @lc app=leetcode id=860 lang=cpp
 *
 * [860] Lemonade Change
 */

// @lc code=start
class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
       int five =0;
       int ten = 0;
       for(int i =0;i<bills.size(); i++)
        {
            if(bills[i] == 20)
            {
               if(ten == 0 && five>=3)
               {
                   five -=3;
               }
               else if(ten >0&& five > 0)
                {
                    five --;
                    ten --;
                }
                else
                {
                    return false;
                }
                
            }
            if(bills[i] == 10)
            {
                if(five>0)
                {
                    five --;
                    ten++;
                }
                else{
                    return false;
                }
               
            }
            if(bills[i]==5)
            {
                five++;
            }
           
        }
        return true;
    }
};
// @lc code=end

