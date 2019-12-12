package id_338;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Leesen
 * @date 2019/12/8 23:09
 */
public class LeetCode_387_338 {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
