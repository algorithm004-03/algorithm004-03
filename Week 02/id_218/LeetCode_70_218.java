package leetcode.week2;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 *
 * @author eason.feng at 2019/10/27/0027 11:33
 **/
public class LeetCode_70_218 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int tmp = 0;
        for(int i = 3; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return tmp;
    }

}
