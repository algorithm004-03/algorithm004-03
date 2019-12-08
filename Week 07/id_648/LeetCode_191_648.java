/**
 * @Date 2019/12/1
 **/
public class LeetCode_191_648 {
    public int hammingWeight(int n) {
        int sum = 0 ;
        while(n!=0){
            sum++;
            n&=n-1;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        LeetCode_191_648 leetCode_191_648 = new LeetCode_191_648();
        leetCode_191_648.hammingWeight(5);
    }

}
