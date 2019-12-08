public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        // 不断去 n 的末尾填充到 result 的末尾
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n&1);
            n >>>= 1;
        }
        return result;
    }
}