/*
 * @lc app=leetcode.cn id=860 lang=csharp
 *
 * [860] 柠檬水找零
 */

// @lc code=start
using System;

public class Solution {
    public bool LemonadeChange(int[] bills) {
        if(bills==null || bills.Length==0 || bills[0]!=5){
            return false;
        }
        int five=0;
        int ten=0;
        for (int i = 0; i < bills.Length; i++)
        {
            if (bills[i]==5)
            {
                five++;
            }
            else if(bills[i]==10){
                if(five==0) return false;
                five--;
                ten ++;
            }
            else {
                if(five>0 && ten>0){
                    ten--;
                    five--;
                } else if(five>3){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

