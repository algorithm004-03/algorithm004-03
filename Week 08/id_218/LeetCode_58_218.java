package leetcode.week8;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 *
 * @author eason.feng at 2019/12/4/0004 20:25
 **/
public class LeetCode_58_218 {

    public int lengthOfLastWord(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

}
