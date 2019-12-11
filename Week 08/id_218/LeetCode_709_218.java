package leetcode.week8;

/**
 * https://leetcode-cn.com/problems/to-lower-case/submissions/
 * @author eason.feng at 2019/12/4/0004 20:12
 **/
public class LeetCode_709_218 {

    public String toLowerCaseV2(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        return str.toLowerCase();
    }
    public String toLowerCase(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        int len = str.length();
        char[] chs = new char[len];
        for (int i = 0; i < len; i++) {
            char t = str.charAt(i);
            if (t <= 'Z' && t >= 'A') {
                t += (char) 32;
            }
            chs[i] = t;
        }
        return new String(chs);
    }
}
