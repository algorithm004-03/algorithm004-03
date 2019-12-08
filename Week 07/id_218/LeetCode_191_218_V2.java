package leetcode.week7;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author eason.feng at 2019/12/1/0001 11:36
 **/
public class LeetCode_191_218_V2 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

}
