package week7;

/**
 * @program: leetcode
 * @description:
 * @author: 王瑞全
 * @create: 2019-12-0122:52
 **/


public class leetcode242_7_468 {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
