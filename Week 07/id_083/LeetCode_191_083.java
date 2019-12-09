/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        // //solution 1,O(1)
        // int bits = 0 , mask = 1;
        // for(int i=0;i<32;i++){
        //     if((n & mask)!= 0){
        //         bits ++;
        //     }
        //     mask <<= 1;
        // }
        // return bits;

            //solution 2,O(1)
            int sum = 0;
            while(n != 0 ){
                sum ++;
                n &= (n-1);
                //将n和n−1做与运算会将最低位的1变成0,并保持其他位不变
            }
            return sum;

    }
}
// @lc code=end

