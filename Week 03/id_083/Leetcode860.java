/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill:bills){
            if(bill == 5){//pay5＄
                five++;
            }else if(bill ==10){//pay10＄
                if(five == 0)
                return false;
                five--;
                ten++;
            }else{//pay20＄
                if(five>0 && ten>0){
                    five --;
                    ten --;
                }else if(five>=3){
                    five -=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

