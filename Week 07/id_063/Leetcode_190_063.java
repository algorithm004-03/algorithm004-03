/*
简单二进制位操作
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int num = n;
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((num & 1) == 1) {
                result |= (1 << i);
            }

            num >>= 1;
            if (num == 0) {
                break;
            }
        }

        return result;
    }
}