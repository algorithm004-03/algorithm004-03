/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 * 思路
 * 利用 x & (x-1)  可以把数字最右边的1去掉进行计算
 * 一直迭代到x 变为0 即可
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        while(n  != 0){
            num ++;
            n = n & (n-1);
        }
        return num;
    }
}
// @lc code=end