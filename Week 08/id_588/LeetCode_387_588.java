import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class LeetCode_387_588 {

    public int firstUniqChar(String s) {
        if (null == s || s.length() <=0 ) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i ++) {
            if (1 == map.get(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
