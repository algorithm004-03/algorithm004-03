/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * @author gning (id=698)
 */

public class LeetCode_231_698 {

    public boolean isPowerOfTwo(int n) {
        return (n>0) && ((n & (n-1))==0);
    }

}