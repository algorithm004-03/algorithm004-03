package leetcode.week7;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author eason.feng at 2019/12/1/0001 11:23
 **/
public class LeetCode_191_218 {

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

}
