/**
 * @author eazonshaw
 * @date 2019/12/1  0:16
 */
public class LeetCode_231_243 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
