/**
 * @author eazonshaw
 * @date 2019/12/1  0:16
 */
public class LeetCode_191_243 {

    public int hammingWeight(int n) {
        int sum = 0;
        while(n!=0){
            sum++;
            n = n & (n-1);
        }
        return sum;
    }

}
