import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_242_383 {

    /**
     * 解法一：将两个字符串排序，排序后如果相等即是异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    /**
     * 解法二：将遍历s，用map统计字符出现的次数，然后遍历t，每遍历一个字符就将map中对应的统计数减1，
     * 最后map为空就代表s和t是异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map map = new HashMap();
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, (int)map.get(c) + 1);
        }
        for (int i = 0, len = t.length(); i < len; i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int count = (int) map.get(c);
            count -= 1;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        return map.isEmpty();
    }


    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0, len = s.length(); i < len; i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0, len = t.length(); i < len; i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

}