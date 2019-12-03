/*
思路
利用 x & (x-1)  可以把数字最右边的1去掉进行计算
一直迭代到x 变为0 即可

*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n-1);
        }

        return cnt;
    }
}