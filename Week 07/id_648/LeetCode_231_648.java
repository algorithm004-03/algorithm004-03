/**
 * @Date 2019/12/1 21:44
 **/
public class LeetCode_231_648 {
    public boolean isPowerOfTwo(int n) {
        return n>0&&(n & (n-1))==0;
    }

    public static void main(String[] args) {
        LeetCode_231_648 leetCode_231_648 = new LeetCode_231_648();
        System.out.println(leetCode_231_648.isPowerOfTwo(16));

    }
}
