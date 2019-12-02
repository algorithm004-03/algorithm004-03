/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 * 我感觉像暴力多过于贫心。。。但居然2ms,打败了100%
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int c5 = 0;
        int c10 = 0;
        for(int b : bills){
            if(b == 5){ //5
                c5 += 1;
            }else if( b == 10){ //10
                if(c5 > 0){
                    c5 -= 1;
                    c10 += 1;
                }else{
                    return false;
                }
            }else { //20
                if(c5 > 0){
                    if(c10 > 0){
                        c5 -= 1;
                        c10 -= 1;
                    }else if( c5 > 2){
                        c5 -= 3 ;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }

}
// @lc code=end

