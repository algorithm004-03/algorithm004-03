package leetcode.week7;

/**
 * https://leetcode-cn.com/problems/power-of-two/submissions/
 * 2进制表示法中只有1个1
 * @author eason.feng at 2019/12/1/0001 11:16
 **/
public class LeetCode_231_218 {

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        LeetCode_231_218 leetCode_231_218 = new LeetCode_231_218();
        System.out.println(leetCode_231_218.isPowerOfTwo(15));
    }

}
