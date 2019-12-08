/**
 * @author northleaf
 * @create 2019年11月26日
 */
public class LeetCode_191_598 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0 ;

        while (n!=0){
            count++;
            n = n & (n - 1);
        }

        return count;
    }
}
