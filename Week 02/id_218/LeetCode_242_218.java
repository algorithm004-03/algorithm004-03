package leetcode.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * //TODO 要熟悉Arrays里的常见函数。
 *
 * @author eason.feng at 2019/10/22/0022 08:49
 **/
public class LeetCode_242_218 {

    public boolean isAnagramBestWay(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for(int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            int pointer = t.charAt(i) - 'a';
            table[pointer]--;
            if(table[pointer] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        int[] counter = new int[26];
        for (int i = 0 ; i < len; i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramByHashMap(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>(len);
        for (int i = 0; i < len; i++) {
            char x = s.charAt(i);
            map.put(x, ((map.get(x) == null) ? 0 : map.get(x)) + 1);
            char y = t.charAt(i);
            map.put(y, ((map.get(y) == null) ? 0 : map.get(y)) - 1);
        }
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for(Map.Entry<Character, Integer> entry : set) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramBruceForce(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        Arrays.sort(sBytes);
        Arrays.sort(tBytes);
        s = new String(sBytes);
        t = new String(tBytes);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

}
