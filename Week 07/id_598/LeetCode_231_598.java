/**
 * @author northleaf
 * @create 2019年11月26日
 */
public class LeetCode_231_598 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & ( n -1)) == 0 ;
    }
}