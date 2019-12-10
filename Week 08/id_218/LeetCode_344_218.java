package leetcode.week8;

/**
 * https://leetcode-cn.com/problems/reverse-string
 *
 * @author eason.feng at 2019/12/7/0007 15:52
 **/
public class LeetCode_344_218 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
