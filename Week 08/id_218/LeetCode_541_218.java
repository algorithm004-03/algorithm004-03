package leetcode.week8;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * @author eason.feng at 2019/12/7/0007 15:56
 **/
public class LeetCode_541_218 {

    public static void main(String[] args) {
        LeetCode_541_218 leetCode_541_218 = new LeetCode_541_218();
        System.out.println(leetCode_541_218.reverseStr("krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc", 20));
    }

    public String reverseStr(String s, int k) {
        if (s == null || "".equals(s) || k <= 0) {
            return s;
        }
        StringBuilder res = new StringBuilder("");
        int length = s.length();
        int index = 0;
        while (index + 2 * k < length) {
            int mid = index + k;
            int end = index + 2 * k;
            String reverseStr = reverse(s.substring(index, mid));
            res.append(reverseStr).append(s.substring(mid, end));
            index += 2 * k;
        }
        String sub = s.substring(index, length);
        int subLength = sub.length();
        if (subLength < k) {
            res.append(reverse(sub));
        } else {
            res.append(reverse(sub.substring(0, k))).append(sub.substring(k));
        }
        return res.toString();
    }

    private String reverse(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
        return new String(chars);
    }
}
