package leetcode.week8;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author eason.feng at 2019/12/4/0004 20:36
 **/
public class LeetCode_387_218 {

    public int firstUniqChar(String s) {
        int res = -1;
        if (s == null || "".equals(s)) {
            return res;
        }
        int[] arr = new int[32];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char t = s.charAt(i);
            int index = t - 'a';
            arr[index]++;
        }
        for (int i = 0; i < len; i++) {
            int k = s.charAt(i) - 'a';
            if (arr[k] == 1) {
                return i;
            }
        }
        return res;
    }
}
