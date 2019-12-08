/*
去掉最右边的0后如果结果是0表示该数字二进制表示中只有一个1，必然就是2次幂
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n-1)) == 0);
    }
}
