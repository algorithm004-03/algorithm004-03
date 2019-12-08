/**
 * 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class LeetCode_231_588 {

    public boolean isPowerOfTwo(int n) {
        // 2的幂则只有一个1，其余都是0
        // 使用位运算去除最低位的1之后判断是否等于0，若等于，则为2的幂
        // 还要注意n必须是一个大于0的数
        return 0 == (n & (n - 1)) && n > 0;
    }
}
