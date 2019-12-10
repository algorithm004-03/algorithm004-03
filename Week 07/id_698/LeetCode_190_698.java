/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 
 * @author gning (id=698)
 */

 public class LeetCode_190_698 {

    public int reverseBits(int n) {
        int result = 0;
        for (int i=0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }

        return result;

    }
 }